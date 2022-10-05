package Hash; /**
  * Classe MEMain
  * Classe di prova della classe ME
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
public class MEMain
{
   public static void main(String[] args) throws java.io.IOException
   {
      Scanner in = new Scanner(new java.io.FileReader(args[0]));
      
      ME<String, String> m = new ME<String, String>();
      
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
              
      String mid = (String)k[k.length/2];      
      SortedMap<String, String> hm = m.headMap(mid);   
      SortedMap<String, String> tm = m.tailMap(mid);
      
      System.out.println("SIZEHM: " + hm.size());
      
      Comparable[] kk = hm.keys();
      
      System.out.println("GETHM: ");
      for (int i = 0; i < kk.length; i++)
         System.out.println(kk[i] + " " + hm.get((String)kk[i]));  
         
      System.out.println("REMOVEHM: ");
       for (int i = 0; i < kk.length; i++)
         System.out.println(kk[i] + " " + hm.remove((String)kk[i])); 
         
      System.out.println("SIZEHM: " + hm.size()); 
      
      kk = tm.keys();
      
      System.out.println("GETTM: ");
      for (int i = 0; i < kk.length; i++)
         System.out.println(kk[i] + " " + tm.get((String)kk[i]));  
         
      System.out.println("REMOVETM: ");
       for (int i = 0; i < kk.length; i++)
         System.out.println(kk[i] + " " + tm.remove((String)kk[i])); 
         
      System.out.println("SIZETM: " + tm.size()); 
      
       System.out.println("REMOVE: ");
       for (int i = 0; i < k.length; i++)
         System.out.println(k[i] + " " + m.remove((String)k[i])); 
         
      System.out.println("SIZE: " + m.size());                 
   }
}
