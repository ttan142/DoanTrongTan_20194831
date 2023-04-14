import java.util.Scanner;

public class TriangleStars {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a, b;

		System.out.print("Enter n = ");
		b = scanner.nextInt();

		for (int i = 1, k = 0; i <= b; ++i, k = 0) {
			for (a = 1; a <= b - i; ++a) {
				System.out.print("  ");
			}

			while (k != 2 * i - 1) {
				System.out.print("* ");
				++k;
			}
			System.out.println();
		}
	}
}