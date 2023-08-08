package libraryApplicationUsingConstructors;

public class Books {
	BookType genereOfBook;
	String nameOfBook;
	String nameOfAuthor;
	int numberOfCopiesAvailable;
	boolean isBorrowed;

	Books(BookType bookGenere, String authorName, String bookName, int copiesAvailable, boolean canBorrow) {
		genereOfBook=bookGenere;
		nameOfBook = bookName;
		nameOfAuthor = authorName;
		numberOfCopiesAvailable = copiesAvailable;
		isBorrowed = canBorrow;
	}
	
	Books(String bookName,String authorName) {
		nameOfBook = bookName;
		nameOfAuthor = authorName;
	}
	
	enum BookType{
		BIOGRAPHY("biography"),
		MYSTREY("mystrey"),
		FANTASY("fantasy"),
		FICTION("fiction"),
		ROMANCE("romance");
		
		String genere;
		
		BookType (String typeOfBook){
			genere=typeOfBook;
		}
		
		String getGenere() {
			return genere;
		}
	}
}