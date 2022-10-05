package Lab7;

public class MiniFinder
{ private int arra[];
  private int size;
  
  public MiniFinder(int[] a , int aSize) {
      size = aSize;
      arra = new int[size];
      arra = a;
    }
    
  public int findMin() {
     
     int minimo = MiniFinder.recursivelyFindMin(arra , size);
     return minimo;  
    }
    
  private static int recursivelyFindMin(int[] a , int aSize) {
      
      int first = 0;
      int min = a[first];
      
      for(int i = 1; i < aSize; i++) {
         
          if(a[i] < min)
           min = a[i];
        }
        
        return min;
    }
 }

