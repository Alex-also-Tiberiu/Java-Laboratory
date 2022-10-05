package Hash;

/**
  * Interfaccia SortedMap
  * Definisce il tipo di dati astratto Mappa Ordinata
  *
  * @param K tipo parametrico della chiave
  * @param V tipo parametrico del valore
  *
  * @author A. Luchetta
  * @version 24-12-2018
  *
  */
public interface SortedMap<K extends Comparable,V>
{
   /**
     * Restituisce il valore a cui la chiave specificata e' associata, o null
     * se questa mappa non contiene associazione per la chiave
     * @param key la chiave specificata
     * @return il valore a cui la chiave specificata e' associata, o null se
     *         questa mappa non contiene associazione per la chiave
     */      
     V get(K key);

   /**
     * @return vero se questa mappa e' vuota, falso altrimenti
     */
   boolean isEmpty();
   
   /**
     * Restituisce un array ordinato contenente le chiavi di questa mappa
     * @return array ordinato contenente le chiavi di questa mappa disposte
     *         secondo il loro ordine naturale o un array di dimensione nulla
     *         se questa mappa e' vuota
     */
     Comparable[] keys();    
   
   /** 
     * Associa il valore specificato alla chiave specificata in questa mappa.
     * Se la mappa conteneva un'associazione per la chiave, il vecchio valore e'
     * sostituito dal valore specificato.
     * @param key la chiave specificata
     * @param value il valore specificato
     * @return il valore precedentemente associato alla chiave, o null se non
     *          esisteva un'associazione per la chiave
     * @throws IllegalArgumentException se la chiave o il valore
     *          specificati valgono null
     */
     V put(K key, V value);    
     
   /**
     * Rimuove da questa mappa l'associazione di chiave specificata, se
     * presente.
     * @param key la chiave specificata
     * @return il valore a cui la chiave specificata era associata, o null se
     *         questa mappa non conteneva associazione per la chiave
     */      
     V remove(K key);  
     
     /**
     * @return il numero di associazioni presenti in questa mappa
     */
     int size();       
}
