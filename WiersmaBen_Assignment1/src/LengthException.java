/**
 * Length Exception
 * Thrown if password is less than 6 characters long
 * @author benwiersma
 *
 */
public class LengthException extends Exception {

	public LengthException()
	{
		super("The password must be at least 6 characters long");
	}
	
}
