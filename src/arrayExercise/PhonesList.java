package arrayExercise;

import java.util.Arrays;
import java.util.Scanner;

public class PhonesList {

	String enteredBrandName, enteredPhoneModel;
	String[] samsungPhones = new String[4];
	String[] googlePhones = new String[4];
	String[] applePhones = new String[4];
	String[] selectedBrand = new String[4];
	int i;
	boolean status = false;

	Scanner sc = new Scanner(System.in);

	void populatePhoneModels() {

		samsungPhones[0] = "S20";
		samsungPhones[1] = "S21";
		samsungPhones[2] = "Flip3";
		samsungPhones[3] = "Fold3";

		googlePhones[0] = "GooglePixel6";
		googlePhones[1] = "GooglePixel6Pro";
		googlePhones[2] = "GooglePixelPro";
		googlePhones[3] = "GooglePixel5";

		applePhones[0] = "iPhone12";
		applePhones[1] = "iPhone12 Mini";
		applePhones[2] = "iPhone13";
		applePhones[3] = "iPhone11";

	}

	void displayAvailablePhoneModelsForTheSelectedBrandAndValidateThePhoneModelForTheSelectedBrand() {
		System.out.println("Enter a Phone Brand name from the list below:");
		System.out.println("samsung");
		System.out.println("google");
		System.out.println("apple");
		enteredBrandName = sc.next();

		switch (enteredBrandName) {

		case "samsung":
			System.out.println("Available Samsung Phone are:" + Arrays.toString(samsungPhones));
			for (i = 0; i < selectedBrand.length; i++) {
				selectedBrand[i] = applePhones[i];
			}
				System.out.println("Choose a phone model from the list above");
				enteredPhoneModel = sc.next();
				for (i = 0; i < selectedBrand.length; i++) {
					if (enteredPhoneModel.equalsIgnoreCase(selectedBrand[i])) {
						System.out.println("Product is: " + enteredPhoneModel);
						status = true;
					}
				}
				if (status == false) {
					System.out.println("Please select a product from the list");
				}
			
			break;

		case "google":
			System.out.println("Available Google Phone are:" + Arrays.toString(googlePhones));
			for (i = 0; i < selectedBrand.length; i++) {
				selectedBrand[i] = applePhones[i];
			}
				System.out.println("Choose a phone model from the list above");
				enteredPhoneModel = sc.next();
				for (i = 0; i < selectedBrand.length; i++) {
					if (enteredPhoneModel.equalsIgnoreCase(selectedBrand[i])) {
						System.out.println("Product is: " + enteredPhoneModel);
						status = true;
					}
				}
				if (status == false) {
					System.out.println("Please select a product from the list");
				}
			
			break;

		case "apple":
			System.out.println("Available Apple Phone are:" + Arrays.toString(applePhones));
			for (i = 0; i < selectedBrand.length; i++) {
				selectedBrand[i] = applePhones[i];
			}
				System.out.println("Choose a phone model from the list above");
				enteredPhoneModel = sc.next();
				for (i = 0; i < selectedBrand.length; i++) {
					if (enteredPhoneModel.equalsIgnoreCase(selectedBrand[i])) {
						System.out.println("Product is: " + enteredPhoneModel);
						status = true;
					}
				}
				if (status == false) {
					System.out.println("Please select a product from the list");
				}
			
			break;
		default:
			System.out.println("Entered Brandname is not in the List!");
		}
	}
}

