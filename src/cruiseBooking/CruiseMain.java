package cruiseBooking;

import java.util.Scanner;

public class CruiseMain {

	public static void main(String[] args) {
		System.out.println("Welcome to Cordella cruises!");
		CruiseOperations cruiseOperations = new CruiseOperations();
		Scanner sc = new Scanner(System.in);
		var selectedCruise = cruiseOperations.selectCruiseToBook();
		int noOfAdults = cruiseOperations.getnoOfAdultsForTheSelectedCruise();
		int noOfKids=cruiseOperations.getnoOfKidsForTheSelectedCruise();

		if (noOfKids>0) {
			int kidsAge[] = cruiseOperations.getKidsAge(noOfKids);
			var noOfChargableKidsTickets = cruiseOperations.calculateNoOfChargableKidsTickets(kidsAge);
			boolean isFoodPrebooked = cruiseOperations.bookFood();
			if (isFoodPrebooked == true && noOfChargableKidsTickets>0) {
				CruiseOperations.checkout(selectedCruise, noOfAdults, noOfChargableKidsTickets, isFoodPrebooked);
			}else if(isFoodPrebooked == true && noOfChargableKidsTickets==0) {
				CruiseOperations.checkout(selectedCruise, noOfAdults, isFoodPrebooked);
			}
			else {
				CruiseOperations.checkout(selectedCruise, noOfAdults, noOfChargableKidsTickets);
			}
		} else if(noOfKids==0) {
			boolean isFoodPrebooked = cruiseOperations.bookFood();
			if (isFoodPrebooked == true) {
				CruiseOperations.checkout(selectedCruise, noOfAdults, isFoodPrebooked);
			} else {
				CruiseOperations.checkout(selectedCruise, noOfAdults);
			}
		}
		sc.close();
	}
}
