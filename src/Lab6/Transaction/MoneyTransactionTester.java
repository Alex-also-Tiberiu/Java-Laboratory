package Lab6.Transaction;

import java.util.Locale;
import java.util.Scanner;
/**
 * Aggiungi qui una descrizione della classe MoneyTransactionTester
 * 
 * @author (il tuo nome) 
 * @version (un numero di versione o una data)
 */
public class MoneyTransactionTester
{
    public static void main (String[] args) {
        Scanner in = new Scanner (System.in);
        
        System.out.println("inserire la data odierna : ");
        String data = in.next();
        System.out.println("inserire il capitale :");
        double capitale = in.nextDouble();
        System.out.println("inserire la valuta es: $ ");
        String valuta = in.next();
        System.out.println("inserire il tasso dell'euro");
        double tasso = in.nextDouble();
        System.out.println("inserire il conto destinatario :");
        String direzione = in.next();
        System.out.println("inserire la motivazione della transazione :");
        String commento = in.next();
        System.out.println();
        
        
        MoneyTransaction mon = new MoneyTransaction ( data, capitale , valuta , tasso , direzione , commento );
        
        
        
        System.out.println(mon.toString());
        
        
        in.close();
        
    }
}
