package libraryApplicationUsingConstructors;

import java.util.Scanner;

import libraryApplicationUsingConstructors.Books.BookType;

public class Library {

	Scanner sc = new Scanner(System.in);

	Books diaryOfAnneFrank = new Books(BookType.BIOGRAPHY, "Anne_Frank", "The_Diary_of_a_Young_Girl", 3, false);
	Books becoming = new Books(BookType.BIOGRAPHY, "Michelle_Obama", "Becoming", 2, false);
	Books harryPotter2 = new Books(BookType.FANTASY, "GK_Rowling", "Chamber_of_Secrets", 1, false);
	Books harryPotter4 = new Books(BookType.FANTASY, "GK_Rowling", "Goblet_of_Fire", 1, false);
	Books iceAndFire = new Books(BookType.FANTASY, "George_R_R_Martin", "Ice_and_Fire", 3, false);
	Books hobbit = new Books(BookType.FANTASY, "Toilkein", "The_Hobbit", 2, false);
	Books lordOfRings = new Books(BookType.FANTASY, "Toilkein", "The_Lord_of_the_Rings", 2, false);
	Books mockingBird = new Books(BookType.FICTION, "Harper_Lee", "To_Kill_a_Mockingbird", 2, false);
	Books fourWinds = new Books(BookType.FICTION, "Kristin_Hannah", "The_Four_Winds", 2, false);
	Books daVinciCode = new Books(BookType.MYSTREY, "Dan_Brown", "The_Da_Vinci_Code", 3, false);
	Books bodyInTheLib = new Books(BookType.MYSTREY, "Agatha_Christie", "The_Body_in_the_Library", 3, false);
	Books walkToRemember = new Books(BookType.ROMANCE, "Nicholas_Sparks", "A_Walk_to_Remember", 2, false);
	Books noteBook = new Books(BookType.ROMANCE, "Nicholas_Sparks", "The_Notebook", 2, false);

	Books[] libraryBooks = { diaryOfAnneFrank, becoming, harryPotter2, harryPotter4, iceAndFire, hobbit, lordOfRings,
			mockingBird, fourWinds, daVinciCode, bodyInTheLib, walkToRemember, noteBook };

	LibraryAccount anu = new LibraryAccount("Anu", "1220", "password", "empty", "empty", 0);
	LibraryAccount aman = new LibraryAccount("Aman", "1221", "password1", "Goblet_of_Fire", "Chamber_of_Secrets", 2);
	LibraryAccount gopi = new LibraryAccount("Gopi", "1222", "password2", "The_Lord_of_the_Rings", "The_Hobbit", 2);
	LibraryAccount binu = new LibraryAccount("Binu", "1223", "password3", "Chamber_of_Secrets", "Goblet_of_Fire", 2);
	LibraryAccount manu = new LibraryAccount("Manu", "1224", "password4", "The_Notebook", "A_Walk_to_Remember", 2);

	LibraryAccount[] libraryAccounts = { anu, aman, gopi, binu, manu };
	LibraryAccount[] loggedInAccount = new LibraryAccount[1];

	boolean validateLoginCredentials() {
		int loginAttempt = 1;
		String enteredAccountNumber;
		String enteredPassword;
		boolean loginStatus = false;

		while (loginAttempt < 4) {
			System.out.println("Login attempt number:" + loginAttempt);
			System.out.println("Enter your Library Ac/no:");
			enteredAccountNumber = sc.next();
			System.out.println("Enter your Password:");
			enteredPassword = sc.next();

			for (int i = 0; i < libraryAccounts.length; i++) {

				if (libraryAccounts[i].accountNumber.equalsIgnoreCase(enteredAccountNumber)
						&& (libraryAccounts[i].accountPassword).equals(enteredPassword)) {
					loginStatus = true;
					System.out.println(libraryAccounts[i].accountHolderName + " is logged into the application");
					loggedInAccount[0] = libraryAccounts[i];
					return loginStatus;
				}
			}
			loginAttempt++;
			if (loginStatus == false && loginAttempt < 4) {
				System.out.println("Incorrect User id or password. Try again");
			} else {
				System.out.println("Too many incorrect login attempts.Please try again later!");
			}
		}
		return loginStatus;
	}

