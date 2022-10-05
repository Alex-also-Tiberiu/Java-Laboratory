package Lab12;

/**
  * FONDAMENTI DI INFORMATICA - Gruppo 2
  * PROVA PRATICA DI PROGRAMMAZIONE DEL 19.6.2018
  *
  * interfaccia Iterator - definisce il concetto astratto di posizione all'interno di una sequenza
  *
  * @author A. Luchetta
  * @version 16-02-2016
  *
  * @see java.util.NoSuchElementException
  * @param E il tipo paramatrico
  */
public interface Iterator<E>
{
   /**
      verifica se e' presente almeno un elemento posto dopo la posizione
      corrente dell'iteratore
      @return true se e' presente almeno un elemento, false altrimenti
   */
   boolean hasNext();
   
   /**
      ispeziona l'elemento posto DOPO la posizione corrente dell'iteratore,
      avanzando successivamente l'iteratore di una posizione nella lista
      @return l'elemento ispezionato, se presente
      @throws java.util.NoSuchElementException se non ci sono elementi dopo la
              posizione corrente dell'iteratore
   */
   E next();
}
