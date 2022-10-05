package Lab9;

public class ArStack {
  
  private final int CAPACITY = 100;
  protected Object[] stack;
  private int counter;
	
	public ArStack() {
		makeEmpty();
	}
	
	public boolean isEmpty() {
		return counter <= 0;
	}
	
	public void makeEmpty() {
		stack = new Object[CAPACITY];
		counter = 0;
	}
	
	public int size() {
		return counter;
	}
	
	public void push(Object obj) throws FullStackException {
		if(counter >= stack.length)
			throw new FullStackException("lo stack è pieno");
		
		stack[counter] = obj;
		counter++;
	}
	
	public Object top() throws EmptyStackException {
		if(isEmpty())
			throw new EmptyStackException("lo stack è vuoto");
		return stack[counter - 1];
	}
	
	public Object pop() {
		if(isEmpty())
			throw new EmptyStackException("non puoi estrarre nessun oggetto, lo stack è vuoto");
		Object obj = top();
		counter--;
		stack[counter] = null;
		return obj;
	}
}
