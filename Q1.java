public class Q1 {
	/**
	 * It returns true if operation is performed successfully. The operation is
	 * performed is done if input is valid.
	 * 
	 * @param list
	 *            linked list from which sublist is to be rotated.
	 * @param left
	 *            position of leftmost node of sublist in list starting from 1.
	 * @param right
	 *            position of rightmost node of sublist in list.
	 * @param steps
	 *            number of steps by which the sublist needs to be rotated
	 *            clockwise.
	 * @return true if operation is successful and false otherwise.
	 */
	public static boolean rotateSubList(LinkedList list, int left, int right,
			int steps) {
		if (left < 1 || left > list.size || right < 1 || right > list.size
				|| left > right || steps < 1) {
			return false;
		} else {
			int subListSize = right - left + 1;
			steps = steps % subListSize; // effective steps to rotate
			if (steps == 0) { // no rotation needed if steps = 0.
				return true;
			}
			int newLeft = (right + 1) - steps; // current position of node which
												// will become start of sublist
												// after rotation.
			int newRight = newLeft - 1; // current position of node which will
										// become end of sublist after rotation.
			LinkedList.Node subListStart = null;
			LinkedList.Node subListNewEnd = null;
			LinkedList.Node NodeBeforeStartOfSubList = null;
			LinkedList.Node current = list.head;
			int currentNodePosition = 1;

			/*
			 * go to node denoting start of sublist
			 */
			if (left == 1) { // already at the start of sublist
				NodeBeforeStartOfSubList = null;
			} else {
				while (currentNodePosition != left - 1) {
					current = current.next;
					currentNodePosition++;
				}
				NodeBeforeStartOfSubList = current;
				current = current.next;
				currentNodePosition++;
			}

			subListStart = current;

			/*
			 * traverse through sublist and change references to reflect rotation.
			 */
			while (currentNodePosition != right + 1) {
				if (currentNodePosition == newLeft) {
					if (left == 1) {
						list.head = current;
					} else {
						NodeBeforeStartOfSubList.next = current;
					}
				}

				if (currentNodePosition == newRight) {
					subListNewEnd = current;
				}

				if (currentNodePosition == right) {
					subListNewEnd.next = current.next;
					current.next = subListStart;
				}

				current = current.next;
				currentNodePosition++;
			}

			return true;
		}
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.insert(2);
		list.insert(3);
		list.insert(4);
		list.insert(5);
		list.insert(6);
		list.insert(7);
		list.printList();
		rotateSubList(list, 2, 5, 2);
		list.printList();

		list = new LinkedList();
		list.insert(2);
		list.insert(3);
		list.insert(4);
		list.insert(5);
		list.insert(6);
		list.insert(7);
		list.printList();
		rotateSubList(list, 1, 5, 6);
		list.printList();
	}
}
