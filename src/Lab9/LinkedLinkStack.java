package Lab9;

public class LinkedLinkStack implements Stack,Container {
	
	private int counter;
	
	private class ListNode {
		private ListNode next;
		private Object element;
		
		public ListNode(Object e, ListNode n) {
			element = e;
			next = n;
		}
		
		public ListNode() { this(null, null); }
		
		public Object getElement() { return element; }
		
		public ListNode getNext() { return next; }
		
		public void setElement(Object e) { element = e; }
		
		public void setNext(ListNode n) { next = n; }

	}
	
	public ListNode head,tail;
	
	public LinkedLinkStack() {
		makeEmpty();
	}

	public void makeEmpty() {
		head = tail = new ListNode();
		counter = 0;
	}
	
	public boolean isEmpty() {
		return head == tail;
	}
	
	public Object getFirst() {
		if(isEmpty())
			throw new EmptyLinkedListException("la lista è vuota");
		return head.getNext().getElement();
	}
	
	
	/** aggiunge un elemento specificato in cima allo stack 0(1)
	 * @param dato un nuovo elemento da aggiungere
	 */
	
	public void push(Object e) {
		head.setElement(e);
		head = new ListNode(null,head);
		counter++;
	}
	
	public Object pop() {
		Object tmp = getFirst();
		head = head.getNext();
		head.setElement(null);
		counter--;
		return tmp;
	}
	
	public Object top() {
		return getFirst();
	}
	
	public int size() {
		return counter;
	}
	
	
	
	
	
	
	
}