import java.util.ArrayList;
import java.util.List;

public class BinaryTreeDictionary<K extends Comparable<K>, V> implements
		Dictionary<K, V> {
	private Node<K, V> root;

	public BinaryTreeDictionary() {
		root = null;
	}

	@Override
	public void put(K key, V value) {
		root = put(root, new Entry<K, V>(key, value));
	}

	private Node<K, V> put(Node<K, V> root, Entry<K, V> entry) {
		if (root == null) {
			root = new Node<K, V>(entry);
		} else if (entry.getKey().compareTo(root.entry.getKey()) < 0) {
			root.left = put(root.left, entry);
		} else if (entry.getKey().compareTo(root.entry.getKey()) > 0) {
			root.right = put(root.right, entry);
		} else {
			root.entry = entry;
		}
		return root;
	}

	@Override
	public void remove(K key) {
		root = remove(root, key);
	}
	
	private Node<K, V> remove(Node<K, V> root, K key) {
		if (root == null) {
			// do nothing
		} else if (key.compareTo(root.entry.key) < 0) {
			root.left = remove(root.left, key);
		} else if (key.compareTo(root.entry.key) > 0){
			root.right = remove(root.right, key);
		} else {
			// node with only one child or no child
			if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			}
			// node with two children, get the inorder successor here and delete
			// it in right subtree
			root.entry = minEntry(root.right);
			root.right = remove(root.right, root.entry.key);
		}
		return root;
	}
	
	private Entry<K, V> minEntry(Node<K, V> root) {
		while (root.left != null) {
			root = root.left;
		}
		return root.entry;
	}

	@Override
	public V get(K key) {
		return get(root, key);
	}
	
	private V get(Node<K, V> root, K key) {
		if (root == null) {
			return null;
		} else if (root.entry.key.compareTo(key) < 0) {
			return get(root.left, key);
		} else if (root.entry.key.compareTo(key) == 0) {
			return root.entry.value; 
		} else {
			return get(root.right, key);
		}
	}

	@Override
	public List<Dictionary.Entry<K, V>> getEntryList() {
		List<Dictionary.Entry<K, V>> entryList = new ArrayList<Dictionary.Entry<K,V>>();
		createInorderEntryList(entryList, root);
		return entryList;
	}

	private void createInorderEntryList(List<Dictionary.Entry<K, V>> entryList,
			Node<K, V> root) {
		if (root != null) {
			createInorderEntryList(entryList, root.left);
			entryList.add(root.entry);
			createInorderEntryList(entryList, root.right);
		}
	}

	@Override
	public List<Dictionary.Entry<K, V>> getEntryList(K low, K high) {
		List<Dictionary.Entry<K, V>> entryList = getEntryList();
		List<Dictionary.Entry<K, V>> result = new ArrayList<Dictionary.Entry<K,V>>();
		int i = 0;
		// reach the entry whose key is greater than or equal to low
		while (i < entryList.size() && entryList.get(i).getKey().compareTo(low) < 0) {
			i++;
		}
		// add entries to result till their keys are smaller than high
		while (i < entryList.size() && entryList.get(i).getKey().compareTo(high) <= 0) {
			result.add(entryList.get(i));
			i++;
		}
		return result;
	}

	public void inorderTraversal() {
		inorderTraversal(root);
	}

	private void inorderTraversal(Node<K, V> root) {
		if (root != null) {
			inorderTraversal(root.left);
			System.out.println(root.entry);
			inorderTraversal(root.right);
		}
	}

	@SuppressWarnings("hiding")
	private class Entry<K, V> implements Dictionary.Entry<K, V> {
		private K key;
		private V value;

		Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public K getKey() {
			return key;
		}

		@Override
		public V getValue() {
			return value;
		}

		public String toString() {
			return "(" + key + ", " + value + ")";
		}
	}

	@SuppressWarnings("hiding")
	private class Node<K, V> {
		Entry<K, V> entry;
		Node<K, V> left;
		Node<K, V> right;

		Node(Entry<K, V> entry) {
			this.entry = entry;
			left = null;
			right = null;
		}
	}

	public static void main(String[] args) {
		BinaryTreeDictionary<String, Integer> dictionary = new BinaryTreeDictionary<String, Integer>();
		dictionary.put("Shivam", 66);
		dictionary.put("Tanmay", 30);
		dictionary.put("Shikher", 22);
		dictionary.put("Lovendra", 26);
		dictionary.put("Gaurav", 7);
//		dictionary.inorderTraversal();
//		System.out.println(dictionary.get("Shivam"));
//		dictionary.remove("Shivam");
//		System.out.println(dictionary.get("Shivam"));
//		dictionary.inorderTraversal();
		List<Dictionary.Entry<String, Integer>> list = dictionary.getEntryList();
		System.out.println(list);
		list = dictionary.getEntryList("Lovendra", "Shivam");
		System.out.println(list);
		list = dictionary.getEntryList("Lovendra", "Shiva");
		System.out.println(list);
	}
}
