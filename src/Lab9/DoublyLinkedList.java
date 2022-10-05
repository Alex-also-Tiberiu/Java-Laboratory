package Lab9;

public class DoublyLinkedList<E> implements Container {
	
	private static int nodes = 0;
	
	private class ListNode {
		private E element;
		private ListNode next;
		private ListNode previous;
		
		public ListNode(ListNode prev,E e ,ListNode n) {
			previous = prev;
			element = e;
			next = n;
			nodes++;
		}
		
		public ListNode() {
			this(null,null,null);
		}
		
		public E getElement() {
			return element;
		}
		
		public ListNode getNext() {
			return next;
		}
		
		public ListNode getPrevious() {
			return previous;
		}
		
		public void setElement(E e) {
			element = e;
		}
		
		public void setNext(ListNode n) {
			next = n;
		}
		
		public void setPrevious(ListNode p) {
			previous = p;
		}
	}
	
	private ListNode head,tail;
	
	public DoublyLinkedList() {
		makeEmpty();
	}
	
	public boolean isEmpty() {
		return head == tail;
	}
	
	public void makeEmpty() {
		head = tail = new ListNode();
	}
	
	public int size() {
		int size = nodes;
		return size;
	}
	
	public E getFirst() {
		if(isEmpty())
			throw new EmptyLinkedListException();
		return(head.getNext()).getElement();
	}
	
	public E getLast() {
		if(isEmpty())
			throw new EmptyLinkedListException();
		return (tail.getPrevious()).getElement();
	}
	
	public void addFirst(E e) {
		head.setElement(e);
		head = new ListNode(null, null, head);
		head.getNext().setPrevious(head);
	}
	
	public E removeFirst() {
		E e = getFirst();
		head = head.getNext();
		head.setElement(null);
		head.setPrevious(null);
		return e;
	}
	
	public void addLast(E e) {
		tail.setElement(e);
		tail = new ListNode(tail,null,null);
		tail.getPrevious().setNext(tail);
	}
	
	public E removeLast() {
		E e = getLast();
		tail = tail.getPrevious();
		tail.setElement(null);
		tail.setNext(null);
		return e;
	}
	
	
	
	
	
	
	
	
}
