package Set.LinkedList;

/**
  * classe Pair, coppia ordinata confrontabile
  *
  * @author A. Luchetta
  * @version 14-Genn-2016
  */
public class Pair implements Comparable<Pair> //--Coppia ordinata comparabile
{
   private final Comparable first;
   private final Comparable second;
   
   /**
      inizializza la coppia ordinata con gli elementi specificati
      @param f primo elemento specificato
      @param s secondo elemento specificato
   */
   public Pair(Comparable f, Comparable s)
   {
      first  = f;
      second = s;
   }
   
   /** 
      @param p coppia specificata
      @return true se questa coppia e la coppia specificata sono uguali, false altrimenti. Le coppie
              (a,b) e (c,d) sono uguali se e solo se a e' uguale a c e b e' uguale a d 
   */
   public boolean equals(Object p)
   {   
      // se p non e' una coppia, allora sicuramente questa coppia e p sono diversi
      if (!(p instanceof Pair))
         return false;
         
      // in questo modo i metodi equals e compareTo sono coerenti fra loro 
      return compareTo((Pair) p) == 0;
   }
   
   /**
      @return descrizione testuale della coppia nella forma "(a,b)" con a e b il primo e secondo
              elemento della coppia, rispettivamente
   */
   public String toString()
   {
      return "(" + first + "," + second + ")";
   }
    
   /**
      @param p coppia specificata
      @return 0 se questa coppia e la coppia specificata sono uguali. Se non sono uguali restituisce
                il confronto fra i primi elementi se sono diversi, altrimenti restituisce il
                confronto fra i secondi elementi.
       Esempio: (1,2) precede (2,1) (primi elementi diversi: confronto fra i primi elementi).
                (1,2) precede (1,3) (primi elementi uguali: confronto fra i secondi elementi).
   */
   public int compareTo(Pair p)
   {
      if (first.compareTo(p.first) == 0 && second.compareTo(p.second) == 0)
         return 0;       
      else if (first.compareTo(p.first) != 0)
         return first.compareTo(p.first);
      else
         return second.compareTo(p.second);      
   }
}
