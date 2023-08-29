package cruiseBookingWithLogin;

import java.util.Scanner;

public class CruiseOperations {

	CruiseDetails scenicCruise = new CruiseDetails("Scenic_Cruise", 43.99, 12.99, 3);
	CruiseDetails sunsetCruise = new CruiseDetails("Sunset_Cruise", 52.99, 15.99, 1);
	CruiseDetails discoveryCruise = new CruiseDetails("Discovery_Cruise", 39.99, 9.99, 4);
	CruiseDetails mystreyCruise = new CruiseDetails("Mystrey_Cruise", 45.99, 12.99, 2);

	public CruiseDetails[] ships = { scenicCruise, sunsetCruise, discoveryCruise, mystreyCruise };

	Scanner sc = new Scanner(System.in);

	// Method#1:To Display the Cruise options.
	public static void displayOptions() {
		System.out.println("We offer 4 different packages as below:");
		System.out.println("1.Scenic Cruise");
		System.out.println("2.Sunset Cruise");
		System.out.println("3.Discovery Cruise");
		System.out.println("4.Mystrey Cruise");
	}

	// Method#2:To Select a Cruise from the options list.
	public CruiseDetails selectCruiseToBook() {
		String viewOptions = "Y";
		CruiseDetails selectedCruise = null;
		while (viewOptions.equalsIgnoreCase("Y")) {
			selectedCruise = null;
			displayOptions();
			System.out.println("Please select an option to view Cruise detials.");
			String optionSelected = sc.next();

			switch (optionSelected) {
			case "1":
				selectedCruise = scenicCruise;
				break;
			case "2":
				selectedCruise = sunsetCruise;
				break;
			case "3":
				selectedCruise = discoveryCruise;
				break;
			case "4":
				selectedCruise = mystreyCruise;
				break;

			default:
				break;
			}
//Handling null pointer Exception. Try to use Try & catch.
			if (selectedCruise != null) {
				printDetailsOfSelectedCruise(selectedCruise);
				System.out.println("Press 'Y' to view details of another Cruise or" + "\n"
						+ "Press any other key to start booking for the selected cruise...");
				viewOptions = sc.next();
			} else if (selectedCruise == null) {
				System.out.println("Wrong selection!Please try again...");
			}
		}
		System.out.println("Booking process for " + selectedCruise.getCruiseName()
				+ " to follow... Please have your personal and payment details ready.");
		return selectedCruise;
	}

	// Method#3:To print the details of the selected Cruise.
	public void printDetailsOfSelectedCruise(CruiseDetails selectedCruise) {
		System.out.println("You have selected " + selectedCruise.getCruiseName() + " which is a "
				+ selectedCruise.getNoOfDays() + " day Cruise.");
		System.out.println("Price for Adults:(above 12 years of age):         $ " + selectedCruise.getPriceForAdults()
				+ "  per day.");
		System.out.println("Price for Kids(above 5 years of age):             $ " + selectedCruise.getPriceForChildren()
				+ "  per day." + "\n"
				+ "-------------------------------------------------------------------------------------------------------");
	}

	// Method#4:To get the # of Adults and validate it for the selected Cruise trip.
	public int getnoOfAdultsForTheSelectedCruise() {
		System.out.println("---------Please read the instructions prior to booking---------");
		System.out.println("Person above 12 years of age is considered an Adult." + "\n"
				+ "Person below 12 years of age is considered as a Kid." + "\n");
		String noOfAdultTickets = "0";
		int noOfAdults = 0;
		while (noOfAdultTickets.equals("0")) {
			try {
				System.out.println("There should be atleast 1 Adult in the trip.");
				System.out.println("Enter the # of Adults:");
				noOfAdultTickets = sc.next();
				noOfAdults = Integer.parseInt(noOfAdultTickets);
			} catch (NumberFormatException e) {
				System.out.println(noOfAdultTickets
						+ " is not a valid number.Please enter a valid number of Adult tickets required.");
				noOfAdultTickets = "0";
			}
		}
		return noOfAdults;
	}

	// Method#5:To get the # of Kids for the selected Cruise trip.
	public int getnoOfKidsForTheSelectedCruise() {
		String noOfKidsTickets = new String("");
		int noOfKids = 0;
		while (noOfKidsTickets.equals("")) {
			try {
				System.out.println("Enter the # of Kids:");
				noOfKidsTickets = sc.next();
				noOfKids = Integer.parseInt(noOfKidsTickets);
			} catch (NumberFormatException e) {
				System.out.println(noOfKidsTickets
						+ " is not a valid number.Please enter a valid number of Kids tickets required.");
				noOfKidsTickets = "";
			}
		}
		return noOfKids;
	}

