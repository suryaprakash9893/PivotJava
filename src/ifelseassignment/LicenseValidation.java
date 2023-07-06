package ifelseassignment;

public class LicenseValidation {
	int age;
	String currentLicense;

		void validateAgeAndCurrentLicenceLevel() {
		if (age>=16 && !currentLicense.equalsIgnoreCase("G1") && !currentLicense.equalsIgnoreCase("G2") && !currentLicense.equalsIgnoreCase("G")) {
			System.out.println("Age is valid, Eligible to apply for G1");
		} else if (age>=16 && currentLicense.equalsIgnoreCase("G1"))		{
			System.out.println("Eligible to apply for G2 license.");
		} else if (age>=16 && currentLicense.equalsIgnoreCase("G2"))		{
			System.out.println("Eligible to apply for G license.");
		} else if (age>=16 && currentLicense.equalsIgnoreCase("G"))		{
			System.out.println("You already have a full G licensece. Not eligible to apply for license.");
		}else {
			System.out.println("Not a valid age to apply for License yet.");
		}
	}

}