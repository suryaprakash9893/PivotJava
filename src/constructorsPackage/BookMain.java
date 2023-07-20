package constructorsPackage;

import java.util.Scanner;

public class BookMain {

	public static void main(String[] args) {

		int numberOfBooksBorrowed = 0;
		int chance = 0;
		String nameOfBookBorrowed;
		boolean canBorrow = false;

		Scanner sc = new Scanner(System.in);

		Book harryPotter = new Book("JK_Rowling", "Goblet_of_fire", false);
		Book famousFive = new Book("Andy_Blyton", "On_an_Island", false);
		Book fivePointSomeone = new Book("Chetan_Bhagat", "Five_Point_Someone", false);
		Book iceAndFire = new Book("R_Martin", "Ice_and_Fire", false);
		Book lordOfTheRings = new Book("JR", "Lord_of_the_Rings", false);

		Book[] namesOfTheBook = { harryPotter, famousFive, fivePointSomeone, iceAndFire, lordOfTheRings };

		while (numberOfBooksBorrowed < 2 && chance < 5 ) {

			System.out.println("Enter the book name to be borrowed:");
			nameOfBookBorrowed = sc.next();

			for (int i = 0; i < namesOfTheBook.length; i++) {
				if (namesOfTheBook[i].bookName.equals(nameOfBookBorrowed) && namesOfTheBook[i].isBookIssued == false) {
					namesOfTheBook[i].isBookIssued = true;
					canBorrow = true;
					numberOfBooksBorrowed++;
					System.out.println(nameOfBookBorrowed + " has been borrowed.");
					break;
				}

			}
			if (canBorrow == false) {
				System.out.println(nameOfBookBorrowed + " can't be borrowed at present. Please choose another book.");

			}
			canBorrow = false;
			chance++;
			
		}
		if (numberOfBooksBorrowed == 2) {
			System.out.println("Max limit of 2 books borrowed.");
		}
		if(chance==5) {
			System.out.println("Please ask for an available book. Please come again later!");
		}

	}
}
