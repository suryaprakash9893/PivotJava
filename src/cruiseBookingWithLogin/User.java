package cruiseBookingWithLogin;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
	private String nameOfUser;
	private String phoneNoOfUser;
	private String email;
	private String password;

	Scanner sc = new Scanner(System.in);

	public User() {
	}

	private User(String email, String password, String nameOfUser, String phoneNoOfUser) {
		this.email = email;
		this.password = password;
		this.nameOfUser = nameOfUser;
		this.phoneNoOfUser = phoneNoOfUser;
	}

	public String getNameOfUser() {
		return nameOfUser;
	}

	public String setNameOfUser() {
		System.out.println("Enter your Full name:");
		return nameOfUser = sc.next();
	}

	public String getPhoneNoOfUser() {
		return phoneNoOfUser;
	}

	public String setPhoneNoOfUser() {
		// To avoid Input mis-match exception used String for input. try catch to avoid
		// number format.
		System.out.println("Enter your Phone#");
		return phoneNoOfUser = sc.next();
	}
//		while (phoneNoOfUser.equalsIgnoreCase("0")) {
//			System.out.println("Enter your phone#:");
//			phoneNoOfUser = sc.next();
//			var validPhoneNo = validatePhoneNo(phoneNoOfUser);
//			if (validPhoneNo == false) {
//				System.out.println("Invalid Phone #.Try again!");
//				phoneNoOfUser = "";
//			}else if(validPhoneNo == true) {
//				return phoneNoOfUser;
//			}
//		}

	public boolean validatePhoneNo(String phoneNoOfUser) {
		String regex = "[0-9]+";
		Pattern p = Pattern.compile(regex);
		if(phoneNoOfUser==null) {
			return false;
		}
		Matcher m = p.matcher(phoneNoOfUser);
		return m.matches();
	}

	public String getEmail() {
		return email;
	}

	public String setEmail() {
		System.out.println("Enter your email address:");
		return email = sc.next();
	}

	public String setPassword() {
		System.out.println("Enter the password you want to use:");
		return password = sc.next();
	}

	public User getUserDetails() {
		setEmail();
		setPassword();
		setNameOfUser();
		setPhoneNoOfUser();
		User user = new User(email, password, nameOfUser, phoneNoOfUser);
		System.out.println("Thanks for registering!");
		return user;
	}

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

	public void displayUserDetails(User user) {
		System.out.println("----------------User Details----------------");
		System.out.println("Name: " + user.nameOfUser);
		System.out.println("email: " + user.email);
		System.out.println("Phone#: " + user.phoneNoOfUser);
		System.out.println("---------------------------------------------------");
	}

}
