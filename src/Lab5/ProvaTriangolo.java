package Lab5; /**
 * Programma di prova della classe Triangolo
 * che usa standard input e output
 * 
 * @author Adriano Luchetta
 * @version 20-Sett-2003
 * @version 28-Ott-2004
 *
 */

import java.util.Scanner;
import java.util.Locale;

public class ProvaTriangolo
{
   public static void main (String[] args)
   {
      Scanner in = new Scanner(System.in);

      // lettura dei dati da Standard Input
      System.out.print ("Introduci lati a, b, c: ");
      int a = in.nextInt();
      int b = in.nextInt();
      int c = in.nextInt();

      // istanza del triangolo
      Triangolo triangolo = new Triangolo (a, b, c);

      // emissione a Standard Output dell'elaborazione
      System.out.println(triangolo +  ": " + triangolo.info());
      System.out.println("area = " + triangolo.area());
      System.out.println("h = " + triangolo.h());
      
      // chiusura del flusso
      in.close();
   }
}

