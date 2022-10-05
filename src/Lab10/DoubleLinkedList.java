package Lab10;

public class DoubleLinkedList {
	
	private class LinkNode {
		private LinkNode next, previous;
		private Object element;
		
		private LinkNode(LinkNode h, Object e, LinkNode t ) {
			next = h; element = e; previous = t;
		}
		
		private LinkNode() { this(null,null,null); }
		
		private void setElement(Object e) { element = e; }
		
		private void setNext(LinkNode n) { next = n; }
		
		private void setPrev(LinkNode p) { previous = p; }
		
		private Object getElement() { return element; }
		
		private LinkNode getNext() { return next; }
		
		private LinkNode getPrev() { return previous; }
	}
	
	
	private LinkNode head,tail;
	private int counter;
	
	public DoubleLinkedList() {
		head = tail = new LinkNode();
		counter = 0;
	}
	
	public boolean isEmpty() { return counter == 0; }
	
	public void makeEmpty() {
		head = tail = new LinkNode();
		counter = 0;
	}
	
	public int size() { return counter; }
	
	public Object getFirst()   {
		Object giveback = head.getNext().getElement();
		if(giveback != null)
			return giveback;
		else
			throw new EmptyLinkedListException("la lista e' vuota");
	}
	
	public Object getLast()  {
		Object toSend = tail.getPrev().getElement();
		if(toSend != null)
			return toSend;
		else
			throw new EmptyLinkedListException("la lista e' vuota");
	}
	
	public void addFirst(Object e) {
		LinkNode n = new LinkNode(head,null,null);
		head.setPrev(n); 
		head.setElement(e);
		head = n;
		counter++;
	}
	
	public Object removeFirst() {
		Object giveback = head.getNext().getElement();
		head = head.getNext();
		head.setPrev(null);
		head.setElement(null);
		counter--;
		return giveback;
	} 
	
	public void addLast(Object e) {
		LinkNode n = new LinkNode(null,null,tail);
		tail.setNext(n);
		tail.setElement(e);
		tail = n;
		counter++;
	}
	
	public Object removeLast() {
		Object giveback = tail.getPrev().getElement();
		tail = tail.getPrev();
		tail.setNext(null);
		tail.setElement(null);
		counter--;
		return giveback;
	}
	
	
}
