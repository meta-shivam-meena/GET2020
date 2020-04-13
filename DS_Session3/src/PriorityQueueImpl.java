/**
 * It implements a priority queue
 * Priority must be non-negative.
 * @author Shivam Kumar Meena
 * @param <T> type of data to be stored in priority queue
 */
public class PriorityQueueImpl<T> implements PriorityQueue<T>{
	private Node<T>[] elements;
	private int current = -1;
	
	@SuppressWarnings("unchecked")
	public PriorityQueueImpl() {
		elements = new Node[100];
	}
	
	@SuppressWarnings("unchecked")
	public PriorityQueueImpl(int capacity) {
		elements = new Node[capacity];
	}

	@Override
	public void enqueue(T item, int priority) {
		current++;
		elements[current] = new Node<T>(item, priority);
	}

	@Override
	public T dequeue() {
		if (current == -1) {
			return null;
		} else {
			int highestPriorityIndex = getHighestPriorityIndex();
			T data = (T) elements[highestPriorityIndex].data;
			int index = highestPriorityIndex;
			while (index != current) {
				elements[index]= elements[index + 1];
				index++;
			}
			current--;
			return data;
		}
	}
	

	private int getHighestPriorityIndex() {
		int maxPriority = -1;
		int maxPriorityIndex = -1;
		for (int i = 0; i <= current; i++) {
			if (elements[i].priority > maxPriority) {
				maxPriority = elements[i].priority;
				maxPriorityIndex = i;
			}
		}
		return maxPriorityIndex;
	}

	@Override
	public boolean isEmpty() {
		return current == -1;
	}

	@Override
	public int getHighestPriority() {
		int maxPriority = -1;
		for (int i = 0; i <= current; i++) {
			if (elements[i].priority > maxPriority) {
				maxPriority = elements[i].priority;
			}
		}
		return maxPriority;
	}
	
	@SuppressWarnings("hiding")
	private class Node<T> {
		T data;
		int priority;
		
		Node(T data, int priority) {
			this.data = data;
			this.priority = priority;
		}
	}

}
