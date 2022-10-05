package Lab9;

public class EmptyLinkedListException extends RuntimeException {
	public EmptyLinkedListException() {
		
	}
	
	public EmptyLinkedListException(String error) {
		super(error);
	}
}
