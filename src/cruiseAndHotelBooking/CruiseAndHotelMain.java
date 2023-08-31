package cruiseAndHotelBooking;

import java.util.Scanner;

public class CruiseAndHotelMain {

	public static void main(String[] args) {
		User user = new User();
		Scanner sc = new Scanner(System.in);
		user=user.setUserDetails(user);
		// Use type casting to access explicit variables & methods of child class Hotel
		// using ref.variable of Parent Class User.

		System.out.println("Please enter the service you want to book." + "\n" + "1.Hotel Stay" + "\n" + "2.Cruise");
		String enteredService = "Y";
		while (enteredService.equalsIgnoreCase("Y")) {
			enteredService = sc.next();
			switch (enteredService) {
			case "1":
				// User Type casting to access explicit variables & methods of child class Hotel using
				// ref.variable of Parent Class User.  resolve unnamed module of loader 'app'.
				user.displayUserDetails(user);
				user=new HotelStay();
				((HotelStay) user).bookHotelRoom(user);
				break;
			case "2":
				user=new Cruise();
				((Cruise) user).bookCruise(user);
				break;

			default:
				System.out.println("Invalid selection!Try again...");
				enteredService = "";
			}
			System.out.println("Do you want to book another Hotel Room or Cruise?Press Y..." + "\n"
					+ "Press any other key to exit the application");
			enteredService = sc.next();
		}
		System.out.println("Exiting the application...");
	}

}
