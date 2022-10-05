package Lab12;

/**
  * FONDAMENTI DI INFORMATICA - Gruppo 2
  * PROVA PRATICA DI PROGRAMMAZIONE DEL 19.6.2018
  *
  * interfaccia Iterable - definisce la proprieta' di iterabilita'
  * @author A. Luchetta
  * @version 16-02-2016
  *
  * @see Iterator
  * @param T il tipo paramatrico
  *
  */
public interface Iterable<T>
{
   /**
      genera un iteratore posizionato prima del primo elemento della sequenza
      @return iteratore
   */
   Iterator<T> iterator();
}