	// Method#6:To get the age of kids & validate it.
	public int[] getKidsAge(int noOfKids) {
		int counter = noOfKids - 1;
		String enteredAgeOfKid = "";
		int[] kidsAge = new int[noOfKids];
		while (noOfKids > 0) {
			for (int i = 0; i <= counter;) {
				try {
					System.out.println("Enter the age for Child " + (i + 1) + ":");
					enteredAgeOfKid = sc.next();
					int enteredAge = Integer.parseInt(enteredAgeOfKid);
					if (enteredAge < 12) {
						kidsAge[i] = enteredAge;
						i++;
						noOfKids--;
					} else if (enteredAge > 11) {
						System.out.println(enteredAge
								+ " years is not a valid age for a kid. Children below 12 years is considered as a kid.Please re-enter the age.");
					}
				} catch (NumberFormatException e) {
					System.out.println(enteredAgeOfKid
							+ " is not a valid number.Please enter a valid number of kids tickets required.");
				}
			}
		}
		return kidsAge;
	}

	// Method#7:To calculate the # chargeable Kids Tickets.
	public int calculateNoOfChargableKidsTickets(int[] kidsAge) {
		int noOfChargableKidsTickets = 0;
		for (int i = 0; i < kidsAge.length; i++) {
			if (kidsAge[i] > 5) {
				noOfChargableKidsTickets++;
			}
		}
		return noOfChargableKidsTickets;
	}

	// Method#8:To Pre-book food on board.
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

	/*
	 * public static void displayTripMembersDetails(CruiseDetails selectedCruise,int
	 * noOfAdultTickets,int noOfChargableKidsTickets,boolean isFoodPrebooked) {
	 * System.out.println("-------------------------"+"Passenger details for the "
	 * +selectedCruise.getCruiseName()+" booked-------------------------");
	 * System.out.println("");
	 * System.out.println("Total # of Adults:"+noOfAdultTickets);
	 * System.out.println("Total # of Kids:"+noOfChargableKidsTickets);
	 * if(isFoodPrebooked==true) {
	 * System.out.println("Total # of pre-booked food onboard:"
	 * +noOfChargableKidsTickets); } }
	 */

	// Method#9:To calculate the gross price of 1 Adult ticket for the selected
	// cruise trip.
	public static double grossPriceForAnAdultTicket(CruiseDetails selectedCruise) {
		return selectedCruise.getNoOfDays() * selectedCruise.getPriceForAdults();
	}

	// Method#10:To calculate the gross price of 1 Kid's ticket for the selected
	// cruise trip.
	public static double grossPriceForAKidsTicket(CruiseDetails selectedCruise) {
		return selectedCruise.getNoOfDays() * selectedCruise.getPriceForChildren();
	}

	// Method#11:To calculate the gross price of 1 Adult ticket for the selected
	// cruise trip.
	public static double grossPriceForAnAdultDinner(CruiseDetails selectedCruise) {
		return selectedCruise.getNoOfDays() * selectedCruise.getPriceForAdults();
	}

	// Method#12:To calculate the gross price of 1 Kid's ticket for the selected
	// cruise trip.
	public static double grossPriceForAKidsDinner(CruiseDetails selectedCruise) {
		return selectedCruise.getNoOfDays() * selectedCruise.getPriceForChildren();
	}

	// Method#13:Order Summary -(Only Adults,Buffet Not Included)
	public static void checkout(CruiseDetails selectedCruise, int noOfAdultTickets) {
		System.out.println("Your Package Includes:");
		double grossPriceForAdults = (grossPriceForAnAdultTicket(selectedCruise) * noOfAdultTickets);
		double totalPriceBeforeTax = grossPriceForAdults;
		double tax = 0.15 * totalPriceBeforeTax;
		double netPriceForBookedTrip = totalPriceBeforeTax + tax;
		netPriceForBookedTrip = Math.round(netPriceForBookedTrip * 100.0) / 100.0;
		System.out.println(selectedCruise.getCruiseName() + "-" + noOfAdultTickets + " Adults                   :$"
				+ grossPriceForAdults);
		System.out.println("Total Price                              :$" + totalPriceBeforeTax);
		System.out.println("HST    @    15%                          :$" + tax);
		System.out.println("Net Price for this trip                  :$" + netPriceForBookedTrip);
	}

	// Method#14:Overloaded Order Summary -(Only Adults,Buffet Included)
	public static void checkout(CruiseDetails selectedCruise, int noOfAdultTickets, boolean isFoodPrebooked) {
		System.out.println("Your Package Includes:");
		double grossPriceForAdults = (grossPriceForAnAdultTicket(selectedCruise) * noOfAdultTickets);
		double grossPriceForAdultDinner = (grossPriceForAnAdultDinner(selectedCruise) * noOfAdultTickets);
		double totalPriceBeforeTax = grossPriceForAdults + grossPriceForAdultDinner;
		double tax = 0.15 * totalPriceBeforeTax;
		double netPriceForBookedTrip = totalPriceBeforeTax + tax;
		netPriceForBookedTrip = Math.round(netPriceForBookedTrip * 100.0) / 100.0;
		System.out.println(selectedCruise.getCruiseName() + "-" + noOfAdultTickets + " Adults                   :$"
				+ grossPriceForAdults);
		System.out.println(
				"Special Dinner Buffet-" + noOfAdultTickets + "Adults            :$" + grossPriceForAdultDinner);
		System.out.println("Total Price                              :$" + totalPriceBeforeTax);
		System.out.println("HST    @    15%                          :$" + tax);
		System.out.println("Net Price for this trip                  :$" + netPriceForBookedTrip);
	}

