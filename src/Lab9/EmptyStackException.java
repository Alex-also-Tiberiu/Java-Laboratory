package Lab9;

public class EmptyStackException extends RuntimeException {
	
	public EmptyStackException() {}
	
	public EmptyStackException(String error) {
		
		super(error);
	}
}
