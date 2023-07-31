package libraryApplicationUsingConstructors;

public class LibraryAccount {
	String accountNumber;
	String accountHolderName;
	String accountPassword;
	String bookBorrowed1,bookBorrowed2;
	int numberOfBooksBorrowed;

	LibraryAccount(String nameOfAccount, String idNumberOfAccount, String passwordOfAccount,String borrowedBooks1,String borrowedBooks2,int noOfBooksBorrowed) {
		accountHolderName = nameOfAccount;
		accountNumber = idNumberOfAccount;
		accountPassword = passwordOfAccount;
		bookBorrowed1 = borrowedBooks1;
		bookBorrowed2=borrowedBooks2;
		numberOfBooksBorrowed=noOfBooksBorrowed;
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