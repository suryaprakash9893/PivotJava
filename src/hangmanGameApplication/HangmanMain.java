package hangmanGameApplication;

import java.util.Arrays;
import java.util.Scanner;

public class HangmanMain {
	public static void main(String[] args) {
		HangmanGameSetup gameSetup = new HangmanGameSetup();
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Hangman!" + "\n" + "Please choose your difficulty level.");
		System.out.println("Easy" + "\n" + "Medium" + "\n" + "Hard");
		String gameLevel = sc.next();

		// Filter an array of names based on difficulty level.
		var selectedListOfNames = gameSetup.filterNamesForTheGame(gameLevel);

		// Pick a random element from the filtered array(difficulty).
		var selectedNameForGame = gameSetup.selectARandomNameForTheGame(selectedListOfNames);

		// Split the selected game name to char[].
		char[] charactersOfGameName = gameSetup.convertSelectedNameToCharArray(selectedNameForGame);
		// System.out.println(charactersOfGameName);

		// Mask the selected game name and store it as char[].
		char[] maskedCharsOfGameName = gameSetup.maskTheSelectedName(selectedNameForGame);

		// Game Logic
		gameSetup.guessTheName(charactersOfGameName, maskedCharsOfGameName);

	}
}
