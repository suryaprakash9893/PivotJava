package ifelseassignment;

import java.util.Scanner;

public class LicenseMain {

	public static void main(String[] args) {
		// Instantiating a class or creating an object "validate".
		LicenseValidation validate = new LicenseValidation();
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Enter age:");
		validate.age = sc.nextInt();
		
		System.out.println("Enter your current License level:");
		validate.currentLicense = sc.next();

		// Invoking the function
		
		validate.validateAgeAndCurrentLicenceLevel();

	}

}