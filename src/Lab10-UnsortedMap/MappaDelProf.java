package Lab10

/**
   Classe MyMap
   realizzazione con array non ordinato, parzialmente riempito a ridimensionamento
   dinamico

   @author A. Luchetta
   @version 20-Genn-2009
   @see Map
*/

public class MappaDelProf implements Map//-ADT map

{
	   // variabili statiche
	   private static final int CAPACITY = 1;

	   // variabili di esemplare
	   private Entry[] v;
	   private int vSize;
	   
	   // Costruttori
	   public MappaDelProf()
	   {
	      v = new Entry[CAPACITY];
	      vSize = 0;
	   }

	   /**
	      O(1)
	      @return true se la mappa e' vuota, false altrimenti
	   */
	   public boolean isEmpty()
	   {
	      return vSize == 0;
	   }

	   /**
	      O(1)
	      @return numero di elementi contenuti nella mappa
	   */
	   public int size()
	   {
	      return vSize;
	   }

	   /**
	      O(n)
	      restituisce il valore associato alla chiave specificata
	      @param key la chiave associata al valore da restituire
	      @return il valore associato alla chiave specificata, se presente,
	              null se l'associazione non e' presente
	      @throws IllegalArgumentException se key vale null
	   */
	   public Object get(Object key)
	   {
	      if (key == null)
	         throw new IllegalArgumentException();

	      int n = search(key);

	      if (n < 0)
	         return null;
	         
	      return v[n].value;
	   }

	   /**
	      O(n)
	      inserisce l'associazione key/value nella mappa. Se la chiave e' gia'
	      presente, sostituisce l'associazione e restituisce il valore
	      precedentemente associato alla chiave
	      @param key la chiave
	      @param value il valore da associare alla chiave
	      @return il valore precedentemente associato alla chiave specificata, se
	              presente, null se la chiave non e' gia' presente
	      @throws IllegalArgumentException se key o value valgono null
	   */
	   public Object put(Object key, Object value)
	   {
	      if (key == null || value == null)
	         throw new IllegalArgumentException();

	      Object x = remove(key);
	      
	      if ( vSize >= v.length)
	      {
	         Entry[] newV = new Entry[2 * v.length];
	         System.arraycopy(v, 0, newV, 0, vSize);
	         v = newV;
	      }

	      v[vSize++] = new Entry(key, value);
	      
	      return x;
	   }

	   /**
	      O(n)
	      elimina l'associazione con la chiave specificata
	      @param key la chiave dell'associazione da eliminare
	      @return il valore associato alla chiave specificata, se
	              presente, null se la chiave non e' presente
	      @throws IllegalArgumentException se key vale null
	   */
	   public Object remove(Object key)
	   {
	      if (key == null)
	         throw new IllegalArgumentException();

	      int n = search(key);

	      if (n < 0)
	         return null;
	         
	      Object x = v[n].value;
	      
	      for (int i = n; i < vSize - 1; i++)
	         v[i] = v[i + 1];
	         
	      v[vSize - 1] = null;
	      vSize--;
	         
	      return x;
	   }

	   /**
	      O(n)
	      restituisce un array contenente le chiavi della mappa.
	      @return array contenente tutte le chiavi della mappa
	   */
	   public Object[] keys()
	   {
	      Object[] p = new Object[vSize];
	      for (int i = 0; i < vSize; i++)
	         p[i] = v[i].key;
	         
	      return p;
	   }
	   
	   // ricerca lineare O(n)
	   private int search(Object key)
	   {
	      for (int i = 0; i < vSize; i++)
	         if (key.equals(v[i].key))
	            return i;

	      return -1;
	   }
	   
	   private class Entry
	   {
	      Object key;
	      Object value;
	      
	      Entry(Object k, Object v)
	      {
	         key = k;
	         value = v;
	      }
	   }
	}
