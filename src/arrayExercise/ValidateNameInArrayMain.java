package arrayExercise;

public class ValidateNameInArrayMain {

	public static void main(String[] args) {

		FindNameInArray arrayIteration = new FindNameInArray();

		arrayIteration.populateNameArray();

		arrayIteration.printNames();
		System.out.println(
				"-----------------------------------------------------------------------------------------------------------");

		arrayIteration.findNameInArray();
		System.out.println(
				"-----------------------------------------------------------------------------------------------------------");
		arrayIteration.countNameInArray();

	}

}
