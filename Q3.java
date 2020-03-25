public class Q3 {
	
	public static void main(String[] args) {
		MultivariatePolynomial poly = new MultivariatePolynomial();
		poly.addTerm(3, 'x', 2);
		poly.printPolynomial();
		System.out.println("Degree: " + poly.getDegree());
		poly.addTerm(1, 'x', 3);
		poly.printPolynomial();
		System.out.println("Degree: " + poly.getDegree());
		poly.addTerm(2, 'y', 5);
		poly.printPolynomial();
		System.out.println("Degree: " + poly.getDegree());
		poly.addTerm(1, 'z', 0);
		poly.printPolynomial();
		System.out.println("Degree: " + poly.getDegree());
	}
}
