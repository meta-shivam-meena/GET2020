/**
 * A class representing a multivariate polynomial with limited operations.
 * @author Shivam Kumar Meena
 */
public class MultivariatePolynomial {
	/**
	 * head of the outer list representing list of univariate polynomials
	 */
	private UnivariatePolynomial polynomialListHead;

	/**
	 * Constructor
	 */
	public MultivariatePolynomial() {
		polynomialListHead = null;
	}
	
	/**
	 * Return degree of the polynomial.
	 * @return
	 */
	public int getDegree() {
		int degree = 0;
		UnivariatePolynomial current = polynomialListHead;
		while (current != null) {
			if (current.getDegree() > degree) {
				degree = current.getDegree();
			}
			current = current.next;
		}
		return degree;
	}
	
	/**
	 * Add a term
	 * @param coefficient
	 * @param variable like 'x', 'y', 'z'
	 * @param exponent
	 */
	public void addTerm(int coefficient, char variable, int exponent) {
		UnivariatePolynomial current = findPolynomialByVariable(variable);
		if (current != null) {
			current.addTerm(coefficient, exponent);
			return;
		} else {
			UnivariatePolynomial polynomial = new UnivariatePolynomial(variable);
			polynomial.addTerm(coefficient, exponent);
			if (polynomialListHead == null) {
				polynomialListHead = polynomial;
				return;
			} else {
				current = polynomialListHead;
				while (current.next != null) {
					current = current.next;
				}
				current.next = polynomial;
				return;
			}
		}
	}

	/**
	 * It finds the polynomial by variable name in the outer list.
	 * @param variable
	 * @return
	 */
	UnivariatePolynomial findPolynomialByVariable(char variable) {
		UnivariatePolynomial current = polynomialListHead;
		while (current != null) {
			if (current.variable == variable) {
				return current;
			}
			current = current.next;
		}

		return null;
	}
	
	/**
	 * It is used to print the polynomial.
	 */
	void printPolynomial() {
		if (polynomialListHead == null) {
			System.out.println(0);
		} else {
			UnivariatePolynomial current = polynomialListHead;
			while (current != null) {
				current.printPolynomial();
				current = current.next;
			}
			System.out.println();
		}
	}

	/**
	 * It represents a univariate polynomial.
	 * @author Shivam Kumar Meena
	 */
	class UnivariatePolynomial {
		/**
		 * like 'x', 'y', 'z' etc.
		 */
		char variable;
		
		/**
		 * head of the list of terms representing this univariate polynomial.
		 */
		Term termListHead;
		
		/**
		 * It is used to connect to the next univariate polynomial.
		 */
		UnivariatePolynomial next;

		/**
		 * Constructor
		 * @param variable
		 */
		UnivariatePolynomial(char variable) {
			this.variable = variable;
			termListHead = null;
			next = null;
		}

		/**
		 * It returns the degree of this polynomial.
		 * @return
		 */
		int getDegree() {
			int degree = 0;
			Term current = termListHead;
			while (current != null) {
				if (current.exponent > degree) {
					degree = current.exponent;
				}
				current = current.next;
			}
			return degree;
		}

		/**
		 * It is used to add a term to this polynomial.
		 * @param coefficient
		 * @param exponent
		 */
		void addTerm(int coefficient, int exponent) {
			Term term = findTermWithExponent(exponent);
			if (term != null) {
				term.coefficient += coefficient;
				// TODO
				// if coefficient becomes 0, then delete the term.
				return;
			} else {
				term = new Term(coefficient, exponent);

				if (termListHead == null) {
					termListHead = term;
					return;
				} else {
					Term current = termListHead;
					while (current.next != null) {
						current = current.next;
					}
					current.next = term;
					return;
				}
			}
		}

		/**
		 * Utility method to find a term with given exponent in this polynomial.
		 * @param exponent
		 * @return
		 */
		Term findTermWithExponent(int exponent) {
			Term current = termListHead;
			while (current != null) {
				if (current.exponent == exponent) {
					return current;
				}
				current = current.next;
			}

			return null;
		}

		/**
		 * It is used to print polynomial.
		 */
		void printPolynomial() {
			Term current = termListHead;
			while (current != null) {
				System.out.print(" + " + current.coefficient + variable + "^"
						+ current.exponent);
				current = current.next;
			}
		}

		/**
		 * It acts as an element of univariate polynomial.
		 * @author Shivam Kumar Meena
		 */
		private class Term {
			private int coefficient;
			private int exponent;
			private Term next;

			Term(int coefficient, int exponent) {
				this.coefficient = coefficient;
				this.exponent = exponent;
				next = null;
			}
		}
	}
}