package Lab12;

/**
  * Interfaccia Multimap
  * Definisce il tipo di dati astratto Multimappa, un contenitore di associazioni
  * chiave/valore dove la chiave nen e' necessariamente univoca
  *
  * @param K tipo parametrico della chiave
  * @param V tipo parametrico del valore
  *
  * @author A. Luchetta
  * @version 24-12-2018
  *
  */
public interface MultiMap<K,V>
{
   /**
     * Restituisce un valore, a caso, a cui la chiave specificata e' associata,
     * o null se questa multimappa non contiene associazioni per la chiave
     * @param key la chiave specificata
     * @return un valore a cui la chiave specificata e' associata, o null se
     *         questa multimappa non conteneva associazione per la chiave
     */      
     V get(K key);
     
     /**
     * Restituisce un array contenente i valori a cui la chiave specificata
     * e' associata, o un array di dimensione nulla se questa multimappa non
     * contiene associazioni per la chiave specificata
     * @param key la chiave specificata
     * @return un array contenente i valori a cui la chiave specificata
     *         e' associata, o un array vuoto se queta multimappa non contiene
     *         associazioni per la chiave
     */      
     Object[] getAll(K key);

   /**
     * @return vero se questa multimappa e' vuota, falso altrimenti
     */
   boolean isEmpty();
   
   /**
     * @return un array contenente le chiavi univoche di questa multimappa
     */
   Object[] keySet();   
   
   /** 
     * Associa il valore specificato alla chiave specificata in questa
     * multimappa
     * @param key la chiave specificata
     * @param value il valore specificato
     * @return il valore precedentemente associato alla chiave, o null se non
     *          esisteva un'associazione per la chiave specificata
     * @throws IllegalArgumentException se la chiave o il valore
     *          specificati valgono null
     */
     void put(K key, V value);    
     
   /**
     * Rimuove da questa multimappa un'associazione di chiave specificata, a
     * caso, se presente.
     * @param key la chiave specificata
     * @return il valore a cui la chiave specificata era associata, o null se
     *         questa multimappa non conteneva associazione per la chiave
     */      
     V remove(K key);
     
        /**
     * @return il numero di associazioni presenti in questa multimappa
     */
     int size();       
}
