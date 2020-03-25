/**
 * Linked List implementation with limited operations and methods as asked in
 * the assignment.
 * @author Shivam Kumar Meena
 */
public class LinkedList {
	/**
	 * Reference to start of the list.
	 */
	Node head;
	int size;
	
	/**
	 * Constructor
	 */
	LinkedList() {
		head = null;
		size = 0;
	}
	
	/**
	 * It act as element of the list.
	 */
	class Node {
		int data;
		Node next;
	}
	
	/**
	 * It creates a node with given data and inserts the node at the end of the list.
	 * @param data
	 */
	void insert(int data) {
		Node newNode = new Node();
		newNode.data = data;
		newNode.next = null;
		
		insert(newNode);
	}
	
	/**
	 * It inserts the given node at the end of the list.
	 * @param node
	 */
	void insert(Node node) {
		if (head == null) { // If list is empty
			head = node; // new Node becomes head
		} else {
			Node last = head;
			while (last.next != null) { // traversing to end of the list.
				last = last.next;
			}
			last.next = node;
		}
		size++;
	}
	
	/**
	 * It prints the list.
	 */
	void printList() {
		Node current = head;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}
}
