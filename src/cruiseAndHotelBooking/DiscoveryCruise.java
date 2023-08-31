package cruiseAndHotelBooking;

public class DiscoveryCruise extends Cruise {

	public DiscoveryCruise(User user, String cruiseName, double priceForAdults, double priceForChildren, int noOfDays) {
		super(user, cruiseName, priceForAdults, priceForChildren, noOfDays);
	}

	// Method#1:To book a Adventure games @ Scenic Cruise.
	public int bookSpaAtScenicCruise(Cruise selectedCruise, int noOfAdultTickets, int noOfChargableKidsTickets) {
		System.out.println(
				"Discovery Cruise has an adventure games section for which the user will be charged $50 per person");
		int totalNoOfTicketsChargable = noOfAdultTickets + noOfChargableKidsTickets;
		System.out.println("Press Y to confirm or press any other key to skip pre-booking for adventure games");
		String optionSelected = sc.next();
		if (optionSelected.equalsIgnoreCase("Y")) {
			return totalNoOfTicketsChargable;
		} else {
			System.out.println("Skipped Pre-booking adventure games");
			return 0;
		}
	}

	// Method#2To Print order summary for Scenic cruise.
	public void checkout(Cruise selectedCruise, int noOfAdultTickets, int noOfChargableKidsTickets,
			boolean isFoodPrebooked, int noOfAdventurenGamesTickets) {
		System.out.println("Your Package Includes:");
		double grossPriceForAdultsTickets = (grossPriceForAnAdultTicket(selectedCruise) * noOfAdultTickets);
		double grossPriceForKidsTickets = (grossPriceForAKidsTicket(selectedCruise) * noOfChargableKidsTickets);
		double grossPriceForAdultDinner = (grossPriceForAnAdultDinner(selectedCruise) * noOfAdultTickets);
		double grossPriceForKidsDinner = (grossPriceForAKidsDinner(selectedCruise) * noOfChargableKidsTickets);
		double grossPriceForAdventureGames = (noOfAdventurenGamesTickets * 50);
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
		if (noOfAdventurenGamesTickets > 0) {
			System.out.println(selectedCruise.getCruiseName() + " Adventure games Tickets -"
					+ noOfAdventurenGamesTickets + "         :$" + grossPriceForAdventureGames);
		}
		double totalPriceBeforeTax = grossPriceForAdultsTickets + grossPriceForKidsTickets + grossPriceForAdultDinner
				+ grossPriceForKidsDinner + grossPriceForAdventureGames;
		double tax = 0.15 * totalPriceBeforeTax;
		double netPriceForBookedTrip = totalPriceBeforeTax + tax;
		netPriceForBookedTrip = Math.round(netPriceForBookedTrip * 100.0) / 100.0;
		System.out.println("Total Price                              :$" + totalPriceBeforeTax);
		System.out.println("HST    @    15%                          :$" + tax);
		System.out.println("Net Price for this trip                  :$" + netPriceForBookedTrip);
	}
}
