package Lab5; /**
  * AverageDice
  *
  * Calcola il valore medio del lancio di un dado lanciato n volte e lo invia a
  * Standard Output.
  * n sia acquisito da Standard Input
  * Il programma itera finche' non viene inviato da Standard input la stringa
  * sentinella "Q"
  *
  */
  import java.util.Scanner;
  public class AverageDice
  {
     public static void main(String[] args)
     {
        final String SENTINEL = "Q";
        
        Scanner in = new Scanner(System.in);
        Dice d = new Dice();

        System.out.println("\n*** PROGRAMMA CHE LANCIA UN DADO N VOLTE ***");
        System.out.println("***CALCOLANDO IL VALORE DEL LANCIO MEDIO ***");       
        System.out.println("***  N E' INTRODOTTO DA STANDARD INPUT   ***");
        System.out.println("***PER TERMINARE IL PROGRAMMA INSERIRE Q ***");                       

        while (true)
        {
           System.out.print("\nIntrodurre n: ");
           String s = in.next();

           // gestione stringa sentinella
           if (s.equalsIgnoreCase(SENTINEL))
              break;

           // conversione in numero intero
           int n = Integer.parseInt(s);

           int sum = 0;
           if (n < 1)
              System.out.println("valore errato: " + n);
           else
           {
              for (int i = 0; i < n; i++)
              {
                 int l = d.throwDice();
                 System.out.print(l + " ");
                 sum += l;  
              }

              System.out.println("\nlanci " + n + " media di = " + (double)sum / n );
           }   
        }

        System.out.println("\n***FINE***");
        in.close();
     }
  }
  
