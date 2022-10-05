package Lab6.Transaction;

/**
 * MoneyTransaction
 * 
 * @author Alexandru Tiberiu Vilcu
 * @version 14/11/2019
 * @param date e' la data
 * @param 
 */
public class MoneyTransaction
{
    private String date = "";
    private double amount = 0;
    private String currency = "";
    private double rate = 0;
    private String direction = "";
    private String comment = "";
    MoneyAmount amo ;
    
 public MoneyTransaction (String aDate ,
                          double anAmount ,
                          String aCurrency ,
                          double anEuroConversionRate ,
                          String aDirection ,
                          String aComment)
                                                        {
    
    date = date + aDate;
    amount = amount + anAmount;
    currency = currency + aCurrency;
    rate = rate + anEuroConversionRate;
    direction = direction + aDirection;
    comment = comment +aComment;
               
    amo = new MoneyAmount(amount , currency , rate);                           
    }
    
 
    
 public double getConvertedToEuroAmount() {
     
     return amount;
     
    }
    
    String s = "";
    
 public void addComment (String newComment) {
     
     s = s + newComment;
     
    }
    
    String c = "";
    
    
public String toString() {
     
     return c = c + direction + " versamento $"+ amount +":"+ amo.getConvertedToEuroAmount() +":€/"+currency+" = " + amo.getToEuroConversionRate() + "spese di spedizione";
     
    } 
}
