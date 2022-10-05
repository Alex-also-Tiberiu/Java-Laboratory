package Lab13;

/**
  * FONDAMENTI DI INFORMATICA - GR. 4
  * Simulazione della Prova di Programmazione del 16-01-2020
  *
  * Classe di Prova della classe S
  *
  * @see S
  */
public class STester
{
   public static void main(String[] args)
   {
      final String[] STR1 = {"Charlie", "Bravo", "Alpha", "Charlie"};
      final String[] STR2 = {"Delta", "Charlie", "Bravo", "Alpha"};
      final String[] STR3 = { "Charlie"};
      S<String> s1 = new S<String>();
      S<String> s2 = new S<String>();
      S<String> s3 = new S<String>();
                 
      s1.add(STR1);                                          // prova metodo add
      s2.add(STR2);
      s3.add(STR3);
      
      System.out.println("SIZE S1 = " + s1.size());         // prova metodo size
      System.out.println("SIZE S2 = " + s2.size());  
      
      Iterator<String> iter = s1.iterator();            // prova metodo iterator
      System.out.print("ELEMENTS S1 = ");
      while (iter.hasNext())                             // prova metodo hasNext
         System.out.print(iter.next() + " ");               // prova metodo next
      System.out.println(); 

      iter = s2.iterator();
      System.out.print("ELEMENTS S2 = ");
      while (iter.hasNext())
         System.out.print(iter.next() + " ");
      System.out.println();      
           
      if (s1.equals(s2))                                  // prova metodo equals
         System.out.println("S1 EQUALS S2");
      else
         System.out.println("S1 DOES NOT EQUAL S2");
         
      if (s1.contains(STR1[2]))                        // prova metodo contains
         System.out.println("S1 CONTAINS " + STR1[2]);
      else
         System.out.println("S1 DOES NOT CONTAIN " + STR1[2]); 
         
      if (s1.contains(STR2[0]))
         System.out.println("S1 CONTAINS " + STR2[0]);
      else
         System.out.println("S1 DOES NOT CONTAIN " + STR2[0]);                                                       
   }
}
