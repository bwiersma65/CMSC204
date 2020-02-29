/**
 * Class representing a line of volunteers
 * Uses a queue data structure to keep track of line
 * @author benwiersma
 *
 */
public class VolunteerLine implements VolunteerLineInterface {

	private final int DEFAULT_SIZE = 5;
	private int vLength, vCount;
	private MyQueue<Volunteer> queue;
	
	/**
	 * Parameterized VolunteerLine constructor
	 * @param size capacity of the queue
	 */
	public VolunteerLine(int size)
	{
		vLength = size;
		vCount = 0;
		queue = new MyQueue<>(size);
	}
	
	/**
	 * Default VolunteerLine constructor
	 */
	public VolunteerLine()
	{
		vLength = DEFAULT_SIZE;
		vCount = 0;
		queue = new MyQueue<>();
	}
	
	/**
	 * adds a new Volunteer to the volunteer line Queue
	 * @param v A Volunteer object
	 * @return true if volunteer is queued successfully
	 * @throws VolunteerException("Volunteer Queue is full") is queue is full
	 */
	@Override
	public boolean addNewVolunteer(Volunteer v) throws VolunteerException {
		try {
			queue.enqueue(v);
		}
		catch (RuntimeException e) {
			throw new VolunteerException("Volunteer Queue is Full");
		}
		
		if (vCount == vLength)
			return false;
		else
			return true;
	}

	/**
	 * removes volunteer from the volunteer queue line
	 * @return Volunteer Object
	 * @throws VolunteerException("Volunteer queue is empty") if queue is empty
	 */
	@Override
	public Volunteer volunteerTurn() throws VolunteerException {
		Volunteer vtr;
		
		try {
			vtr = new Volunteer(queue.dequeue());
		}
		catch (RuntimeException e) {
			throw new VolunteerException("Volunteer Queue is Empty");
		}

		return vtr;
	}

	/**
	 * checks if there are volunteers in line 
	 * @return true if volunteer line is empty, true otherwise
	 */
	@Override
	public boolean volunteerLineEmpty() {
		if (queue.isEmpty())
			return true;
		else
			return false;
	}

	/**
	 * Returns an array of the Volunteers in the queue.  
	 * Because of type erasure by the JVM at run-time, the array of type T that the generic queue
	 * returns from the call to queue.toArray() is an array of type Object, i.e., Object[] temp. 
	 * But since the individual elements of the array are still Volunteers, we can copy them one 
	 * by one into a new array	of type Volunteer and cast each one to Volunteer. 
	 * So create a new array of Volunteers of the same length as temp, run a for-loop that casts each element 
	 * of temp to Volunteer and copies it to the corresponding position in the new array.  Then return the new array.
	 * @return an array of the Volunteers in the queue
	 */
	@Override
	public Volunteer[] toArrayVolunteer() {
		Object[] temp = queue.toArray();
		int index = 0;
		Volunteer[] arr = new Volunteer[temp.length];
		
		for (Object e: temp) {
			arr[index++] = new Volunteer((Volunteer)e);
		}
		
		return arr;
	}

}
