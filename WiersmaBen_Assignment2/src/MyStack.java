/**
 * Class for Stack style data structure
 * @author benwiersma
 *
 * @param <T>
 */
public class MyStack<T> implements StackInterface<T> {

	private final int DEFAULT_CAPACITY = 5;
	private int size;
	private int topIndex;
	private T[] stack;
	
	/**
	 * default constructor
	 */
	@SuppressWarnings("unchecked")
	public MyStack() 
	{
		size = DEFAULT_CAPACITY;
		stack = (T[]) new Object[DEFAULT_CAPACITY];
		topIndex = -1;
	}
	/**
	 * parameterized
	 * @param size capacity of stack
	 */
	@SuppressWarnings("unchecked")
	public MyStack(int size) 
	{
		this.size = size;
		stack = (T[]) new Object[size];
		topIndex = -1;
	}
	
	/**
	 * Determines if Stack is empty
	 * @return true if Stack is empty, false if not
	 */
	@Override
	public boolean isEmpty() {
		
		if (stack[0] == null)
			return true;
		else
			return false;
	}

	/**
	 * Determines if Stack is full
	 * @return true if Stack is full, false if not
	 */
	@Override
	public boolean isFull() {
		
		if (stack[size-1] == null)
			return false;
		else
			return true;
	}

	/**
	 * Deletes and returns the element at the top of the Stack
	 * @return the element at the top of the Stack
	 */
	@Override
	public T pop() {
		if (!isEmpty()) {
			T something = stack[topIndex];
			stack[topIndex] = null;
			topIndex--;
			return something;
		}
		else
			throw new RuntimeException();
	}

	/**
	 * Number of elements in the Stack
	 * @return the number of elements in the Stack
	 */
	@Override
	public int size() {
		if (isFull())
			return size;
		else
			return topIndex+1;
	}

	/**
	 * Adds an element to the top of the Stack
	 * @param e the element to add to the top of the Stack
	 * @return true if the add was successful, false if not
	 */
	@Override
	public boolean push(T e) {
		if (isFull())
			throw new RuntimeException();
		else {
			stack[++topIndex] = e;
			
			if (stack[topIndex] == null)
				return false;
			else
				return true;
		}
	}

	/**
	 * Returns the elements of the Stack in an array, [0] is top of Stack, [1] is next in Stack, etc.
	 * @return an array of the Objects in the Stack
	 */
	@Override
	public T[] toArray() {
		int index = 0;
		@SuppressWarnings("unchecked")
		T[] arr = (T[]) new Object[size];
		
//		for (int i = topIndex; i >= 0; i--) {
//			arr[index++] = stack[i];
//		}
		for (int i = 0; i <= topIndex; i++) {
			arr[index++] = stack[i];
		}
		
		return arr;
	}

}
