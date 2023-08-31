package cruiseAndHotelBooking;

public class HotelStay extends User {
	private String roomType;
	private int rentPerDay;
	public User user;
	private int maxAudltsInARoom, maxKidsInARoom;

	//Constructor#1:
	public HotelStay() {
	}

	//Constructor#2:
	public HotelStay(String roomType, int rentPerDay, int maxAudltsInARoom, int maxKidsInARoom, User user) {
		this.roomType = roomType;
		this.rentPerDay = rentPerDay;
		this.maxAudltsInARoom = maxAudltsInARoom;
		this.maxKidsInARoom = maxKidsInARoom;
		this.user = user;
	}
	
	//Method#1:To get the # of Adults for the Hotel room.
	public int noOfAdultsForHotelStay(HotelStay hotel) {
		boolean canBookHotelStay = false;
		int noOfAdultsForHotelRoom = 0;
		while (canBookHotelStay == false) {
			noOfAdultsForHotelRoom = getnoOfAdultsForTheSelectedCruise();
			if (noOfAdultsForHotelRoom <= hotel.maxAudltsInARoom) {
				canBookHotelStay = true;
				return noOfAdultsForHotelRoom;
			} else {
				System.out.println("--------------" + hotel.roomType + " Max occupancy--------------");
				System.out.println("Adutls-" + hotel.maxAudltsInARoom + "\n" + "Kids-" + hotel.maxKidsInARoom);
				System.out.println("Please book a seperate room if you have more guests than the Max occupancy of the "
						+ hotel.roomType);
			}
		}
		return noOfAdultsForHotelRoom;
	}

	//Method#2:To get the # of Kids for the Hotel room.
	public int noOfKidsForHotelStay(HotelStay hotel) {
		boolean canBookHotelStay = false;
		int noOfKidsForHotelStay = 0;
		while (canBookHotelStay == false) {
			System.out.println("Enter the number of Kids:");
			noOfKidsForHotelStay = sc.nextInt();
			if (noOfKidsForHotelStay <= hotel.maxAudltsInARoom) {
				if (noOfKidsForHotelStay <= hotel.maxAudltsInARoom) {
					noOfKidsForHotelStay = calculateNoOfChargableKidsTickets(getKidsAge(noOfKidsForHotelStay));
					canBookHotelStay = true;
				}
			} else {
				System.out.println("--------------" + hotel.roomType + " Max occupancy--------------");
				System.out.println("Adutls-" + hotel.maxAudltsInARoom + "\n" + "Kids-" + hotel.maxKidsInARoom);
				System.out.println("Please book a seperate room if you have more guests than the Max occupancy of the "
						+ hotel.roomType);
			}
		}
		return noOfKidsForHotelStay;
	}

	//Method#3:To check if pre-booking lunch is required or not. 
	public boolean preBookLunchAtHotel() {
		boolean preBookLunchAtHotel = false;
		System.out.println(
				"All rooms come with free breakfast. Do you want to add lunch in your room as well at a discounted pre-booking rate of $25/ adult and $5/ child.");
		System.out.println("Press Y to confirm or press any other key to skip pre-booking food on board");
		String optionSelected = sc.next();
		if (optionSelected.equalsIgnoreCase("Y")) {
			preBookLunchAtHotel = true;
		} else {
			System.out.println("Skipped Pre-booking for Lunch at Hotel...");
		}
		return preBookLunchAtHotel;
	}

	//Method#4To print Order summary.(Checkout)
	public void checkoutHotelRoom(HotelStay hotel,int noOfAdultsForHotelStay,int noOfKidsForHotelStay, boolean preBookLunchAtHotel) {
		System.out.println("Enter the number of days of Stay:");
		int noOfDaysStay = sc.nextInt();
		System.out.println("Your Package Includes:");
		double grossPriceForRooms = (hotel.rentPerDay * noOfDaysStay);
		double grossPriceForAdultLunchAtHotel = (noOfAdultsForHotelStay * 25);
		double grossPriceForKidsLunchAtHotel = (noOfAdultsForHotelStay * 5);
		System.out.println(hotel.roomType + " @ " + noOfDaysStay + "                   : $" + grossPriceForRooms);
		if (preBookLunchAtHotel == true) {
			System.out.println(
					"Lunch Pre-Booked Adults-" + noOfAdultsForHotelStay + ": $" + grossPriceForAdultLunchAtHotel);
			if (noOfKidsForHotelStay > 0) {
				System.out.println(
						"Lunch Pre-Booked Kids-" + noOfAdultsForHotelStay + ": $" + grossPriceForAdultLunchAtHotel);
			}
		}
		double totalPriceBeforeTax = grossPriceForRooms + grossPriceForAdultLunchAtHotel + grossPriceForKidsLunchAtHotel
				+ grossPriceForKidsLunchAtHotel;
		double tax = 0.18 * totalPriceBeforeTax;
		double netPriceForBookedTrip = totalPriceBeforeTax + tax;
		netPriceForBookedTrip = Math.round(netPriceForBookedTrip * 100.0) / 100.0;
		System.out.println("Total Price                              :$" + totalPriceBeforeTax);
		System.out.println("HST    @    18%                          :$" + tax);
		System.out.println("Net Price for this trip                  :$" + netPriceForBookedTrip);
	}
	
	//Method#5:To book a Hotel Room.Complete process of booking a hotel room & checkout.
	public HotelStay bookHotelRoom(User user) {
		System.out.println("1.Deluxe Suite can accommodate 2 adults and 2 children at the rate of $180/night." + "\n"
				+ "2.Family Suite can accommodate 4 adults and 4 children at $230/ night.");
		HotelStay hotel = null;
		String enteredSelection = "";
		while (enteredSelection.equals("")) {
			System.out.println("Please enter the option of the room type you want to book.");
			enteredSelection = sc.next();
			switch (enteredSelection) {
			case "1":
				hotel = new HotelStay("Deluxe Suite", 180, 2, 2, user);
				checkoutHotelRoom(hotel,noOfAdultsForHotelStay(hotel),noOfKidsForHotelStay(hotel), preBookLunchAtHotel());
				break;
			case "2":
				hotel = new HotelStay("Family Suite",230,4,4,user);
				checkoutHotelRoom(hotel,noOfAdultsForHotelStay(hotel),noOfKidsForHotelStay(hotel), preBookLunchAtHotel());
				break;

			default:
				System.out.println("Invalid selection!Please try again");
				enteredSelection = "";
			}
		}
		return hotel;
	}

}
