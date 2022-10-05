package Lab11;

import java.util.NoSuchElementException;

public class Lista implements List{
	
	
	private class Node{
		
		private Node next;
		private Object element;
		
		private Node(Object e, Node n) {
			setNext(n);
			setElement(e);
		}
		
		private Node() { this(null,null); }
		
		private void setNext(Node n) { next = n; }
		
		private void setElement(Object e) { element = e; }
		
		private Node getNext() { return next; }
		
		private Object getElement() { return element; }
	}
	
	
	private class Lit implements Iterator{
		
		private Node current,previous;
		
		private Lit() {
			current = head;
			previous = null;
		}

		@Override
		public Object next() {
			if(hasNext()) {
				Object give = current.getNext().getElement();
				previous = current;
				current = current.getNext();
				return give;
			}
			else
				throw new NoSuchElementException("adoperarsi del metodo hasNext!!");
				
		}

		@Override
		public boolean hasNext() {
			if(current.getNext() != null)
				return true;
			else 
				return false;
		}

		@Override
		public void add(Object x) {
			
			current.setNext(new Node(x,current.getNext()));
			current = current.getNext();
			previous = null;
			counter++;
			
			if(current.getNext() == null)
				tail = current;
		}

		@Override
		public void remove() {
			if(previous == null)
				throw new IllegalStateException("usare hasNext()");
				
			current = previous;
			previous.setNext(current.getNext().getNext());
			previous = null;
			
			if(current.getNext() == null)
				tail = current;
			
			counter--;
		}
	}
	
	
	
	
	
	
	private Node head,tail;
	private int counter;
	
	public Lista() {
		head = tail = new Node();
		counter = 0;
	}
	
	@Override
	public Iterator iterator() {
		return new Lit();
	}

	@Override
	public boolean isEmpty() { return counter == 0; }

	@Override
	public void makeEmpty() {
		head = tail = new Node();
		counter = 0;
	}

	
	
	@Override
	public int size() { return counter; }

	
	
	@Override
	public Object get(int index) {
		
		if(index <= counter) {
			Iterator it = iterator();
			int i = 0;
			
			while(i < index) {
				it.next();
				i++;
			}
			return it.next();
		}
		
		return null;
	}

	
	
	@Override
	public Object set(int index, Object x) {
	
		if((index < 0) && (index > counter) && (x == null))
			throw new IllegalArgumentException();
		
		Iterator it = iterator();
		
		for(int i = 0; i < index; i++) 
			it.next();
		
		Object give = it.next();
		it.remove();
		it.add(x);
		return give;
	
	}

	@Override
	public void add(int index, Object x) {
		
		if((index < 0) && (index > counter) && (x == null))
			throw new IllegalArgumentException();
		
		Iterator it = iterator();
		int i = 0;
		
		while((i < index) && (it.hasNext())) {
			it.next();
			i++;
		}
		it.add(x);
	
	}

	@Override
	public Object remove(int index) {
		
		if((index < 0) && (index > counter))
			throw new IllegalArgumentException();
		
		Iterator it = iterator();
		int i = 0;
		
		Object give = new Object();
		while(i < index)  {
			give = it.next();
			i++;
		}
		it.remove();
		return give;
	}

}
