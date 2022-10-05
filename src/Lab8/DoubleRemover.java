package Lab8; /**
  * DoubleRemover
  *
  * Contenitore di numeri interi
  * @author Adriano Luchetta
  * @version 14-Dic-2008
  */

import java.util.Scanner;

public class DoubleRemover implements Container
{
   private static final int DIM = 1;

   private int[] v;
   private int vSize;
   
   public DoubleRemover()
   {
      makeEmpty();
   }
   
   /**
      inserisce un elemento nel contenitore
      @param n il numero intero da inserire
      andamento asintotico O(1) nel caso migliore e medio
                           O(n) nel caso peggiore

   */
   public void add(int n)
   {
     if (vSize >= v.length)
        v = resize(v, 2 * v.length);
        
     v[vSize] = n;
     vSize++;
   }
   
   /**
      @return true se il contenitore e' vuoto, false altrimenti
      andamento asintotico O(1)
   
   */
   public boolean isEmpty()
   {
      return vSize == 0;
   }
   
   /**
      rende vuoto il contenitore
      andamento asintotico O(1)
   */
   public void makeEmpty()
   {
      v = new int[DIM];
      vSize = 0;
   }
   
   /**
      @return il numero di elementi nel contenitore
      andamento asintotico O(1)
   */
   public int size()
   {
      return vSize;
   }
   
   /**
      rimuove gli elementi non unici
      O(nlogn)
   */
   public void linearRemoveDoubles()
   {
      v = resize(v, vSize);
      mergesort(v);
      
      int from = 0;
      int to = 1;
      
      while (to < v.length)
         if (v[from] == v[to])
            to++;
         else
            v[++from] = v[to];

      vSize = from + 1;
   }

   /**
      rimuove gli elementi non unici
      O(n*n) nel caso peggiore e medio
   */
   public void quadraticRemoveDoubles()
   {
      for (int i = 0; i < vSize - 1; i++)
         for (int j = i + 1; j < vSize; j++)
            if (v[i] == v[j])
            {
               int k = vSize - 1;
               while (k > j && v[j] == v[k])
                  k--;

               v[j] = v[k];
               vSize = k;
            }
   }
   
   /**
      restituisce la descrizione testuale
      O(n)
   */
   public String toString()
   {
      String s = "";

      for (int i = 0; i < vSize; i++)
         s = s + v[i] + "\n";
         
      return s;
   }

   private void sort()
   {
      mergesort(v);
   }

   private static void mergesort(int[] a)
   {
      if (a.length < 2)
         return;

      int mid =  a.length / 2;
      int[] left = new int[mid]; 
      int[] right = new int[a.length - mid];
      System.arraycopy(a, 0, left, 0, mid);
      System.arraycopy(a, mid, right, 0, a.length - mid);

      mergesort(left);
      mergesort(right);
      
      merge(a, left, right);
   }

   private static void merge(int[] b, int[] l, int[] r)
   {
      int ib = 0, il = 0, ir = 0;
      
      while (il < l.length && ir < r.length)
         if (l[il] <= r[ir])
            b[ib++] = l[il++];
         else
            b[ib++] = r[ir++];
            
       while (il < l.length)
          b[ib++] = l[il++];
          
       while (ir < r.length)
          b[ib++] = r[ir++];
   }
   
   private int[] resize(int[]a, int size)
   {
      int length = a.length;
      if (size < length)
         length = size;

      int[] b = new int[size];
      System.arraycopy(a, 0, b, 0, length);
      
      return b;
   }
   
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      DoubleRemover d1 = new DoubleRemover();
      DoubleRemover d2 = new DoubleRemover();

      while (in.hasNextLine())
      {
         String s = in.nextLine();
         int n = Integer.parseInt(s);
         d1.add(n);
         d2.add(n);
      }

      d1.linearRemoveDoubles();
      d2.quadraticRemoveDoubles();

      System.out.println("***ELIMINAZIONE DOPPI LINEARE");
      System.out.println(d1.toString());
      
      System.out.println("***ELIMINAZIONE DOPPI QUADRATICA");
      System.out.println(d2.toString());   }
}
