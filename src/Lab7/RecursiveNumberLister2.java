package Lab7;

import java.lang.IllegalArgumentException;

public class RecursiveNumberLister2
{
    public RecursiveNumberLister2(){
    }
    
    public static String recursivelyList(int n) {
        
        int columns = 10;
        String s ="";
        
        if(n==1)
          return s += 1;
        
        s = recursivelyList(n-1)+"  " +n;
        
        if( (n%columns) == 0 )
          s += "\n";
        
        return s;
        
    }
}
