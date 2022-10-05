package Lab9;

public class MyVectorGenerics <E> {
	final int SIZE = 1;
	private Object[] objs;
	private int counter;
	
	public MyVectorGenerics() {
		objs = new Object[SIZE];
		counter = 0;
	}
	
	
	public boolean isEmpty() {
		return counter == 0;
	}
	
	
	public void makeEmpty() {
		Object[] newObj = new Object[SIZE];
		objs = newObj;
	}
	
	
	public int size() {
		return counter;
	}

	
	public void resize() {
			/*Object[] newOb = new Object[size];
			System.arraycopy(ob, 0, newOb, 0, ob.length);
			ob = newOb;*/	
			
			Object[] temp = new Object[2*objs.length];
			for(int i=0; i < objs.length; i++)
				temp[i] = objs[i];
			
			objs =  temp;
	}
	
	
	public void add(int index, E e) {
		if(index < 0 || index > counter-1 || e == null) {
			return;
		}
		
		if(index >= objs.length-1) {
			resize();
		}
		
		for(int i = counter-1; i > index; i--)
			objs[i] = objs[i - 1];
		
		objs[index] = e;
		counter++;
		
	}
	
	
	public void add(E e) {
		add(counter,e);
	}
	
	
	public int capacity() {
		return objs.length;
	}
	
	
	public boolean contains(E e) {
		for(int i =0; i < counter; i++)
			if(objs[i].equals(e))
				return true;
		
		return false;
	}
	
	
	public E elementAt(int index) {
		if(index < 0 || index > objs.length)
			return null;
		
		return (E)objs[index];
	}
	
	
	public int indexOf(E e) {
		for(int i = 0; i < counter;i++)
			if(objs[i].equals(e))
				return i;
		return -1;
	}
	
	
	public E remove( int index) {
		if(index < 0 && index >= objs.length)
			return null;
		
		Object tmp = objs[index];
		
		for(int i = index; i < objs.length-1; i++)
			objs[i] = objs[i+1];
		
		counter--;
		return (E)tmp;
	}
	
	
	public E set(int index, Object e) {
		if(index < 0 && index >= objs.length)
			return null;
		Object tmp = objs[index];
		objs[index] = e;
		return (E)tmp;
	}
	
	
	public Object[] toArray() {
		
		Object[] tmp = new Object[counter];
		for(int i = 0; i < counter; i++) 
			tmp[i] = objs[i];
		
		return tmp;
	}
	
	
	public String toString() {
		String lines = "";
		objs = toArray();
		for(int i = 0; i < objs.length; i++)
			lines = lines + objs[i] + "\n";
		
		return lines;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
