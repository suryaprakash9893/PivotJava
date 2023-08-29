package cruiseBookingWithLogin;

public class CruiseDetails {

	private String cruiseName;
	private double priceForAdults;
	private double priceForChildren;
	private int noOfDays;
	
	public CruiseDetails(String cruiseName,double priceForAdults, double priceForChildren, int noOfDays) {
		this.cruiseName=cruiseName;
		this.priceForAdults=priceForAdults;
		this.priceForChildren=priceForChildren;
		this.noOfDays=noOfDays;
	}

	public CruiseDetails() {
	}
	
	public String getCruiseName() {
		return cruiseName;
	}

	public double getPriceForAdults() {
		return priceForAdults;
	}

	public double getPriceForChildren() {
		return priceForChildren;
	}

	public int getNoOfDays() {
		return noOfDays;
	}

}
