public interface Stack<T> {
	public void push(T element) throws Exception;
	public T pop() throws Exception;
	public T peek() throws Exception;
	public boolean isEmpty();
	public int getSize();
	public void display();
}