package Lab4;

import java.util.Scanner;
public class BaseConverter3
{
 public static void main(String[]args)
 {
 	Scanner in= new Scanner(System.in);
 	System.out.println("inserire un carattere casuale oppure \"Q\" per terminare il programma");

	int num=0;
	int base=0;
	String conv="";
	
	String avvio=in.next();
	
	if(!(avvio.equalsIgnoreCase("q")))
		{
		 System.out.println("inserisci un numero e una base compresa tra 2 e 10");
 		 while(in.hasNext())		//introdurre un numero
 		 {String token1=in.next();
 		  String token2=in.next();		
	 	 	num= Integer.parseInt(token1);
	 	 	base= Integer.parseInt(token2);	
	 	 	System.out.println("n :"+num+" , base: "+base);
 		  	   
 		 	int p=num;
 		 	while(p>0)
 		 		{
	  			int ai=p%base;
	  			p=p/base;
	  			String ses=Integer.toString(ai);
	  			conv=ses+conv;
 		 	 	 
 		 		}
 		   System.out.println("il numero è: "+conv+" in base: "+base); 
			 System.out.println("inserire un numero e una base compresa tra 2 e 10");
 		 }
   }
 	else 
 		 {System.out.println("il programma è terminato");
 		 return;
 		 }   
   
 	in.close();
 	}
}
