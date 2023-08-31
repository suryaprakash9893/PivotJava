package cruiseAndHotelBooking;

import java.util.Scanner;

import cruiseBookingWithLogin.CruiseDetails;

public class Cruise extends User {
	public String cruiseName;
	public double priceForAnAdultPerDay;
	public double priceForAKidPerDay;
	public int noOfDays;

	// Constructor#1:Parameterized constructor to instantiate the class level
	// variables.

	public Cruise(User user, String cruiseName, double priceForAdults, double priceForChildren, int noOfDays) {
		this.cruiseName = cruiseName;
		this.priceForAnAdultPerDay = priceForAdults;
		this.priceForAKidPerDay = priceForChildren;
		this.noOfDays = noOfDays;
	}

	public Cruise() {
	}

	Scanner sc = new Scanner(System.in);

	// Constructor#2:Non-Parameterized constructor to create an object of this
	// class.
	public String getCruiseName() {
		return cruiseName;
	}

	public double getPriceForAnAdultPerDay() {
		return priceForAnAdultPerDay;
	}

	public double getPriceForAKidPerDay() {
		return priceForAKidPerDay;
	}

	public int getNoOfDays() {
		return noOfDays;
	}

	// Method#1:To Display the Cruise options.
	public static void displayOptions() {
		System.out.println("We offer 4 different packages as below:");
		System.out.println("1.Scenic Cruise");
		System.out.println("2.Sunset Cruise");
		System.out.println("3.Discovery Cruise");
		System.out.println("4.Mystrey Cruise");
	}

	public void printDetailsOfSelectedCruise(Cruise selectedCruise) {
		System.out.println("You have selected " + selectedCruise.getCruiseName() + " which is a "
				+ selectedCruise.getNoOfDays() + " day Cruise.");
		System.out.println("Price for Adults:(above 12 years of age):         $ "
				+ selectedCruise.getPriceForAnAdultPerDay() + "  per day.");
		System.out.println("Price for Kids(above 5 years of age):             $ "
				+ selectedCruise.getPriceForAKidPerDay() + "  per day." + "\n"
				+ "-------------------------------------------------------------------------------------------------------");
	}

	// Method#6:To Pre-book food on board.
	public boolean bookFood() {
		boolean bookFood = false;
		System.out.println(
				"All our cruises have food service on board.Do you want to pre-book for dinner buffet meals at $20.99 per day and $4.99 per day for Kids?");
		System.out.println("Press Y to confirm or press any other key to skip pre-booking food on board");
		String optionSelected = sc.next();

		if (optionSelected.equalsIgnoreCase("Y")) {
			bookFood = true;
		} else {
			System.out.println("Skipped Pre-booking for dinner buffet");
		}
		return bookFood;
	}

	// Method#7:To calculate the gross price of 1 Adult ticket for the selected
	// cruise trip.
	public static double grossPriceForAnAdultTicket(Cruise selectedCruise) {
		return selectedCruise.getNoOfDays() * selectedCruise.priceForAnAdultPerDay;
	}

	// Method#8:To calculate the gross price of 1 Kid's ticket for the selected
	// cruise trip.
	public static double grossPriceForAKidsTicket(Cruise selectedCruise) {
		return selectedCruise.getNoOfDays() * selectedCruise.priceForAKidPerDay;
	}

	// Method#9:To calculate the gross price of 1 Adult Dinner for the selected
	// cruise trip.
	public static double grossPriceForAnAdultDinner(Cruise selectedCruise) {
		return selectedCruise.getNoOfDays() * 20.99;
	}

	// Method#10:To calculate the gross price of 1 Kid's Dinner for the selected
	// cruise trip.
	public static double grossPriceForAKidsDinner(Cruise selectedCruise) {
		return selectedCruise.getNoOfDays() * 4.99;
	}

	// Method#11:Order Summary -(Adults,Kids,Buffet)
	public static void checkout(Cruise selectedCruise, int noOfAdultTickets, int noOfChargableKidsTickets,
			boolean isFoodPrebooked) {
		System.out.println("Your Package Includes:");
		double grossPriceForAdultsTickets = (grossPriceForAnAdultTicket(selectedCruise) * noOfAdultTickets);
		double grossPriceForKidsTickets = (grossPriceForAKidsTicket(selectedCruise) * noOfChargableKidsTickets);
		double grossPriceForAdultDinner = (grossPriceForAnAdultDinner(selectedCruise) * noOfAdultTickets);
		double grossPriceForKidsDinner = (grossPriceForAKidsDinner(selectedCruise) * noOfChargableKidsTickets);
		if (noOfChargableKidsTickets == 0) {
			System.out.println(selectedCruise.getCruiseName() + "-" + noOfAdultTickets + " Adults                   :$"
					+ grossPriceForAdultsTickets);
		}
		if (noOfChargableKidsTickets > 0) {
			System.out.println(selectedCruise.getCruiseName() + "-" + noOfChargableKidsTickets
					+ " Kids(above age 5)        :$" + grossPriceForKidsTickets);
		}
		if (isFoodPrebooked == true) {
			System.out.println(
					"Special Dinner Buffet-" + noOfAdultTickets + "Adults            :$" + grossPriceForAdultDinner);
			System.out.println("Special Dinner Buffet-" + noOfChargableKidsTickets + "Kids(above age 5) :$"
					+ grossPriceForKidsDinner);
		}
		double totalPriceBeforeTax = grossPriceForAdultsTickets + grossPriceForKidsTickets + grossPriceForAdultDinner
				+ grossPriceForKidsDinner;
		double tax = 0.15 * totalPriceBeforeTax;
		double netPriceForBookedTrip = totalPriceBeforeTax + tax;
		netPriceForBookedTrip = Math.round(netPriceForBookedTrip * 100.0) / 100.0;
		System.out.println("Total Price                              :$" + totalPriceBeforeTax);
		System.out.println("HST    @    15%                          :$" + tax);
		System.out.println("Net Price for this trip                  :$" + netPriceForBookedTrip);
	}

