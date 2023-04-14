import java.util.Scanner;

public class AddTwoMatrices {
	
	static int MAX = 100;
	
	public static void main(String[] args) {
		
		double arr1[][] = new double[MAX][MAX];
		double arr2[][] = new double[MAX][MAX];
		double arr[][] = new double[MAX][MAX];
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the number of rows = ");
		int rows = scanner.nextInt();
		System.out.print("Enter the number of cols = ");
		int cols = scanner.nextInt();
		
		System.out.println("Enter the figures for the first matrix:");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.printf("arr1[%d][%d] = ", i, j);
				arr1[i][j] = scanner.nextDouble(); 
			}
		}
		
		System.out.println();
		
		System.out.println("Enter the figures for the second matrix:");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.printf("arr2[%d][%d] = ", i, j);
				arr2[i][j] = scanner.nextDouble(); 
			}
		}
		
		System.out.println();
		
		System.out.println("The first matrix:");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print(arr1[i][j] + "\t"); 
			}
			System.out.println();
		}
		
		System.out.println();
		
		System.out.println("The second matrix:");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print(arr2[i][j] + "\t"); 
			}
			System.out.println();
		}
		
		System.out.println();
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				arr[i][j] = arr1[i][j] + arr2[i][j];
			}
		}
		
		System.out.println("The sum of two matrices is:");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print(arr[i][j] + "\t"); 
			}
			System.out.println();
		}
	}
}