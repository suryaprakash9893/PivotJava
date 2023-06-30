package arithmeticPackage;

public class ArithmeticMain {

	public static void main(String[] args) {
	//Instantiating a class
	ArithmeticOperators basic = new ArithmeticOperators();
	//Assigning values to the variable for the object "basic".
	basic.num1= 5.35;
	basic.num2= 2.5;
	
	//calling a function or Invoking a method
	basic.addTwoNumbers();
	basic.subtractTwoNumbers();
	basic.multiplyTwoNumbers();
	
	basic.num1=75;
	basic.num2=4;			
	basic.divideTwoNumbers();
	
	System.out.println("*****Reassigning values to variable for object \"basic\".*****");
	//Reassigning values to variable for object "basic".
	basic.num1= 9;
	basic.num2= 3;
	
	//calling a function or Invoking a method
	basic.subtractTwoNumbers();
	basic.divideTwoNumbers();
	
	//Dividing using int variables
	basic.dividend=75;
	basic.divisor=4;
	basic.divideTwoIntNumbers();
	
	System.out.println("-------------------------------------------------------------------------");
	
	basic.age=30;
	basic.n=10;
	
	basic.ageAfterNYears();
	basic.ageBeforeNYears();
	
	//Reassigning the values for age,n.
	basic.age=30;
	basic.n=10;
	
	//Invoking a method
	basic.ageBeforeNYears();
	basic.ageAfterNYears();
	
	System.out.println("-------------------------------------------------------------------------");
	
	//Instantiating a class
	ArithmeticOperators ao	= new ArithmeticOperators();
	
	ao.num1=30;
	ao.n=5;
	
	System.out.println("num1="+ao.num1);
	ao.productOfProduct();
	ao.productOfN();
	
	System.out.println("-------------------------------------------------------------------------");

	ao.n=2;
	ao.quotient=5;
	ao.reminder=5;
	
	System.out.println("quotient="+ao.quotient+"  n="+ao.n);
	ao.quotientOfQuotientByN();
	ao.reminderOfReminderByN();
 }
			
}
