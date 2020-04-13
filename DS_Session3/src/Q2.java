public class Q2 {
	public static void main(String[] args) {
		PriorityQueue<String> queue = new PriorityQueueImpl<String>();
		queue.enqueue("Shivam", 2);
		queue.enqueue("tanma", 3);
		queue.enqueue("shikher", 1);
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
	}
}
