package Set.ArraySorted;

/**
  * interfaccia Set - ADT Insieme di elementi di tipo generico
  * @author A. Luchetta
  * @version 14-Genn-2016
  */
public interface Set <T>
{
   /**
      inserisce nell'insieme l'elemento specificato se diverso da null e non gia' presente
      @param x l'elemento specificato
      @throws ClassCastException se l'elemento specificato non e' un esemplare di una
              classe che realizza l'interfaccia java.lang.Comparable
   */ 
   void add(T x);
   
   /**
      Se l'array specificato e' diverso da null inserisce  nell'insieme gli elementi contenuti
      dell'array, se non gia' presenti
      @param a l'array specificato
      @throws ClassCastException se gli elementi dell'array specificato non sono esemplari
              di una classe che realizza l'interfaccia java.lang.Comparable
   */ 
   void add(T[] a);   
   
  /** 
      prodotto cartesiano di questo insieme con l'insieme specificato. Detti A e B i due insiemi
      e AxB il prodotto cartesiano allora AxB = {coppie (a,b) | a appartiene a A e b appartiene a B}
      @param s l'insieme specificato
      @return insieme prodotto cartesiano di questo insieme con l'insieme specificato. Restituisce
              un insieme vuoto se s vale null oppure uno dei due insiemi e' vuoto
   */ 
   Set cartesianProduct(Set s);

   /**
      @param x elemento specificato
      @return true se questo insieme contiene l'elemento specificato, false altrimenti
   */
   boolean contains(T x);
   
   /**
      @return true se questo insieme e' vuoto, false altrimenti
   */
   boolean isEmpty();
   
   /**
      @return il numero di elementi contenuti in questo insieme
   */
   int size();        
   
   /**
      @return array contenente tutti gli elementi di questo insieme disposti
              secondo il loro ordine naturale in senso crescente.
   */
   Comparable[] toArray();  
}
