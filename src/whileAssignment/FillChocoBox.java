package whileAssignment;

public class FillChocoBox {
	
	int currentNumberOfChoco,boxCapacity,chocoCount;
	
	void addChocolatesToChocoBox() {
		while (currentNumberOfChoco<=boxCapacity) {
			currentNumberOfChoco+=chocoCount;
			
			if (currentNumberOfChoco>boxCapacity) {
				System.out.println("Box capacity is "+boxCapacity +" Chocolates.Can't add 5 more chocolates.");
				break;
			}
			System.out.println("Added "+ chocoCount + " more chocolates. Choco box now has "+currentNumberOfChoco+" chocolates.");
		}
	}
}