	void displayBooksAsPerGenere() {
		String selectedGenere;
		boolean status = false;
		String displayBooksOfAGenere = "Y";

		while (displayBooksOfAGenere.equalsIgnoreCase("Y")) {
			System.out.println("Select your favourite genere from the list below:");
			System.out.println("Biography" + "\n" + "Fantasy" + "\n" + "Fiction" + "\n" + "Mystrey" + "\n" + "Romance");

			selectedGenere = sc.next();

			for (int i = 0; i < libraryBooks.length; i++) {
				if (libraryBooks[i].genereOfBook.genere.equalsIgnoreCase(selectedGenere)
						&& libraryBooks[i].numberOfCopiesAvailable > 0) {
					status = true;
					System.out.println(libraryBooks[i].nameOfBook + "|| No. of Copies available:"
							+ libraryBooks[i].numberOfCopiesAvailable);
				}
			}
			if (status == false) {
				System.out.println(selectedGenere
						+ " category is not available here.Please enter a valid genere from the list above!");
			}

			System.out.println("Do you want to view the books available in another genere?(Y/N)");
			displayBooksOfAGenere = sc.next();
			status = false;
			if (displayBooksOfAGenere.equalsIgnoreCase("N")) {
				System.out.println("Exiting from the book genere menu!");
			}
			if ((!displayBooksOfAGenere.equalsIgnoreCase("Y")) && (!displayBooksOfAGenere.equalsIgnoreCase("N"))) {
				System.out.println("Invalid selection.Exiting from the book genere menu!");
			}
		}
	}

	void bookDetails() {
		String nameOfBookForDetails;
		boolean showDetails = false;
		String displayBookDetails = "Y";
		while (displayBookDetails.equalsIgnoreCase("Y")) {
			System.out.println("Enter the book name for further details");
			nameOfBookForDetails = sc.next();
			for (int i = 0; i < libraryBooks.length; i++) {

				if (libraryBooks[i].nameOfBook.equals(nameOfBookForDetails)) {
					showDetails = true;
					System.out.println("Book Name:" + libraryBooks[i].nameOfBook);
					System.out.println("Book Author:" + libraryBooks[i].nameOfAuthor);
					System.out.println("#ofcopies available" + libraryBooks[i].numberOfCopiesAvailable);
					for (i = 0; i < libraryAccounts.length; i++) {
						if (libraryAccounts[i].bookBorrowed1.equalsIgnoreCase(nameOfBookForDetails)
								|| libraryAccounts[i].bookBorrowed2.equalsIgnoreCase(nameOfBookForDetails)) {
							System.out.println(libraryAccounts[i].accountHolderName + " has a copy of this book");
						}
					}
					break;
				}
			}
			if (showDetails == false) {
				System.out.println("Please enter a valid book name!");
			}
			System.out.println("Do you want to view details of another book?(Y/N)");
			displayBookDetails = sc.next();
			showDetails = false;
			if (!displayBookDetails.equalsIgnoreCase("Y") && !displayBookDetails.equalsIgnoreCase("N")) {
				System.out.println("Invalid selection.Exiting to Main menu.");
			}
			if (displayBookDetails.equalsIgnoreCase("N")) {
				System.out.println("Exiting from the book details menu to the Main menu!");
				break;
			}
		}
	}

	void viewBooksBorrowed() {
		if (loggedInAccount[0].bookBorrowed1.equalsIgnoreCase("empty")
				&& loggedInAccount[0].bookBorrowed2.equalsIgnoreCase("empty")) {
			System.out.println("No books borrowed at present. Can borrow two books.");
		} else if (loggedInAccount[0].bookBorrowed1.equalsIgnoreCase("empty")) {
			System.out.println("1 book can be borrowed");
			System.out.println("Below books are on hand:" + "\n" + loggedInAccount[0].bookBorrowed2);
		} else if (loggedInAccount[0].bookBorrowed2.equalsIgnoreCase("empty")) {
			System.out.println();
			System.out.println(
					"1 book can be borrowed." + " Below books are on hand:" + "\n" + loggedInAccount[0].bookBorrowed1);
		} else
			System.out.println("Below books are on hand:" + "\n" + loggedInAccount[0].bookBorrowed1 + "\n"
					+ loggedInAccount[0].bookBorrowed2);
	}

