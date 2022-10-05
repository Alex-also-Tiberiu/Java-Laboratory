package Lab4;

import java.util.Scanner;
public class Mcd
{
 public static void main(String[] args)
 {
  Scanner in= new Scanner(System.in);
  System.out.println("inserire due numeri per cui si troverà il massimo comune divisore");
  System.out.println();
  System.out.println("si prega di rispettare la condizione di inserire il primo termine maggiore del secondo");
  int p= in.nextInt();
  int q= in.nextInt();
  int p2=0;
  
  if(q<0 || p<0)
  	{
  		System.out.println("hai inserito due numeri negativi, il programma termina");
  		return;
  	}
  
  while(p%q!=0)
  	{ 
  	  p2=q;
  	  q=p%q;
  	  
  	 }
  	 
  System.out.println(" l' MCD è: "+q);
  
  in.close();
  
 }
  
}
