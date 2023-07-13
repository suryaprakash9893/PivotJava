package switchFunction;

import java.util.Scanner;

public class CalculatorOperations {

	int num1, num2, total, difference, product, quotient, reminder;
	String operationRequested;

	Scanner calc = new Scanner(System.in);

	void simpleCalculator() {

		String continueCalculation = "Y";
		while (continueCalculation.equalsIgnoreCase("Y")) {

			System.out.println("Enter num1:");
			num1 = calc.nextInt();

			System.out.println("Enter num2:");
			num2 = calc.nextInt();

			System.out.println("Enter the arithmetic opertaion to be performed:");
			operationRequested = calc.next();

			switch (operationRequested) {

			case "+":
				addTwoNumbers();
				break;

			case "-":
				subtractTwoNumbers();
				break;

			case "*":
				multiplyTwoNumbers();
				break;

			case "/":
				divideTwoNumbers();
				break;

			}

			System.out.println("Do you want to perform another calculation?(Y/N)");
			continueCalculation = calc.next();
		}
	}

	void addTwoNumbers() {
		total = num1 + num2;
		System.out.println("The sum of " + num1 + " and " + num2 + " is " + total);
	}

	void subtractTwoNumbers() {
		difference = num1 - num2;
		System.out.println("The difference between " + num1 + " and " + num2 + " is " + difference);
	}

	void multiplyTwoNumbers() {
		product = num1 * num2;
		System.out.println("The product of " + num1 + " and " + num2 + " is " + product);
	}

	void divideTwoNumbers() {
		quotient = num1 / num2;
		reminder = num1 % num2;
		if (reminder > 0) {
			System.out.println(num1 + "is Not directly divisble by " + num2);
		} else {
			System.out.println(num1 + "is directly divisble by " + num2);
		}
		System.out.println("The quotient of " + num1 + " and " + num2 + " is " + quotient);
		System.out.println("The reminder of " + num1 + " and " + num2 + " is " + reminder);
	}

}
