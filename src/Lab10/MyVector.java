package Lab10;

public class MyVector implements Container {
	private Object[] v;
	private int counter;
	private final int SIZE = 1;
	
	public MyVector() {
		makeEmpty();
	}

	
	public void makeEmpty() {
		v = new Object[SIZE];
		counter = 0;
		v[counter] = new Object();
	}
	
	private Object[] resize() {
		Object[] newVector = new Object[v.length * 2];
		System.arraycopy(v, 0, newVector, 0, v.length);
		v = newVector;
		return v;
	}
	
	public void add(int index, Object e) {
		if(index >= 0 && index <= v.length) {
			if(counter >= v.length)
				v = resize();
			if(v[index] != null) {
				for(int i = counter; i > index; i--) {
					v[i] = v[i-1];
				}
				v[index] = e;
				counter++;
			}
			else { v[index] = e; counter++; }
		}
	}
	
	
	public void add(Object e) {
		if(counter >= v.length)
			v = resize();
		
		if(e != null) {
			v[counter] = e;
			counter++;
		}
	}
	
	public int capacity() {
		return v.length;
	}
	
	public boolean contains(Object e) {
		for(int i = 0; i < v.length; i++) {
			if(v[i].equals(e))
				return true;
			
		}		return false;
	}
	
	public Object elementAt(int index) {
		if(index >= 0 && index <= counter) {
			Object giveback = v[index];
			return giveback;
		}
		return null;
	}
	
	public int indexof(Object e) {
		if( e != null ) {
			for(int i = 0; i < counter; i++) {
				if(v[i].equals(e))
					return i;
			}
		}			return -1;
	}
	
	
	public boolean isEmpty() { return counter == 0; }
	
	
	public Object remove(int index) {
		if(index >= 0 && index <= counter) {
			Object giveback = v[index];
			
			for(int i = index; i < counter - 1; i++)
				v[i] = v[i + 1];
			
			counter--;
			return giveback;
		}
		
		return null;
	}
	
	
	public Object set(int index, Object e) {
		if( (index >= 0) && (index <= v.length) && (e != null)) {
			Object giveback = v[index];
			v[index] = e;
			return giveback;
		}
		return null;
	}
	
	public int size() {
		return counter;
	}
	
	public Object[] toArray() {
		Object[] array = new Object[counter];
		System.arraycopy(v, 0, array, 0, counter);
		return array;
	}
	
	public String toString() {
		String elements = "";
		for(int i = 0; i < counter; i++) {
			elements = elements + " " + v[i] +"\n";
		}
		
		return elements;
	}
	
	
}
