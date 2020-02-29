/**
 *If the user attempts to add new Recipient and the recipient line is full, throw RecipientException(“Recipient Queue is full”).  
 *If user attempts to remove a recipient and the recipient is empty, throw RecipientException(“Recipient Queue is empty”); 
 * @author benwiersma
 */
public class RecipientException extends RuntimeException {

	/**
	 * Default constructor
	 */
	public RecipientException() {};
	
	/**
	 * Constructor sending message to super-constructor
	 * @param message exception message to be shown in event of exception
	 */
	RecipientException(String message) {
		super(message);
	}
	
}
