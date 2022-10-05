package Lab9;

/**
  * Classe PTester - classe didattica
  *
  * classe di prova della classe P
  *
  * @see P
  *
  * @author A. Luchetta
  * @version 8-Dic.2016
  *
  */

public class PTester
{
   public static void main(String[] args)
   {
      final int DIM = 10;
      
      P[] v = new P[DIM];
      
      for(int i = 0; i < v.length; i++)
         v[i] = new P();
         
      System.out.println("***STAMPA ARRAY ORIGINARIO***");
      for (P e: v)
         System.out.print(e + " ");
      System.out.println();      
        
      // ordinamento dell'array v         
      ArrayAlgorithms2.mergeSort(v);
      
      System.out.println("***STAMPA ARRAY ORDINATO***");
      for (P e: v)
         System.out.print(e + " ");
      System.out.println();      
   }
}
