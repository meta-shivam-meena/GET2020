public interface Queue<T> {
	public void enqueue(T element) throws Exception;
	public T dequeue() throws Exception;
	public boolean isEmpty();
	public boolean isFull();
	public int getSize();
	public void display();
}
