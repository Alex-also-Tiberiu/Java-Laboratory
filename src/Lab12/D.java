package Lab12;

public class D<K,V> implements MultiMap<K,V> {
	
	private class Node {
		private Node next;
		private Entry element;
		
		private Node(Entry e, Node n ) {
			setNext(n);
			setEntry(e);
		}
		
		private Node() { this(null,null); }
		
		private void setEntry(Entry e) { element = e; }
		
		private void setNext(Node n) { next = n; }
		
		private Node getNext() { return next; }
		
		private Entry getEntry() { return element; }
	}
	
	private class Entry {
		private Object key, value;
		
		private Entry(K k, V v) {
			setKey(k);
			setValue(v);
		}
		
		private void setKey(K k) { key = k; }
		
		private void setValue(V v) { value = v; }
		
		private Object getKey() { return key; }
		
		private Object getValue() { return value;}
	}
	
	

	
	
	
	private Object[] map;
	private static final int SIZE = 97;
	private int counter;
	
	
	public D() {
		map = new Object[SIZE];
		counter = 0;
		for(int i = 0; i < map.length; i++)
			map[i] = new Node();
	}
	
	private int hash(K k) {
		int h = k.hashCode()% map.length;
		if(h < 0) { h = -h; }
		return h;
	}
	
	
	
	
	private Node search (K k) {
		if(k == null)
			throw new IllegalArgumentException();
		
		int h = hash(k);
		Node n =  (Node) map[h];
		
		while(n.getNext() != null) {
			if(n.getNext().getEntry().getKey().equals(k))
				return n;
			n = n.getNext();
		}
		
		return n;
	}
	
	@Override
	public V get(K key) {
		if(key == null)
			throw new IllegalArgumentException();
		
		Node n = search(key);
		
		if(n.getNext() == null)
			return null;
		
		return (V)n.getNext().getEntry().getValue();
	}

	
	@Override
	public Object[] getAll(K key) {
		if(key == null)
			throw new IllegalArgumentException();
		
		Object[] array = new Object[counter];
		Node n = search(key);
		int j = 0;

		while(n.getNext() != null) {
			array[j++] =  n.getNext().getEntry().getValue();
			n = n.getNext();			
		}
		if(j > 0) {
			Object[] give = new Object[j];
			System.arraycopy(array, 0, give, 0, j);
			return give;
		}
		else
			return null;
	}

	
	@Override
	public boolean isEmpty() { return counter == 0; }

	
	@Override
	public Object[] keySet() {
		Object[] keys = new Object[counter];
		int j = 0;
		for(int i = 0; i < map.length; i++) {
			Node n = ((Node)map[i]);
			while(n.getNext() != null) {
				keys[j++] = n.getNext().getEntry().getKey();
				n = n.getNext();
			}
		}
		
		Object[] newK = new Object[j];
		j = 0;
		newK[j++] = ((Node)map[1]).getEntry().getKey();
		for(int i = 0; i < keys.length; i++) {
			for(int l = 1; l < keys.length; l++) {
				if(!((Node)keys[i]).getEntry().getKey().equals(((Node)map[l]).getEntry().getKey())) {
					newK[j++] = ((Node)keys[l]).getEntry().getKey(); 
				}
			}
		}
		
		Object[] give = new Object[j];
		System.arraycopy(newK, 0, give, 0, j);
		return give;
	}

	
	@Override
	public void put(K key, V value) {
		
		if(key == null || value == null)
			throw new IllegalArgumentException();
		
		int h = hash(key);
		Node n = search(key);
		
		if(n.getNext() == null) {
			n.setNext(new Node(new Entry(key,value),null));
		}
		
		else {
			Node head = (Node)map[h];
			head.setNext(new Node(new Entry(key,value),head.getNext()));
		}
		counter++;
	}

	
	@Override
	public V remove(K key) {
		if(key == null)
			throw new IllegalArgumentException();
		Node n = search(key);
		
		if(n.getNext() == null)
			return null;
		else {
			Object give = n.getNext().getEntry().getValue();
			n.setNext(n.getNext().getNext());
			counter--;
			return (V)give;
		}
	}

	
	@Override
	public int size() { return counter; }

}
