package Lab13;

import java.util.NoSuchElementException;

public class S<E extends Comparable> implements Set<E> {
	
	private class Node {
		private Node next;
		private E element;
		
		private Node(E e, Node n) {
			setElement(e);
			setNext(n);
		}
		
		private Node() { this(null,null); }
		
		private void setElement(E e) { element = e; }
		
		private void setNext(Node n) { next = n; }
		
		private E getElement() { return (E)element; }
		
		private Node getNext() { return next; }
	}
	
	private class Literator<E> implements Iterator<E> {
		
		private Node current,prev;
		
		private Literator() {
			current = head;
			prev = null;
		}
		
		@Override
		public boolean hasNext() {
			if(current.getNext() != null)
				return true;
			else
				return false;
		}

		@Override
		public E next() throws NoSuchElementException {
			if(hasNext()) {
				prev = current;
				current = current.getNext();
				return (E)current.getNext().getElement();
			}
			else
				return null;
		}
		
	}
	
	
	
	
	
	
	
	private Node head,tail;
	private int counter;
	
	
	
	public S() {
		head = tail = new Node();
		counter = 0;
	}
	
	
	
	
	@Override
	public Iterator<E> iterator() {
		return new Literator();
	}

	
	
	@Override
	public void add(E e) {
		if(e == null)
			throw new IllegalArgumentException();
		
		if(contains(e))
			return;
		
		tail.setNext(new Node(e,null));
		tail = tail.getNext();
		counter++;
	}

	
	
	@Override
	public void add(E[] a) {
		
		for(int i = 0; i < a.length; i++) {
			add(a[i]);
		}
	}

	
	
	@Override
	public boolean contains(E e) {
	
		Node n = head;
		while(n != tail) {
			if(n.getElement().equals(e))
				return true;
			else
				n = n.getNext();
		}
			return false;
	}

	
	
	@Override
	public boolean isEmpty() {
		
		return counter <= 0;
	}

	@Override
	public int size() {
		return counter;
	}
	
	
	public boolean equals(Object o) {
		
		if(!(o instanceof Set))
			return false;
		
		Set s = (Set)o;
		
		if(s.size() != size())
			return false;
		
		Iterator iter2 = s.iterator();
		Iterator iter = iterator();
		
		while(iter.hasNext() && iter2.hasNext()) {
			if(!(iter.next().equals(iter2.next())))
				return false;
		}
			return true;
	}
	
	
	
	
	
	
	
	
	
}
