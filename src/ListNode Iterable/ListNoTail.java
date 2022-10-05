package ListNode

public class ListNoTail <E> {
	
	private ListNode head;
	private int counter;
	
	
	private class ListNode {
		
		private ListNode next;
		private E element;
		
		private ListNode(E e, ListNode n) {
			next = n;
			element = e;
		}
		
		private ListNode() { this(null,null); }
		
		private void setElement(E e) { element = e; }
		
		private void setNext(ListNode n) { next = n; }
		
		private E getElement() { return element; }
		
		private ListNode getNext() { return next; }
	}
	
	private class Iterator<T> {
		
		private ListNode current, previous;
		
		private Iterator() {
			current = head;
			previous = null;
		}
		
		private boolean hasNext() {
			return current.getNext() != null;
		}
		
		private T next() {
			if(!(hasNext()))
				throw new java.util.NoSuchElementException();
			
			previous = current;
			current = current.getNext();
			
			return (T)current.getElement();
		}
		
		private void remove() {
			if(previous == null)
				throw new IllegalArgumentException();
			
			//SPOSTAMENTO
			previous.setNext(current.getNext());
			
			//BLOCCO REMOVE
			current = previous;
			previous = null;
			
			counter--;
			
		}
	}
	
	public ListNoTail() {
		head = new ListNode();
		counter = 0;
	}
	
	
	public void add(int r, E x) {
		if(r < 0 || r > counter)
			throw new IndexOutOfBoundsException();
		if(x == null)
			throw new IllegalArgumentException();
	
		ListNode n = head;
		int i = 0;
		
		while(i < r) {
			n = n.getNext();
			i++;
		}
		
		n.setNext(new ListNode(x,n.getNext()));
		
		counter++;
	}
	
	public E get(int r) {
		
		if(r < 0 || r > counter - 1)
			throw new IndexOutOfBoundsException();
		
		Iterator iter = iterator();
		int i = 0;
		
		while(i < r) {
			iter.next();
			i++;
		}
		
		return (E)iter.next();
	}
	
	public boolean isEmpty() { return head.getNext() == null; }
	
	public Iterator iterator() { return new Iterator<E>(); }
	
	public int rankOg(E x) {
		Iterator iter = iterator();
		int i = 0;
		while(iter.hasNext()) {
			if(iter.next().equals(x))
				return i;
			else
				i++;
		}
		return -1;
	}
	
	

}
