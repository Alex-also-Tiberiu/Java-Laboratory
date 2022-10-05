package Lab12;

/**
  * FONDAMENTI DI INFORMATICA - Gruppo 2
  * PROVA PRATICA DI PROGRAMMAZIONE DEL 19.6.2018
  *
  * interfaccia Deque - definisce l'ADT doppia coda iterabile
  * @author A. Luchetta
  * @version 15-06-2018
  *
  * @see Iterable
  * @see EmptyDequeException
  */
public interface Deque<T> extends Iterable<T>
{
   /**
      inserisce l'elemento specificato all'inizio alla doppia coda
      @param element l'elemento specificato
      @throws IllegalArgumentException se l'elemento specificato vale null
   */
   void addFirst(T element);
   
   /**
      inserisce l'elemento specificato alla fine alla doppia coda
      @param element l'elemento specificato
      @throws IllegalArgumentException se l'elemento specificato vale null
   */
   void addLast(T element);

   /**
      verifica se la doppia coda e' vuota
      @return true se questa doppia coda e' vuota, false altrimenti
   */
   boolean isEmpty();
   
   /**
      ispeziona ed estrae il primo elemento della doppia coda
      @return il primo elemento della doppia coda
      @throws EmptyDequeException se la doppia coda e' vuota
   */
   T removeFirst() throws EmptyDequeException;
   
   /**
      ispeziona ed estrae l'ultimo elemento della doppia coda
      @return il primo elemento della doppia coda
      @throws EmptyDequeException se la doppia coda e' vuota
   */
   T removeLast() throws EmptyDequeException;
   
   /**
      fornisce  il numero di elementi contenuti nella doppia coda
      @return il numero di elementi contenuti in questa doppia coda
   */
   int size(); 
}
