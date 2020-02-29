/**
 * Class facilitating the functions associated with a donation fair
 * @author benwiersma
 *
 */
public class DonationManager implements DonationManageInterface {

	private Container stack;
	private VolunteerLine volQueue;
	private RecipientLine recQueue;
	private Volunteer dequeuedVol;
	private Recipient dequeuedRec;
	private DonationPackage poppedDonation;
	
	/**
	 * Default DonationManager constructor
	 */
	public DonationManager()
	{
		stack = new Container();
		volQueue = new VolunteerLine();
		recQueue = new RecipientLine();
	}
	
	/**
	 * Stacks a new donation package in to the container
	 * @param dPackage Donation package that is stacked in the container
	 * @return true if the package is stacked, false if the container is full
	 * @throws ContainerException if container is full
	 */
	@Override
	public boolean managerLoadContainer(DonationPackage dPackage) throws ContainerException {
		boolean didStack;
		try {
			didStack = stack.loadContainer(dPackage);
		}
		catch (ContainerException c) {
			throw new ContainerException("Container Stack is Full");
		}
		return didStack;
	}

	/**
	 * adds a new Volunteer to the volunteer line queue
	 * @param v A Volunteer object
	 * @return true if volunteer is queued successfully, false if volunteer line is full
	 * @throws VolunteerException("Volunteer Line is full") if the Volunteer Line queue is full
	 */
	@Override
	public boolean managerQueueVolunteer(Volunteer v) throws VolunteerException {
		boolean didQueue;
		try {
			didQueue = volQueue.addNewVolunteer(v);
		}
		catch (VolunteerException ve) {
			throw new VolunteerException("Volunteer Queue is Full");
		}
		return didQueue;
	}

	/**
	 * adds a new Recipient to the queue of the Recipient line
	 * @param rc a Recipient
	 * @return true if recipient is queued successfully, false if queue is full
	 * @throws RecipientException("Recipient Line is full") if the Recipient line is full
	 */
	@Override
	public boolean managerQueueRecipient(Recipient r) throws RecipientException {
		boolean didQueue;
		try {
			didQueue = recQueue.addNewRecipient(r);
		}
		catch (RecipientException re) {
			throw new RecipientException("Recipient Queue is Full");
		}
		return didQueue;
	}

	/**
	 * Simulates donating a DonationPackage from the container stack by the volunteer from the volunteer queue line to the 
	 * recipients from the recipients queue line. As a result the package is removed from the container, volunteer will be dequeued
	 * from  volunteer line and QUEUED BACK to the volunteer line and recipient will be dequeued from the recipient line.
	 * @throws VolunteerException("Volunteer Queue is empty") if there are no volunteers
	 * @throws ContainerExcpetion("Contain is empty") if the container is empty
	 * @throws RecipientException("Recipient Queue is empty") if there are no recipients
	 */
	@Override
	public int donatePackage() throws VolunteerException, ContainerException, RecipientException {
	
//		dequeuedVol = volQueue.volunteerTurn();
//		volQueue.addNewVolunteer(dequeuedVol);
//		dequeuedRec = recQueue.recipientTurn();
//		poppedDonation = stack.removePackageFromContainer();
//		
//		return 0;
		
		
		if (volQueue.volunteerLineEmpty())
			throw new VolunteerException("Volunteer Queue is empty");
		else {
			// deep copy?
			try { dequeuedVol = volQueue.volunteerTurn(); }
			catch (VolunteerException e) {
				throw new VolunteerException("Volunteer Queue is empty");
			}
			try { volQueue.addNewVolunteer(dequeuedVol); }
			catch ( VolunteerException e) {
				throw new VolunteerException("Volunteer Queue is Full");
			}
		}
		if (recQueue.recipientLineEmpty())
			throw new RecipientException("Recipient Queue is empty");
		else {
			try { dequeuedRec = recQueue.recipientTurn(); }
			catch (RecipientException e) {
				throw new RecipientException("Recipient Queue is empty");
			}
		}
		
		try { poppedDonation = stack.removePackageFromContainer(); }
		catch (ContainerException e) {
			throw new ContainerException("Container Stack is empty");
		}
		return 0;
		
//		Volunteer temp;
//		try { stack.removePackageFromContainer(); }
//		catch (ContainerException c) {
//			throw new ContainerException("Container is Empty");
//		}
//		
//		if (volQueue.volunteerLineEmpty())
//			throw new VolunteerException("Volunteer Queue is Empty");
//		else {
//			try { temp = volQueue.volunteerTurn(); }
//			catch (VolunteerException ve) {
//				throw new VolunteerException("Volunteer Queue is Empty");
//			}
//			try { volQueue.addNewVolunteer(temp); }
//			catch (VolunteerException ve) {
//				throw new VolunteerException("Volunteer Queue is Full");
//			}
//		}
//		
//		if (recQueue.recipientLineEmpty())
//			throw new RecipientException("Recipient Queue is Empty");
//		else {
//			try { recQueue.recipientTurn(); }
//			catch (RecipientException re) {
//				throw new RecipientException("Recipient Queue is Empty");
//			}
//		}
//		
//		return 1;
	}

	/**
	 * Returns an array of DonationPackages
	 * @return an array of Donation Packages
	 */
	@Override
	public DonationPackage[] managerArrayPackage() {
		return stack.toArrayPackage();
	}

	/**
	 * Returns an array of Volunteers
	 * @return an array of Volunteers
	 */
	@Override
	public Volunteer[] managerArrayVolunteer() {
		return volQueue.toArrayVolunteer();
	}

	/**
	 * Returns an array of Recipients
	 * @return an array of Recipients
	 */
	@Override
	public Recipient[] managerArrayRecipient() {
		return recQueue.toArrayRecipient();
	}

	/**
	 * Returns a String representation of the donation that was made: 
	 * the volunteer giving a package to a recipient
	 * @return String representation
	 */
	public String toString() {
		return dequeuedVol + " gave " + poppedDonation + " to " + dequeuedRec;
	}
}
