package Lab4;

import java.util.Scanner;
public class BaseConverter2
{
 public static void main(String[]args)
 {
 	Scanner in= new Scanner(System.in);
 	System.out.println("*************************************************************");
 	System.out.println("           CONVERTIRE NUMERI DALLA BASE DECIMALE             ");
 	System.out.println("*************************************************************");
 	System.out.println("inserisci un numero e una base compresa tra 2 e 10");

	int num=0;
	int base=0;
	String conv="";
	
	
 	while(in.hasNext())		//introdurre un numero
 		{ String token1=in.next();
 			if(token1.equalsIgnoreCase("q"))
 				 {
 				  System.out.println("il programma termina qui");
 				  return;
 				 }
 		  		String token2=in.next();
 								
	 	 			num= Integer.parseInt(token1);
	 	 			base= Integer.parseInt(token2);	

	 		 	  int p=num;
	 		 		while(p>0)
		 		 		{
			  			int ai=p%base;
			  			p=p/base;
			  			String ses=Integer.toString(ai);
			  			conv=ses+conv;
 		 	 	 
		 		 		}
 		   System.out.println("il numero convertito è: "+conv+" in base: "+base); 
 			 System.out.println("inserisci un numero e una base compresa tra 2 e 10");
 			 System.out.println("oppure inserire \"Q\" per uscire");
 		}

 	in.close();
 	}
}
