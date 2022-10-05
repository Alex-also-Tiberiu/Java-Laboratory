package Lab7;

import java.lang.IllegalArgumentException;


public class RecursiveMeanCalculator
{
    
    int[] arra;
    int size;
    
    public RecursiveMeanCalculator(int[] a, int aSize){
        if(aSize <=0)
          throw new IllegalArgumentException();
        
        size = aSize;  
        arra = new int[size];
        arra = a;
        
    }
    
    public double recursiveAverage(){
     
        double average = 0;
        
        if(size > 1){   
        
        average = (RecursiveMeanCalculator.recursivelyComputeMean(arra, size))/size;
    
    }
      else if (size == 1){
        
        average = arra[1];
        
    }
    
        return average;
    }
    
    private static double recursivelyComputeMean(int[] a, int aSize){

        int last = aSize-1;
        double sum = 0;
        
        if(aSize == 1)
            
          return a[last];
        
        else if(aSize > 0)
            
           sum = a[last]+recursivelyComputeMean(a , aSize-1);
         
        
        return sum;
    
    }
    
    public double iterativelyAverage(){
        
        return RecursiveMeanCalculator.iterativelyComputeMean( arra , size);
         
    }
    
     private static double iterativelyComputeMean(int[] a , int aSize) {
             
            int sum = 0;
            
            for(int i = 0; i < aSize; i++){
               
                sum += a[i];
               
            }
            
            return sum/aSize;
    }
    
    
}
