package arrayExercise;

import java.util.Arrays;
import java.util.Scanner;

public class FindNameInArray {
	int i, numberOfTimesInTheList = 0;

	String[] names = new String[5];
	String enteredName;
	boolean status = false;

	Scanner sc = new Scanner(System.in);
	
	void populateNameArray() {

		for (int i = 0; i < names.length; i++) {
			System.out.println("Enter name: " + (i + 1));
			names[i] = sc.next();
		}
	}

	void printNames() {
		// Print array using Arrays.toString method.
		System.out.println(Arrays.toString(names));
		// Print array using for loop
		for (i = 0; i < names.length; i++) {
			System.out.println(names[i]);
		}
	}

	// Find the entered name if present in the array
	void findNameInArray() {
		System.out.println("Enter the name you want to search");
		enteredName = sc.next();

		for (i = 0; i < names.length; i++) {

			if (enteredName.equals(names[i])) {
				System.out.println(
						enteredName + " is present in the array list.Index of " + enteredName + " is " + i + ".");

				status = true;
				numberOfTimesInTheList++;
			}

		}
		if (status == false) {
			System.out.println(enteredName + " is not present in the list");
		}
		System.out.println(enteredName + " is present " + numberOfTimesInTheList + " times in the array list.");
	}

	void countNameInArray() {
		numberOfTimesInTheList = 0;
		for (i = 0; i < names.length; i++) {
			if (enteredName.equals(names[i])) {
				numberOfTimesInTheList++;
			}
		}
		System.out.println(enteredName + " is present " + numberOfTimesInTheList + " times in the array list.");
	}

}
