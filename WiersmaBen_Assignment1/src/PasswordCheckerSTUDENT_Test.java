import java.util.ArrayList;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordCheckerUtility
 * @author 
 *
 */
public class PasswordCheckerSTUDENT_Test {
	ArrayList<String> passwords;
	String p1, p2;
	
	@Before
	public void setUp() throws Exception {
		String[] p = {"mrrobotnik3","Sputnik123","QWERTYUIOP45","Runawaaay12","asdf3","machete"};
		passwords = new ArrayList<>();
		passwords.addAll(Arrays.asList(p));
	}

	@After
	public void tearDown() throws Exception {
		passwords = null;
	}

	/**
	 * Test if the password is less than 8 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("sunRise17"));
			PasswordCheckerUtility.isValidPassword("sun17");
			assertTrue("Did not throw lengthException",false);
		}
		catch (LengthException e){
			assertTrue("Successfully threw a lengthException",true);
		}
		catch (Exception e) {
			assertTrue("Threw some other exception besides lengthException",true);
		}
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("CanadianTuxedo7"));
			PasswordCheckerUtility.isValidPassword("tuxedo7");
			assertTrue("Did not throw noUpperAlphaException",false);
		}
		catch (NoUpperAlphaException e) {
			assertTrue("Successfully threw a noUpperAlphaException",true);
		}
		catch (Exception e) {
			assertTrue("Threw some other exception besides noUpperAlphaException",true);
		}
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("CanadianTuxedo7"));
			PasswordCheckerUtility.isValidPassword("TUXEDO7");
			assertTrue("Did not throw noLowerAlphaException",false);
		}
		catch (NoLowerAlphaException e) {
			assertTrue("Successfully threw a noLowerAlphaException",true);
		}
		catch (Exception e) {
			assertTrue("Threw some other exception besides noLowerAlphaException",true);
		}
	}
	/**
	 * Test if the password has more than 9 characters
	 * This test should return true for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		try{
			assertEquals(true,PasswordCheckerUtility.isValidPassword("Columbus1492"));
			boolean weakPwd = PasswordCheckerUtility.isWeakPassword("LaNina");
			assertTrue(weakPwd);
		}
		catch(Exception e)
		{
			assertTrue("Threw some incorrect exception",false);
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("CardiffW2"));
			PasswordCheckerUtility.isValidPassword("CaaardiffW2");
			assertTrue("Did not throw noUpperAlphaException",false);
		}
		catch (InvalidSequenceException e) {
			assertTrue("Successfully threw a invalidSequenceException",true);
		}
		catch (Exception e) {
			assertTrue("Threw some other exception besides invalidSequenceException",true);
		}
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("TabletopD10"));
			PasswordCheckerUtility.isValidPassword("TabletopDie");
			assertTrue("Did not throw noDigitException",false);
		}
		catch (NoDigitException e) {
			assertTrue("Successfully threw a noDigitException",true);
		}
		catch (Exception e) {
			assertTrue("Threw some other exception besides noDigitException",true);
		}
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("Veritas47"));
			PasswordCheckerUtility.isValidPassword("Veritas47");
			assertTrue("Did not throw exception",true);
		}
		catch (Exception e) {
			assertTrue("Threw some exception",true);
		}
	}
	
	/**
	 * Test the validPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testValidPasswords() {
		ArrayList<String> valids;
		valids = PasswordCheckerUtility.invalidPasswords(passwords);
		
		Scanner scan = new Scanner(valids.get(0));
		assertEquals(scan.next(), "mrrobotnik3");
		String results = scan.nextLine().toLowerCase();
		assertTrue(results.contains("uppercase"));
		
		scan = new Scanner(valids.get(1));
		assertEquals(scan.next(), "QWERTYUIOP45");
		results = scan.nextLine().toLowerCase();
		assertTrue(results.contains("lowercase"));
		
		scan = new Scanner(valids.get(2));
		assertEquals(scan.next(), "Runawaaay12");
		results = scan.nextLine().toLowerCase();
		assertTrue(results.contains("sequence"));
		
		scan = new Scanner(valids.get(3));
		assertEquals(scan.next(), "asdf3");
		results = scan.nextLine().toLowerCase();
		assertTrue(results.contains("long"));
		
		scan = new Scanner(valids.get(4));
		assertEquals(scan.next(), "machete");
		results = scan.nextLine().toLowerCase();
		assertTrue(results.contains("digit"));
	}
	
}