package Lab13;

public class SE<E extends Comparable> extends S<E> implements Comparable<SE> {

	public SE() {
		super();
	}
	
	@Override
	public int compareTo(SE o) {
		
		Set s = (Set)o;
		if(equals(s))
			return 0;
		
		Iterator iter2 = s.iterator();
		Iterator iter = iterator();
		
		while(iter.hasNext() && iter2.hasNext()) {
			E a = (E)iter.next();
			E b = (E)iter.next();
			
			if (a.compareTo(b) < 0)
				return -1;
			else if (a.compareTo(b) > 0)
				return 1;
		}
			return 0;
	}
	
	public int hashCode() {
		
		return 0;
	}
	
	public void toArray(E[] a) throws IllegalArgumentException {
		
		if(a.length < size())
			throw new IllegalArgumentException();
		
		Iterator iter = iterator();
		
		int j = 0;
		while(iter.hasNext()) {
			a[j++] = (E)iter.next();
		}
	}
	
	public void toSortedArray(E[] a) throws IllegalArgumentException {
		
		if(a.length < size())
			throw new IllegalArgumentException();
		
		Iterator iter = iterator();
		
		int j = 0;
		while(iter.hasNext()) {
			a[j++] = (E)iter.next();
		}
		
		mergeSort(a);
	}
	
	private static void mergeSort(Object[] a) {
		if(a.length < 2)
			return;
		
		int mid = a.length/2;
		Object[] right = new Comparable[a.length - mid];
		Object[] left = new Comparable[mid];
		System.arraycopy(a, 0, right, 0, right.length);
		System.arraycopy(a, 0, left, 0, left.length);
		
		mergeSort(right);
		mergeSort(left);
		
		merge(a,right,left);
	}
	
	
	private static void merge(Object[] a, Object[] b, Object[] c) {
		
		int ia = 0, ib = 0, ic = 0;
		
		while(ib < b.length && ic < c.length) {
			if(((Comparable)b[ib]).compareTo(c[ic]) < 0 )
				a[ia++] = b[ic++];
			else
				a[ia++] = c[ic++];
		}
		
		while(ib < b.length)
			a[ia++] = b[ib++];
		while(ic < c.length)
			a[ia++] = c[ic++];
	}
	
	
	
	
	
	
}
