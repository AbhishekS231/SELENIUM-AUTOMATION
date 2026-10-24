package javaprogram;

import java.util.Scanner;

public class ArmstrongNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number:");
		int num = sc.nextInt();
		int originalNum = num; // Store the original number
		int sum = 0;
		int digits = 0;

		// Count the number of digits
		int temp = num;
		while (temp > 0) {
			temp = temp / 10;
			digits++;
		}

		// Calculate the sum of digits raised to the power of the number of digits
		temp = num;
		while (temp > 0) {
			int digit = temp % 10; // Extract last digit
			int fact = 1;
			
			// Calculate digit^digits
			for (int i = 1; i <= digits; i++) {
				fact *= digit;
			}
			
			sum += fact; // Add power to sum
			temp /= 10; // Remove last digit
		}

		// Compare sum with original number
		if (sum == originalNum)
			System.out.println(originalNum + " is an Armstrong number.");
		else
			System.out.println(originalNum + " is not an Armstrong number.");
		
		sc.close(); // Close scanner
	}
}

