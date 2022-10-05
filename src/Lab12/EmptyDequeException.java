package Lab12;

public class EmptyDequeException extends Exception {
	
	public EmptyDequeException() { }
	
	public EmptyDequeException(String error) { super(error) ; }
}
