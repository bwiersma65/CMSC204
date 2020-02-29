
/**
 * Class representing Volunteer giving out donations
 * @author benwiersma
 *
 */
public class Volunteer {

	private String name;
	
	/**
	 * default constructor
	 */
	public Volunteer() {
		name = "";
	}
	
	/**
	 * parameterized constructor
	 * @param name of volunteer
	 */
	public Volunteer(String name) {
		this.name = name;
	}

	/**
	 * copy constructor
	 * @param v volunteer to be copied
	 */
	public Volunteer(Volunteer v) {
		this.name = v.name;
	}
	
	/**
	 * retriever method for name field
	 * @return name of volunteer
	 */
	public String getName() {
		return name;
	}

	/**
	 * mutator method for name field
	 * @param name of the volunteer
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * generates String representation of volunteer
	 * @return name of volunteer
	 */
	public String toString() {
		return name;
	}
}
