import java.text.DecimalFormat;
import java.util.Scanner;

public class FirstDegreeEquation {
	public static void main(String[] args) {
		DecimalFormat decimalformat = new DecimalFormat("#.####");
		Scanner scanner = new Scanner(System.in);
		float a, b, x;
		do {
			System.out.println("a = ");
			a = scanner.nextFloat();
			if (a == 0) {
				System.out.println("a have to be different from 0. Enter again!");
			} else {
				break;
			}
		} while(true);
		System.out.println("b = ");
		b = scanner.nextFloat();
		x = -b /a;
		System.out.println("Result: " + decimalformat.format(x));
		
	}
}