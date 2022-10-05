package Lab10

public class NewMySortedMap implements SortedMap {
	
	private class Entry implements Comparable<Entry> {
		private Comparable key;
		private Object value;
		
		private Entry(Comparable k, Object v) {
			key = k;
			value = v;
		}
		
		private void setKey(Comparable k) { key = k; }
		
		private void setValue(Object v) { value = v; }
		
		public int compareTo(Entry e) { return key.compareTo(e.key); }
	}
	
	
	private Entry[] e;
	private int counter;
	private final int SIZE = 1;
	
	public NewMySortedMap() {
		e = new Entry[SIZE];
		counter = 0;
	}
	
	
	public boolean isEmpty() { return counter == 0; }
	
	public int size() { return counter; }
	
	private static int binarySearch(Comparable[] a, int from, int to, Comparable k) {
		if(from > to)
			return -1;
		
		int mid = (from + to) / 2;
		
		if(k.compareTo(a[mid]) == 0)
			return mid;
		else if(k.compareTo(a[mid]) < 0)
			return binarySearch(a, from , mid-1, k);
		else
			return binarySearch(a, mid + 1, to, k);
	}
	
	private static int search(Comparable[] b, int size, Comparable t) {
		return binarySearch(b, 0, size-1, t);
	}
	
	public Object get(Comparable key) {
		if(key == null )
			throw new IllegalArgumentException();
		
		int n = search(e, counter, new Entry(key,null));
		
		if(n < 0)
			return null;
		else
			return e[n].value;
	}
	
	public Object remove(Comparable key) {
		if(key == null )
			throw new IllegalArgumentException();
		
		int n = search(e, counter, new Entry(key,null));
		
		if(n < 0)
			return null;
		
		Object x = e[n].value;
		
		for(int i = n; i < counter - 1; i++)
			e[i] = e[i + 1];
		
		e[counter - 1] = null;
		counter--;
		return x;
	}
	
	
	public Object put(Comparable key, Object value) {
		if( key == null || value == null)
			throw new IllegalArgumentException();
		
		Object x = remove(key);
		
		if(x == null && counter >= e.length) {
			
			Entry[] newE = new Entry[2 * e.length];
			System.arraycopy(e, 0, newE, 0, counter);
			e = newE;
		}
		
		Entry newE = new Entry(key,value);
		int j;
		for(j = counter; j > 0 && newE.compareTo(e[j-1]) < 0; j--)
			e[j] = e[j - 1];
		
		e[j] = newE;
		counter++;
		return x;
	}
	
	
	public Comparable[] sortedKeys() {
		Comparable[] newE = new Comparable[counter];
		for(int i = 0; i < counter; i++)
			newE[i] = e[i].key;
		
		return newE;
	}
	
	
	
	
	
	
	
	
}
