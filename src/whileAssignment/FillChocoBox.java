package whileAssignment;

public class FillChocoBox {
	
	int currentNumberOfChoco;
	
	void measureChocoBox() {
		while (currentNumberOfChoco<=63) {
			currentNumberOfChoco+=5;
			
			if (currentNumberOfChoco>63) {
				System.out.println("Box capacity is 63 chocolates. Can't add 5 more chocolates.");
				break;
			}
			System.out.println("Added 5 more chocolate. Choco box now has "+currentNumberOfChoco+" chocolates.");
		}
	}
}
