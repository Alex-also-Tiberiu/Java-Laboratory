package Lab7;

import java.util.Random;
import javax.swing.JOptionPane;
import java.lang.IllegalArgumentException;
import java.util.Arrays;


public class RecursiveMinTester
{
 public static void main(String[] args) {
      
   Random ran = new Random();
   int counter = 0;
   int n = Integer.parseInt(args[counter]);
   counter++;
   int dim = Integer.parseInt(args[counter]);
   
   if(dim <= 0)
        throw new IllegalArgumentException();
   
     int a[] = new int[dim];   
        
   for(int i = 0; i < dim; i++) {
     
       a[i] = 1 + ran.nextInt(n);  
       
    }
    
    RecursiveMin find = new RecursiveMin(a , dim);
    
    int min = find.findMin();
    
    JOptionPane.showMessageDialog(null , "dim = "+dim+"n = "+n+"\n"+"Arrays = "+Arrays.toString(a)+"\n il minimo e' = "+min);
    
    
  }
}
