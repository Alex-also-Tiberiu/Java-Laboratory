package Lab12;

public class DE<K extends Comparable,V> extends D<K,V> {
	
	public DE() {
		super();
	}
	
	public boolean containsKey(K k) {
		Object v = get(k);
		if(v == null)
			return false;
		else
			return true;
	}
	
	public boolean isMultipleKey(K k) {
		Object[] scan = getAll(k);
		if(scan.length == 1 || scan == null)
			return false;
		else
			return true;
	}
	
	public Comparable[] sortedKeySet() {
		
		Object[] keys = keySet();
		mergeSort(keys);
		return (Comparable[])keys;
	}
	
	private static void mergeSort(Object[] a) {
		if(a.length < 2)
			return;
		int mid = a.length/2;
		Object[] rigth = new Object[ mid];
		Object[] left = new Object[a.length - mid];
		System.arraycopy(a, 0, rigth, 0, rigth.length);
		System.arraycopy(a, mid, left, 0, left.length);
		
		mergeSort(rigth);
		mergeSort(left);
		merge(a,left, rigth);
	}
	
	private static void merge(Object[] a, Object[] b, Object[] c) {
		int ia = 0, ib = 0, ic = 0;
		
		while(ib < b.length && ic < c.length) {
			if(((Comparable)b[ib]).compareTo(c[ic]) < 0) 
				a[ia++] = b[ib++];
			else
				a[ia++] = c[ic++];
		}
		while(ib < b.length)
			a[ia++] = b[ib++];
		while(ic < c.length)
			a[ia++] = c[ic++];
	}
	
}
