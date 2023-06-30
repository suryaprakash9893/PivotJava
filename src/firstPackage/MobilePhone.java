package firstPackage;

public class MobilePhone {

	String brandname,modelnumber;
	double screensizeininches;
	int capacity;
	String operatingsystem;
	boolean iscamerapresent;
	
	void makeCalls() {
		System.out.println("Making calls from "+brandname+modelnumber);
	}
	void sendTextMessage() {
		System.out.println("Sent text message using "+brandname+"device.");
	}
	void takePicturues() {
		System.out.println("Taking picture using "+brandname+" camera");
	}
}