	public void printDetailsOfSelectedCruise(CruiseDetails selectedCruise) {
		System.out.println("You have selected " + selectedCruise.getCruiseName() + " which is a "
				+ selectedCruise.getNoOfDays() + " day Cruise.");
		System.out.println("Price for Adults:(above 12 years of age):         $ " + selectedCruise.getPriceForAdults()
				+ "  per day.");
		System.out.println("Price for Kids(above 5 years of age):             $ " + selectedCruise.getPriceForChildren()
				+ "  per day." + "\n"
				+ "-------------------------------------------------------------------------------------------------------");
	}
	
	// Method#12:To Book a cruise
	public void bookCruise(User user) {
		displayOptions();

		String enteredSelection = "";
		while (enteredSelection.equals("")) {
			System.out.println("Please enter the option of the cruise you want to book.");
			enteredSelection = sc.next();
			switch (enteredSelection) {
			case "1":
				user = new ScenicCruise(user, "Scenic Cruise", 43.99, 12.99, 3);			
				((Cruise) user).printDetailsOfSelectedCruise((Cruise) user);
				int noOfAdults=user.getnoOfAdultsForTheSelectedCruise();
				int noOfChargeableKids=user.calculateNoOfChargableKidsTickets(user.getKidsAge(getnoOfKidsForTheSelectedCruise()));
				var isFoodPrebooked=((Cruise) user).bookFood();
				var isSpaBooked=((ScenicCruise) user).bookSpaAtScenicCruise((Cruise) user,noOfAdults,noOfChargeableKids);
				
				((ScenicCruise) user).checkoutScenicCruise((Cruise) user,noOfAdults,noOfChargeableKids,isFoodPrebooked,isSpaBooked);
				break;
			case "2":
				user = new SunsetCruise(user, "Sunset Cruise", 52.99, 15.99, 1);
				((Cruise) user).printDetailsOfSelectedCruise((Cruise) user);
				noOfAdults=user.getnoOfAdultsForTheSelectedCruise();
				noOfChargeableKids=user.calculateNoOfChargableKidsTickets(user.getKidsAge(getnoOfKidsForTheSelectedCruise()));;
				var isCLDinnerBooked=((SunsetCruise) user).bookSpaAtScenicCruise((Cruise) user,noOfAdults,noOfChargeableKids);
				((SunsetCruise) user).checkout((Cruise) user,noOfAdults,noOfChargeableKids,((Cruise) user).bookFood(),isCLDinnerBooked);		
				break;
				
			case "3":
				user = new DiscoveryCruise(user, "Discovery Cruise", 39.99, 9.99, 4);
				((Cruise) user).printDetailsOfSelectedCruise((Cruise) user);
				noOfAdults=user.getnoOfAdultsForTheSelectedCruise();
				noOfChargeableKids=user.calculateNoOfChargableKidsTickets(user.getKidsAge(getnoOfKidsForTheSelectedCruise()));;
				var isAdventureGamesBooked=((DiscoveryCruise) user).bookSpaAtScenicCruise((Cruise) user,noOfAdults,noOfChargeableKids);
				((DiscoveryCruise) user).checkout((Cruise) user,noOfAdults,noOfChargeableKids,((Cruise) user).bookFood(),isAdventureGamesBooked);		
				break;
				
			case "4":
				user = new MystreyCruise(user, "Mystrey Cruise", 45.99, 12.99, 2);
				((Cruise) user).printDetailsOfSelectedCruise((Cruise) user);
				noOfAdults=user.getnoOfAdultsForTheSelectedCruise();
				noOfChargeableKids=user.calculateNoOfChargableKidsTickets(user.getKidsAge(getnoOfKidsForTheSelectedCruise()));;
				var isCasinoTableBooked=((MystreyCruise) user).bookSpaAtScenicCruise((Cruise) user,noOfAdults,noOfChargeableKids);
				((MystreyCruise) user).checkout((Cruise) user,noOfAdults,noOfChargeableKids,((Cruise) user).bookFood(),isCasinoTableBooked);		
				break;

			default:
				System.out.println("Invalid selection!Please try again");
				enteredSelection = "";
			}
		}
	}
}
