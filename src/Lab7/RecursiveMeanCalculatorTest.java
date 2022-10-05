package Lab7;

import java.util.Random;
import javax.swing.JOptionPane;
import java.util.Arrays;


public class RecursiveMeanCalculatorTest
{
  public static void main(String[] args) {
      
      Random ran = new Random();
      int dimension = Integer.parseInt(args[0]);
      int maxValue = Integer.parseInt(args[1]);
      int[] arra = new int[dimension];
      
      for(int i = 0; i < dimension; i++) {
          
          arra[i] = ran.nextInt(maxValue);
          
        }
        
      RecursiveMeanCalculator obj = new RecursiveMeanCalculator(arra , dimension);
        
      double average = obj.recursiveAverage();
      double average2 = obj.iterativelyAverage();
      
      JOptionPane.showMessageDialog(null, "La media e' di :"+average+"\n"+Arrays.toString(arra));
      JOptionPane.showMessageDialog(null, "La media e' di :"+average2+"\n"+Arrays.toString(arra));
      
  }
}
