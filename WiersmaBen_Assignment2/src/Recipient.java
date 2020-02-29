
/**
 * Class representing Recipient of donation
 * @author benwiersma
 *
 */
public class Recipient {

	private String name;
	
	/**
	 * default constructor
	 */
	public Recipient() {
		name = "";
	}
	
	/**
	 * parameterized constructor
	 * @param name name of the recipient
	 */
	public Recipient(String name) {
		this.name = name;
	}

	/**
	 * copy constructor
	 * @param r recipient to be copied
	 */
	public Recipient(Recipient r) {
		this.name = r.name;
	}
	
	/**
	 * retriever method for name field
	 * @return name of the recipient
	 */
	public String getName() {
		return name;
	}

	/**
	 * mutator method for name field
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * generates String representation of Recipient's name
	 * @return Recipient name
	 */
	public String toString() {
		return name;
	}
}
