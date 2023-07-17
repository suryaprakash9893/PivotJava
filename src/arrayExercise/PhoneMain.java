package arrayExercise;

public class PhoneMain {

	public static void main(String[] args) {
		PhonesList phonesList = new PhonesList();

		phonesList.populatePhoneModels();
		phonesList.displayAvailablePhoneModelsForTheSelectedBrandAndValidateThePhoneModelForTheSelectedBrand();
	}

}
