package hangmanGameApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HangmanGameSetup {

	Names binu = new Names("binu", DifficultyLevel.EASY);
	Names aman = new Names("aman", DifficultyLevel.EASY);
	Names gopi = new Names("gopi", DifficultyLevel.EASY);
	Names manvir = new Names("manvir", DifficultyLevel.MEDIUM);
	Names anumol = new Names("anumol", DifficultyLevel.MEDIUM);
	Names ketkai = new Names("ketkai", DifficultyLevel.MEDIUM);
	Names abishek = new Names("abishek", DifficultyLevel.HARD);
	Names manpreet = new Names("manpreet", DifficultyLevel.HARD);
	Names krishnaji = new Names("krishnaji", DifficultyLevel.HARD);

	Names[] namesList = { binu, aman, gopi, manvir, anumol, ketkai, abishek, manpreet, krishnaji };
	Scanner sc = new Scanner(System.in);

	String[] filterNamesForTheGame(String difficultyLevel) {
		String[] selectedListOfNames = new String[3];
		int counter = 0;
		for (int i = 0; i < namesList.length; i++) {
			if (namesList[i].level.difficultyLevel.equalsIgnoreCase(difficultyLevel)) {
				selectedListOfNames[counter] = namesList[i].name;
				System.out.println(selectedListOfNames[counter]);
				counter++;
			}
		}
		return selectedListOfNames;
	}

	String selectARandomNameForTheGame(String[] selectedListOfNames) {
		Random random = new Random();
		String randomName = selectedListOfNames[random.nextInt(selectedListOfNames.length)];
		//System.out.println(randomName);
		System.out.println("You have 5 chances to guess the correct name & save the stick man from hanging!");
		return randomName;
	}

	char[] convertSelectedNameToCharArray(String selectedgameName) {
		char[] charactersOfTheName = selectedgameName.toCharArray();
		return charactersOfTheName;
	}

	char[] maskTheSelectedName(String randomName) {
		var maskedName = randomName.replaceAll("[a-zA-z]", "*");
		char[] maskedCharOfAName = maskedName.toCharArray();
		System.out.println(maskedCharOfAName);
		return maskedCharOfAName;
	}

	String guessTheName(char[] charactersOfAName, char[] maskedCharOfAName) {
		int attempt = 1;
		boolean guess = false;
		ArrayList<Character> incorrectGuesses = new ArrayList<Character>();
		while (attempt < 6) {
			System.out.println("which letter are you guessing?");
			char enteredLetter = sc.next().charAt(0);
			for (int i = 0; i < charactersOfAName.length; i++) {
				if (charactersOfAName[i] == enteredLetter) {
					guess = true;
					maskedCharOfAName[i] = enteredLetter;
				}
			}
			System.out.println(Arrays.toString(maskedCharOfAName));
			if (guess == false) {
				incorrectGuesses.add(enteredLetter);
				System.out.println("Incorrect guess #: "+attempt + "\n" + "Previous Incorrect guesses:" +incorrectGuesses);
				attempt++;
			}
			guess = false;
			if(Arrays.equals(charactersOfAName,maskedCharOfAName)) {
					System.out.println("Wow,You saved stick man!...Congrats");
					return "Wow,You saved stick man!...Congrats";
				}	
		}
		return "You Lost:(";
	}

}
