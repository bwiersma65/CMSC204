/**
 * No Digit Exception
 * Thrown if password does not contain any digit characters
 * @author benwiersma
 *
 */
public class NoDigitException extends Exception {

	public NoDigitException()
	{
		super("The password must contain at least one digit character");
	}
	
}
