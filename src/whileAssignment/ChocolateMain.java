package whileAssignment;

public class ChocolateMain {

	public static void main(String[] args) {
//Instantiating a class. Create an object "FillBox"
		
		FillChocoBox fillBox = new FillChocoBox();
		
		fillBox.currentNumberOfChoco=27;
		System.out.println("Chocolate box has 27 chocolates at present.");
		
		fillBox.measureChocoBox();

	}

}
