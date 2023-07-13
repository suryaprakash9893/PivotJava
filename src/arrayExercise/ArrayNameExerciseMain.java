package arrayExercise;

import java.util.Arrays;

public class ArrayNameExerciseMain {

	public static void main(String[] args) {

		ArrayNameExercise listOfArray = new ArrayNameExercise();

		listOfArray.arrayList();
		System.out.println(Arrays.toString(listOfArray.arrayOfNames));
		
		System.out.println("----------------------------------------------------------");

		listOfArray.phoneNumber();
		System.out.println(Arrays.toString(listOfArray.arrayOfNames));
		
		System.out.println("----------------------------------------------------------");
		
		listOfArray.favDrinks();
		System.out.println(Arrays.toString(listOfArray.drinks));
	}

}
