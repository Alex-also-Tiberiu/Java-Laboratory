package Set.Hashtable;

/**
  * classe S - Insieme di elementi di tipo generico
  * soluzione che usa come struttura dati una hash table
  * @author A. Luchetta
  * @version 14-Genn-2016
  */
public class S<T> implements Set<T>
{
   // parte privata
   private static final int CAPACITY = 29;
   private Object[] v;
   private int size;
   
   private class ListNode
   {
      private T element;
      private ListNode next;
      
      public ListNode(T e, ListNode n)
      {
         setElement(e);
         setNext(n);
      }
      
      public ListNode()
      {
         this(null, null);
      }
      
      public T getElement() { return element; }
      public ListNode getNext() { return next; }
      void setElement(T e) { element = e; }
      void setNext(ListNode n) { next = n;}
   }
   
   public S()
   {
      v = new Object[CAPACITY];
      for (int i = 0; i < v.length; i++)
         v[i] = new ListNode();
   }
   
   public S(T[] a)
   {
      this();         
      add(a); 
   }   

   /**
      inserisce nell'insieme l'elemento specificato se diverso da null e non gia' presente
      @param x l'elemento specificato
      @throws ClassCastException se l'elemento specificato non e' un esemplare di una
              classe che realizza l'interfaccia java.lang.Comparable
   */ 
   public void add(T x) //O(n/CAPACITY)
   {
      if (x == null || contains(x))
         return;
         
      if (!(x instanceof Comparable))
         throw new ClassCastException();   
         
      int h = hash(x);
      ListNode n = (ListNode)v[h];
      n.setElement(x);
      v[h] = new ListNode(null, n); 
      
      size++;
   }
   
   private int hash(Object x)
   {
      int h = x.hashCode() % v.length;
      if (h < 0)
         h = -h;
      return h;   
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
      prodotto cartesiano di questo insieme con l'insieme specificato. Detti A e B i due insiemi
      e AxB il prodotto cartesiano allora AxB = {coppie (a,b) | a appartiene a A e b appartiene a B}
      @param s l'insieme specificato
      @return insieme prodotto cartesiano di questo insieme con l'insieme specificato. Restituisce
              un insieme vuoto se s vale null oppure uno dei due insiemi e' vuoto
   */ 
   public Set cartesianProduct(Set s)
   {
      Set r = new S();
      
      if (s == null || isEmpty() || s.isEmpty())
         return r;
    
      Comparable[] a = toArray();
      Comparable[] b = s.toArray();
      
      for (int i = 0; i < a.length; i++)
         for (int j = 0; j < b.length; j++)
            r.add(new Pair(a[i], b[j]));

      return r;
   }

   /**
      @param x elemento specificato
      @return true se questo insieme contiene l'elemento specificato, false altrimenti
   */
   public boolean contains(T x) //O(n/CAPACITY)
   {
      int h = hash(x);
      ListNode n = (ListNode)v[h];
      n = n.getNext();
      
      while (n != null)
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
      return size <= 0;
   }    
   
   /**
      @return il numero di elementi contenuti in questo insieme
   */
   public int size()
   {
      return size;
   }            
   
   /**
      @return array contenente tutti gli elementi di questo insieme disposti
              secondo il loro ordine naturale in senso crescente.
   */
   public Comparable[] toArray() //O(nlogn)
   {
      Comparable[] r = new Comparable[size];
      
      int j = 0;
      for (int i = 0; i < v.length; i++)
      {
         ListNode n = (ListNode)v[i];
         while (n.getNext() != null)
         {
            r[j++] = (Comparable)(n.getNext().getElement());
            n = n.getNext();
         }   
      }
      
      sort(r);

      return r;
   } 
   
   private static void sort(Comparable[] a)
   {
      if (a.length < 2)
         return;
         
      int mid = a.length / 2;
      Comparable[] left = new Comparable[mid];
      Comparable[] right = new Comparable[a.length - mid];
      System.arraycopy(a, 0, left, 0, mid);
      System.arraycopy(a, mid, right, 0, a.length - mid);       
      
      sort(left);
      sort(right);
      
      merge(a, left, right);
   } 
   
   private static void merge(Comparable[] a, Comparable[] b, Comparable[] c)
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
