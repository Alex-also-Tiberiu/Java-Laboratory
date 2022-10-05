package Lab9;

/**
  * Classe QTester - classe didattica
  *
  * classe di prova della classe Q
  *
  * @see Q
  *
  * @author A. Luchetta
  * @version 8-Dic.2016
  *
  */

public class QTester
{
   public static void main(String[] args)
   {
      final int DIM = 10;
      
      Q[] v = new Q[DIM];
      
      for(int i = 0; i < v.length; i++)
         v[i] = new Q();
         
      System.out.println("***STAMPA ARRAY ORIGINARIO***");
      for (Q e: v)
         System.out.print(e + " ");
      System.out.println();      
        
      // ordinamento dell'array v         
      ArrayAlgorithms2.mergeSort(v);
      
      System.out.println("***STAMPA ARRAY ORDINATO***");
      for (Q e: v)
         System.out.print(e + " ");
      System.out.println();      
   }
}
