package Lab5; /**
 * MyPoint2D
 * rappresenta un punto nel piano cartesiano
 *
 * @author Adriano Luchetta
 * @version 25-10-2007
 *
 */
import java.util.Locale;
public class MyPoint2D
{
   //variabili di esemplare
   private double x;
   private double y;
   
   /**
      inizializza l'ascissa e l'ordinata del punto
      @param aX ascissa
      @param aY ordinata
   */
   public MyPoint2D(double aX, double aY)
   {
      x = aX;
      y = aY;
   }
   
   /**
      calcola la distanza fra due punti
      
      @param q punto per il calcolo della distanza
      @return distanza fra due punti     
   */
   public double getDistanceFrom(MyPoint2D q)
   {
      double dquadro = (x - q.x) * (x - q.x) + (y - q.y) * (y - q.y);
      return Math.sqrt(dquadro);
   }
   /** trasla il punto 
      @param deltax spostare lungo l'ascissa il punto
      @param deltay spostare lungo l'ordinata il punto
   */
   public MyPoint2D move(double deltax , double deltay)
   {
      x = x + deltax;
      y = y + deltay;
      return new MyPoint2D(x , y);
   }
   
   public MyPoint2D turn (double alpha)
   {
      double x1 = this.x*Math.cos(alpha)-this.y*Math.cos(alpha);
      double y1 = this.x*Math.sin(alpha)-this.y*Math.sin(alpha);
      return new MyPoint2D(x1 , y1);
   }
   /**
      calcola il punto medio fra due punti
      @param q punto per il calcolo del punto medio
      @return punto medio 
   */ 
   public MyPoint2D getMidpoint(MyPoint2D q)
   {
      double xm = (x + q.x) / 2;
      double ym = (y + q.y) / 2;
      
      MyPoint2D tmp = new MyPoint2D(xm, ym);
      
      return tmp;
   }
   
   /**
      descrizione testuale nella forma (x, y)
      @return descrizione testuale
   */ 
   public String toString()
   {
      return String.format(Locale.US, "MyPoint2D(%.2f, %.2f)", x, y);
   }
   
   /**
      verifica se due punti sono coincidenti
      @param q il punto da confrontare
      @return true se i due punti coincidono, false altrimenti
   */
   public boolean isCoincident(MyPoint2D q)
   {
      return approxEquals(x, q.x) && approxEquals(y, q.y);
   }
   
   // confronto fra numeri in virgola mobile di tipo double
   private static boolean approxEquals(double a, double b)
   {
      final double EPSILON = 1E-14;

      return Math.abs(a - b) <= EPSILON * Math.max(Math.abs(a), Math.abs(b));
   }

}
