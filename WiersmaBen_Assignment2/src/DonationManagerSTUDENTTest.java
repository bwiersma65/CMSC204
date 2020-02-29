
import static org.junit.Assert.*;

import java.util.EmptyStackException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

 
/**
 * @author khandan Monshi, revised by Professor Kartchner
 *
 */
public class DonationManagerSTUDENTTest {
	DonationManager manager;

	@Before
	public void setUp() throws Exception {
	 
		manager = new DonationManager();
		
	}
 
	@After
	public void tearDown() throws Exception {
		 
		manager = null;
	}
 
	/** 
	 * Student test that a new DonationPackage is created and 
	 * the manager correctly calls load the container 
	 */
	@Test
	public void testManagerLoadcontainer()   {
		try {
			manager.managerLoadContainer(new DonationPackage("Cups",15));
			manager.managerLoadContainer(new DonationPackage("Pencils",5));
			manager.managerLoadContainer(new DonationPackage("Atlas",17));
			manager.managerLoadContainer(new DonationPackage("Cookies",2));
		}
		catch (ContainerException e) {
			System.out.println("Should not have thrown exception in tMLC");
		}
	}
	 
	/**
	 * Student test that a new Volunteer is created and 
	 * the manager correctly queues the volunteer
	 */
	@Test
	public void testManagerQueueVolunteer() {
		try {
			manager.managerQueueVolunteer(new Volunteer("James"));
			manager.managerQueueVolunteer(new Volunteer("Becky"));
			manager.managerQueueVolunteer(new Volunteer("Josh"));
			manager.managerQueueVolunteer(new Volunteer("Nick"));
			manager.managerQueueVolunteer(new Volunteer("Ben"));
		}
		catch (VolunteerException e) {
			System.out.println("Should not have thrown exception in tMQV");
		}
	}

	/**
	 * Student test that a new Recipient is created and 
	 * the manager correctly queues the recipient
	 */
	@Test
	public void testManagerQueueRecipient() {
		try {
			manager.managerQueueRecipient(new Recipient("Maryland"));
			manager.managerQueueRecipient(new Recipient("Baltimore"));
			manager.managerQueueRecipient(new Recipient("Towson"));
			manager.managerQueueRecipient(new Recipient("Salisbury"));
			manager.managerQueueRecipient(new Recipient("Montgomery"));
		}
		catch (RecipientException e) {
			System.out.println("Should not have thrown exception in tMQR");
		}
	}

	/**
	 * Student test that the manager correctly calls donatePackage,
	 * testing the situations noted in the assignment document
	 */
	@Test
	public void testDonatePackage() {
		Volunteer v1 = new Volunteer("Michael"),
				v2 = new Volunteer("Kate");
		Recipient r1 = new Recipient("RichardMontgomery"),
				r2 = new Recipient("Wootton");
		DonationPackage d1 = new DonationPackage("Binders",14),
				d2 = new DonationPackage("Rulers",7);
		
		try {
			manager.managerLoadContainer(d1);
			
			assertFalse(0 == manager.donatePackage());
			System.out.println("Should not reach this: cannot donate because no volunteers");
		}
		catch (ContainerException | RecipientException | VolunteerException e) {
			System.out.println(e.getMessage() + " in testDonatePackage");
		}
		
		try {
			manager.managerQueueVolunteer(v1);
			
			assertFalse(0 == manager.donatePackage());
			System.out.println("Should not reach this: cannot donate because no recipients");
		}
		catch (ContainerException | RecipientException | VolunteerException e) {
			System.out.println(e.getMessage() + " in testDonatePackage");
		}
		
		try {
			manager.managerQueueRecipient(r1);
			
			assertEquals(manager.donatePackage(),0);
			System.out.println("Should donate here");
		}
		catch (ContainerException | RecipientException | VolunteerException e) {
			System.out.println(e.getMessage() + " in testDonatePackage");
		}
		
		try {
			assertFalse(0 == manager.donatePackage());
		}
		catch (ContainerException | RecipientException | VolunteerException e) {
			System.out.println(e.getMessage() + " in testDonatePackage");
		}
		
		try {
			manager.managerQueueRecipient(r2);
			assertFalse(0 == manager.donatePackage());
		}
		catch (ContainerException | RecipientException | VolunteerException e) {
			System.out.println(e.getMessage() + " in testDonatePackage");
		}
	} 

}
