package cruiseAndHotelBooking;

public class SunsetCruise extends Cruise {

	public SunsetCruise(User user, String cruiseName, double priceForAdults, double priceForChildren, int noOfDays) {
		super(user, cruiseName, priceForAdults, priceForChildren, noOfDays);
	}
//Question-Can we declare the class level variable in the constructor itself?

	// Method#1:To book a candle light dinner.
	public int bookSpaAtScenicCruise(Cruise selectedCruise,int noOfAdultTickets, int noOfChargableKidsTickets) {
		System.out.println("Sunset Cruise has a candle light dinner for which the user will be charged $45 per person");
		int totalNoOfTicketsChargable = noOfAdultTickets+noOfChargableKidsTickets;
			System.out.println("Press Y to confirm or press any other key to skip pre-booking candle light dinner");
			String optionSelected = sc.next();
		if (optionSelected.equalsIgnoreCase("Y")) {
			return totalNoOfTicketsChargable;
		} else {
			System.out.println("Skipped Pre-booking candle light dinner");
			return 0;
		}
	}
	
	// Method#2To Print order summary for Scenic cruise.
		public void checkout(Cruise selectedCruise, int noOfAdultTickets, int noOfChargableKidsTickets,
				boolean isFoodPrebooked, int noOfCandleLightTickets) {
			System.out.println("Your Package Includes:");
			double grossPriceForAdultsTickets = (grossPriceForAnAdultTicket(selectedCruise) * noOfAdultTickets);
			double grossPriceForKidsTickets = (grossPriceForAKidsTicket(selectedCruise) * noOfChargableKidsTickets);
			double grossPriceForAdultDinner = (grossPriceForAnAdultDinner(selectedCruise) * noOfAdultTickets);
			double grossPriceForKidsDinner = (grossPriceForAKidsDinner(selectedCruise) * noOfChargableKidsTickets);
			double grossPriceForCLDinner = (noOfCandleLightTickets * 45);
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
			if (noOfCandleLightTickets > 0) {
				System.out.println(
						selectedCruise.getCruiseName() + " Candle Light Dinner -" + noOfCandleLightTickets + "         :$" + grossPriceForCLDinner);
			}
			double totalPriceBeforeTax = grossPriceForAdultsTickets + grossPriceForKidsTickets + grossPriceForAdultDinner
					+ grossPriceForKidsDinner + grossPriceForCLDinner;
			double tax = 0.15 * totalPriceBeforeTax;
			double netPriceForBookedTrip = totalPriceBeforeTax + tax;
			netPriceForBookedTrip = Math.round(netPriceForBookedTrip * 100.0) / 100.0;
			System.out.println("Total Price                              :$" + totalPriceBeforeTax);
			System.out.println("HST    @    15%                          :$" + tax);
			System.out.println("Net Price for this trip                  :$" + netPriceForBookedTrip);
		}

}
