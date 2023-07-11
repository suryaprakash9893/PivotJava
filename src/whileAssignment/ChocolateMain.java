package whileAssignment;

import java.util.Scanner;

public class ChocolateMain {

	public static void main(String[] args) {
//Instantiating a class. Create an object "FillBox"
		
		FillChocoBox fillBox = new FillChocoBox();
		Scanner choco = new Scanner(System.in);
		
		System.out.println("Enter Total Chocolate Box capacity=");
		fillBox.boxCapacity=choco.nextInt();
		
		System.out.println("Enter current # of chocolates in the box=");
		fillBox.currentNumberOfChoco=choco.nextInt();
		
		System.out.println("Enter Choco count=");
		fillBox.chocoCount=choco.nextInt();
		
		System.out.println("Chocolate box has "+fillBox.currentNumberOfChoco+" chocolates at present.");
		
		fillBox.addChocolatesToChocoBox();

	}

}
