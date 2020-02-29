/**
 * Class for a Queue style data structure
 * @author benwiersma
 * @param <T>
 */
public class MyQueue<T> implements QueueInterface<T> {

	private final int DEFAULT_CAPACITY = 5;
	private int size;
	private int lastIndex;
	private T[] queue;
	
	/**
	 * default constructor
	 */
	@SuppressWarnings("unchecked")
	public MyQueue()
	{
		size = DEFAULT_CAPACITY;
		queue = (T[]) new Object[DEFAULT_CAPACITY];
		lastIndex = -1;
	}
	
	/**
	 * parameterized constructor
	 * @param size capacity of the queue
	 */
	@SuppressWarnings("unchecked")
	public MyQueue(int size)
	{
		this.size = size;
		queue = (T[]) new Object[size];
		lastIndex = -1;
	}
	
	/**
	 * Determines if Queue is empty
	 * @return true if Queue is empty, false if not
	 */
	public boolean isEmpty() {
		if (queue[0] == null)
			return true;
		else
			return false;
	}

	/**
	 * Determines if the Queue is full
	 * @return true if Queue is full, false if not
	 */
	public boolean isFull() {
		if (queue[size-1] == null)
			return false;
		else
			return true;
	}

	/**
	 * Deletes and returns the element at the front of the Queue
	 * @return the element at the front of the Queue
	 */
	public T dequeue() {
		if (!isEmpty()) {
			int emptySpot = lastIndex;
			T something = queue[0];
			for (int i = 0, j = 1; i < lastIndex && j <= lastIndex; i++, j++)
			{
				queue[i] = queue[j];
			}
			queue[emptySpot] = null;
			lastIndex--;
			return something;
		}
		else
			throw new RuntimeException();
	}

	/**
	 * Number of elements in the Queue
	 * @return the number of elements in the Queue
	 */
	public int size() {
		if (isFull())
			return size;
		else
			return lastIndex+1;
	}

	/**
	 * Adds an element to the end of the Queue
	 * @param e the element to add to the end of the Queue
	 * @return true if the add was successful, false if not
	 */
	public boolean enqueue(T e) {
		if (isFull())
			throw new RuntimeException();
		else {
			queue[++lastIndex] = e;
			
			if (queue[lastIndex] == null)
				return false;
			else
				return true;
		}
	}

	/**
	 * Returns the elements of the Queue in an array, [0] is front of Queue, [1] is next in Queue, etc.
	 * @return an array of the Object elements in the Queue
	 */
	public T[] toArray() {
		int index = 0;
		@SuppressWarnings("unchecked")
		T[] arr = (T[]) new Object[lastIndex+1];
		
//		for (T e: queue) {
//			arr[index++] = e;
//		}
		for (int i = 0; i <= lastIndex; i++) {
			arr[index++] = queue[i];
		}
		
		return arr;
	}

}
