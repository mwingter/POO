package ssc103.dic;

public class Dicionario<K, V> {

	private K chaves[];
	private V valores[];
	private int next;
	
	@SuppressWarnings("unchecked")
	public Dicionario(int n) {
		chaves = (K[]) new Object[n];
		valores = (V[]) new Object[n];
		next = 0;
	}
	
	public void add(K key, V value) {
		if (this.contains(key)) 
			throw new IllegalArgumentException("Chave já existe");
		if ( next == chaves.length)
			throw new IndexOutOfBoundsException("Nao ha mais espaço para inserir");
		chaves[next] = key;
		valores[next] = value;
		next++;
	}
	
	public V get(K key) {
		for (int i = 0; i < chaves.length; i++) {
			if (chaves[i] == null)
				return null;
			if (chaves[i].equals(key))
				return valores[i];
		}
		return null;
	}
	
	public boolean contains(K key) {
		return get(key) != null;
	}
	
	public boolean containsValue(V value) {
		for (V v : valores) {
			if (v == null) 
				return false;
			if (v.equals(value))
				return true;
		}
		return false;
	}
}
