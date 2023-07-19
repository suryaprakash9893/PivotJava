package methodsPractise;

import java.util.Arrays;
import java.util.Scanner;

public class PhoneListUsingMethods {

	String[] samsungPhones = { "S20", "S21", "Flip3", "Fold3" };
	String[] googlePhones = { "GooglePixel6", "GooglePixel6Pro", "GooglePixel5", "GooglePixelPro" };
	String[] applePhones = { "iPhone12", "iPhone12Mini", "iPhone13", "iPhone11" };

	Scanner sc = new Scanner(System.in);

	String[] validateBrandname(String brand) {

		switch (brand) {
		case "samsung":
			System.out.println("Seleceted brand is " + brand);
			return samsungPhones;

		case "google":
			System.out.println("Seleceted brand is " + brand);
			return googlePhones;

		case "apple":
			System.out.println("Seleceted brand is " + brand);
			return applePhones;
		}
		return null;
	}

	String validatePhoneModel(String[] storedBrandname, String enteredPhoneModel) {
		for (int i = 0; i < storedBrandname.length; i++) {
			if (enteredPhoneModel.equalsIgnoreCase(storedBrandname[i])) {
				System.out.println("Product selected is: " + enteredPhoneModel);
			}
	}
		System.out.println(enteredPhoneModel+" is not avaialble.");
		return null;
}
}