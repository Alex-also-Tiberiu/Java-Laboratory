package Set.Hashtable;

public class Pair implements Comparable<Pair> //--Coppia ordinata comparabile
{
   // parte privata
   private Comparable first;
   private Comparable second;
   
   /**inizializza la coppia ordinata con gli elementi specificati
      @param f primo elemento specificato
      @param s secondo elemento specificato
   */
   public Pair(Comparable f, Comparable s)
   {
      first = f;
      second = s;
   }
   
   /**@return true se questa coppia e la coppia specificata sono uguali, false altrimenti. Le coppie
              (a,b) e (c,d) sono uguali se e solo se a e c sono uguali e b e d sono uguali 
      @param p coppia specificata
   */
   public boolean equals(Object p)
   {
      Pair c = (Pair)p;
      return first.equals(c.first) && second.equals(c.second);
   }
   
   /**@return descrizione testuale della coppia nella forma "(a,b)" con a e b il primo e secondo
              elemento della coppia, rispettivamente
   */
   public String toString()
   {
      return "(" + first + "," + second + ")";
   }
   
   /**@param p coppia specificata
      @return 0 se questa coppia e la coppia specificata sono uguali, altrimenti se i primi elementi
              sono diversi restituisce il loro confronto, se sono uguali il confronto fra i secondi
              elementi.
      Esempio: (1,2) precede (2,1) (primi elementi diversi: confronto fra i primi elementi).
               (1,2) precede (1,3) (primi elementi uguali: confronto fra i secondi elementi).
   */
   public int compareTo(Pair p)
   {
      if (equals(p))
         return 0;
         
      if (!first.equals(p.first))
         return first.compareTo(p.first);
      else
         return second.compareTo(p.second);         
   }
}