	// Method#15:Order Summary -(Adults,Kids,Buffet Not Included)
	public static void checkout(CruiseDetails selectedCruise, int noOfAdultTickets, int noOfChargableKidsTickets) {
		System.out.println("Your Package Includes:");
		double grossPriceForAdults = (grossPriceForAnAdultTicket(selectedCruise) * noOfAdultTickets);
		double grossPriceForKids = (grossPriceForAKidsTicket(selectedCruise) * noOfChargableKidsTickets);
		double totalPriceBeforeTax = grossPriceForAdults + grossPriceForKids;
		double tax = 0.15 * totalPriceBeforeTax;
		double netPriceForBookedTrip = totalPriceBeforeTax + tax;
		netPriceForBookedTrip = Math.round(netPriceForBookedTrip * 100.0) / 100.0;
		System.out.println(selectedCruise.getCruiseName() + "-" + noOfAdultTickets + " Adults                   :$"
				+ grossPriceForAdults);
		System.out.println(selectedCruise.getCruiseName() + "-" + noOfChargableKidsTickets
				+ " Kids(above age 5)        :$" + grossPriceForKids);
		System.out.println("Total Price                              :$" + totalPriceBeforeTax);
		System.out.println("HST    @    15%                          :$" + tax);
		System.out.println("Net Price for this trip                  :$" + netPriceForBookedTrip);
	}

	// Method#16:Overloaded Order Summary -(Adults,Kids,Buffet Included)
	public static void checkout(CruiseDetails selectedCruise, int noOfAdultTickets, int noOfChargableKidsTickets,
			boolean isFoodPrebooked) {
		System.out.println("Your Package Includes:");
		double grossPriceForAdults = (grossPriceForAnAdultTicket(selectedCruise) * noOfAdultTickets);
		double grossPriceForKids = (grossPriceForAKidsTicket(selectedCruise) * noOfChargableKidsTickets);
		double grossPriceForAdultDinner = (grossPriceForAnAdultDinner(selectedCruise) * noOfAdultTickets);
		double grossPriceForKidsDinner = (grossPriceForAKidsDinner(selectedCruise) * noOfChargableKidsTickets);
		double totalPriceBeforeTax = grossPriceForAdults + grossPriceForKids + grossPriceForAdultDinner
				+ grossPriceForKidsDinner;
		double tax = 0.15 * totalPriceBeforeTax;
		double netPriceForBookedTrip = totalPriceBeforeTax + tax;
		netPriceForBookedTrip = Math.round(netPriceForBookedTrip * 100.0) / 100.0;
		System.out.println(selectedCruise.getCruiseName() + "-" + noOfAdultTickets + " Adults                   :$"
				+ grossPriceForAdults);
		System.out.println(selectedCruise.getCruiseName() + "-" + noOfChargableKidsTickets
				+ " Kids(above age 5)        :$" + grossPriceForKids);
		System.out.println(
				"Special Dinner Buffet-" + noOfAdultTickets + "Adults            :$" + grossPriceForAdultDinner);
		System.out.println(
				"Special Dinner Buffet-" + noOfChargableKidsTickets + "Kids(above age 5) :$" + grossPriceForKidsDinner);
		System.out.println("Total Price                              :$" + totalPriceBeforeTax);
		System.out.println("HST    @    15%                          :$" + tax);
		System.out.println("Net Price for this trip                  :$" + netPriceForBookedTrip);
	}

	// Method#17:Book Cruise for Adults only.
	public void bookCruise(int noOfAdults, CruiseDetails selectedCruise) {
		boolean isFoodPrebooked = bookFood();
		if (isFoodPrebooked == true) {
			CruiseOperations.checkout(selectedCruise, noOfAdults, isFoodPrebooked);
		} else {
			CruiseOperations.checkout(selectedCruise, noOfAdults);
		}
	}
	
	//Method#18:Overloaded Book Cruise for Adults & Kids.
	public void bookCruise(int noOfAdults,int noOfKids, CruiseDetails selectedCruise) {
		int kidsAge[] = getKidsAge(noOfKids);
		var noOfChargableKidsTickets = calculateNoOfChargableKidsTickets(kidsAge);
		boolean isFoodPrebooked = bookFood();
		if (isFoodPrebooked == true && noOfChargableKidsTickets>0) {
			CruiseOperations.checkout(selectedCruise, noOfAdults, noOfChargableKidsTickets, isFoodPrebooked);
		}else if(isFoodPrebooked == true && noOfChargableKidsTickets==0) {
			CruiseOperations.checkout(selectedCruise, noOfAdults, isFoodPrebooked);
		}
		else {
			CruiseOperations.checkout(selectedCruise, noOfAdults, noOfChargableKidsTickets);
		}
	}
		
}
