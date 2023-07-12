package whileAssignment;

import java.util.Scanner;

public class FillTank {
	double currentTankLevel,maxFillCapacity,fillRate,maxTankCapacity;
	Scanner water = new Scanner(System.in);

	void measureTank() {
		System.out.println("Enter Max Tank capacity=");
		maxTankCapacity=water.nextDouble();
		
		System.out.println("Enter Max Fill capacity=");
		maxFillCapacity=water.nextDouble();
		
		if (maxFillCapacity < maxTankCapacity) {
			
			System.out.println("Enter Fill Rate=");
			fillRate=water.nextDouble();

			System.out.println("Enter current water level=");
			currentTankLevel = water.nextDouble();
			
		while (currentTankLevel <= maxFillCapacity) {

			currentTankLevel += fillRate;

			if (currentTankLevel > maxFillCapacity) {
				System.out.println("Can't add"+fillRate+ " L of water.Reached maximum tank capacity.");
				break;
			}
			System.out.println("Added "+fillRate+" L water from bucket.Current waterlevel in the tank is " + currentTankLevel + "L");
		}
	}else {
		System.out.println("Safety level should be less than the Max capacity");
	}
}
}