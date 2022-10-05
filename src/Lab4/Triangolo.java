package Lab4;

import java.util.Scanner;
public class Triangolo
{
 public static void main(String[] args)
 {
  Scanner in=new Scanner(System.in);
  System.out.println("inserire 3 lati");
  
  int a=0;
  int b=0;
  int c=0;
  
  while(in.hasNext())
  	{
  	 String token1=in.next();
  	 String token2=in.next();
  	 String token3=in.next();
  	 a=Integer.parseInt(token1);
  	 b=Integer.parseInt(token2);
  	 c=Integer.parseInt(token3);
  	}
  	
  	boolean ar1=false;
  	boolean ar2=false;
  	boolean ar3=false;
  	//boolean ar12=false;
  	//boolean ar13=false;
  	//boolean ar23=false;
  	
  if(a==b)
  	{ ar1=true;}
  if(b==c)
  	{ ar2=true;}
  if(a==c)
  	{ ar3=true;}
  else
    {System.out.println("è un triangolo scaleno");
    }
  
