import java.util.List;

public interface Dictionary<K extends Comparable<K>, V> {
	void put(K key, V value);

	void remove(K key);

	V get(K key);

	List<Entry<K, V>> getEntryList();
	
	List<Entry<K, V>> getEntryList(K low, K high);

	public interface Entry<K, V> {
		K getKey();
		V getValue();
	}
}