import java.util.Arrays;

class MaxHeap {
	private int capacity;
	private int size = 0;
	private Node[] heap;

	MaxHeap(int capacity) {
		this.capacity = capacity;
		heap = new Node[capacity];
	}

	void printHeap() {
		for (int i = 0; i < size; i++) {
			System.out.print(heap[i].ballsLeft + " ");
		}
		System.out.println();
	}

	void add(int bowlerIndex, int ballsLeft) {
		ensureCapacity();
		heap[size] = new Node(bowlerIndex, ballsLeft);
		size++;
		heapifyUp();
	}

	int reduceMaxBowlerBallsLeftByOne() {
		if (size == 0) {
			return -1;
		}
		int bowlerIndex = heap[0].bowlerIndex;
		heap[0].ballsLeft = heap[0].ballsLeft - 1;
		heapifyDown();
		return bowlerIndex;
	}

	private int getLeftChildIndex(int parentIndex) {
		return 2 * parentIndex + 1;
	}

	private int getRightChildIndex(int parentIndex) {
		return 2 * parentIndex + 2;
	}

	private int getParentIndex(int childIndex) {
		return (childIndex - 1) / 2;
	}

	private boolean hasLeftChild(int parentIndex) {
		return getLeftChildIndex(parentIndex) < size;
	}

	private boolean hasRightChild(int parentIndex) {
		return getRightChildIndex(parentIndex) < size;
	}

	private boolean hasParent(int childIndex) {
		return getParentIndex(childIndex) >= 0;
	}

	private Node getLeftChild(int parentIndex) {
		return heap[getLeftChildIndex(parentIndex)];
	}

	private Node getRightChild(int parentIndex) {
		return heap[getRightChildIndex(parentIndex)];
	}

	private Node getParent(int childIndex) {
		return heap[getParentIndex(childIndex)];
	}

	private void swap(int index1, int index2) {
		Node element = heap[index1];
		heap[index1] = heap[index2];
		heap[index2] = element;
	}

	private void ensureCapacity() {
		if (size == capacity) {
			heap = Arrays.copyOf(heap, capacity * 2);
			capacity *= 2;
		}
	}

	private void heapifyUp() {
		int index = size - 1;
		while (hasParent(index) && getParent(index).compareTo(heap[index]) < 0) {
			swap(getParentIndex(index), index);
			index = getParentIndex(index);
		}
	}

	private void heapifyDown() {
		int index = 0;
		while (hasLeftChild(index)) {
			int biggestChildIndex = getLeftChildIndex(index);
			if (hasRightChild(index)
					&& getRightChild(index).compareTo(getLeftChild(index)) > 0) {
				biggestChildIndex = getRightChildIndex(index);
			}
			if (heap[index].compareTo(heap[biggestChildIndex]) < 0) {
				swap(index, biggestChildIndex);
			} else {
				break;
			}
			index = biggestChildIndex;
		}
	}

	private class Node implements Comparable<Node> {
		int bowlerIndex;
		int ballsLeft;

		Node(int bowlerIndex, int ballsLeft) {
			this.bowlerIndex = bowlerIndex;
			this.ballsLeft = ballsLeft;
		}

		@Override
		public int compareTo(Node that) {
			return this.ballsLeft - that.ballsLeft;
		}
	}
}

public class Q3 {

	public static void printBowlers(int totalBowlers, int ballsToBePlayed,
			int[] quotaOfBalls) {
		MaxHeap heap = new MaxHeap(totalBowlers);
		for (int i = 0; i < totalBowlers; i++) {
			heap.add(i, quotaOfBalls[i]);
		}
		while (ballsToBePlayed != 0) {
			System.out.println(heap.reduceMaxBowlerBallsLeftByOne() + " ");
//			heap.printHeap();
			ballsToBePlayed--;
		}
	}

	public static void main(String[] args) {
		int[] quotaOfBalls = { 10, 2, 3, 4, 1, 7, 6, 8, 2 };
		int ballsToBePlayed = 20;
		printBowlers(quotaOfBalls.length, ballsToBePlayed, quotaOfBalls);
	}
}
