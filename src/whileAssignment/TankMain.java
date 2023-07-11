package whileAssignment;

import java.util.Scanner;

public class TankMain {

	public static void main(String[] args) {
//Instantiating a class. or create an object "FillLevel"

		FillTank fillLevel = new FillTank();
		Scanner waterlevel = new Scanner(System.in);
		
		System.out.println("Enter Max Tank capacity=");
		fillLevel.maxTankCapacity=waterlevel.nextDouble();
		
		System.out.println("Enter Max Fill capacity=");
		fillLevel.maxFillCapacity=waterlevel.nextDouble();
		
		System.out.println("Enter Fill Rate=");
		fillLevel.fillRate=waterlevel.nextDouble();

		System.out.println("Enter current water level=");
		fillLevel.currentTankLevel = waterlevel.nextDouble();
		
		
		
		
		fillLevel.measureTank();
	}

}
