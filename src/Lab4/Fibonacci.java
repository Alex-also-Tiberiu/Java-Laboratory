package Lab4;

import java.util.Scanner;
public class Fibonacci
{
 public static void main(String[] args)
 {
 	
 	Scanner in= new Scanner(System.in);
 	System.out.println("inserire un numero maggiore di 2 per vedere le successive due successioni di fibonacci");
 	int f= in.nextInt();
 	final int max=Integer.MAX_VALUE;
 	int fib=(f-2)+(f-1);
 	String conv=Integer.toString(fib);
 	String suc="";
 	
 	
 	if(f>2)  //pn(pn-2)+(pn-1)
 		{
 		  while(max>=fib)
 		  	{
 		  		fib=(fib-2)+(fib-1);
 		  		suc=conv+" "+suc;
 		  		
 		  	}
 		  	
 		}
 		
 	else
 	 System.out.println("inserisci un numero maggiore di 2");
 	 
 }
 


}
