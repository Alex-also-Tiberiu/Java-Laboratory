package Lab5;

import java.util.Random;

public class Dice {

 private Random generatore;
 private int facce; 

 
 public Dice() {
   this.facce = 6;
   generatore = new Random();
  }
 
 public int throwDice() {
   return 1 + generatore.nextInt(facce); 
  }
 
 
 
 
 
 } 





