package Lab5; /**
 * MainMyPoint2D
 * Classe di prova della classe MyPoint2D
 *
 * @see MyPoint2D
 *
 * @author Adriano Luchetta
 * @version 25-10-2007
 *
 */
 
import java.util.Scanner;
import java.util.Locale;

public class MainMyPoint2D
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      in.useLocale(Locale.US);
      
      System.out.println();
      System.out.println("*********************************************************************");
      System.out.println("* Acquisisce le coordinate di due punti P e Q da standard input.    *");       
      System.out.println("* Usare il punto come separatore fra parti intera e frazionaria.    *");
      System.out.println("* Invia a standard output la descrizione testuale dei punti,        *");
      System.out.println("* la distanza, il punto medio, un punto traslato e un punto ruotato *");              
      System.out.println("*********************************************************************\n");
            
      System.out.print("P x? y? ");
      double xp = in.nextDouble();
      double yp = in.nextDouble();
      MyPoint2D p = new MyPoint2D(xp, yp);
      
      System.out.print("Q x? y? ");
      double xq = in.nextDouble();
      double yq = in.nextDouble();
      MyPoint2D q = new MyPoint2D(xq, yq);
      
      System.out.println("Descrizione testuale dei punti P e Q: ");
      System.out.println(p);              
      System.out.println(q);
      
      System.out.println("Distanza e punto medio dei punti P e Q: ");
      System.out.println("distanza PQ: " + p.getDistanceFrom(q));
      System.out.println("punto medio : " + p.getMidpoint(q));
      
      System.out.print("Trasla punto P. deltaX? deltaY?: ");
      double deltaX = in.nextDouble();
      double deltaY = in.nextDouble();
      MyPoint2D r = p.move(deltaX, deltaY);
      System.out.println("punto traslato: " + r);

      System.out.print("Ruota punto P. alpha (gradi sessagesimali)?: ");
      double alpha = in.nextDouble();
      MyPoint2D s = p.turn(alpha);
      System.out.println("punto ruotato: " + s);      
      in.close();        
   }
}

