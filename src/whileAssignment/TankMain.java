package whileAssignment;

import java.util.Scanner;

public class TankMain {

	public static void main(String[] args) {
//Instantiating a class. or create an object "FillLevel"

		FillTank fillLevel = new FillTank();
		Scanner waterlevel = new Scanner(System.in);

		System.out.println("Enter current water level=");
		fillLevel.currentTankCapacity = waterlevel.nextDouble();
		fillLevel.measureTank();
	}

}
