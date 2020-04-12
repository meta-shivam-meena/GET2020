import java.util.Stack;

public class Q3 {

	public static int calculateMass(String molecule)
			throws IllegalArgumentException {
		int n = 0; // number corresponding to instances of element on top
		int mass = 0;
		try {
			Stack<Integer> stack = new Stack<Integer>();
			for (int i = 0; i < molecule.length(); i++) {
				char ch = molecule.charAt(i);
				// increase number of instances if character is a digit
				if (ch >= '0' && ch <= '9') {
					n = n * 10 + (ch - '0');
				} else {
					// calculate mass of top of stack having n instances and
					// push onto stack
					if (n != 0) {
						stack.push(stack.pop() * n);
						n = 0;
					}
					switch (ch) {
					case '(':
						stack.push(0); // 0 represents '(' symbol.
						break;
					case ')':
						// combine elements within braces and push onto stack
						int sumOfElementsWithinBraces = 0;
						while (stack.peek() != 0) {
							sumOfElementsWithinBraces += stack.pop();
						}
						stack.peek();
						stack.push(sumOfElementsWithinBraces);
						break;
					case 'C':
						stack.push(12);
						break;
					case 'H':
						stack.push(1);
						break;
					case 'O':
						stack.push(16);
						break;
					default:
						throw new Exception();
					}
				}
			}
			if (n != 0) {
				stack.push(stack.pop() * n);
			}
			while (!stack.isEmpty()) {
				mass += stack.pop();
			}
		} catch (Exception e) {
			throw new IllegalArgumentException();
		}
		return mass;
	}

	public static void main(String[] args) {
		System.out.println(calculateMass("C(OH)2"));
		System.out.println(calculateMass("CHOC(CH3)3"));
	}

}
