package Lab10

/**
 * 	CLASSE CHE DEFINISCE UNA MAPPA
 * @author Alexandru Tiberiu Vilcu
 * @version 15/12/2019
 *
 */
public class MySortedMap implements SortedMap {
	
	/**
	 * Classe interna che definisce Entry
	 * @author Alexandru Tiberiu Vilcu
	 * @version 15/12/2019
	 *
	 */
	private class Entry implements Comparable<Entry> {
		private Comparable key;
		private Object value;
		
		private Entry(Comparable k, Object v ) {
			setKey(k);
			setValue(v);
		}
		
		private void setKey(Comparable k) { key = k; }
		
		private void setValue(Object v) { value = v; }
		
		private Comparable getKey() { return key; }
		
		private Object getValue() { return value; }
		
		public int compareTo(Entry e) {
			return key.compareTo(e.key);
		}
		
	}
	
	
	/**
	 *  	VARIABILI DI ESEMPLARE
	 */
	private Entry[] bipol;
	private int counter;
	final private int SIZE = 1;
	
	
	/**
	 *  	COSTRUTTORE
	 */
	public MySortedMap() { makeEmpty(); }
	
	
	/**
	 * 		SVUOTA LA MAPPA
	 */
	public void makeEmpty() {
		bipol = new Entry[SIZE];
		counter = 0;
	}
	
	
	/**
	 * 		VERIFICA SE LA MAPPA È VUOTA
	 * 	@param vero/falso a seconda se la mappa è vuota
	 */
	public boolean isEmpty() { return counter == 0; }
	
	
	/**
	 * 		METODO CHE RESTITUISCE IL NUMERO DI CHIAVI
	 * @return numero di chiavi
	 */
	public int size() { return counter; }
	
	
	private static int search(Comparable[] a, int size, Comparable t) {
		return binarySearch(a, 0, size-1, t);	
	}
	
	/**
	 * O(logn)
	 *  	METODO DI RICERCA BINARIA
	 * @param a = array da ricercare
	 * @param from = indice iniziale
	 * @param to = indice finale
	 * @param sentinel = valore da ricercare
	 * @return numero dell'indice nell'array se c'è
	 */
	private static int binarySearch(Comparable[] a, int from, int to, Comparable sentinel) {
		if(from > to)
			return -1;
		
		int mid = (from + to) / 2;
		
		if(sentinel.compareTo(a[mid]) == 0)
			return mid;
		else if(sentinel.compareTo(a[mid]) < 0)
			return binarySearch(a, from, mid - 1, sentinel);
		else 
			return binarySearch(a,mid + 1, to, sentinel);
	}
	
	
	/**
	 * O(n)
	 * 		METODO CHE RESTITUISCE LA DIMENSIONE EFFETTIVA DELL'ARRAY CON LE RISPETTIVE CHIAVI E I LORO VALORI
	 * @return  nuovo array
	 */
	public Comparable[] sortedKeys() {
		Comparable[] keys = new Comparable[counter];
		for(int i = 0; i < counter; i++)
			keys[i] = bipol[i].getKey();
		return keys;
	}
	
	/**
	 * O(n)
	 *  	METODO ANALOGO A SORTEDKEYS
	 * @return  nuovo array
	 */
	public Comparable[] keys() {
		return sortedKeys();
	}
	
	/**
	 * O(n)
	 *   	INSERISCE UNA CHIAVE NELL'ARRAY CON IL SUO VALORE
	 * @param akey = chiave
	 * @param avalue = valore della chiave
	 * @return il valore della chiave se è già presente nel'array
	 */
	public Object put(Comparable akey, Object avalue) {
		if(akey == null || avalue == null )
			throw new IllegalArgumentException("chiave/valore non valido");
		
		Object x = remove(akey);
		
		if(x == null && counter >= bipol.length) {
			
			Entry[] newBipol = new Entry[bipol.length * 2];
			System.arraycopy(bipol, 0, newBipol, 0, counter);
			bipol = newBipol;
		}
		
		Entry newE = new Entry(akey, avalue);
		int j;
		for(j = counter; j > 0 && newE.compareTo(bipol[j-1]) < 0; j--)
			bipol[j] = bipol[j-1];
		
		bipol[j] = newE;
		counter++;
		return x;
	}
	
	/**
	 * O(n)
	 * 		RIMUOVE UNA CHIAVE DALL'ARRAY E NE RESTITUISCE IL VALORE
	 * @param akey = chiave de rimuovere
	 * @return valore della chiave rimossa
	 */
	public Object remove(Comparable akey) {
		if (akey == null )
			throw new IllegalArgumentException("chiave non valida");
		
		int n = search(bipol, counter, new Entry(akey, null));
		
		if(n < 0)
			return null;
		
		Object x = bipol[n].getValue();
		
		for(int i = n; i < counter - 1; i++)
			bipol[i] = bipol[i+1];
		
		bipol[counter-1] = null;
		
		counter--;
		return x;
	}

	/**		
	 * O(logn)
	 * 		RESTITUISCE IL VALORE DI UNA CHIAVE SE ESISTE ALTRIMENTI RESTITUISCE NULL
	 * @param akey = chiave da ricercare
	 * @return valore della chiave
	 */
	public Object get(Comparable akey) {
		if( akey == null )
			throw new IllegalArgumentException("chiave non valida");
		
		int n = search(bipol, counter, new Entry(akey, null));
		
		if( n < 0)
			return null;
		else
			return bipol[n].getValue();
	}

	
}
