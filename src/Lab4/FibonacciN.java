package Lab4;

import java.util.Scanner;
public class FibonacciN
{
 public static void main(String[] args)
 {
 	
 	Scanner in= new Scanner(System.in);
 	System.out.println("inserire un numero maggiore di 2 per vedere le successive due successioni di fibonacci");
 	long f= in.nextInt();
 	long a=f-1;
 	long b=f-2;
 	String fi=Long.toString(f);
 	String ai=Long.toString(a);
 	String bi=Long.toString(b);
 	String fibo= fi+" "+bi+" "+ai;
 	final int max=Integer.MAX_VALUE;
 	int maxbound=max-1000;
 	
 	if(f>=2)
 		{ 
 			while((maxbound>=f))
 				{
 					f=a+b;
 					a=f-1;
 					b=f-2;
 					String fw=Long.toString(f);
 					fibo=fw+" "+fibo;
 					
 				}
 		}
 		
 	System.out.println(fibo);
 	
 }
 
}
