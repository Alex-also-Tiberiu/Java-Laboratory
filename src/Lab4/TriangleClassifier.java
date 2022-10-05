package Lab4;

import java.util.Scanner;
public class TriangleClassifier
{
 public static void main(String[]args)
 {
 
  Scanner in=new Scanner(System.in);
  System.out.println("**************************************************************");
  System.out.println("              IDENTIFICATORE DI TRIANGOLI");
  System.out.println("**************************************************************");
  System.out.println("inserire la lunghezza di 3 lati di un triangolo");
  
  int a=0;
  int b=0;
  int c=0;
  
  while(in.hasNext())
  	{
  	 int token1=in.nextInt();
  	 int token2=in.nextInt();
  	 int token3=in.nextInt();
  	 a=token1;
  	 b=token2;
  	 c=token3;
  	 System.out.println("lato a: "+a+", lato b: "+b+" ,lato c: "+c);
  	 break;
  	}
  	
  	int maxab=Math.max(a,b);
  	int minab=Math.min(a,b);
  	int maxbc=Math.max(b,c);
  	int minbc=Math.min(b,c);
  	int maxac=Math.max(a,c);
  	int minac=Math.min(a,c);
  	
  	System.out.println("max-ab:"+maxab+",min-ab:"+minab+",max-bc:"+maxbc+",min-bc:"+minbc+",max-ac:"+maxac+",min-ac:"+minac);
  	
  
  	in.close();
  	
 }
}
