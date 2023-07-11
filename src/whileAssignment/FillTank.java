package whileAssignment;

public class FillTank {
	double currentTankLevel,maxFillCapacity,fillRate,maxTankCapacity;

	void measureTank() {
		while (currentTankLevel <= maxFillCapacity) {

			currentTankLevel += fillRate;

			if (currentTankLevel > maxFillCapacity) {
				System.out.println("Can't add"+fillRate+ " L of water.Reached maximum tank capacity.");
				break;
			}
			System.out.println("Added "+fillRate+" L water from bucket.Current waterlevel in the tank is " + currentTankLevel + "L");
		}
	}
}
