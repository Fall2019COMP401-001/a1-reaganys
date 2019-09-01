package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Read in and store the number of customers - i.e. the first integer
		int customerCount = scan.nextInt();
		
		// Create two string arrays: one to store the first name, and one to store the last
		String[] fName = new String[customerCount];
		String[] lName = new String[customerCount];
		
		// Create a string array to store customer totals
		double[] output = new double[customerCount];
		
		// Cycle through each customer's information and store the first and last names and number of items bought
		for (int i = 0; i < customerCount; i++) {
			fName[i] = scan.next();
			lName[i] = scan.next();
			
			int totalBought = scan.nextInt();
			
			// Cycle through each product's info, multiply the number of items by the price, and store in output
			for (int a = 0; a < totalBought; a++) {
				int iTemp = scan.nextInt();
				scan.next();
				double dTemp = scan.nextDouble();
				
				output[i] += iTemp * dTemp;
				
			}
			
		}
		
		scan.close();
		
		// Print output as F. Last: Total. Shorten fName to first char of string and convert output to a string with 2 decimal places
		for (int i = 0; i < customerCount; i++) {
			System.out.println(fName[i].charAt(0) + ". " + lName[i] + ": " + String.format("%.2f", output[i]));
		}
		
	}
}
