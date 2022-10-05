package Lab7;

public class RecursiveMin{
private int arra[];
  private int size;
  
  public RecursiveMin(int[] a , int aSize) {
      size = aSize;
      arra = new int[size];
      arra = a;
    }
    
  public int findMin() {
     
     int minimo = RecursiveMin.recursivelyMin(arra , size);
     return minimo;  
    }
    
 private static int recursivelyMin(int[] a , int aSize) {
     
     int elements = aSize-1;
     int first = 0;
     int last = a[elements];
     int min = a[first];
     
     //for(int i = elements; i >  ;i--){ 
        //if( a[first] < last) {
         if(a[elements] == a[first])
            return min = a[elements];
            
         else if(last < a[first]){
            a[first] = last;  
            min = last;
            min = RecursiveMin.recursivelyMin( a , aSize-1);
            return min;
        }
        else {
            min = a[first];
            min = RecursiveMin.recursivelyMin( a , aSize-1);
            return min;
        }
        
        
}

}