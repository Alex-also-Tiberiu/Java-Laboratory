package Lab4;

import java.util.Scanner;
public class BaseConverter
{
 public static void main(String[]args)
 {
 	Scanner in= new Scanner(System.in);
 	System.out.println("inserisci un numero e una base compresa tra 2 e 10");

	int num=0;
	int base=0;
 	//int p=num;
	String conv="";
 	while(in.hasNext())		//introdurre un numero
 		{ String token1=in.next();
 		  String token2=in.next();
 				if(!(token1.equalsIgnoreCase("q")))		
 					{		
	 	 			num= Integer.parseInt(token1);
	 	 			base= Integer.parseInt(token2);	
	 	 			System.out.println("n :"+num+" , base: "+base);
 		  	  }
 		  	else 
 				  {System.out.println("il programma è terminato");
 		  		return;
 		  		}
 		  
 		  //String c="";
 		 	  int p=num;
 		 		while(p>0)
 		 		{
	  			int ai=p%base;
	  			p=p/base;
	  			String ses=Integer.toString(ai);
	  			conv=ses+conv;
 		 	 	 //System.out.print(conv); non funziona
 		 		}
 		   System.out.println("il numero è: "+conv+" in base: "+base); 
 			 System.out.println("inserisci un numero e una base compresa tra 2 e 10");
 			 System.out.println("oppure inserire q e un carattere casuale per uscire");
 		}

 	in.close();
 	}
}
