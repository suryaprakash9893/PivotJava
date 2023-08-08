package libraryApplicationUsingConstructors;

public class UserAccount {
	String accountNumber;
	String accountHolderName;
	String accountPassword;
//	Books bookBorrowed;                   // Tried to store 1 book borrowed in type "Books".
//	String bookBorrowed1, bookBorrowed2;  // Using String to store the values of books borrowed.
	String[] booksBorrowed=new String[2]; // Using String ARRAY to store the values of books borrowed.
	int numberOfBooksBorrowed;

	UserAccount(String nameOfAccount, String idNumberOfAccount, String passwordOfAccount, String[] borrowedBooks1,
			int noOfBooksBorrowed) {
		accountHolderName = nameOfAccount;
		accountNumber = idNumberOfAccount;
		accountPassword = passwordOfAccount;
		booksBorrowed = borrowedBooks1;
		//bookBorrowed2 = borrowedBooks2;
		numberOfBooksBorrowed = noOfBooksBorrowed;
//		bookBorrowed=borrowedBook;
	}

	UserAccount(String idNumberOfAccount, String passwordOfAccount) {
		accountNumber = idNumberOfAccount;
		accountPassword = passwordOfAccount;
	}

//	String getBookName() {
//		int i;
//		for (i = 0; i < bookBorrowed.length; i++) {
//			if (bookBorrowed[i] == null)
//				return "No";
//		}
//		return bookBorrowed[i];
//
//	}
}