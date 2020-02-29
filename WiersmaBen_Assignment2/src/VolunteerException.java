
/**
 *If the user attempts to add new Volunteer and the volunteer line is full, throw VolunteerException(“Volunteer Queue is full”).  
 *If user attempts to remove a Volunteer and the line is empty, throw VolunteerException(“Volunteer Queue is empty”); 
 * @author benwiersma
 */
public class VolunteerException extends RuntimeException{

	/**
	 * Default constructor
	 */
	public VolunteerException() {};
	
	/**
	 * Constructor sending message to super-constructor
	 * @param message exception message to be shown in event of exception
	 */
	VolunteerException(String message) {
		super(message);
	}
}
