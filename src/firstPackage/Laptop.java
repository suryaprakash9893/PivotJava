package firstPackage;

public class Laptop extends Device {
	String brandname,operatingsystem;
	double screensize;
	boolean isGPUpresent;
	
	void runApplications() {
		System.out.println("Running desktop application on "+operatingsystem+" in a "+screensize+"inches screen");
	}
	void storeFiles() {
		System.out.println("Store pictures and documents transfered to "+brandname+" laptop device.");
	}

}
