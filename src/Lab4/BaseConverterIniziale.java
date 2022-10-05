package Lab4;

import java.util.Scanner;
public class BaseConverterIniziale
{
 public static void main(String[]args)
 {
 	Scanner in= new Scanner(System.in);
 	System.out.println("inserisci un numero e una base compresa tra 2 e 10");

	int num=0;
	int base=0;
	int conv=0;
 	int p=num;
	String c="";
 	while(in.hasNext())		//introdurre un numero
 		{ String token1=in.next();
 			String token2=in.next();
 			System.out.println("n :"+token1+" , base: "+token2);		
 	
 	if(!token1.equalsIgnoreCase("Q"))	//verifica del numero
 		{ 
	 	 num= Integer.parseInt(token1);
	 	 base= Integer.parseInt(token2);	
 		 
 		 while(p>0)
 		 	{
 		 	 conv=p%base;
 		 	 p=p/base;
 		 	 c=conv+"";
 		 	}
 		 System.out.println("il numero è: "+c+" in base: "+base); 
 		}
 	else	 
 		{System.out.println("il programma è terminato");
 		return;
 		}
 		}
 	in.close();
 	}
}
