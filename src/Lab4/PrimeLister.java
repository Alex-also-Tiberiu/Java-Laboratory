package Lab4;

import java.util.Scanner;
public class PrimeLister
{
 public static void main(String[]args)
 {
  Scanner in = new Scanner(System.in);
  System.out.println("inserire un numero intero maggiore di 1");
  int n= in.nextInt();
  //int z=0;
  String primi="";
 
  int b=2;
  while(b*b<=n)
    {
     int r=n%b;
     
     if(r==0)
     	{
     	 String res=Integer.toString(b);
     	 primi= res+" "+primi;
     	}
     	b++;
     }
  
  System.out.println("i divisori sono "+primi); 
 
 in.close();   
 }
}
