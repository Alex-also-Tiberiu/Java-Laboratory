package Lab4;

import java.util.Scanner;
public class Factor
{
 public static void main(String[]args)
 {
 	Scanner in= new Scanner(System.in);
 	System.out.println("inserire un numero da scomporre in fattori primi");
 	int n= in.nextInt();
 	int fact=2;
 	int iniziale=n;
 	String f="";
 	
 	while(fact<=n)
 		{ 
 			if(n%fact==0)
 				{
 			  	String ses=Integer.toString(fact);
 			  	f= f+" * "+ses;
 			  	n=n/fact;
 			  	
 			  }
 			else
 			 {fact++;}
 		}
 	int lung=f.length();
 	String fine=f.substring(3,lung);
 	System.out.println(iniziale+" = "+fine);
 	in.close();
 	
 }
 
}
