/**
 * No Lower Alpha Exception
 * Thrown if password does not contain any lowercase alphabetic characters
 * @author benwiersma
 *
 */
public class NoLowerAlphaException extends Exception {

	public NoLowerAlphaException()
	{
		super("The password must contain at least one lowercase alphabetic character");
	}
	
}
