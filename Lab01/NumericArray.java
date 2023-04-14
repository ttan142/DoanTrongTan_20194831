import java.util.Arrays;

public class NumericArray {
	public static void main(String[] args) {
		double my_array1[] = new double[] {1789, 2035, 1899, 1456, 2013};
		for (int i = 0; i < my_array1.length; i++) {
			System.out.print(my_array1[i] + " ");
		}
		
		Arrays.sort(my_array1);
		
		System.out.println("\nThe sorted array:");
		
		for (int i = 0; i < my_array1.length; i++) {
			System.out.print(my_array1[i] + " ");
		}
		 int sum = 0;
       	 for (int i = 0; i < my_array1.length; i++)
       	 {
        	    sum += my_array1[i];
       	 }
      	  System.out.println("\nThe total sum of all the elements in the array is "+sum);
		  double avg= sum/my_array1.length;     
       	  System.out.println("The average of all the elements in an array is "+avg);
	}
}