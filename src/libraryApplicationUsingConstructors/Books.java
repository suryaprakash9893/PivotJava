package libraryApplicationUsingConstructors;

public class Books {
	String nameOfBook;
	String nameOfAuthor;
	int numberOfCopiesAvailable;
	boolean isBorrowed;

	Books(String authorName, String bookName, int copiesAvailable, boolean canBorrow) {
		nameOfBook = bookName;
		nameOfAuthor = authorName;
		numberOfCopiesAvailable = copiesAvailable;
		isBorrowed=canBorrow;
	}
}