package arithmeticPackage;

public class ArithmeticOperators {
	double num1,num2,total,difference,product,quotient,reminder,n;
	int age,dividend,divisor;
		
	void addTwoNumbers() {
		total = num1+num2;
		System.out.println("The sum of "+num1+" and "+num2+" is "+total);
	}
	void subtractTwoNumbers() {
		difference=num1-num2;
		System.out.println("The difference between "+num1+" and "+num2+" is "+difference);
	}
	void multiplyTwoNumbers() {
		product=num1*num2;
		System.out.println("The product of "+num1+" and "+num2+" is "+product);
	}
	void divideTwoNumbers() {
		quotient=num1/num2;
		reminder=num1%num2;
		if(reminder>0) {
					System.out.println(num1+"is Not directly divisble by "+num2);
		}
		else { 
			System.out.println(num1+"is directly divisble by "+num2);
		}
		System.out.println("The quotient of "+num1+" and "+num2+" is "+quotient);
		System.out.println("The reminder of "+num1+" and "+num2+" is "+reminder);
}
	void divideTwoIntNumbers() {
		quotient=dividend/divisor;
		reminder=dividend%divisor;
		System.out.println("The quotient of "+dividend+" and "+divisor+" is "+quotient);
		System.out.println("The reminder of "+dividend+" and "+divisor+" is "+reminder);
	}
	void ageAfterNYears() {
		age+=n;
		System.out.println("Age after "+n+" years is "+age);
	}
	void ageBeforeNYears() {
		age-=n;
		System.out.println("Age before "+n+" years is "+age);
	}
	void productOfProduct() {
		num1*=num1;
		System.out.println("The new num1 is a product of num1 and num1. Answer="+num1);		
	}
	void productOfN() {
		num1*=n;
		System.out.println("This new num1 is a product of num1 and "+n+".Answer="+num1);
	}
	void quotientOfQuotientByN() {
		quotient/=n;
		System.out.println("The new quotient is"+quotient);		
	}
	void reminderOfReminderByN() {
		reminder%=n;
		System.out.println("The new reminder is"+reminder);
	}

}
