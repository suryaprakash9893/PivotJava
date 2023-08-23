package javaPracticals;

public class SwapTwoNumbers {

	public static void main(String[] args) {
		int a=482,b=87256;
		
		System.out.println("Numbers before swapping are " + a + " " + b);
		
		/* Logic1 - Using 3 variables.
		int t=a;
		a=b;
		b=t;
		System.out.println("Numbers after swapping are " + a + " " + b);
		
		// Logic2 - Using 2 variables a,b.
		a=a+b;
		b=a-b;
		a=a-b;
		System.out.println("Numbers after swapping are " + a + " " + b);
		
		//Logic3 - Using 2 variables a,b. * && / operators.
		a=a*b;
		b=a/b;
		a=a/b;
		System.out.println("Numbers after swapping are " + a + " " + b);
		
		//Logic4 - Using caret bitwise operator.^
		a=a^b;
		b=a^b;
		a=a^b;
		System.out.println("Numbers after swapping are " + a + " " + b);*/
		
		//Logic5 - Using a single line algorithm.
		b=(a+b)-(a=b);
		System.out.println("Numbers after swapping are " + a + " " + b);
	}

}
