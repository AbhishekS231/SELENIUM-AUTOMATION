package javaprogram;

import java.util.Scanner;

public class PowerPrgram {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number");
		int N = sc.nextInt();
		System.out.println("Enter the power");
		int P = sc.nextInt();
		int power = 1;
		if (N > 0) {
			for (int i = 1; i <= P; i++) {
				power = power * N;
			}
		}
		System.out.println("The Now number after power=" + power);
	}
}
