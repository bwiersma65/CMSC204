/**
 * Class representing line of donation recipients
 * Uses queue data structure to keep track of recipients
 * @author benwiersma
 *
 */
public class RecipientLine implements RecipientLineInterface {

	private final int DEFAULT_SIZE = 5;
	private int rLength, rCount;
	private MyQueue<Recipient> queue;
	
	/**
	 * parameterized constructor
	 * @param size capacity of recipient queue
	 */
	public RecipientLine(int size)
	{
		rLength = size;
		rCount = 0;
		queue = new MyQueue<Recipient>(size);
	}
	
	/**
	 * default constructor
	 */
	public RecipientLine()
	{
		rLength = DEFAULT_SIZE;
		rCount = 0;
		queue = new MyQueue<Recipient>();
	}
	
	/**
	 * Enqueue a new Recipient to the queue of the Recipients in the Recipient line
	 * @param rc a Recipient
	 * @return true if recipient is queued successfully
	 * @throws RecipientException("The Recipient Queue is Full") if queue is full
	 */
	@Override
	public boolean addNewRecipient(Recipient rc) throws RecipientException {
		try {
			queue.enqueue(rc);
		}
		catch (RuntimeException e) {
			throw new RecipientException("Recipient Queue is Full");
		}
		
		if (rCount == rLength)
			return false;
		else
			rCount++;
			return true;
	}

	/**
	 * When it is the recipient turn, recipient will be dequeued from the recipient line
	 * @return a Recipient object
	 * @throws RecipientException("The Recipient Queue is empty") if there is no Recipient in the line
	 */
	@Override
	public Recipient recipientTurn() throws RecipientException {
		Recipient rcp;
		
		try {
			rcp = new Recipient(queue.dequeue());
		}
		catch (RuntimeException e) {
			throw new RecipientException("Recipient Queue is Empty");
		}
		rCount--;
		return rcp;
	}

	/**
	 * check if Recipient  queue line is empty
	 * @return true if queue is empty, false otherwise
	 */
	@Override
	public boolean recipientLineEmpty() {
		if (queue.isEmpty())
			return true;
		else
			return false;
	}

	/**
	 * Returns an array of the Recipients in the queue.  
	 * Because of type erasure by the JVM at run-time, the array of type T that the generic queue
	 * returns from the call to queue.toArray() is an array of type Object, i.e., Object[] temp. 
	 * But since the individual elements of the array are still Recipients, we can copy them one 
	 * by one into a new array	of type Recipient and cast each one to Recipient. 
	 * So create a new array of Recipients of the same length as temp, run a for-loop that casts each element 
	 * of temp to Recipient and copies it to the corresponding position in the new array.  Then return the new array.
	 * @return an array of the Recipients in the queue
	 */
	@Override
	public Recipient[] toArrayRecipient() {
		Object[] temp = queue.toArray();
		Recipient[] arr = new Recipient[temp.length];

		for (int i = 0; i < rCount; i++) {
			arr[i] = new Recipient((Recipient)temp[i]);
		}
		
		return arr;
	}

}
