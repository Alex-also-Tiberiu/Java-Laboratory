package Lab7;

import java.lang.IllegalArgumentException;

public class RecursiveNumberLister {
 
 public RecursiveNumberLister() {
 
 }

 
 public static String recursivelyListNumbers(int n) {
   
   String s = " ";
     
   if (n ==1)
      return s += 1;
     
   if (n <= 0)
      throw new IllegalArgumentException();
      
      s = recursivelyListNumbers(n-1)+" "+n;
      return s;
   
 }
 
}
