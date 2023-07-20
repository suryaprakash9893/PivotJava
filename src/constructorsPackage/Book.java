package constructorsPackage;

import java.util.Scanner;

public class Book {

	boolean isBookIssued;
	String bookName;
	String nameOfAuthor;
	String takeAnotherBook = "Y";
	int numberOfBooksBorrowed;

	Scanner sc = new Scanner(System.in);

	Book(String nameAuthor, String nameBook, boolean isIssued) {

		bookName = nameBook;
		nameOfAuthor = nameAuthor;
		isBookIssued = isIssued;
	}

}
