package Lab12;

import java.util.NoSuchElementException;

public class DequeBack<T> implements Deque<T> {
	
	private class Node {
		private Node next,previous;
		private T element;
		
		private Node(Node p, T e, Node n)  {
			setElement(e);
			setNext(n);
			setPrev(p);
		}
		
		private void setNext(Node n) { next = n; }
		
		private void setPrev(Node p) { previous = p; }
		
		private void setElement(T e) {element = e; }
		
		private Node getNext() { return next; }
		
		private Node getPrev() { return previous; }
		
		private T getElement() { return element; }
	}
	
	private class Literator<T> implements Iterator {
		
		private Node current,previous;
		
		private Literator() {
			current = head;
			previous = null;
		}
		
		@Override
		public boolean hasNext() {
			if(current.getNext() != null)
				return true;
			else
				return false;
		}

		@Override
		public T next() {
			if(hasNext()) {
				previous = current;
				current = current.getNext();
				return (T)current.getElement();
			}
			else
				throw new NoSuchElementException();
		}
		
	}
	
	
	
	
	private Node head,tail;
	private int counter;
	
	public DequeBack() {
		head = new Node(null,null,tail);
		tail = new Node(head,null,null);
		counter = 0;
	}
	
	
	@Override
	public Iterator<T> iterator() {
		return new Literator();
	}

	
	@Override
	public void addFirst(T element) {
		
		if(element == null)
			throw new IllegalArgumentException();
		
		head.setElement(element);
		head.setPrev(new Node(null,null,head));
		head = head.getPrev();
		counter++;
	}

	@Override
	public void addLast(T element) {
		
		if(element == null)
			throw new IllegalArgumentException();
		
		tail.setElement(element);
		tail.setNext(new Node(tail,null,null));
		tail = tail.getNext();
		counter++;
	}

	@Override
	public boolean isEmpty() { return counter == 0;}

	@Override
	public T removeFirst() throws EmptyDequeException {
		Object give = head.getNext().getElement();
		head = head.getNext();
		head.setElement(null);
		head.setPrev(null);
		counter--;
		return (T)give;
	}

	@Override
	public T removeLast() throws EmptyDequeException {
		Object give = tail.getPrev().getElement();
		tail = tail.getPrev();
		tail.setElement(null);
		tail.setNext(null);
		counter--;
		return (T)give;
	}

	@Override
	public int size() { return counter; }

}
