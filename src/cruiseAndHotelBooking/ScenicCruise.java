package cruiseAndHotelBooking;

public class ScenicCruise extends Cruise {
	/*
	 * private static String cruiseName="ScenicCruise"; private static double
	 * priceForAnAdultPerDay=43.99; private static double priceForAKidPerDay=12.99;
	 * private static int noOfDays=3;
	 */

	public ScenicCruise(User user, String cruiseName, double priceForAdults, double priceForChildren, int noOfDays) {
		super(user, "ScenicCruise", 43.99, 12.99, 3);
	}

	// Method#1:To book a Spa @ Scenic Cruise
	public int bookSpaAtScenicCruise(Cruise selectedCruise,int noOfAdultTickets, int noOfChargableKidsTickets) {
		System.out.println("Scenic Cruise has a Spa for which the user will be charged $50 per person");
		int totalNoOfTicketsChargable = noOfAdultTickets+noOfChargableKidsTickets;
			System.out.println("Press Y to confirm or press any other key to skip pre-booking Spa");
			String optionSelected = sc.next();
		if (optionSelected.equalsIgnoreCase("Y")) {
			return totalNoOfTicketsChargable;
		} else {
			System.out.println("Skipped Pre-booking for Spa at Scenic Cruise");
			return 0;
		}
	}

	// Method#2To Print order summary for Scenic cruise.
	public void checkoutScenicCruise(Cruise selectedCruise, int noOfAdultTickets, int noOfChargableKidsTickets,
			boolean isFoodPrebooked, int noOfSpaTickets) {
		System.out.println("Your Package Includes:");
		double grossPriceForAdultsTickets = (grossPriceForAnAdultTicket(selectedCruise) * noOfAdultTickets);
		double grossPriceForKidsTickets = (grossPriceForAKidsTicket(selectedCruise) * noOfChargableKidsTickets);
		double grossPriceForAdultDinner = (grossPriceForAnAdultDinner(selectedCruise) * noOfAdultTickets);
		double grossPriceForKidsDinner = (grossPriceForAKidsDinner(selectedCruise) * noOfChargableKidsTickets);
		double grossPriceForSpa = (noOfSpaTickets * 50);
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
		if (noOfSpaTickets > 0) {
			System.out.println(
					selectedCruise.getCruiseName() + " Spa -" + noOfSpaTickets + "         :$" + grossPriceForSpa);
		}
		double totalPriceBeforeTax = grossPriceForAdultsTickets + grossPriceForKidsTickets + grossPriceForAdultDinner
				+ grossPriceForKidsDinner + grossPriceForSpa;
		double tax = 0.15 * totalPriceBeforeTax;
		double netPriceForBookedTrip = totalPriceBeforeTax + tax;
		netPriceForBookedTrip = Math.round(netPriceForBookedTrip * 100.0) / 100.0;
		System.out.println("Total Price                              :$" + totalPriceBeforeTax);
		System.out.println("HST    @    15%                          :$" + tax);
		System.out.println("Net Price for this trip                  :$" + netPriceForBookedTrip);
	}
}
