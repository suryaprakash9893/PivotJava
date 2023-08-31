package cruiseAndHotelBooking;

import java.util.Scanner;

public class User {
	private String nameOfUser;
	private String phoneNoOfUser;
	private String email;
	private String password;

	Scanner sc = new Scanner(System.in);

// Constructor#1:Non-parameterized constructor.
	public User() {
	}

	// Constructor#2:Parameterized constructor to instantiate the class level
	// variables.
	public User(String nameOfUser, String phoneNoOfUser, String email, String password) {
		this.nameOfUser = nameOfUser;
		this.phoneNoOfUser = phoneNoOfUser;
		this.email = email;
		this.password = password;
	}

	// Method#:To get the name of User.
	public String getNameOfUser() {
		return nameOfUser;
	}

	// Method#:To Set the name of User.
	public String setNameOfUser() {
		System.out.println("Enter your Full name:");
		return nameOfUser = sc.next();
	}

	// Method#:To get the Phone# of the User.
	public String getPhoneNoOfUser() {
		return phoneNoOfUser;
	}

	// Method#:To set the Phone# of the User.
	public String setPhoneNoOfUser() {
		System.out.println("Enter your Phone#");
		return phoneNoOfUser = sc.next();
	}

	// Method#:To get the email of the User.
	public String getEmail() {
		return email;
	}

	// Method#:To set the email of the User.
	public String setEmail() {
		System.out.println("Enter your email address:");
		return email = sc.next();
	}

	// Method#:To set the Password for User login.
	public String setPassword() {
		System.out.println("Enter the password you want to use:");
		return password = sc.next();
	}

	public User setUserDetails(User user) {
		System.out.println("Welcome to Cordella Cruises." + "\n"
				+ "Please sign-up to view & book the services offered by Cordella.");
		user = new User(setNameOfUser(), setPhoneNoOfUser(), setEmail(), setPassword());
		System.out.println("Thanks for registering!");
		return user;
	}

	// Method#:To update the User's personal details.
	public User updateUserDetails(User user) {
		String updatePersonalInfo = "";
		System.out.println("Do you want to update your personal info?Press Y..." + "\n"
				+ "Press any other key to exit the application.");
		updatePersonalInfo = sc.next();
		while (updatePersonalInfo.equalsIgnoreCase("Y")) {
			boolean loginAttempt = user.loginAttempts(user);
			if (loginAttempt == true && updatePersonalInfo.equalsIgnoreCase("Y")) {
				System.out.println("Please enter the option you want to change.");
				System.out.println("1.Password" + "\n" + "2.Phone number" + "\n" + "3.Email");
				String enteredOption = sc.next();
				switch (enteredOption) {
				case "1":
					user.password = setPassword();
					System.out.println("Your Password is Updated successfully.");
					break;
				case "2":
					user.phoneNoOfUser = setPhoneNoOfUser();
					System.out.println("Your Phone# is Updated to " + user.phoneNoOfUser + " successfully.");
					break;
				case "3":
					user.email = setEmail();
					System.out.println("Your email is Updated to " + user.email + " successfully.");
					break;
				default:
					System.out.println("Enter a valid selection");
					break;
				}
			}
			System.out.println("Do you want to make another change to your profile?Press Y..." + "\n"
					+ "Press any other key to exit application.");
			updatePersonalInfo = sc.next();
		}
		System.out.println("Exiting the application.Thanks for choosing Cordella cruises " + user.getNameOfUser());
		return user;
	}

	// Method#:To validate the login credentials.
	public boolean validateLoginCredentials(User user) {
		System.out.println("Please enter your login credentials.");
		boolean loginStatus = false;
		System.out.println("Enter your email:");
		String enteredEmail = sc.next();
		System.out.println("Enter your password:");
		String enteredPassword = sc.next();
		if (user.email.equalsIgnoreCase(enteredEmail) && user.password.equals(enteredPassword)) {
			loginStatus = true;
		} else {
			System.out.println("Wrong Credentials. Try again!");
		}
		return loginStatus;
	}

	// Method#:To validate the login credentials with 3 incorrect attempts.
	public boolean loginAttempts(User user) {
		int loginAttempt = 1;
		boolean loginStatus = false;
		while (loginAttempt < 4) {
			System.out.println("Login attempt number:" + loginAttempt);
			loginStatus = validateLoginCredentials(user);
			if (loginStatus == true) {
				return loginStatus;
			} else if (loginStatus == false && loginAttempt < 4) {
				System.out.println("Incorrect login credentials.");
				loginAttempt++;
			} else if (loginStatus == false && loginAttempt == 4) {
				System.out.println(
						"3 incorrect login attempts. Can't update your personal info without validating your current credentials.");
			}
		}
		return loginStatus;
	}

	// Method#2:To get the # of Adults and validate it for the selected Cruise trip.
	public int getnoOfAdultsForTheSelectedCruise() {
		System.out.println("---------Please read the instructions prior to booking---------");
		System.out.println("Person above 12 years of age is considered an Adult." + "\n"
				+ "Person below 12 years of age is considered as a Kid." + "\n"
				+ "Children below 5 years of age can avail free services at Cordella:)");
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

	// Method#3:To get the # of Kids for the selected Cruise trip.
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
						+ " is not a valid number.Please enter a valid number of Adult tickets required.");
				noOfKidsTickets = "";
			}
		}
		return noOfKids;
	}

	// Method#4:To get the age of kids & validate it.
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
					if (enteredAge <= 11) {
						kidsAge[i] = enteredAge;
						i++;
						noOfKids--;
					} else if (enteredAge >= 12) {
						System.out.println(enteredAge
								+ " years is not a valid age for a kid. Children below 12 years is considered as a kid.Please re-enter the age.");
					}
				} catch (NumberFormatException e) {
					System.out
							.println(enteredAgeOfKid + " is not a valid age.Please enter a valid kid's age(below 12).");
				}
			}
		}
		return kidsAge;
	}

	// Method#5:To calculate the # chargeable Kids Tickets.
	public int calculateNoOfChargableKidsTickets(int[] kidsAge) {
		int noOfChargableKidsTickets = 0;
		for (int i = 0; i < kidsAge.length; i++) {
			if (kidsAge[i] >= 5) {
				noOfChargableKidsTickets++;
			}
		}
		return noOfChargableKidsTickets;
	}

	// Method#To display the User Personal details.
	public void displayUserDetails(User user) {
		System.out.println("----------------User Information----------------");
		System.out.println("Name: " + user.getNameOfUser());
		System.out.println("email: " + user.getEmail());
		System.out.println("Phone#: " + user.phoneNoOfUser);
		System.out.println("---------------------------------------------------");
	}
}
