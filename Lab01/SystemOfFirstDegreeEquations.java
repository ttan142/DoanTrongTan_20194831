import java.util.Scanner;

public class SystemOfFirstDegreeEquations {
	public static void main(String[] args) {
		double a11, a12, a21, a22, b1, b2, D, D1, D2;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the following parameters:");
		System.out.print("a11 = ");
		a11 = scanner.nextDouble();
		System.out.print("a12 = ");
		a12 = scanner.nextDouble();
		System.out.print("a21 = ");
		a21 = scanner.nextDouble();
		System.out.print("a22 = ");
		a22 = scanner.nextDouble();
		System.out.print("b1 = ");
		b1 = scanner.nextDouble();
		System.out.print("b2 = ");
		b2 = scanner.nextDouble();
		
		D = a11 * a22 - a21 * a12;
		D1 = b1 * a22 - b2 * a12;
		D2 = a11 * b2 - a21 * b1;
		
		if (D != 0) {
			double x1 = D1 / D, x2 = D2 / D;			
			System.out.println("The system has a unique solution (x1, x2) = "
					+ "(" + x1 + "," + x2 + ")");
		} else {
			if (D1 == 0 && D2 == 0) {
				System.out.println("The system has infinitely many solutions");
			} else {
				System.out.println("The system has no solution");
			}
		}
	}
}