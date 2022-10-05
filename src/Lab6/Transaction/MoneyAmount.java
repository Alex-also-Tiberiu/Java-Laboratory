package Lab6.Transaction;

import java.lang.IllegalArgumentException;



/**
 *  MoneyAmount
 * 
 * @author Alexandru Tiberiu Vilcu 
 * @version 14/11/2019
 */
public class MoneyAmount
{
    private String money = "";
    private double amount = 0;
    private double aEuroRate = 0;
    
  public MoneyAmount(double anAmount, String aCurrency, double aToEuroRate) {
      if(anAmount < 0 || aEuroRate < 0)  {
         throw new IllegalArgumentException();
        }
      
      amount = anAmount;
      money = aCurrency;  
      aEuroRate = aToEuroRate;
      
      
    }
    
    public String getCurrency() {
        return money;
    }
    
    
    /**
      *restituisce il denaro nella valuta desiderata
  
      */
  public double getAmount() {
      
      return amount;
      
    }
    
    
    /**rapporto euro/valuta
      *
      */
  public double getToEuroConversionRate (){
      
      return getConvertedToEuroAmount()/amount;
      
    }
  
    
  /**denaro espresso in euro
    *
    *
    */
 public double getConvertedToEuroAmount () {
    
      return amount * aEuroRate;
    }

private String s = "";
    
  /**descrizione valuta
    *
    *
    */
 public String toString() {
   
      return s = s + money + amount +" :€ "+getConvertedToEuroAmount() + ":€/"+money+"="+getToEuroConversionRate();
    
  }
  
}