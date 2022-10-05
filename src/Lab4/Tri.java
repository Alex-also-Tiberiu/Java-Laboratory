package Lab4;

import java.util.Scanner;
public class Tri
{
 public static void main(String[] args)
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
  	int tri=0;
  	//boolean z=true;
  	System.out.println();
  	System.out.println("max-ab:"+maxab+",min-ab:"+minab+",max-bc:"+maxbc+",min-bc:"+minbc+",max-ac:"+maxac+",min-ac:"+minac);
  	System.out.println();
  	
  	
                                    // verifica dei lati congruenti
																		//--------------------------------
  	//while(z==true)
  	//{
  	if(maxab==minab)
  		{if(maxbc==minbc)
  		 	{System.out.println("è un triangolo regolare");
  		 	 //z=false;
  		 	 //break;
  		 	}
  		 else
  		 	{System.out.println("è un triangolo isoscele");
  		 	 //z=false;
  		 	 //break;
  		 	}}
  	else
  		{tri++;}	 	
  	if(maxbc==minbc)
  		{if(maxac==minac)
  			{System.out.println("è un triangolo regolare");
  			 //z=false;
  			 //break;
  			}
  		 else
  			 {System.out.println("è un triangolo isoscele");
  			 //z=false;
  			 //break;	
  			 }}
  	else
  		{tri++;}	 	
  	if(maxac==minac)
  		{if(maxab==minab)
  			 {System.out.println("è un triangolo regolare");
  			 //z=false;
  			 //break;
  			 }
  		 else
  		 	 {System.out.println("è un triangolo isoscele");
  		 	 //z=false;
  		 	 //break;
  		 	 }}
  	else
  		{tri++;}	  		
  	
  	//}
  	
  	if(tri==3)
  		{System.out.println("è un triangolo scaleno");}
  	
  	in.close();
  	
  	/*                                           verifica degli angoli
  	                                           -------------------------                             */
  	
  	
  	if((a>=b)&&(b>=c))
  		{if((a*a-b*b-c*c)<0)
  		 	{System.out.println("è un triangolo acutangolo");
  		 	 return;}
  		 if((a*a-b*b-c*c)==0)
  		  {System.out.println("è un triangolo rettangolo");}
  		 if((a*a-b*b-c*c)>0)
  		  {System.out.println("è un triangolo ottusangolo");}}
  	else if((a>=c)&&(c>=b))
  		{if((a*a-c*c-b*b)<0)
  			{System.out.println("è un triangolo acutangolo");}
  		 if((a*a-c*c-b*b)==0)
  		  {System.out.println("è un triangolo rettangolo");}
  		 if((a*a-c*c-b*b)>0)
  		  {System.out.println("è un triangolo ottusangolo");}}
  	else if((b>=a)&&(a>=c))
  	 {if((b*b-a*a-c*c)<0)
  		 {System.out.println("è un triangolo acutangolo");}
  		if((b*b-a*a-c*c)==0)
  		 {System.out.println("è un triangolo rettangolo");}
  		if((b*b-a*a-c*c)>0)
  		 {System.out.println("è un triangolo ottusangolo");}}
  	else if((b>=c)&&(c>=a))
  	 {if((b*b-c*c-a*a)<0)
  	   {System.out.println("è un triangolo acutangolo");}
  	  if((b*b-c*c-a*a)==0)
  	   {System.out.println("è un triangolo rettangolo");}
  	  if((b*b-c*c-a*a)>0)
  	   {System.out.println("è un triangolo ottusangolo");}}
  	else if((c>=a)&&(a>=b))
  	 {if((c*c-a*a-b*b)<0)
  	   {System.out.println("è un triangolo acutangolo");}
  	  if((c*c-a*a-b*b)==0)
  	   {System.out.println("è un triangolo rettangolo");}
  	  if((c*c-a*a-b*b)>0)
  	   {System.out.println("è un triangolo ottusangolo");}}
  	else if((c>=b)&&(b>=a))
  	 {if((c*c-b*b-a*a)<0)
  	   {System.out.println("è un triangolo acutangolo");}
  	  if((c*c-b*b-a*a)==0)
  	   {System.out.println("è un triangolo rettangolo");}
  	  if((c*c-b*b-a*a)>0)
  	   {System.out.println("è un triangolo ottusangolo");}}
  	
  	
  	 
  }
}
