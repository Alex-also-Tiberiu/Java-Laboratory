package Lab10;

public class EmptyStackException extends RuntimeException {
	
	public EmptyStackException() {}
	
	public EmptyStackException(String error) { super(error); }
}
