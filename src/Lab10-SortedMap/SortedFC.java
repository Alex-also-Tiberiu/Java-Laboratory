package Lab10 /**
   Simulazione della prova d'esame
   20-Genn-2009
   Classe FC - classe eseguibile di prova
   @author A. Luchetta
   @version 20-Genn-2009
   @see Map
*/

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SortedFC
{
   public static void main(String[] args) throws IOException
   {
      Scanner in = new Scanner(new FileReader(args[0])).useDelimiter("[^a-zA-Z]+");;
      MySortedMap m = new MySortedMap();
      
      while (in.hasNext())
      {
         String s = in.next();

         Object x = m.get(s);
         if (x == null)
            m.put(s, 1);
         else
            m.put(s, (Integer)x + 1);
      }

      Comparable[] keys = m.sortedKeys();
      
      for (int i = 0; i< keys.length; i++)
         System.out.println(keys[i] + " : " + m.get(keys[i]));
   }
}
