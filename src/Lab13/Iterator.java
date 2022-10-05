package Lab13;

/**
  * FONDAMENTI DI INFORMATICA - GR. 4
  * Simulazione della Prova di Programmazione del 16-01-2020
  *
  * Interfaccia Iterator
  * Definisce un iteratore
  *
  * @param T il tipo di elementi dell'iterazione
  *
  * @author A. Luchetta
  * @version 20200115
  *
  */
public interface Iterator<T>
{
   /**
      il metodo restituisce true se c'e' un prossimo elemento nell'iterazione,
      false altrimenti 
      @return true se c'e' un prossimo elemento nell'iterazione, false
              altrimenti
   */
   boolean hasNext();

   /**
      il metodo restituisce il prossimo elemento dell'iterazione e poi avanza
      nell'iterazione 
      @return il prossimo elemento nell'iterazione
      @throws java.util.NoSuchElementException se non c'e' un prossimo elemento
              nell'iterazioen
   */   
   T next() throws java.util.NoSuchElementException;  
}
