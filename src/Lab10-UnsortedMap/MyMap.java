package Lab10


public class MyMap implements Map {
	
	/**
	 * realizzazione della classe entry
	 * @author Alexandru Tiberiu Vilcu
	 *
	 */
	private class Entry {
		private Object key;
		private Object value;
		
		/**
		 * costruttore
		 * @param k = chiave
		 * @param v = valore della chiave
		 */
		private Entry(Object k, Object v) {
			setKey(k);
			setValue(v);
		}
		
		/**
		 * 
		 * @return riferimento alla chiave
		 */
		private Object getKey() { return key; }
		
		/**
		 * 
		 * @return valore associato alla chiave
		 */
		private Object getValue() { return value; }
		
		/**
		 *  imposta la chiave
		 */
		private void setKey(Object k) { key = k; }
		
		/**
		 * imposta il valore della chiave
		 */
		private void setValue(Object v) { value = v; }
	}
	
	/**
	 * variabili di esemplare
	 */
	private Entry[] p;
	private int counter;
	private final int CAPACITY = 1;
	
	/**
	 * costruttore
	 */
	public MyMap() { makeEmpty(); }
	
	/**
	 * svuota la mappa
	 */
	public void makeEmpty() {
		p = new Entry[CAPACITY];
		counter = 0;
	}
	
	/**
	 * 
	 * @return true se la mappa e' vuota
	 */
	public boolean isEmpty() { return counter == 0; }
	
	/**
	 * 
	 * @return dimensione della mappa
	 */
	public int size() { return counter; }
	
	/**
	 * O(n)
	 * clona le chiavi
	 * @return array ridimensionato di tutte le chiavi
	 */
	public Object[] keys() {
		Object[] keys = new Object[counter];
		for(int i = 0; i < counter; i++)
			keys[i] = p[i].getKey();
		return keys;
	}
	
	/**
	 * O(n)
	 * inserirsce una chiave
	 * @param key = chiave
	 * @param value = valore della chiave
	 * @return chiave sostituita con quella attuale
	 */
	public Object put(Object key, Object value) {
		if( key == null || value == null)
			throw new IllegalArgumentException("inserire una chiave/valore valido");
		
		Object old = remove(key);
		if(counter >= p.length) {
			Entry[] p2 = new Entry[p.length*2];
			System.arraycopy(p, 0, p2, 0, p.length);
			p = p2;
		}
		
		p[counter++] = new Entry(key,value);
		return old;
	}
	
	/**
	 * O(n)
	 * data una chiave la elimina e ne restituisce il valore
	 * @param key = chiave
	 * @return valore della chiave eliminata
	 */
	public Object remove(Object key) {
		for(int i = 0; i < counter; i++) {
			if(p[i].getKey().equals(key)) {
				Object obj = p[i].getValue();
				p[i] = p[counter-1];
				p[counter-1] = null;
				counter--;
				return obj;
			}
		}return null;
		
	}
	
	/**
	 * O(n)
	 * verifica l'esistenza di una chiave e ne restituisce il valore se esiste
	 * @param key = chiave
	 * @return valore della chiave
	 */
	public Object get(Object key) {
		for(int i = 0; i < counter; i++) {
			if(p[i].getKey().equals(key))
				return p[i].getValue();
		}
		return null;
	}
	
	
	
}
