package Hash;

/**
  * Classe ME
  * Realizza una Mappa estesa, un contenitore di associazioni chiave/valore con
  * chiave di un tipo che realizza l'interfaccia Comparable
  *
  * @param K tipo parametrico della chiave
  * @param V tipo parametrico del valore
  *
  * @author A. Luchetta
  * @version 24-12-2018
  *
  */
public class ME<K extends Comparable,V> extends M<K,V>
{
   /**
     * Inizializza una mappa vuota
     */
   public ME()
   {
      super();
   }
   
   /**
     * Restituisce una porzione di questa mappa in cui le chiavi sono
     * strettamente minori della chiave specificata
     * @param toKey la chiave specificata
     * @return una mappa che e' una porzione di questa mappa in cui le chiavi
     *         sono strettamente minori della chiave specificata
     * @throws IllegalArgumentException se la chiave specificata vale
               null
     */
   public SortedMap<K,V> headMap(K toKey)
   {
      // precondizioni
      if (toKey == null)
         throw new IllegalArgumentException();
          
      // accesso alle chiavi
      Comparable[] k = keys();

      // nuova mappa
      SortedMap<K,V> m = new M<K,V>();

      // inserimento delle associazioni con chiave minore di toKey        
      int i = 0;
      while (i < k.length && k[i].compareTo(toKey) < 0)
      {
         m.put((K)k[i], get((K)k[i]));
         i++;
      }
              
      return m;           
   }
     
   /**
     * Restituisce una porzione di questa mappa in cui le chiavi sono
     * maggiori o uguali alla chiave specificata
     * @param fromKey la chiave specificata
     * @return una mappa che e' una porzione di questa mappa in cui le chiavi
     *         sono maggiori o uguali alla chiave specificata
     * @throws IllegalArgumentException se la chiave specificata vale
               null
     */
   public SortedMap<K,V> tailMap(K fromKey)
   {
      // precondizioni
      if (fromKey == null)
         throw new IllegalArgumentException();
          
      // accesso alle chiavi
      Comparable[] k = keys();

      // nuova mappa
      SortedMap<K,V> m = new M<K,V>();
                
      // inserimento delle associazioni con chiave maggiore o uguale a fromKey                  
      int i = k.length - 1;
      while (i >=0 && k[i].compareTo(fromKey) >= 0)
      {
         m.put((K)k[i], get((K)k[i]));
         i--;
      }
              
      return m;           
   }
}