	void borrowBook() {
		String nameOfBookBorrowed;
		String takeABook = "Y";
		int i = 0;
		boolean canBorrow = false;

		while (loggedInAccount[0].numberOfBooksBorrowed < 3 && takeABook.equalsIgnoreCase("Y")) {
			System.out.println("Enter the bookname to be borrowed:");
			nameOfBookBorrowed = sc.next();
			for (i = 0; i < libraryBooks.length; i++) {
				if (libraryBooks[i].nameOfBook.equals(nameOfBookBorrowed) && libraryBooks[i].isBorrowed == false
						&& !loggedInAccount[0].bookBorrowed1.equalsIgnoreCase(nameOfBookBorrowed)
						&& !loggedInAccount[0].bookBorrowed2.equalsIgnoreCase(nameOfBookBorrowed)) {
					libraryBooks[i].isBorrowed = true;
					libraryBooks[i].numberOfCopiesAvailable--;
					canBorrow = true;
					loggedInAccount[0].numberOfBooksBorrowed++;
					libraryBooks[i].isBorrowed = false;
					if(loggedInAccount[0].bookBorrowed1.equalsIgnoreCase("empty")) {
						loggedInAccount[0].bookBorrowed1=nameOfBookBorrowed;
					}else {
						loggedInAccount[0].bookBorrowed2=nameOfBookBorrowed;
					}
					System.out.println(libraryBooks[i].nameOfBook + " has been borrowed by"+ loggedInAccount[0].accountHolderName);
					break;
					// return libraryAccounts[i].bookBorrowed;
				} 
			}
			if(canBorrow == false) {
				System.out.println(nameOfBookBorrowed + " can't be borrowed.Please choose another book.");
			}
			System.out.println("Do you want to take another book?(Y/N)");
			takeABook = sc.next();
			canBorrow = false;
		}
		if(loggedInAccount[0].numberOfBooksBorrowed==2) {
		System.out.println("Max limit of 2 books already borrowed. Please return a book before you can borrow any other books.");	
		}				
	}

	void returnBook() {
		String bookToReturn;
		String returnABook = "Y";
		while (loggedInAccount[0].numberOfBooksBorrowed > 0 && returnABook.equalsIgnoreCase("Y")) {
			System.out.println("Enter the bookname you want to return:");
			bookToReturn = sc.next();
			if (loggedInAccount[0].bookBorrowed1.equalsIgnoreCase(bookToReturn)
					|| loggedInAccount[0].bookBorrowed2.equalsIgnoreCase(bookToReturn)) {
				for (int i = 0; i < libraryBooks.length; i++) {
					if (libraryBooks[i].nameOfBook.equals(bookToReturn)) {
						libraryBooks[i].numberOfCopiesAvailable++;
						loggedInAccount[0].numberOfBooksBorrowed--;
						System.out.println(libraryBooks[i].nameOfBook + " has been returned.");
						if (loggedInAccount[0].bookBorrowed1.equalsIgnoreCase(bookToReturn)) {
							loggedInAccount[0].bookBorrowed1 = "empty";
							break;
						} else if (loggedInAccount[0].bookBorrowed2.equalsIgnoreCase(bookToReturn)) {
							loggedInAccount[0].bookBorrowed2 = "empty";
							break;
						}
					}
				}
			} else {
				System.out.println(bookToReturn + " can't be returned.");
			}
			System.out.println("Press Y return a book...");
			returnABook = sc.next();
		}
		if (loggedInAccount[0].numberOfBooksBorrowed == 0) {
			System.out.println("You don't have any books to return at present!");
		}
	}

	String logoutApplication() {
		System.out.println("You are logged out of the application");
		return null;
	}

}
