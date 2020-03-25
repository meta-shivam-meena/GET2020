public class Q2 {
	public static boolean detectLoop(LinkedList list) {
		if (list == null) {
			return false;
		}

		LinkedList.Node iterator1 = list.head; // it goes to next node in one
												// step
		LinkedList.Node iterator2 = list.head; // it goes next to next node in
												// one step
		
		while (iterator2 != null && iterator2.next != null) {
			iterator1 = iterator1.next;
			iterator2 = iterator2.next.next;
			
			if (iterator1 == iterator2) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.insert(2);
		list.insert(3);
		LinkedList.Node node = list.new Node();
		node.data = 4;
		node.next = null;
		list.insert(node);
		list.insert(5);
		list.insert(6);
		list.insert(7);
		list.printList();
		System.out.println(detectLoop(list));
		
		// adding loop
		LinkedList.Node node2 = list.new Node();
		node2.data = 8;
		node2.next = node;
		list.insert(node2);
		// avoid printlist here as it will go in infinite loop
		System.out.println(detectLoop(list));
	}
}
