import java.util.Scanner;

public class TheNumberOfDaysOfAMonth {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String month;
		int year;
		do {
			System.out.print("Enter month (1-12): ");
			month = scanner.nextLine();
			if (month.length() == 1 || month.length() == 2) {
				if (Integer.parseInt(month) < 1 || Integer.parseInt(month) > 12)
					continue;
				else
					break;
			} else
				break;
		} while (true);

		do {
			System.out.print("Enter year (>0): ");
			year = scanner.nextInt();
			if (year <= 0)
				continue;
			else
				break;
		} while (true);

		if (month.length() == 1 || month.length() == 2) {
			switch (Integer.parseInt(month)) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				System.out.println("31 days.");
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				System.out.println("30 days.");
				break;
			default: {
				if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
					System.out.println("29 days.");
				else
					System.out.println("28 days.");
			}
			}
		}

		if (month.compareTo("January") == 0 || month.compareTo("Jan.") == 0
				|| month.compareTo("Jan") == 0 || month.compareTo("March") == 0
				|| month.compareTo("Mar.") == 0 || month.compareTo("Mar") == 0
				|| month.compareTo("May") == 0 || month.compareTo("May.") == 0
				|| month.compareTo("July") == 0 || month.compareTo("Jul.") == 0
				|| month.compareTo("Jul") == 0 || month.compareTo("August") == 0
				|| month.compareTo("Aug.") == 0 || month.compareTo("Aug") == 0
				|| month.compareTo("October") == 0 || month.compareTo("Oct.") == 0
				|| month.compareTo("Oct") == 0 || month.compareTo("December") == 0
				|| month.compareTo("Dec.") == 0 || month.compareTo("Dec") == 0)
			System.out.println("31 days.");

		if (month.compareTo("April") == 0 || month.compareTo("Apr.") == 0
				|| month.compareTo("Apr") == 0 || month.compareTo("June") == 0
				|| month.compareTo("Jun.") == 0 || month.compareTo("Jun") == 0
				|| month.compareTo("September") == 0 || month.compareTo("Sep.") == 0
				|| month.compareTo("Sep") == 0 || month.compareTo("November") == 0
				|| month.compareTo("Nov.") == 0 || month.compareTo("Nov") == 0)
			System.out.println("30 days.");

		if (month.compareTo("February") == 0 || month.compareTo("Feb.") == 0
				|| month.compareTo("Feb") == 0) {
			if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
				System.out.println("29 days.");
			else
				System.out.println("28 days.");
		}
	}
}