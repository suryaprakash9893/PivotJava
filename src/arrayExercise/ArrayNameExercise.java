package arrayExercise;

import java.util.Scanner;

public class ArrayNameExercise {
	
	Scanner input = new Scanner(System.in);
	
	int[]arrayOfNames= new int[5];
	int i;
	String[] drinks=new String[5];
	
	void arrayList() {
		
		System.out.println("Enter array 1");
		arrayOfNames[0]= input.nextInt();
		
		System.out.println("Enter array 2");
		arrayOfNames[1]= input.nextInt();
		
		System.out.println("Enter array 3");
		arrayOfNames[2]= input.nextInt();
		
		System.out.println("Enter array 4");
		arrayOfNames[3]= input.nextInt();
		
		System.out.println("Enter array 5");
		arrayOfNames[4]= input.nextInt();
		
	}
	
	void phoneNumber() {
		while (i<5){
			System.out.println("Enter # to array list");
			arrayOfNames[i]=input.nextInt();
			i++;
		}
	}
	void favDrinks() {
		for(int n=0;n<3;n++) {
			System.out.println("Enter your 3 favourite drinks :");
			drinks[n]= input.next();
		}
	}

}
