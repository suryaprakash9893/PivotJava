package libraryApplicationUsingConstructors;

public class LibraryAccount {

	int accountNumber;
	String accountHolderName;
	String accountPassword;
	Books bookBorrowed;

	LibraryAccount(String nameOfAccount, int idNumberOfAccount, String passwordOfAccount, Books borrowedBooks) {
		accountHolderName = nameOfAccount;
		accountNumber = idNumberOfAccount;
		accountPassword = passwordOfAccount;
		bookBorrowed = borrowedBooks;
	}

}
