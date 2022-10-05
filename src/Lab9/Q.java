package Lab9;

/**
  * Classe Q - classe didattica
  *
  * Non realizza l'interfaccia java.lang.Comparable<T> ma definisce il metodo compareTo
  *
  * @see Comparable
  *
  * @author A. Luchetta
  * @version 8-Dic.2016
  *
  */

public class Q implements Comparable<Q>
{
   // variabile di esemplare
   private final int p;
   
   // costruttore
   public Q()
   {
      p = (int)(1 +  99 * Math.random()); // genera un numero intero casuale nell'intervallo [1, 100] 
   }
   
   /*
      Confronta questo esemplare con l'esemplare specificato
      
      @param n l'esemplare specificato
      @return zero se questo esemplare coincide con l'esemplare specificato
              un numero negativo se questo esemplare precede l'esemplare specificato
              un numero positivo altrimenti.
   */
   public int compareTo(Q n)
   {
      return p - n.p;
   }
   
   /**
      Descrizione testuale
   */
   public String toString()
   {
      return "" + p;
   }  
}
