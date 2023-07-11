package whileAssignment;

import java.util.Scanner;

public class LoginValidation {
	String savedUser = "pivotAdmin";
	String savedPass = "Admin123";
	String userName, password;
	int attempt = 1;
	Scanner login = new Scanner(System.in);

	void validateLoginCredentials() {
		while (attempt < 4) {

			System.out.println("Login attempt number:" + attempt);

			System.out.println("Enter your Username:");
			userName = login.next();

			System.out.println("Enter your Password:");
			password = login.next();

			if (userName.equals(savedUser) && password.equals(savedPass)) {
				System.out.println("You are logged in to the application");
				break;

			} else {

				attempt += 1;
				if (attempt == 4) {
					System.out.println("Account Locked");
					break;
				}
				System.out.println("Incorrect User id or password. Try again");

			}
		}
	}
}
