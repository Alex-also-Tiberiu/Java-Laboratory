package Hash;

/**
  * Classe M
  * Realizza una Mappa ordinata, un contenitore di associazioni chiave/valore
  * con chiave univoca di tipo comparabile.
  *
  * Realizzazione con hash table.
  *
  * Nota sulla complessita' temporale
  * Nei metodi get, put e remove la complessita' temporale e' determinata dalla
  * ricerca lineare nel bucket. Se la distribuzione delle associazioni nei
  * bucket e' uniforme allora i metodi hanno complessita' temporale pari a
  * O(n/M) nel caso medio e peggiore dove M e' la dimensione della tabella.
  * binaria ed e', quindi, O(logn) nel caso medio e peggiore. 
  * Il metodo keys ha complessita' temporale O(nlog) dovuta all'ordinamento.
  *
  * @param K tipo parametrico della chiave
  * @param V tipo parametrico del valore
  *
  * @author A. Luchetta
  * @version 24-12-2018
  *
  */
public class M<K extends Comparable,V> implements SortedMap<K,V>
{
   // variabili di esemplare
   private static final int CAPACITY = 97;
   private Object[] v;
   private int size;
   
   // classe interna
   private class Entry
   {
      private K key;
      private V value;
      
      public Entry(K k, V v)
      {
         setKey(k);
         setValue(v);
      }
      
      public K getKey()   { return key; }
      public V getValue() { return value; }
      public void setKey(K k) { key = k; }
      public void setValue(V v) { value = v; }
   } 
   
   // classe interna ListNode
   private class ListNode
   {
      private Entry element;
      private ListNode next;
      
      public ListNode(Entry e, ListNode n)
      {
         setElement(e);
         setNext(n);
      }
      
      public ListNode()
      {
         this(null, null);
      }
      
      public Entry getElement()   { return element; }
      public ListNode getNext() { return next; }
      public void setElement(Entry e) { element = e; }
      public void setNext(ListNode n) { next = n; }
   }          

   /**
     * Inizializza una mappa vuota di dimensione nulla
   */
   public M()
   {
      v = new Object[CAPACITY];
      for (int i = 0; i < v.length; i++)
         v[i] = new ListNode();
      size = 0;
   }
   
   /**
     * Restituisce il valore a cui la chiave specificata e' associata, o null
     * se questa mappa non contiene associazione per la chiave
     * @param key la chiave specificata
     * @return il valore a cui la chiave specificata e' associata, o null se
     *         questa mappa non conteneva associazione per la chiave
     */      
   public V get(K key)
   {
      // ricerca della chiave
      ListNode n = search(key);
      
      // chiave non presente
      if (n.getNext() == null)
         return null;
         
      return n.getNext().getElement().getValue();
   }

   /**
     * @return vero se questa mappa e' vuota, falso altrimenti
     */
   public boolean isEmpty()
   {
        return size <= 0;
   }
   
   /**
     * Restituisce un array ordinato contenente le chiavi di questa mappa
     * disposte secondo il loro ordine naturale
     * @return array ordinato contenente le chiavi di questa mappa disposte
     *         secondo il loro ordine naturale
     */
   public Comparable[] keys()
   {
      // array contenente le chiavi
      Comparable[] k = new Comparable[size];
      
      // accesso alle chiavi
      int j = 0;
      for (int i = 0; i < v.length; i++)
      {
         ListNode n = ((ListNode)v[i]).getNext();
         while (n != null)
         {
            k[j++] = n.getElement().getKey();
            n = n.getNext();
         }
      } 
           
      sort(k);
         
      return k;   
   }
   
   /** 
     * Associa il valore specificato alla chiave specificata in questa mappa.
     * Se la mappa conteneva un'associazione per la chiave, il vecchio valore e'
     * sostituito dal valore specificato.
     * @param key la chiave specificata
     * @param value il valore specificato
     * @return il valore precedentemente associato alla chiave, o null se non
     *          esisteva un'associazione per la chiave
     * @ throws java.lang.IllegalArgumentException se la chiave o il valore
     *          specificati valgono null
     */
   public V put(K key, V value)
   {
      // precondizioni
      if (key == null || value == null)
         throw new IllegalArgumentException();
         
      // ricerca della chiave
      ListNode n = search(key);
      
      // chiave gia' presente
      if (n.getNext() != null)
      {
         V ret = n.getNext().getElement().getValue();
         n.getNext().setElement(new Entry(key, value));

         return ret;
      } 
      
      // inserimento della nuova associazione
      n.setNext(new ListNode(new Entry(key, value), null));
         
      // incremento del numero di associazioni
      size++;
      
      return null;
   }   
     
   /**
     * Rimuove da questa mappa l'associazione di chiave specificata, se
     * presente.
     * @param key la chiave specificata
     * @return il valore a cui la chiave specificata era associata, o null se
     *         questa mappa non conteneva associazione per la chiave
     */      
   public V remove(K key)
   {
      // ricerca della chiave
      ListNode n = search(key);
        
      // chiave non presente
      if (n.getNext() == null)
         return null;
           
      // memorizzazione temporanea del valore
      V ret = n.getNext().getElement().getValue();
         
      // eliminazione dell'associazione
      n.setNext(n.getNext().getNext());
      
      // decremento del numero di associazioni
      size--;                 
        
      return ret; 
   }
     
   /**
     * @return il numero di associazioni presenti in questa mappa
     */
   public int size()
   {
      return size;
   } 
     
   // ricerca nel bucket 
   private ListNode search(K key)
   {
      ListNode n = (ListNode)v[h(key)];
      
      while (n.getNext() != null)
      {
         if (n.getNext().getElement().getKey().compareTo(key) == 0)
            return n;
         n = n.getNext();   
      }

      return n;    
   }
   
   // chiave ridotta
   private int h(K key)
   {
      int h = key.hashCode();
      if (h < 0)
         h = -h;
         
      return h % v.length;   
   }
   
   // ordinamento mergesort - O(nlogn)
   private static void sort(Comparable[] a)
   {
      // caso base
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
