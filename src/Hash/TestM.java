package Hash; /**
  * Classe TestM
  * Classe di prova della classe M
  *
  * @param K tipo parametrico della chiave
  * @param V tipo parametrico del valore
  *
  * @see ME
  * @author A. Luchetta
  * @version 24-12-2018
  *
  */
import java.util.Scanner;
public class TestM
{
   public static void main(String[] args) throws java.io.IOException
   {
      Scanner in = new Scanner(new java.io.FileReader(args[0]));
      
      M<String, String> m = new M<String, String>();
      
      while (in.hasNextLine())
      {
         Scanner tk = new Scanner(in.nextLine()).useDelimiter("[#]+");
         m.put(tk.next(), tk.next()); 
         tk.close();       
      }
      
      in.close();
         
      Comparable[] k = m.keys();   

      System.out.println("SIZE: " + m.size());
      
      System.out.println("GET: ");
      for (int i = 0; i < k.length; i++)
         System.out.println((String)(k[i]) + " " + m.get((String)k[i]));  
      
       System.out.println("REMOVE: ");
       for (int i = 0; i < k.length; i++)
         System.out.println(k[i] + " " + m.remove((String)k[i])); 
         
      System.out.println("SIZE: " + m.size());                 
   }
}
