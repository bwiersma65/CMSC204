import java.util.Comparator;
import java.util.ListIterator;

/**
 * Represents a List of Linked Nodes, sorted upon addition to the list according to a given Comparator
 * @author benwiersma
 * CMSC204 - Assignment 3
 * @param <T>
 */
public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> implements Iterable<T> {

	private Comparator<T> comparator;
	
	/**
	 * Constructs SortedDoubleLinkedList<T> using superclass constructor to generate linked list
	 * @param comparator for T data
	 */
	public SortedDoubleLinkedList(Comparator<T> comparator) {
		super();
		this.comparator = comparator;
	}
	
	/**
	 * Adds Node with given T data to sorted list
	 * Travels through list comparing given T data with data attached to each individual node
	 * Finds point at which given T data is determined to be "less than" the comparable Node
	 * @param data	T data element to be added
	 * @return		Reference to this SortedDoubleLinkedList<T> object
	 */
	public SortedDoubleLinkedList<T> add(T data) {
		
		Node newNode = new Node(data),
			 nextNode = getHead();
		boolean found = false;
		
		if (getSize() > 0) 
		{
			while (!found && nextNode != null) 
			{
				if (comparator.compare(data, nextNode.getData()) > 0) 
				{
					nextNode = nextNode.getNext();
				}
				// found spot
				else 
				{
					// If new Node is to be placed at beginning of list
					if (nextNode.getPrev() == null) {
						newNode.setNext(getHead());
						setHead(newNode);
						
						newNode.getNext().setPrev(newNode);
					}
					// If new Node is to be placed in non-extremity
					else {
						nextNode.getPrev().setNext(newNode);
						newNode.setPrev(nextNode.getPrev());
						newNode.setNext(nextNode);
						nextNode.setPrev(newNode);
					}
					
					found = true;
				}
			}
			
			// If new Node is to be placed at end of list
			if (nextNode == null) {
				newNode.setPrev(getTail());
				setTail(newNode);
				newNode.getPrev().setNext(newNode);
			}
		}
		// List is empty
		else {
			setHead(newNode);
			setTail(newNode);
		}
		
		incrSize();
		return this;
	}
	
	
	@Override
	public BasicDoubleLinkedList<T> addToEnd(T data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	
	@Override
	public BasicDoubleLinkedList<T> addToFront(T data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	
	/**
	 * Returns reference to superclass Iterator for sorted list
	 */
	@Override
	public ListIterator<T> iterator() {
		return super.iterator();
	}
	
	/**
	 * Calls superclass remove(T, Comparator<T>) method to remove elements from sorted list
	 * @return	reference to this SortedDoubleLinkedList<T> object 
	 */
	public SortedDoubleLinkedList<T> remove(T data, Comparator<T> comparator) {
		super.remove(data, comparator);
		return this;
	}
}
