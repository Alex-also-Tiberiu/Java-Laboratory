package Lab5;

public class MyComplex{

private double re;
private double im;
private String s = "";

public MyComplex(double anre, double anim){
  this.re = anre;
  this.im = anim;
 }
 
public MyComplex add(MyComplex z){
  return new MyComplex(re + z.re , im + z.im);
 }
 
public MyComplex sub(MyComplex z){
  return new MyComplex(re - z.re , im - z.im);
 }
 
public MyComplex conj(){
  return new MyComplex(re, -im); 
 }
 
public MyComplex mult(MyComplex z){
  return new MyComplex(re * z.re - im * z.im , re * z.im + z.re * im);
 }
 
public MyComplex div(MyComplex z){
  return new MyComplex( re / z.re , im / z.im);
 }

public double mod(){
  return Math.sqrt(re * re + im * im);
 }
 
public MyComplex inv(){
  return new MyComplex(re/(mod()*mod()) , -im/(mod()*mod()));
 }
 
public double re(){
  return re;
 }
 
public double im(){
  return im;
 } 
 
public String toString(){
  String sre = Double.toString(this.re);
  String sim = Double.toString(this.im);
  return s = s+sre + " +i("+im+")";
 }
 
private boolean equal( double x , double y ){
  final double EPS = 1E-14;
  return Math.abs(x - y) <= EPS * Math.max(Math.abs(x) , Math.abs(y));
 }
 
public boolean equalsApprox(MyComplex z){
  return equal(re , z.re) && equal(im , z.im);
 }
 
 
 
 
 
 
 
 
 
}


  
  
  
  
  
  
