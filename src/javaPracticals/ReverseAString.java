package javaPracticals;

public class ReverseAString {

	public static void main(String[] args) {

		String str = "brita";
		String rev = "";

		/*
		 * Logic1- Using Concatenate operator. for(int i=4;i>=0;i--) {
		 * rev=rev+str.charAt(i); } System.out.println(rev);
		 */

		// Logic2- Using String Builder
		/*
		 * StringBuilder str1= new StringBuilder("geeks"); System.out.println(str1); var
		 * reverse=str1.reverse(); System.out.println(reverse);
		 */

		// Logic3-Using String Buffer
		StringBuffer str1 = new StringBuffer("geeks");
		str1.append(" goppa");
		System.out.println(str1);
		str1.reverse();
		System.out.println(str1);
	}

}
