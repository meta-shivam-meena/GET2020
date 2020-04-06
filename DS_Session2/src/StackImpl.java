@SuppressWarnings("rawtypes")
public class StackImpl<T> implements Stack {
	private int top = -1;
	private T[] elements;
	private int size;
	
	@SuppressWarnings("unchecked")
	public StackImpl() {
		elements = (T[]) new Object[1000];
	}
	
	@SuppressWarnings("unchecked")
	public StackImpl(int size) {
		elements = (T[]) new Object[size];
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void push(Object element) throws Exception {
		if (this.top == elements.length - 1) {
			throw new Exception("Stack Overflow");
		}
		elements[++top] = (T) element;
		size++;
	}
	
	@Override
	public Object pop() throws Exception {
		if (isEmpty()) {
			throw new Exception("Stack Underflow");
		}
		size--;
		return elements[top--];
	}
	
	@Override
	public Object peek() throws Exception {
		if (isEmpty()) {
			throw new Exception("Stack Underflow");
		}
		return elements[top];
	}
	
	@Override
	public boolean isEmpty() {
		return top == -1;
	}
	
	public int getSize() {
		return size;
	}
	
	@Override
	public void display() {
		System.out.println();
		System.out.println("Stack (Top on the right)");
		for (int i = 0; i <= top; i++) {
			System.out.print(elements[i] + ",");
		}
		System.out.println("\n");
	}
	
	public static void main(String[] args) {
		StackImpl<Integer> stack = new StackImpl<Integer>();
		try {
			stack.push(1);
			stack.push(2);
			stack.push(3);
			stack.display();
			System.out.println("Size - " + stack.getSize());
			System.out.println(stack.pop());
			stack.display();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
