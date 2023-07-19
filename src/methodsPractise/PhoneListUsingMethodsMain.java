package methodsPractise;

import java.util.Arrays;
import java.util.Scanner;

public class PhoneListUsingMethodsMain {

	public static void main(String[] args) {
		PhoneListUsingMethods pListUsingMethods = new PhoneListUsingMethods();

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter your preffered Brandname:");
		String brand = sc.next();

		String[] storedBrandname= pListUsingMethods.validateBrandname(brand);
		
		if (storedBrandname==null) {
			System.out.println(brand+" is not in the database.");
		}else {
			System.out.println("Available "+brand+" phones are: "+ Arrays.toString(storedBrandname));
			System.out.println("Enter your preffered Phone model:");
			String enteredPhoneModel = sc.next();
			pListUsingMethods.validatePhoneModel(storedBrandname,enteredPhoneModel);
		}		
	}
}
