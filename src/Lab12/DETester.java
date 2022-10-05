package Lab12; /**
  * FONDAMENTI DI INFORMATICA - Gruppo 2
  * PROVA PRATICA DI PROGRAMMAZIONE DEL 19.6.2018
  *
  * classe DETester - classe di prova della classe DE
  * @author A. Luchetta
  * @version 21-Genn-2016
  *
  * @see Deque, Iterable, Iterator
  * @see D, DE
  * @see EmptyDequeException
  */
  import java.util.Scanner;
public class DETester
{
   public static void main(String[] args) throws java.io.IOException
   {
      Dec<String> df = new Dec<String>();                 // prova del costruttore
      Dec<String> db = new Dec<String>();                 // prova del costruttore
           
      Scanner in = new Scanner(new java.io.FileReader(args[0]));
      
      while (in.hasNext())
      {
         String s = in.next();
         df.addFirst(s);                            // prova del metodo addFirst
         db.addLast(s);                              // prova del metodo addLast
      }                                                                    
         
      // prova del metodo size
      System.out.println("SIZE = " + df.size() + " " + db.size());  

      System.out.print("TOARRAY = ");                // prova del metodo toArray
      Object[] a = df.toArray(); 
      for (int i = 0; i < a.length; i++)
         System.out.print(a[i] + " ");
      System.out.println();      
      System.out.print("TOARRAY = ");
      Object[] b = db.toArray();        
      for (int i = 0; i < b.length; i++)
         System.out.print(b[i] + " ");
      System.out.println();

      System.out.print("TOSORTEDARRAY = ");    // prova del metodo toSortedArray
      a = df.toSortedArray(); 
      for (int i = 0; i < a.length; i++)
         System.out.print(a[i] + " ");
      System.out.println();      
      System.out.print("TOSORTEDARRAY = ");                               
      b = db.toSortedArray(); 
      for (int i = 0; i < b.length; i++)
         System.out.print(b[i] + " ");
      System.out.println();
      
      // prova del metodo getMultipleElements
      System.out.print("GETMULTIPLEELEMENTS = "); 
      a = df.getMultipleElements();
      System.out.print(" MULTIPLE SIZE = " + a .length + " -> ");      
      for (int i = 0; i < a.length; i++)
         System.out.print(a[i] + " ");
      System.out.println();
            
      System.out.print("REMOVEFIRT = ");         // prova del metodo removeFirst
      while (!df.isEmpty())  
         System.out.print(df.removeFirst() + " ");
      System.out.println();
      System.out.print("REMOVELAST = ");          // prova del metodo removeLast
      while (!db.isEmpty())  
         System.out.print(db.removeLast() + " ");
      System.out.println();   
      
      // prova del metodo size
      System.out.println("SIZE = " + df.size() + " " + db.size());
   }
}
