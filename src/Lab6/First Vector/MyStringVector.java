package Lab6.First

import java.util.ArrayList;
import java.util.Arrays;

/**
 *  MyStringVector realizza un vettore di stringhe. Usa come struttura dati un array riempito parzialmente 
 *  che viene dinamicamente modificato in caso di necessità.
 * 
 * @author Alexandru Tiberiu Vilcu 
 * @version 15/11/2019
 * @param LENGTH - lunghezza array iniziale
 * 
 * 
 */
public class MyStringVector
{
  private String[] v; 
  private final int LENGTH = 1;
  private int counter;
  
  /** MyStringVector - costruisce un vettore vuoto con un array interno di dimensione predefinita
   * 
   * 
   */
   public MyStringVector() {
       v = new String[LENGTH];
       counter = 0;
    }
    
    /**
     *  add- inserisce l'elemento specificato nella posizione specificata in questo vettore
     * 
     */
  
  public void add(int index, String s) {
    if(s == null)
        return ;
       
    if(counter == v.length-1) {
        
         String[] newv = Arrays.copyOf(v , 2*v.length); 
         v = newv;
     }
      
      for( int i = index ; i < v.length ; i++) {

        v[index+1] = v[index];
         
    }

        v[index] = s;
        counter++;
    
    }
    
    /**
     *  add- se l'elemento inserito non vale null, allora viene inserito in coda al vettore
     */
  public void add(String s) {
      if(s == null)
         return;
        
      if(counter == v.length-1) {
          String[] newv = Arrays.copyOf(v , 2*v.length);
          v = newv;
          
        }
      
      v[counter] = s;
      counter ++;
    }
   
    /**
     *  capacity - restituisce la capacità del vettore
     */
   public int capacity(){
       
      return counter;
      
    }
    
    /**
     *  contains - restituisce true se questo vettore contiene l'elemento specificato
     */
   public boolean contains(String s){
      String find = "" + s;
      boolean cont = false;
       for(String element : v){
          if(find == element)
            cont = true;   
          
        }
        
      return cont;
    }
    
    /**
     *  elementAt - restituisce l'elemento specificato, altrimenti restituisce null
     */
   public String elementAt(int index) {
      int ix = index;
      if(v[ix] != null)
       return v[ix];
      else
       return null;
       
    }
    
    /**
     *  indexof - restituisce l'indice della prima occorrenza dell'elelemento specificato in questo 
     *  vettore, 0-1 se questo vettore non contiene elementi
     */
   public int indexof(String s) {
      String find = ""+s;
      int index = 0;
      for(int i = 0; i < v.length ; i++)
         if(v[i] == find)
           index = i;
         
      return index;     
    }
   
    /**
     * isEmpty - restituisce true se il vettore è vuoto
     * 
     */
  public boolean isEmpty(String s) {
        return counter <=0;
        
    }
    
    /**
     *  makeEmpty - rimuove tutti gli elementi di questo vettore imposta la sua dimensione a zero
     * 
     */
  public void makeEmpty(){
      String[] newv = new String[LENGTH];
      v = newv;
    }
    
    /**
     *  max - restituisce l'elemento massimo in ordine lessicografico di questo vettore
     * 
     */
  public String max() {
            String first = "";
      String second = "";
      String finale = "";
      for(int i = 0; i < v.length-1 ; i++) {
          first = v[i];
          second = v[i+1];
         if(first.compareTo(second) >= 0)
           finale = first;
         else
           finale = second;
         
        }
        
      return finale;  
    }
    
    
    /**
     *  min - restituisce l'lemento minimo in ordine lessicografico di questo vettore
     * 
     */
  public String min() {
      String first = "";
      String second = "";
      String finale = "";
      for(int i = 0; i < v.length-1 ; i++) {
          first = v[i];
          second = v[i+1];
         if(first.compareTo(second) <= 0)
           finale = first;
         else
           finale = second;
         
        }
        
      return finale;  
    }
    
    /**
     *  remove - rimuove l'elemento all'indice specificato, restituendolo
     * 
     */
  public String remove(int index) {
      String removed = null;
      if(index >= 0 && index < size()){
          removed = v[index];
          
      for(int i = index ; i < v.length-1 ; i++) {
         v[index] = v[index+1]; 
        }
      v[counter] = null;
      counter--;
    }
      return removed;
    }
    
    /**
     *  set - sostituisce l'elemento alla posizione specificata in questo vettore con l'elemento 
     *  specificato e restituisce il valore precedentemente memorizzato
     * 
     */
  public String set(int index, String s) {
      String replaced = null;
   
      if(index >= 0 && index < size()){
          replaced = v[index];
          v[index] = s;
              
            }
         return replaced; 
         
        }
        
    
    
    /**
     *  size - restituisce il numero di componenti in questo vettore
     * 
     */
  public int size() {
      int size = counter + 1;
      return size;
    }
    
    /**
     *  toArray - restituisce un array contenente tutti gli elementi in questo vettore nell'ordine 
     *  corretto
     * 
     */
  public String[] toArray() {
      String[] newv = Arrays.copyOf( v , counter+1);
      v = newv;
      return v;
    }
    
    /**
     *  toString - restituisce una stringa contente gli elementi di questo array in ordine, un 
     *  elemento per riga
     * 
     */
  public String toString() {
      String elem = "";
      for(int i = 0 ; i < counter+1 ; i++) {
          elem = elem + v[i] +"\n";
    }
      return elem;
    }
  
}
