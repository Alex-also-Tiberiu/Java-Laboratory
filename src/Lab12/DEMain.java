package Lab12; /**
  * Classe DEMain
  * Classe di prova della classe DE
  *
  * @param K tipo parametrico della chiave
  * @param V tipo parametrico del valore
  *
  * @see DE
  * @author A. Luchetta
  * @version 24-12-2018
  *
  */
import java.util.Scanner;
public class DEMain
{
   public static void main(String[] args) throws java.io.IOException
   {
      Scanner in = new Scanner(new java.io.FileReader(args[0]));
      
      DE d = new DE();
      
      while (in.hasNextLine())
      {
         Scanner tk = new Scanner(in.nextLine()).useDelimiter("[#]+");
         d.put(tk.next(), tk.next());                    // prova del metodo put
         tk.close();       
      }
      
      in.close();
            
      Comparable[] k = d.sortedKeySet();            // prova del metodo sortedKeySet

      System.out.println("SIZE: " + d.size());          // prova del metodo size
      
      System.out.println("GETALL: ");                 // prova del metodo getAll
      for (int i = 0; i < k.length; i++)
      {
         Object[] v = d.getAll(k[i]);
         for (int j = 0; j < v.length; j++)
           System.out.println((String)(k[i]) + " " + v[j]);  
      }
      
      System.out.println("CONTAINSKEY: ");       // prova del metodo containsKey 
      for (int i = 0; i < k.length; i++)
         if (d.containsKey(k[i])) 
            System.out.println(k[i] + " yes");
         else
            System.out.println(k[i] + " no"); 
            
      System.out.println("ISMULTIPLEKEY: ");   // prova del metodo isMultipleKey 
      for (int i = 0; i < k.length; i++)
         if (d.isMultipleKey(k[i])) 
            System.out.println(k[i] + " multiple");
         else
            System.out.println(k[i] + " single");  
         
      System.out.println("REMOVE: ");                 // prova del metodo remove
      for (int i = 0; i < k.length; i++)
         while (d.get(k[i]) != null)
          System.out.println((String)(k[i]) + " " + d.remove(k[i]));  
      
         
     System.out.println("SIZE: " + d.size());          // prova del metodo size   
   }
}
