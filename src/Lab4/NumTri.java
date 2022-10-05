package Lab4;

import java.util.Scanner;
public class NumTri
{
 public static void main(String[] args)
 {
 	
 	Scanner in= new Scanner(System.in);
 	System.out.println("inserire un k casuale");
 	int k= in.nextInt();
 	String is=Integer.toString(k);
 	final long max=Long.MAX_VALUE;
 	long maxbound=max-10000;
 	String tri="";
 	int t=0;
 	
 	if(k>0)
 		{ 
 			while((maxbound>=t))
 				{
 					t=(k*(k+1))/2;
 					String ti=Integer.toString(t);
 					tri=tri+" "+ti;
 					
 				}
 		}
 		
 	System.out.println(tri);
 	in.close();
 	
 }
 
}
 	
 	
 	
