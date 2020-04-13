@SuppressWarnings("rawtypes")
public class QueueImpl<T> implements Queue {
	private T[] elements;
	private int frontIndex;
	private int rearIndex;

	@SuppressWarnings("unchecked")
	public QueueImpl() {
		elements = (T[]) new Object[1000];
		frontIndex = -1;
		rearIndex = -1;
	}

	@SuppressWarnings("unchecked")
	public QueueImpl(int size) {
		elements = (T[]) new Object[size];
		frontIndex = -1;
		rearIndex = -1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void enqueue(Object element) throws Exception {
		if (isFull()) {
			throw new Exception("Queue full");
		}
		if (frontIndex == -1) {
			frontIndex = 0;
			rearIndex = 0;
		} else {
			rearIndex = (rearIndex + 1) % elements.length;
		}
		elements[rearIndex] = (T) element;
	}

	@Override
	public Object dequeue() throws Exception {
		if (isEmpty()) {
			throw new Exception("Queue Empty");
		}
		T element = elements[frontIndex];
		if (frontIndex == rearIndex) {
			frontIndex = -1;
			rearIndex = -1;
		} else {
			frontIndex = (frontIndex + 1) % elements.length;
		}
		return element;
	}

	@Override
	public boolean isEmpty() {
		return frontIndex == -1;
	}

	@Override
	public boolean isFull() {
		return (rearIndex + 1) % elements.length == frontIndex;
	}

	public int getSize() {
		if (isEmpty()) {
			return 0;
		}
		return ((rearIndex + elements.length) - frontIndex + 1)
				% elements.length;
	}

	@Override
	public void display() {
		System.out.println();
		if (isEmpty()) {
			System.out.println("Queue Empty\n");
			return;
		}
		System.out.println("Queue (Front on the left and back on the right)");
		if (rearIndex >= frontIndex) {
			for (int i = frontIndex; i <= rearIndex; i++) {
				System.out.print(elements[i] + ",");
			}
		}
		else {
			for (int i = frontIndex; i < elements.length; i++) {
				System.out.print(elements[i] + ",");
			}
			for (int i = 0; i <= rearIndex; i++) {
				System.out.print(elements[i] + ",");
			}
		}
		System.out.println("\n");
	}

	public static void main(String[] args) {
		QueueImpl<Integer> queue = new QueueImpl<Integer>(3);
		try {
			System.out.println(queue.isEmpty());
			queue.enqueue(1);
			System.out.println(queue.isEmpty());
			queue.display();
			queue.enqueue(2);
			queue.enqueue(3);
			queue.display();
			System.out.println(queue.isFull());
			queue.dequeue();
			queue.display();
			System.out.println(queue.isFull());
			queue.enqueue(0);
			queue.display();
			System.out.println(queue.isFull());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
