import java.util.ArrayList;

/**
 * Utility class with methods for checking the validity of passwords
 * 1 - isValidPassword: checks if passed Strings meets five conditions
 * 		* At least 6 characters long
 * 		* At least one digit character
 * 		* At least one uppercase alphabetic character
 * 		* At least one lowercase alphabetic character
 * 		* No more than two of the same character in sequence
 * 2 - isWeakPassword: checks if password is weak (between 6 and 9 characters long inclusive)
 * 					   or strong (longer than 9 characters)
 * 3 - invalidPasswords: returns list of invalid passwords from list of passwords
 * @author benwiersma
 *
 */
public class PasswordCheckerUtility {
	
	/**
	 * no-arg constructor
	 */
	PasswordCheckerUtility() {
	}
	
	/**
	 * isValidPassword method
	 * @param password
	 * @return true if valid password
	 * @throws LengthException
	 * @throws NoUpperAlphaException
	 * @throws NoLowerAlphaException
	 * @throws NoDigitException
	 * @throws InvalidSequenceException
	 */
	public static boolean isValidPassword(String password) throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, InvalidSequenceException
	{
		boolean valid = true;
		///////////////////////////////////////////////////////////////////////////////////////////////////
		//LengthException Test//
		if (password.length() < 6)
		{
			throw new LengthException();
		}
		///////////////////////////////////////////////////////////////////////////////////////////////////
		//NoDigitException Test//
		int digitCounter = 0;
		for (int i = 0; i < password.length(); i++)
		{
			if (48 <= password.charAt(i) && password.charAt(i) <= 57)
			{
				 digitCounter++;
			}
		}
		if (digitCounter == 0)
		{
			throw new NoDigitException();
		}
		
		///////////////////////////////////////////////////////////////////////////////////////////////////
		//NoUpperAlphaException Test//
		int upperCounter = 0;
		
		for (int i = 0; i < password.length(); i++)
		{
			if (65 <= password.charAt(i) && password.charAt(i) <= 90) 
			{
				upperCounter++;
			}
		}
		if (upperCounter == 0)
		{
			throw new NoUpperAlphaException();
		}
		
		///////////////////////////////////////////////////////////////////////////////////////////////////
		//NoLowerAlphaException Test//
		int lowerCounter = 0;
		
		for (int i = 0; i < password.length(); i++)
		{
			if (97 <= password.charAt(i) && password.charAt(i) <= 122)
			{
				lowerCounter++;
			}
		}
		if (lowerCounter == 0)
		{
			throw new NoLowerAlphaException();
		}
		
		///////////////////////////////////////////////////////////////////////////////////////////////////
		//InvalidSequenceException Test//
		for (int i = 0; i < (password.length() - 2); i++)
		{
			if (password.charAt(i) == password.charAt(i+1) && password.charAt(i) == password.charAt(i+2))
			{
				throw new InvalidSequenceException();
			}
		}
		
		///////////////////////////////////////////////////////////////////////////////////////////////////
		if (valid)
			return true;
		return false;
	}
	
	/**
	 * isWeakPassword method
	 * @param password
	 * @return true if weak
	 * 		   false if strong
	 */
	public static boolean isWeakPassword(String password)
	{
		boolean strong = true;
		if (6 <= password.length() && password.length() <= 9)
		{
			strong = false;
		}
		
		if (strong)
		{
			return false;
		}
		else
			return true;
	}
	
	/**
	 * invalidPasswords method
	 * @param passwordList
	 * @return ArrayList of Strings representing invalid passwords
	 */
	public static ArrayList<String> invalidPasswords(ArrayList<String> passwordList)
	{
		ArrayList<String> invalidPasswords = new ArrayList<String>();
		
		for (String pwd : passwordList)
		{
			
			try {
				isValidPassword(pwd);
			}
			catch (LengthException | NoUpperAlphaException | NoLowerAlphaException | NoDigitException 
					| InvalidSequenceException e) {
				invalidPasswords.add(pwd + " " + e.getMessage());
			}

		}
			
		return invalidPasswords;
	}

}
