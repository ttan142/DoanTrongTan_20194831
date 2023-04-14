import java.util.Scanner;

public class SecondDegreeEquationWithOneVariable {
	public static void main(String[] args) {
		double a, b, c, delta, x1, x2;
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.print("a = ");
			a = scanner.nextDouble();
			if (a == 0) {
				System.out.println("The value of 'a' have to be different from zero! "
						+ "Try again ");
				continue;
			} else {
				break;
			}
		} while (true);
		
		System.out.print("b = ");
		b = scanner.nextDouble();
		System.out.print("c = ");
		c = scanner.nextDouble();
		
		delta = b * b - 4 * a * c;
		
		if (delta == 0) {
			x1 = -b / (2 * a);
			System.out.println("The equation has double root: " + x1);
		} else if (delta > 0) {
			x1 = (-b + Math.sqrt(delta)) / (2 * a);
			x2 = (-b - Math.sqrt(delta)) / (2 * a);
			System.out.println("The equation has two distinct roots: " 
			+ x1 + " and " + x2);
		} else {
			System.out.println("The equation has no solution");
		}
	}
}