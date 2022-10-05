package Lab10;

public class MyVectroGenerics<E> implements Container {
	private Object[] v;
	private int counter;
	private final int SIZE = 1;
	
	@Override
	public boolean isEmpty() { return counter == 0; }
	
	@Override
	public void makeEmpty() {
		v = new Object[SIZE];
		counter = 0;
	}
	
	@Override
	public int size() { return counter ;}
	
	public MyVectroGenerics() { makeEmpty(); }
	
	private E resize() {
		Object[] draft = new Object[v.length * 2];
		System.arraycopy(v, 0, draft, 0, counter);
		v = draft;
		return (E)v;
	}
	
	public void add( E e ) {
		if(e != null) {
			if(counter >= v.length)
				resize();
			v[counter++] = e;
		}
	}
	
	public void add( int index, E e ) {
		if((index >= 0) && (index < v.length) && (e != null)) {
			if(v[index] == null) {
				v[index] = e;
				counter++;
			}
			else {
				if(counter >= v.length)
					resize();
				
				for(int i = counter; i > index; i-- )
					v[i] = v[i - 1];
				v[index] = e;
				counter++;
			}
		}
	}
	
	public int capacity() { return v.length; }
	
	public boolean contains( E e ) {
		for(int i = 0; i < counter; i++) {
			if(v[i].equals(e))
				return true;
		}
			return false;
	}
	
	public E elementAt(int index) {
		if( (index >= 0) && (index <= counter) ) {
			Object giveback = v[index];
			return (E)giveback;
		} 
			return null;
	}
	
	public int indexOf( E e ) {
		for(int i = 0; i < v.length; i++) {
			if(v[i].equals(e))
				return i;
		}
		return -1;
	}
	
	public E remove(int index) {
		if(index >= 0 && index <= counter) {
			Object giveback = v[index];
			for(int i = index; i < counter -1; i++)
				v[i] = v[i + 1];
			counter--;
			return (E)giveback;
		}
		return null;
	}
	
	public E set(int index, E e) {
		if((index >= 0) && (index <= v.length) && (e != null)) {
			Object giveback = v[index];
			v[index] = e;
			return (E)giveback;
		}
		return null;
	}
	
	public  Object[] toArray() {
		Object[] array = new Object[counter];
		System.arraycopy(v, 0, array, 0, counter);
		return array;
	}
	
	public String toString() {
		String elements = "";
		for(int i = 0; i < v.length; i++)
			elements = elements + " " + v[i] + "\n";
		return elements;
	}
	
	
	
	
}
