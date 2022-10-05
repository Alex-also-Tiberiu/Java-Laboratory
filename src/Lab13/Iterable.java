package Lab13;

/**
  * FONDAMENTI DI INFORMATICA - GR. 4
  * Simulazione della Prova di Programmazione del 16-01-2020
  *
  * Interfaccia Iterable
  * Definisce la proprieta' di iterabilita' una sequenza
  *
  * @param T il tipo di elementi dell'iterazione
  *
  * @author A. Luchetta
  * @version 20200115
  *
  */
  public interface Iterable<T>
{
   /**
      il metodo restituisce un iteratore
      @return un iteratore posto all'inizio della sequenza
   */
   Iterator<T> iterator();
}
