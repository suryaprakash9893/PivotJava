package whileAssignment;

public class FillTank {
	double currentTankCapacity;

	void measureTank() {
		while (currentTankCapacity <= 100) {

			currentTankCapacity += 10;

			if (currentTankCapacity > 100) {
				System.out.println("Can't add 10L of water.Reached maximum tank capacity.");
				break;
			}
			System.out.println("Added 10L water from bucket.Current waterlevel in the tank is " + currentTankCapacity + "L");
		}
	}
}
