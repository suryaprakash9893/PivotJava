package cruiseBookingWithLogin;

import java.util.Scanner;
import cruiseBooking.CruiseOperations;

public class CruiseMain {
	public static void main(String[] args) {
		System.out.println("Welcome to Cordella cruises!" + "\n"
				+ "Please sign-up to view details or book a cruise from Cordella.");
		Scanner sc = new Scanner(System.in);
		User user = new User();
		User selectedUser = user.getUserDetails();
		boolean loginStatus = false;
		while (loginStatus == false) {
			loginStatus = user.validateLoginCredentials(selectedUser);
		}
		if (loginStatus == true) {
			System.out.println("Hi "+selectedUser.getNameOfUser()+ ",You are logged into the Cordella cruises booking page.");
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
		System.out.println("Do you want to update your personal info?" + "\n"
				+ "Press Y to change. Press any other key to exit.");
		String updatePersonalInfo = sc.next();
		if (updatePersonalInfo.equalsIgnoreCase("Y")) {
			boolean loginAttempt = user.loginAttempts(selectedUser);
			if (loginAttempt == true && updatePersonalInfo.equalsIgnoreCase("Y")) {
				user.updateUserDetails(selectedUser);
				System.out.println("Do you want to update any other profile info? Press Y. Press any other key to exit.");
				updatePersonalInfo=sc.next();
			}
		}
		System.out.println("Exiting the application.Thanks for choosing Cordella cruises "+selectedUser.getNameOfUser());
	}
}
