package libraryApplicationUsingConstructors;

import java.awt.print.Book;
import java.util.Arrays;
import java.util.Scanner;

public class Library {
	Scanner sc = new Scanner(System.in);
	
	Books harryPotter2 = new Books("GK_Rowling", "Chamber_of_Secrets", 3, false);
	Books atomicHabits = new Books("James_Clear", "Atomic_Habits", 3, false);
	Books sapiens = new Books("Yuval_Noah", "Sapiens", 3, false);
	Books threeMistakes = new Books("Chetan_Bagat", "3_Mistakes", 3, false);
	Books fivePoint = new Books("Chetan_Bagat", "Five_Point_Someone", 3, false);
	Books[] libraryBooks = { harryPotter2, atomicHabits, sapiens, threeMistakes, fivePoint };

	LibraryAccount anu = new LibraryAccount("Anu", 1220, "password", sapiens);
	LibraryAccount aman = new LibraryAccount("Aman", 1221, "password1", harryPotter2);
	LibraryAccount gopi = new LibraryAccount("Gopi", 1222, "password2", sapiens);
	LibraryAccount[] libraryAccounts = { anu, aman, gopi };

	LibraryAccount validateLoginCredentials() {
		int loginAttempt = 1;
		int enteredAccountNumber;
		String enteredPassword;
		boolean loginStatus = false;

		while (loginAttempt < 4) {
			System.out.println("Login attempt number:" + loginAttempt);
			System.out.println("Enter your Library Ac/no:");
			enteredAccountNumber = sc.nextInt();
			System.out.println("Enter your Password:");
			enteredPassword = sc.next();

			for (int i = 0; i < libraryAccounts.length; i++) {

				if (libraryAccounts[i].accountNumber == enteredAccountNumber
						&& (libraryAccounts[i].accountPassword).equals(enteredPassword)) {
					loginStatus = true;
					System.out.println(libraryAccounts[i].accountHolderName + " is logged into the application");
					return libraryAccounts[i];
				}
			}
			loginAttempt++;
			if (loginStatus == false && loginAttempt < 4) {
				System.out.println("Incorrect User id or password. Try again");
			} else {
				System.out.println("Too many incorrect login attempts.Please try again later!");
			}
		}
		return null;
	}

	void bookDetails() {
		String nameOfBookForDetails;
		int i;

		System.out.println("Enter the book name for further details");
		nameOfBookForDetails = sc.next();

		for (i = 0; i < libraryBooks.length; i++) {
			if (libraryBooks[i].nameOfBook.equals(nameOfBookForDetails)) {
				System.out.println("Book Name:" + libraryBooks[i].nameOfBook);
				System.out.println("Book Author:" + libraryBooks[i].nameOfAuthor);
				System.out.println("#ofcopies available" + libraryBooks[i].numberOfCopiesAvailable);

				for (i = 0; i < libraryAccounts.length; i++) {
					if (libraryAccounts[i].bookBorrowed.nameOfBook.equalsIgnoreCase(nameOfBookForDetails)) {
						System.out.println(libraryAccounts[i].accountHolderName + "has this book");
					}
				}
			}
		}
	}

	void borrowBook() {
		String nameOfBookBorrowed;
		int numberOfBooksBorrowed = 0;
		String takeABook = "Y";
		int i;
		boolean canBorrow = false;

		while (numberOfBooksBorrowed < 2 && takeABook.equalsIgnoreCase("Y")) {

			System.out.println("Enter the bookname to be borrowed:");
			nameOfBookBorrowed = sc.next();

			for (i = 0; i < libraryBooks.length; i++) {
				if (libraryBooks[i].nameOfBook.equals(nameOfBookBorrowed) && libraryBooks[i].numberOfCopiesAvailable > 0
						&& libraryBooks[i].isBorrowed == false) {
					libraryBooks[i].isBorrowed = true;
					libraryBooks[i].numberOfCopiesAvailable--;
					canBorrow = true;
					numberOfBooksBorrowed++;
					System.out.println(libraryBooks[i].nameOfBook + " has been borrowed.");
					break;
					// return libraryAccounts[i].bookBorrowed;
				}
			}
			if (canBorrow == false) {
				System.out.println(nameOfBookBorrowed + " can't be borrowed at present. Please choose another book.");
			}
			if (numberOfBooksBorrowed == 2) {
				System.out.println("Max limit of 2 books borrowed.");
				break;
			}

			System.out.println("Do you want to take another book?(Y/N)");
			takeABook = sc.next();
			canBorrow = false;
		}

	}
}
