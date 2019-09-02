package a1;

import java.util.Scanner;

public class A1Adept {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// Arrays for store items
		int inventory = scan.nextInt();
		String[] itemName = new String[inventory];
		double[] prices = new double[inventory];
		
		// Assigning values to arrays
		for (int i = 0; i < inventory; i++) {
			itemName[i] = scan.next();
			prices[i] = scan.nextDouble();
		}
		
		// Arrays for customers
		int customerNumber = scan.nextInt();
		String[] firstName = new String[customerNumber];
		String[] lastName = new String[customerNumber];
		double[] spent = new double[customerNumber];
		
		// Assigning values to arrays
		for (int i = 0; i < customerNumber; i++) {
			firstName[i] = scan.next();
			lastName[i] = scan.next();
			int purchases = scan.nextInt();
			
			for (int a = 0; a < purchases; a++) {
				double quantity = scan.nextDouble();
				String type = scan.next();
				spent[i] += totalSpent(quantity, type, itemName, prices);
			}
		}
		
		// Preparing output: Biggest
		int winner = 0;
		double bigWinner = 0;
		for (int i = 0; i < customerNumber; i++) {
			if (spent[i] > bigWinner) {
				bigWinner = spent[i];
				winner = i;
			}
		}
		String biggest = firstName[winner] + " " + lastName[winner] + " (" + String.format("%.2f", spent[winner]) + ")";
		System.out.println("Biggest: " + biggest);
		
		// Preparing output: Smallest
		double smallWinner = 100;
		for (int i = 0; i < customerNumber; i++) {
			if (spent[i] < smallWinner) {
				smallWinner = spent[i];
				winner = i;
			}
		}
		String smallest = firstName[winner] + " " + lastName[winner] + " (" + String.format("%.2f", spent[winner]) + ")";
		System.out.println("Smallest: " + smallest);
		
		// Preparing output: Average
		double temp = 0;
		for (int i = 0; i < customerNumber; i++) {
			temp += spent[i];
		}
		temp /= customerNumber;
		String average = String.format("%.2f", temp);
		System.out.println("Average: " + average);
	}
	
	// Match customer's items with recorded item prices and calculate total
	public static double totalSpent (double quantity, String type, String[] itemName, double[] prices) {
		for (int i = 0; i < itemName.length; i++) {
			if (type.equals(itemName[i])) {
				return quantity * prices[i];
			}
		}
		return 0;
	}
}