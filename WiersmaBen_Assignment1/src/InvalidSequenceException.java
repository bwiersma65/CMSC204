/**
 * Invalid Sequence Exception
 * Thrown if password has three or more identical characters in sequence
 * @author benwiersma
 *
 */
public class InvalidSequenceException extends Exception{

	public InvalidSequenceException()
	{
		super("The password cannot contain more than two of the same character in sequence");
	}
	
}
