/**
 * Class to represent a package meant for donation
 * @author benwiersma
 */
public class DonationPackage {

	private String description;
	private double weight;
	
	/**
	 * Default DonationPackage constructor
	 */
	public DonationPackage() {
		description = "";
			weight = 0.0;
	}
	
	/**
	 * Parameterized DonationPackage constructor
	 * @param description description of donation
	 * @param weight weight of donation
	 */
	public DonationPackage(String description, double weight) {
		this.description = description;
		this.weight = weight;
	}
	
	/**
	 * Copy DonationPackage constructor
	 * @param d DonationPackage to be copied
	 */
	public DonationPackage(DonationPackage d) {
		this.description = d.description;
		this.weight = d.weight;
	}
	
	/**
	 * Mutator method for description field
	 * @param description description of donation
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Retriever method for description field
	 * @return description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Mutator method for weight field
	 * @param weight weight of donation
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	/**
	 * Retriever method for weight field
	 * @return weight
	 */
	public double getWeight() {
		return weight;
	}
	
	/**
	 * Determines if package is too heavy for donation
	 * @return true if package weights more than 20, false if package weighs less
	 */
	public boolean isHeavy() {
		if (weight > 20.0)
			return true;
		else
			return false;
	}
	
	/**
	 * Provides String representation of package
	 * @return description and weight as a String
	 */
	public String toString() {
		return description + "(" + weight + ")";
	}
}
