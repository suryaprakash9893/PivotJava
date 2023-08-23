package javaPracticals;

import java.util.Scanner;

public class PalindromeNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number:");
		int num = sc.nextInt();
		int rev=0;
		int orgNum=num;
		
		while(num!=0) {
			rev=(rev*10)+(num%10);
			num=num/10;
		}
		System.out.println(rev);
		
		if(orgNum==rev) {
			System.out.println(orgNum+"is a Palindrome#.");
		}else {
			System.out.println(orgNum+"is NOT a Palindrome#.");
		}
		
	}

}
