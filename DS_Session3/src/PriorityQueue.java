public interface PriorityQueue<T> {
	void enqueue(T item, int priority);
	T dequeue();
	boolean isEmpty();
	int getHighestPriority();
}
