package Lab5;

public class Triangolo{

private int a = 0;
private int b = 0;
private int c = 0;
String classeTri = "";

     //definisce l'oggetto triangolo
public Triangolo( int la, int lb, int lc){
  a = la;
  b = lb;
  c = lc;
 }
    //classificazione del triangolo
public String info(){
  int max = Math.max(Math.max(a,b),c);
  int min1 = Math.min(a,b);
  int min2 = Math.min(b,c);
  
  
  if(min1 + min2 > max){
      
      if((a == b) && (b == c))
        { return classeTri = classeTri + " è un triangolo equilatero "; }
        
      else if((a == b) || (b == c) || (a == c))
        { return classeTri = classeTri + " è un triangolo isoscle"; }
        
      else if((a!=b) && (b!=c))
        { return classeTri = classeTri + " è un triangolo scaleno"; }
  }
  else{
    return classeTri = classeTri + " non può essere un triangolo il lato maggiore deve essere minore della somma dei 2 minori!!!";}
    
   if((max*max - min1*min1 - min2*min2) < 0)
     { classeTri = classeTri + ", è un triangolo acutangolo."; 
       return classeTri;
     }
    
   if((max*max - min1*min1 - min2*min2) == 0)
     { classeTri = classeTri + ", è un triangolo rettangolo."; 
       return classeTri;
     }
  
   if((max*max - min1*min1 - min2*min2) > 0)
     { classeTri = classeTri + ", è un triangolo ottusangolo."; 
       return classeTri;
     }
    

  
   return classeTri; 
}
    
   //descrizione dei lati del triangolo
   
  public String toString(){
    String latoa = Integer.toString(a);
    String latob = Integer.toString(b);
    String latoc = Integer.toString(c);
    String t= "Triangolo" + latoa + "," + latob + "," + latoc;
    return t;
  }

  public int p(){
    int perimetro = a + b + c;
    return perimetro;
  }

  public double area(){
    double aarea = Math.sqrt(p()*(p()-a)*(p()-b)*(p()-c));
    return aarea;
  } 
 
  public double h(){
    int min = Math.min(Math.min(a,b),c);
    double altezza = (area()*2)/min;
    return altezza;
  } 
}
 
 
      
