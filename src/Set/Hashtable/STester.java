package Set.Hashtable;

/**
  * classe STester classe di prova della classe S
  * @author A. Luchetta
  * @version 14-Genn-2016
  *
  * @see Set
  * @see S
  * @see Pair
  */
public class STester
{
   public static void main(String[] args) throws java.io.IOException
   {
      Set<String> s = new S<String>();                                      // prova del costruttore
     
      java.util.Scanner in = new java.util.Scanner(new java.io.FileReader(args[0]));
      
      while (in.hasNext())
         s.add(in.next());                                                   // prova del metodo add
         
      System.out.println("SIZE = " + s.size());                             // prova del metodo size  

      System.out.print("TOARRAY = ");                                    // prova del metodo toArray
      Object[] a = s.toArray(); 
      for (int i = 0; i < a.length; i++)
         System.out.print(a[i] + " ");
      System.out.println();
      
      Set b = s.cartesianProduct(new S(new String[] {"A", "B", "C"}));           // prova del metodo
      System.out.println("CARTESIAN_PRODUCT = " + b.size() + " coppie");         // cartesianProduct  
      Object[] p = b.toArray();
      for (int i = 0; i < p.length; i++)
         System.out.print(p[i] + " ");
      System.out.println();             
   }
}
