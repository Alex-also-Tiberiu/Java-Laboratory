package Lab6.Transaction;

import java.util.Scanner;

/**
 * MoneyAmountTester
 * 
 * @author 
 * @version 
 */
public class MoneyAmountTester
{
  public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      System.out.println(" inserire il credito da convertire");
      double amount = in.nextDouble();
      System.out.println(" inserire la moneta, es:$ ");
      String money = in.next();
      System.out.println("inserire il tasso dell'euro rispettivo a quella moneta");
      double rate = in.nextDouble();
      
      
      MoneyAmount am = new MoneyAmount(amount , money , rate);
      
      System.out.println(am.toString());
      System.out.println(am.getAmount());
      System.out.println(am.getToEuroConversionRate());
      System.out.println(am.getConvertedToEuroAmount());
      
    }
}
