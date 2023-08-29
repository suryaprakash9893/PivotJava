package cruiseBookingWithLogin;

import java.util.Scanner;

public class User {
	private String nameOfUser;
	private long phoneNoOfUser;
	private String email;
	private String password;

	Scanner sc = new Scanner(System.in);

	public User() {
	}

	private User(String email, String password, String nameOfUser, long phoneNoOfUser) {
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

	public long getPhoneNoOfUser() {
		return phoneNoOfUser;
	}

	public long setPhoneNoOfUser() {
		System.out.println("Enter your phone#:");
		// handle Input mis-match exception using try catch
		return phoneNoOfUser = sc.nextLong();
	}

	public String getEmail() {
		return email;
	}

	public String setEmail() {
		System.out.println("Enter your email address:");
		return email = sc.next();
	}

	public String getPassword() {
		return password;
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
		System.out.println("Please enter the information you want to change.");
		System.out.println("1.Password" + "\n" + "2.Phone number" + "\n" + "3.Email");
		String enteredOption = sc.next();
		switch (enteredOption) {
		case "1":
			user.password = setPassword();
			break;
		case "2":
			user.phoneNoOfUser = setPhoneNoOfUser();
			break;
		case "3":
			user.email = setEmail();
			break;
		default:
			System.out.println("Enter a valid selection");
			break;
		}
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

}
