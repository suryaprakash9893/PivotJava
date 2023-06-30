package firstPackage;

public class Device {

	public static void main(String[] args) {
		MobilePhone iPhone = new MobilePhone();
		iPhone.brandname="iPhone";
		iPhone.capacity=256;
		iPhone.iscamerapresent=true;
		iPhone.modelnumber= "12";
		iPhone.operatingsystem="iOS";
		iPhone.screensizeininches=6.1;
		
		MobilePhone samsung = new MobilePhone();
		samsung.brandname="samsung";
		samsung.capacity=256;
		samsung.iscamerapresent=true;
		samsung.modelnumber = "S22";
		samsung.operatingsystem="Android";
		iPhone.makeCalls();
		samsung.sendTextMessage();
		iPhone.takePicturues();
		samsung.takePicturues();
		System.out.println("----------------------------------------------");
		
		Laptop apple = new Laptop();
		apple.brandname="Apple";
		apple.isGPUpresent=false;
		apple.operatingsystem="mac OS";
		apple.screensize=15;
		
		//Instantiating a class or creating an object or creating an instance of the class "Laptop".
		Laptop hp = new Laptop();

		//Assigning values to variables.
		hp.brandname="hp";
		hp.isGPUpresent=true;
		hp.operatingsystem="windows 11";
		hp.screensize=14.5;
		
		Laptop ASUS = new Laptop();
		ASUS.brandname="ASUS";
		ASUS.isGPUpresent=true;
		ASUS.operatingsystem="Ubuntu";
		ASUS.screensize=11.5;
		
		//Invoking a method
		apple.storeFiles();
		apple.runApplications();
		hp.storeFiles();
		hp.runApplications();
		ASUS.runApplications();
		ASUS.storeFiles();
	
	}

}
