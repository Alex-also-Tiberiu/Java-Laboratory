package Lab6.Transaction;

import java.util.Arrays;
import java.lang.IllegalArgumentException;

/**
 *  MoneyTransactionRecorder
 * 
 * @author (il tuo nome) 
 * @version (un numero di versione o una data)
 */
public class MoneyTransactionRecorder
{
    private final int LENGTH = 1;
    private MoneyTransaction[] moves ;
    private static int counter = 0;
    private double total;
    private MoneyAmount coin;
    private String dir = "";
    
    
  /** MoneyTransactionRecorder()
   *  inizializza il valore iniziale di un registratore di transazioni
   * 
   */
    
  public MoneyTransactionRecorder() {
      moves = new MoneyTransaction[LENGTH];   
      total = 0;
    }
  
    /** MoneyTransactionRecorder (double initialMoneyInEuro)
     *  inizializza un registratore di transazioni con un valore iniziale
     *  @param initialMoneyInEuro - valore iniziale registratore di transazioni
     */
  public MoneyTransactionRecorder(double initialMoneyInEuro) {
       moves = new MoneyTransaction[LENGTH];
       total = total + initialMoneyInEuro;
    }
  
    
    /**  aggiunge transazioni al registratore
     *  @param aDate - data della transazione
     *  @param anAmount - valore valuta transazione
     *  @param aCurrency - valuta della transazione
     *  @param anEuroConversionRate - rapporto Euro/valuta
     *  @param aDirection - conto destinatario
     *  @param aComment - motivazione transazione
     * 
     */
  public void addTransaction(String aDate,
                             double anAmount,
                             String aCurrency,
                             double anEuroConversionRate,
                             String aDirection,
                             String aComment)  {
      if(counter == moves.length-1) {
          MoneyTransaction[] newmoves = Arrays.copyOf(moves , 2*moves.length);
          moves = newmoves;
        }
     String data = aDate;
     double amount = anAmount;
     String currency = aCurrency;
     double euroRate = anEuroConversionRate;
     String direction = aDirection;
     String comment = aComment;
     String iamount = String.valueOf(amount);
     String iRate = String.valueOf(euroRate);
     
     moves[counter] = new MoneyTransaction( data , 
                                            amount , 
                                            currency , 
                                            euroRate , 
                                            direction , 
                                            comment);                                 
     counter++;   
     coin = new MoneyAmount (amount , currency , euroRate) ;
     total = total + coin.getToEuroConversionRate();
     //dir = data +"  "+" "+currency+" "+" "+amount+" "+euroRate+" "+comment+"\n" ;
     String space = " ";
     
     while(currency.length() < 6) {
         currency = space + currency;
        }
      
     while(iamount.length() < 8) {
         iamount = space + iamount;
        }
     
     while(iRate.length() < 21) {
        iRate = iRate + space;
        }
        
     dir = dir + data + currency + iamount +"     "+ iRate +comment +"\n"; 
    }
  
  public double getTotalMoneyInEuro() {
    
      return total;
       
    }
  
  public String toString() {
      return dir;
    }
    
    
}
