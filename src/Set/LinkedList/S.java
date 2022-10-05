package Set.LinkedList;

/**
  * classe S realizza - realizza un insieme
  * @author A. Luchetta
  * @version 14-Genn-2016
  *
  * @see Set
  * @see Pair
  */
// realizzazione con lista concatenata non ordinata
// soluzione  non ottima: toArray O(nlogn), contains O(n)  
public class S<T> implements Set<T>
{
   // parte privata
   private ListNode head;
   private int size;
   
   // classe interna
   private class ListNode
   {
      private Comparable element;
      private ListNode next;
      
      public ListNode(T e, ListNode n)
      {
         setElement((Comparable)e);
         setNext(n);
      }
      
      public ListNode()
      {
         this(null, null);
      }
      
      public void setElement(Comparable e) { element = e; }
      public void setNext(ListNode n) { next = n; }
      public Comparable getElement() { return element; }
      public ListNode getNext() { return next; }  
   }
   
   // parte pubblica
   
   /**
      inizializza un insieme vuoto
   */   public S()
   {
      head = new ListNode();
      size = 0;
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
      inserisce nell'insieme l'elemento specificato se diverso da null e non gia' presente,
      altrimenti termina silenziosamente
      @param x l'elemento specificato
      @throws java.lang.CastClassException se l'elemento specificato non e' confrontabile
   */ 
   public void add(T x)            // o(n) nel caso medio
   {
      // precondizioni
      if (!(x instanceof Comparable))
         throw new ClassCastException();

      if (x == null || contains(x)) // O(n) nel caso medio
         return;
         
      // inserimento non ordinato O(1)
      head.setElement((Comparable)x);
      head = new ListNode(null, head);
            
      // incremento del numero di associazioni
      size++;      
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
   public boolean contains(T x) // O(n) nel caso medio
   {
      ListNode n = head.getNext();
      
      while(n != null)
      {
         if (n.getElement().equals(x))
            return true;
            
         n = n.getNext();   
      }    
      
      return false;
   }
   
   /**
      @return true se questo insieme e' vuoto, false altrimenti
   */
   public boolean isEmpty()
   {
      return size == 0;
   }
   
   /**
      @return il numero di elementi contenuti in questo insieme
   */
   public int size()
   {
      return size;
   }        
   
   /**
      @return array contenente tutti gli elementi di questo array disposti secondo il loro ordine
              naturale crescente.
   */
   // Complessita' temporale O(nlogn)
   public Comparable[] toArray()
   {    
      Comparable[] v = toUnsortedArray();      
      sort(v);   
      
      return v;
   }
   
  /**
      genera il prodotto cartesiano fra questo insieme e l'insieme specificato. Detti A e B questo
      insieme e l'insieme specificato, rispettivamente, il loro prodotto cartesiano vale
      AxB = {(a, b) | a appartiene a A e b appartiene a B}. 
      @param s l'insieme specificato
      @return l'insieme prodotto cartesiano fra questo insieme e l'insieme specificato
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
      ListNode n = head.getNext();
      
      Comparable[] v = new Comparable[size];
      int i = 0;
      while(n != null)
      {
         v[i++] = n.getElement();
            
         n = n.getNext();   
      } 
      
      return v;
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
