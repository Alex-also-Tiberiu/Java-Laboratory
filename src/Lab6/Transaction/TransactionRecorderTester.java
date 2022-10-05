package Lab6.Transaction;

import java.util.Scanner;
import java.util.Locale;
/**
 * Aggiungi qui una descrizione della classe TransactionRecorderTester
 * 
 * @author (il tuo nome) 
 * @version (un numero di versione o una data)
 */
public class TransactionRecorderTester
{
  public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      in.useLocale(Locale.US);
      System.out.println("inserire il valore iniziale del saldo disponibile :");
      double initial = in.nextDouble();
      MoneyTransactionRecorder rec = new MoneyTransactionRecorder(initial);
      

  
     while(true){
      System.out.println("inserire la data odierna gg/mm/aaaa : (oppure premere q per terminare)");
      String data = in.next();
       if(data.equalsIgnoreCase("q"))
        { System.out.println(rec.toString());
          return;
        }
      System.out.println("inserire la somma :");
      double amount = in.nextDouble();
      System.out.println("inserire la valuta (£,$,€) ");
      String currency = in.next();
      System.out.println("inserire il tasso tra euro e valuta :");
      double rate = in.nextDouble();
      System.out.println("inserire il conto destinatario :");
      String direction = in.next();
      System.out.println("inserire la motivazione della transazione :");
      String comment = in.next();
      
      
      rec.addTransaction(data , amount , currency , rate , direction , comment);
    }
     
      
    }
}
