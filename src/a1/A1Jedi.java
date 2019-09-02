package a1;

import java.util.Scanner;

public class A1Jedi {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// Array for item
		int inventory = scan.nextInt();
		String[] item = new String[inventory];
		
		// Assigning values to array
		for (int i = 0; i < inventory; i++) {
			item[i] = scan.next();
			scan.nextDouble();
		}
		
		// Array for total
		int[] total = new int[inventory];
		
		// Array for number
		int customerNumber = scan.nextInt();
		boolean[][] numberGatherer = new boolean[customerNumber][inventory];
		// Set array of each customer's items to false
		for (int i = 0; i < customerNumber; i++) {
			for (int a = 0; a < inventory; a++) {
				numberGatherer[i][a] = false;
			}
		}
		int[] number = new int[inventory];
		
		// Assigning values to arrays
		for (int i = 0; i < customerNumber; i++) {
			// Skip customer name
			scan.next();
			scan.next();
			// Read number of items customer bought
			int temp = scan.nextInt();
			// Sort customer's 'cart' into arrays
			for (int a = 0; a < temp; a++) {
				int quantity = scan.nextInt();
				String product = scan.next();
				for (int b = 0; b < inventory; b++) {
					if (product.equals(item[b])) {
						numberGatherer[i][b] = true;
						total[b] += quantity;
					}
				}
			}
		}
		
		for (int i = 0; i < customerNumber; i++) {
			for (int a = 0; a < inventory; a++) {
				if (numberGatherer[i][a]) {
					number[a]++;
				}
			}
		}
		
		// Print results
		for (int c = 0; c < inventory; c++) {
			if (total[c] == 0) {
				System.out.println("No customers bought " + item[c]);
			} else {
				System.out.println(number[c] + " customers bought " + total[c] + " " + item[c]);
			}
		}
		
	}
	
}
