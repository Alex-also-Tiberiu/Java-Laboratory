package Lab7;


public class recursiveTester
{
  public static void main(String[] args) {
         
    int counter = 0;
    int n = Integer.parseInt(args[counter]);
    
    String s = RecursiveNumberLister.recursivelyListNumbers(n);
    
    System.out.println(s);
    
   }
}
