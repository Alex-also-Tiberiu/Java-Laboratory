package Lab13;

/**
  * FONDAMENTI DI INFORMATICA - GR. 4
  * Simulazione della Prova di Programmazione del 16-01-2020
  *
  * Classe di Prova della classe SE 
  *
  * @see SE
  * @see S
  */
public class SETester
{
   public static void main(String[] args)
   {
      final String[] STR1 = {"Charlie", "Bravo", "Alpha", "Charlie"};
      final String[] STR2 = {"Delta", "Charlie", "Bravo", "Alpha"};
      final String[] STR3 = { "Charlie"};
      SE<String> s1 = new SE<String>();
      SE<String> s2 = new SE<String>();
      SE<String> s3 = new SE<String>();
                 
      s1.add(STR1);                                          // prova metodo add
      s2.add(STR2);
      s3.add(STR3);
      
      System.out.println("SIZE S1 = " + s1.size());         // prova metodo size
      System.out.println("SIZE S2 = " + s2.size());
      
      System.out.println("HASHCODE S1 = " + s1.hashCode());    // prova hashCode
      System.out.println("HASHCODE S2 = " + s2.hashCode());      
      
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

      String[] st1 = new String[s1.size()]; 
      s1.toSortedArray(st1);         
      System.out.print("SORTED ELEMENTS S1 = ");
      for (String p : st1)
         System.out.print(p + " ");
      System.out.println(); 
      
      String[] st2 = new String[s2.size()]; 
      s2.toSortedArray(st2); 
      System.out.print("SORTED ELEMENTS S2 = ");
      for (String p : st2)
         System.out.print(p + " ");
      System.out.println();       
           
      if (s1.equals(s2))                                  // prova metodo equals
         System.out.println("S1 EQUALS S2");
      else
         System.out.println("S1 DOES NOT EQUAL S2");
         
      if (s1.contains((String)st2[0]))                  // prova metodo contains
         System.out.println("S1 CONTAINS " + st2[0]);
      else
         System.out.println("S1 DOES NOT CONTAIN " + st2[0]); 
         
      if (s1.contains((String)st2[3]))
         System.out.println("S1 CONTAINS " + st2[3]);
      else
         System.out.println("S1 DOES NOT CONTAIN " + st2[3]); 
         
      if (s1.compareTo(s2) < 0)                        // prova metodo compareTo
         System.out.println("S1 PRECEDES S2");
      else if (s1.compareTo(s2) > 0) 
         System.out.println("S1 FOLLOWS S2"); 
      else
         System.out.println("S1 EQUALS S2");
         
      if (s3.compareTo(s2) < 0) 
         System.out.println("S3 PRECEDES S2");
      else if (s3.compareTo(s2) > 0) 
         System.out.println("S3 FOLLOWS S2"); 
      else
         System.out.println("S2 EQUALS S3");                                                             
   }
}
