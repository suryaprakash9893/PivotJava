package cruiseBookingWithLogin;

import java.util.Scanner;
import cruiseBooking.CruiseOperations;

public class CruiseMain {
	public static void main(String[] args) {
		System.out.println("Welcome to Cordella cruises!" + "\n"
				+ "Please sign-up to view details or book a cruise from Cordella.");
		Scanner sc = new Scanner(System.in);
		User user = new User();
		user = user.getUserDetails();
		user.displayUserDetails(user);
		boolean loginStatus = false;
		while (loginStatus == false) {
			loginStatus = user.validateLoginCredentials(user);
		}
		if (loginStatus == true) {
			System.out.println("Hi "+user.getNameOfUser()+ ",You are logged into the Cordella cruises booking page.");
			CruiseOperations cruiseOperations = new CruiseOperations();
			var selectedCruise = cruiseOperations.selectCruiseToBook();
			int noOfAdults = cruiseOperations.getnoOfAdultsForTheSelectedCruise();
			int noOfKids = cruiseOperations.getnoOfKidsForTheSelectedCruise();
			if (noOfKids == 0) {
				cruiseOperations.bookCruise(noOfAdults, selectedCruise);
			} else if (noOfKids > 0) {
				cruiseOperations.bookCruise(noOfAdults, noOfKids, selectedCruise);
			}
			System.out.println("---------------------------------------------------"+"\n");
		}
		user.updateUserDetails(user);
	sc.close();
	}
}
