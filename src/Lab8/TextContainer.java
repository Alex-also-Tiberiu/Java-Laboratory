package Lab8;

import java.util.Scanner;
import java.lang.IllegalArgumentException;
public class TextContainer implements Container {
  
 private final int leg ;

 private String[] box;
 private int counter;
  
  
   public TextContainer() {
    leg = 1;
    box = new String[leg];
    }
   
   public TextContainer(Scanner reader, String delimiter) {
    
    leg = 1;
    box = new String[leg];
    
     while(reader.hasNextLine()) {
        String line = reader.nextLine();

        
            if(!line.equals("")) {
                Scanner sc2 = new Scanner(line);
                sc2.useDelimiter("["+delimiter+"]+");         
                
               while(sc2.hasNext()) {
                   
                   String token = sc2.next();
                   add(token);
                   
                }
        sc2.close();
            }
    
   
      }  
    
   }
   
   public boolean isEmpty() {
    boolean status = false;
    
    if(box[0] == null)
      status = true;
      
      return status;
     
    }
    
   public void makeEmpty() {
    String[] newBox = new String[leg];
    box = newBox;
    counter = 0;
   
    }
    
   public int size() {
    return counter;
    
    }
    
   public void add(String aWord) {
       
    if(counter == (box.length)) {
      String[] newBox = new String[box.length*2];
      System.arraycopy(box, 0, newBox, 0, box.length);
      box = newBox;
     }
      
      box[counter] = aWord;
      counter++;
    
    }
    
   public String removeLast() {
     String last = box[counter-1];
    
       if(counter >=0) {
        box[counter-1] = null;
        counter--;}
     else
        throw new IllegalArgumentException("l'array non ha elementi");
    
     return last;   
    }
    
   public void sort() {
     String[] newBox = new String[counter];
     System.arraycopy(box, 0, newBox, 0,newBox.length);
     box = newBox;
     mergeSort(box);
    }
    
   public static void mergeSort(String[] a) {
     if(a.length < 2)
        return;
     int mid = a.length/2;
     String[] left = new String[mid];
     String[] rigth = new String[a.length - mid];
     System.arraycopy(a, 0, left, 0, mid);
     System.arraycopy(a, mid, rigth, 0, a.length - mid);
     
     mergeSort(left);
     mergeSort(rigth);
     
     merge(a, left, rigth);
     
    }
    
   public static void merge(String[] a, String[] b, String[] c) {
   
      int ia = 0, ib = 0, ic = 0;
      
    while(ib < b.length && ic < c.length) {
    
         if(b[ib].compareTo(c[ic])<0)
           a[ia++] = b[ib++];
         else  
           a[ia++] = c[ic++];
      }
      
        while(ib < b.length)
           a[ia++] = b[ib++];
        while(ic < c.length)
           a[ia++] = c[ic++];
           
       
       
    }   
      
     
     
     
     
   
}