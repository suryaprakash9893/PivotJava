package javaPracticals;

import java.util.Scanner;

public class ReverseANumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number:");
		int num = sc.nextInt();
		int rev = 0;

		// Logic1
		while (num != 0) {
			rev = (rev * 10) + (num % 10);
			num = num / 10;
			System.out.println(rev);
		}
		System.out.println(rev);

		sc.close();

	}

}