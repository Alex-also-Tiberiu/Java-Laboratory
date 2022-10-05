package Set.ArraySorted;

/**
  * classe S realizza - realizza un insieme
  * @author A. Luchetta
  * @version 14-Genn-2016
  *
  * @see Set
  * @see Pair
  */
// realizzazione con array ordinato riempito parzialmente
// soluzione ottima - Complessita' temporale toArray O(n), contains O(logn)
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
   // Complessita' temporale O(n) nel caso medio e peggiore 
   public void add(T x) 
   {
      // precondizioni
      if (!(x instanceof Comparable))
         throw new ClassCastException();

      if (x == null || contains(x)) // O(logn) nel caso medio
         return;
         
      // eventuale ridimensionamento dinamico
      if (vSize >= v.length)
      {
         Comparable[] tmpV = new Comparable[ 2 * v.length];
         System.arraycopy(v, 0, tmpV, 0, v.length);
         v = tmpV;
      }
         
      // inserimento ordinato - O(n) nel caso medio
      int j = vSize - 1;
      while (j >= 0 && v[j].compareTo(x) > 0)
      {
         v[j + 1] = v[j];
         j--;
      }     
      v[j + 1] = (Comparable)x;
      
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
   public boolean contains(T x) // O(logn)
   {
      return search(v, 0, vSize - 1, x) >= 0;
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
   // Complessita' temporale O(n)
   public Comparable[] toArray()
   {
      Comparable[] w = new Comparable[vSize];
      System.arraycopy(v, 0, w, 0, w.length);
      
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
         
   // ricerca binaria O(logn)
   private int search(Comparable[] a, int from, int to, Object target)
   {
      // caso base
      if (from > to)
         return -1;
         
         
      int mid = (from + to) / 2;
      
      if ((a[mid]).compareTo(target) == 0)
         return mid;
      else if (a[mid].compareTo(target) > 0)
         return search(a, from, mid - 1, target);
      else
         return search(a, mid + 1, to, target);               
   }
}
