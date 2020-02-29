
/**
 * If the user attempts to add new package and the container stack is full, throw ContainerException(“Container stack is full”).  
 * If user attempts to remove a package and the stack is empty, throw ContainerException(“Container stack is empty”);
 * @author benwiersma
 */
public class ContainerException extends RuntimeException {

	/**
	 * Default constructor
	 */
	public ContainerException() {};
	
	/**
	 * Constructor sending message to super-constructor
	 * @param message exception message to be shown in event of exception
	 */
	ContainerException(String message) {
		super(message);
	}
}
