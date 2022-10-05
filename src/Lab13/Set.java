package Lab13;

/**
  * FONDAMENTI DI INFORMATICA - GR. 4
  * Simulazione della Prova di Programmazione del 16-01-2020
  *
  * Interfaccia Set
  * Definisce il tipo di dati astratto insieme
  *
  * @param E il tipo di elementi contenuti nell'insieme
  *
  * @author A. Luchetta
  * @version 20200115
  *
  */
public interface Set<E> extends java.lang.Iterable<E>
{
   /**
      il metodo inserisce in questo insieme l'elemento specificato se questo e'
      diverso da null e se non e' gia' presente in questo insieme 
      @param e l'elemento specificato
   */
   void add(E e);
   
   /**
      il metodo inserisce in questo insieme gli elementi contenuti nell'array
      specificato  se questi sono diversi da null e non sono gia' presenti
      in questo insieme
      @param e l'array specificato      
   */
   void add(E[] a);
   
   /**
      verifica la presenza dell'elemento specificato in questo insieme
      @param e l'elemento specificato
      @return true se l'elemento specificato e' presente in questo insieme,
              false altrimenti      
   */
   boolean contains(E e);
     
   /**
      @return true se questo insieme e' vuoto, false altrimenti     
   */
   boolean isEmpty();
      
   /**
      @return il numero di elementi presenti in questo insieme     
   */
   int size();  
}  
 
