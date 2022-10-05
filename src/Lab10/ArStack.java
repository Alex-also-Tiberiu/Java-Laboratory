package Lab10;

public class ArStack implements Stack {
	
	private Object[] stack;
	private int counter;
	private final int SIZE = 1;
	
	public ArStack() { makeEmpty(); }
	
	private void resize() {
		Object[] newStack = new Object[stack.length * 2];
		System.arraycopy(stack, 0, newStack, 0, counter);
		stack = newStack;
	}
	
	@Override
	public boolean isEmpty() { return counter == 0; }
	
	@Override
	public void makeEmpty() { 
		stack = new Object[SIZE];
		counter = 0;
	}
	
	@Override
	public int size() { return counter; }
	
	@Override
	public void push(Object obj) {
		if(obj != null) {
			if(counter >= stack.length)
				resize();
			stack[counter++] = obj;
		}
	}
	
	@Override
	public Object pop() throws EmptyStackException {
		Object giveback = stack[counter-1];
		stack[counter -1] = null;
		counter--;
		return giveback;
	}
	
	@Override
	public Object top() throws EmptyStackException {
		return stack[counter -1];
	}
	
	
}
