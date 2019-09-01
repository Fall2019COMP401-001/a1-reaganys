package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Read in and store the number of customers - i.e. the first integer
		int customerCount = scan.nextInt();
		
		// Create two string arrays: one to store the first name, and one to store the last.
		String[] fName = new String[customerCount];
		String[] lName = new String[customerCount];
		
		double[] output = new double[customerCount];
		
		for (int i = 0; i < customerCount; i++) {
			fName[i] = scan.next();
			lName[i] = scan.next();
			
			int totalBought = scan.nextInt();
			
			for (int a = 0; a < totalBought; a++) {
				int iTemp = scan.nextInt();
				scan.next();
				double dTemp = scan.nextDouble();
				
				output[i] += iTemp * dTemp;
				
			}
			
		}
		
		scan.close();
		
		for (int i = 0; i < customerCount; i++) {
			System.out.println(fName[i].charAt(0) + ". " + lName[i] + ": " + String.format("%.2f", output[i]));
		}
		
	}
}
