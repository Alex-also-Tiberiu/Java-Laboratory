package Set.Array;

/**
  * classe S - realizza un insieme
  * @author A. Luchetta
  * @version 14-Genn-2016
  *
  * @see Set
  * @see Pair
  */
// realizzazione con array riempito parzialmente
// soluzione non ottima - complessita' temporale: toArray O(nlogn), contains O(n)

public class S<T> implements Set<T>
{
   // parte privata
   private static final int INITIAL_CAPACITY = 1;
   
   private Comparable[] v;
   private int vSize;
   
   // parte pubblica
   
   /**
      inizializza un insieme vuoto
   */
   public S()
   {
      v = new Comparable[INITIAL_CAPACITY];
      vSize = 0;
   }
   
   /**
      inizializza un insieme contenente gli elementi dell'array specificato
      @param array specificato
   */
   public S(T[] a)
   {
      this();
      add(a);
   }

   /**
      inserisce nell'insieme l'elemento specificato, se diverso da null e non gia' presente,
      altrimenti termina silenziosamente
      @param x l'elemento specificato
      @throws java.lang.CastClassException se l'elemento specificato non e' confrontabile
   */
   // complessita' temporale O(n) nel caso medio e peggiore
   public void add(T x)
   {
      // precondizioni
      if (!(x instanceof Comparable))
         throw new ClassCastException();

      if (x == null || contains(x)) // O(n) nel caso medio
         return;
         
      // eventuale ridimensionamento dinamico
      if (vSize >= v.length)
      {
         Comparable[] tmpV = new Comparable[ 2 * v.length];
         System.arraycopy(v, 0, tmpV, 0, v.length);
         v = tmpV;
      }
            
      // inserimento
      v[vSize] = (Comparable)x;
      
      // incremento del numero di associazioni
      vSize++;      
   }
   
   /**
      Se l'array specificato e' diverso da null inserisce  nell'insieme gli elementi contenuti
      dell'array, se non gia' presenti
      @param a l'array specificato
      @throws ClassCastException se gli elementi dell'array specificato non sono esemplari
              di una classe che realizza l'interfaccia java.lang.Comparable
   */
   public void add(T[] a)
   { 
      if (a == null)
         return;
         
      for (int i = 0; i < a.length; i++)
         add(a[i]);     
   }   
   
   /**
      @param x l'elemento su cui e' effettuata la verifica
      @return true se questo insieme contiene l'elemento specificato, false altrimenti
   */
   // Complessita' temporale O(n) nel caso medio e peggiore
   public boolean contains(T x)
   {
      return search(v, 0, vSize - 1, (Comparable)x) >= 0;
   }
   
   /**
      @return true se questo insieme e' vuoto, false altrimenti
   */
   public boolean isEmpty()
   {
      return vSize == 0;
   }
   
   /**
      @return il numero di elementi contenuti in questo insieme
   */
   public int size()
   {
      return vSize;
   }        
   
   /**
      @return array contenente tutti gli elementi di questo array disposti secondo il loro ordine
              naturale crescente.
   */
   // Complessita' temporale O(nlogn)
   public Comparable[] toArray()
   {
      Comparable[] w = toUnsortedArray();     
      sort(w); // O(nlogn)
      
      return w;
   }
   
  /**
      genera il prodotto cartesiano fra questo insieme e l'insieme specificato. Detti A e B questo
      insieme e l'insieme specificato, rispettivamente, il loro prodotto cartesiano vale
      AxB = {(a, b) | a appartiene a A e b appartiene a B}. 
      @param s l'insieme specificato
      @return insieme prodotto cartesiano fra questo insieme e l'insieme specificato
              Se l'insieme specificato s vale null, oppure se questo insieme o l'insieme specificato
              sono vuoti restituisce un insieme vuoto
   */  
   public Set cartesianProduct(Set s)
   {
      // restituzione di insieme vuoto
      if (s == null || isEmpty() || s.isEmpty())
         return new S();

      // acquisizione degli elementi degli array
      Comparable[] a = toArray();  
      Comparable[] b = s.toArray();
      
      // generazione dell'insieme prodotto cartesiano
      Set t = new S();     
      for (int i = 0; i < a.length; i++)       
         for (int j = 0; j < b.length; j++)    
            t.add(new Pair(a[i], b[j]));       
            
      return t;      
   }
         
   // array non ordinato
   private Comparable[] toUnsortedArray()  // O(n)
   {
      Comparable[] w = new Comparable[vSize];
      System.arraycopy(v, 0, w, 0, w.length);
      
      return w;
   }


   // ricerca lineare O(n)
   private int search(Comparable[] a, int from, int to, Comparable t)
   {
      for (int i = from; i <= to; i++)
         if (a[i].equals(t))
            return i;
            
      return -1;      
   }


   // ordinamento per fusione O(nlogn)
   private void sort(Comparable[] a)
   {
      if (a.length < 2)
         return;
      
      int mid = a.length / 2;
      Comparable[] left = new Comparable[mid];   
      Comparable[] right = new Comparable[a.length - mid];
      System.arraycopy(a, 0, left, 0, left.length);
      System.arraycopy(a, mid, right, 0, right.length);
      
      sort(left);
      sort(right);
      
      merge(a, left, right);                  
   }
   
   private void merge(Comparable[] a, Comparable[] b, Comparable[] c)
   {
      int ia = 0, ib = 0, ic = 0;
      
      while (ib < b.length && ic < c.length)
         if (b[ib].compareTo(c[ic]) < 0)
            a[ia++] = b[ib++];
         else
            a[ia++] = c[ic++];   
      
      while (ib < b.length)
         a[ia++] = b[ib++];      
      
      while (ic < c.length)
         a[ia++] = c[ic++];             
   }
}
