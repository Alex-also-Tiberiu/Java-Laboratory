package Lab6.First

import java.util.Scanner;

/**
 *  TextAnalyzer - analizza un testo
 * 
 * @author Alexandru
 * @version 15/11/2019
 */
public class TextAnalyzer {
  public static void main(String[] args) {
      final int LENGTH = 1;
      Scanner in = new Scanner(System.in);
      MyStringVector vec = new MyStringVector();      
      MyStringVector vec2 = new MyStringVector();
      
      while(in.hasNextLine()) {
         String line = in.nextLine();
         vec.add(line);
         //System.out.println(line);
          
        }
      
      String[] newvec = vec.toArray();
      
      
      for(int i = 0; i < newvec.length; i++) {
          Scanner nin = new Scanner(newvec[i]);
          
          while(nin.hasNext()) {
              String word = nin.next();
              vec2.add(word);
              
            }
           
        }
      
      System.out.println(vec.toString());
      
      in.close();
    }
}
