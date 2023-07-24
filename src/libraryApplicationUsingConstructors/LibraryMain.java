package libraryApplicationUsingConstructors;

import java.util.Scanner;

public class LibraryMain {

	public static void main(String[] args) {
		Library torontoPublic = new Library();
		Scanner sc = new Scanner(System.in);
		String libraryFunction;

		System.out.println("Welcome to Online Library!");
		torontoPublic.validateLoginCredentials();

		System.out.println("What function to perform?");
		System.out.println("Get details regarding a book: " + " Press D");
		System.out.println("Borrow a book: " + " Press B");

		libraryFunction = sc.next();

		switch (libraryFunction) {

		case "d":
			torontoPublic.bookDetails();
			break;

		case "b":
			torontoPublic.borrowBook();
			break;
		default:
			System.out.println("Enter a valid function to perform at the Library");
		}
	}
}
