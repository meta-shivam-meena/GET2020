import java.util.Collections;
import java.util.Comparator;

public class LinkedList {
	Node head;

	public void append(Employee data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
		} else {
			Node current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}
	}

	public void display() {
		Node current = head;
		System.out.println("List: ");
		while (current != null) {
			System.out.print(current.data + ", ");
			current = current.next;
		}
		System.out.println();
	}

	public void sortEmployeesBySalaryAndAgeDescending() {
		Node sortedListHead = null;
		Node current = head;
		while (current != null) {
			Node next = current.next;
			// insert current element in sortedList at correct position
			sortedListHead = sortedInsert(sortedListHead, current);
			current = next;
		}
		head = sortedListHead;
	}

	private Node sortedInsert(Node sortedListHead, Node newNode) {
		// if sorted list is empty
		if (sortedListHead == null) {
			newNode.next = null;
			return newNode;
		}
		Comparator<Employee> comparator = new CompareEmployeesBySalaryAndAge();
		// if element to be inserted is less than the head element
		if (comparator.compare(sortedListHead.data, newNode.data) < 0) {
			newNode.next = sortedListHead;
			sortedListHead = newNode;
		} else {
			Node current = sortedListHead;
			// locate the node before the point of insertion
			while (current.next != null && comparator.compare(current.next.data, newNode.data) > 0) {
				current = current.next;
			}
			newNode.next = current.next;
			current.next = newNode;
		}
		return sortedListHead;
	}
	
	class Node {
		Employee data;
		Node next;

		Node(Employee data) {
			this.data = data;
			next = null;
		}
	}

	class Employee {
		int id;
		int age;
		int salary;

		Employee(int id, int age, int salary) {
			this.id = id;
			this.age = age;
			this.salary = salary;
		}

		public String toString() {
			return ("(" + id + ", " + age + ", " + salary + ")");
		}
	}

	class CompareEmployeesBySalaryAndAge implements Comparator<Employee> {
		@Override
		public int compare(Employee employee1, Employee employee2) {
			if (employee1.salary < employee2.salary) {
				return -1;
			} else if (employee1.salary > employee2.salary) {
				return 1;
			} else {
				if (employee1.age > employee2.age) {
					return -1;
				} else if (employee1.age < employee2.age) {
					return 1;
				} else {
					return 0;
				}
			}
		}
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.append(list.new Employee(1, 20, 10000));
		list.append(list.new Employee(2, 21, 12000));
		list.append(list.new Employee(1, 20, 11000));
		list.append(list.new Employee(1, 19, 11000));
		list.append(list.new Employee(1, 22, 15000));
		list.display();
		list.sortEmployeesBySalaryAndAgeDescending();
		list.display();
	}
}
