import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Represents a List of Linked Nodes, each possessing a data element of type T
 * @author benwiersma
 * CMSC204 - Assignment 3
 * @param <T>
 */
public class BasicDoubleLinkedList<T> implements Iterable<T>{

	private Node head;
	private Node tail;
	private int  size;
	
	/**
	 * Inner class - Node element that constitutes the Linked List
	 * Each node possesses: a T data element
	 * 						a reference to the next Node in list
	 * 						a reference to the previous Node in list
	 * @author benwiersma
	 * CMSC204 - Assignment 3
	 * @param <T>
	 */
	protected class Node {
		private T 	 data;	// Data portion: entry in list
		private Node next;  // Link portion: reference to next Node
		private Node prev;  // Link portion: reference to previous Node
		
		public Node(T data) {
			this(data, null, null);
		}
		
		public Node(T data, Node next, Node prev) {
			this.data = data;
			this.next = next;
			this.prev = prev;
		}

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public Node getPrev() {
			return prev;
		}

		public void setPrev(Node prev) {
			this.prev = prev;
		}
		
	}
	
	
	public BasicDoubleLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}
	
	/**
	 * Adds new Node element to end of linked list
	 * @param newData	New data element to be attached to new Node in list
	 * @return			Reference to BasicDoubleLinkedList<T> object
	 */
	public BasicDoubleLinkedList<T> addToEnd(T newData) {
		Node newLast = new Node(newData);
		
		if (size > 0) {
			newLast.setPrev(tail);
			tail = newLast;
			newLast.getPrev().setNext(newLast);
		}
		else {
			tail = newLast;
			head = newLast;
		}

		size++;
		return this;
	}
	
	/**
	 * Adds new Node element to front of linked list
	 * @param newData	New data element to be attached to new Node in list
	 * @return			Reference to BasicDoubleLinkedList<T> object
	 */
	public BasicDoubleLinkedList<T> addToFront(T newData) {
		Node newFirst = new Node(newData);
		
		if (size > 0) {
			newFirst.setNext(head);
			head = newFirst;
			newFirst.getNext().setPrev(newFirst);
		}
		else {
			head = newFirst;
			tail = newFirst;
		}
		
		size++;
		return this;
	}
	
	
	/**
	 * Returns reference to (but does not remove) T data of first node in list
	 * If list is empty, returns null
	 * @return	Reference to first data element
	 */
	public T getFirst() {
		return head.getData();
	}
	
	
	/**
	 * @return	Reference to first Node in list, or null if list empty
	 */
	public Node getHead() {
		return head;
	}
	protected void setHead(Node node) {
		head = node;
	}
	
	
	/**
	 * Returns reference to (but does not remove) T data of last node in list
	 * If list is empty, returns null
	 * @return	Reference to last data element
	 */
	public T getLast() {
		if (size > 0)
			return tail.getData();
		else
			return null;
	}
	
	
	/**
	 * @return Reference to last Node in list, or null if list empty
	 */
	public Node getTail() {
		return tail;
	}
	protected void setTail(Node node) {
		tail = node;
	}
	
	
	/**
	 * Returns the size of the linked list
	 * @return	Number of elements in linked list
	 */
	public int getSize() {
		return size;
	}
	
	
	protected void incrSize() {
		size = size + 1;
	}

	
	/**
	 * Removes the Node with the given T data from the list
	 * @param targetData	T data to be removed from the list (along with its Node)
	 * @param comparator	Comparator to be used to determine when T data has been found in list
	 * @return				Reference to BasicDoubleLinkedList<T> object
	 */
	public BasicDoubleLinkedList<T> remove(T targetData, Comparator<T> comparator) {
		Node currentNode = head;
		boolean found = false;
		
		if (size > 1) {
			while (!found && currentNode != null) {
				if (comparator.compare(targetData, currentNode.getData()) == 0) {
					
					// targetData is in first node
					if (currentNode.getPrev() == null) {
						currentNode.getNext().setPrev(null);
						head = currentNode.getNext();
						currentNode.setNext(null);
					}
					
					// targetData is in last node
					else if (currentNode.getNext() == null) {
						currentNode.getPrev().setNext(null);
						tail = currentNode.getPrev();
						currentNode.setPrev(null);
					}
					
					// targetData is in non-extremity node
					else {
						currentNode.getPrev().setNext(currentNode.getNext());
						currentNode.getPrev().getNext().setPrev(currentNode.getPrev());
						currentNode.setNext(null);
						currentNode.setPrev(null);
					}
					
					found = true;
				}
				currentNode = currentNode.getNext(); //here
			}
		}
		// List has one element, or is empty
		else {
			head = null;
			tail = null;
		}
		
		size--;
		return this;
	}
	
	/**
	 * Removed and returns last data element from list
	 * If list is empty, returns null
	 * @return	T data to be retrieved from list
	 */
	public T retrieveLastElement() {
		if (size > 0) {
			Node temp = tail;
			T data = tail.getData();
			
			tail.getPrev().setNext(null);
			tail = tail.getPrev();
			temp.setPrev(null);
			
			size--;
			temp = null;
			return data;
		}
		else
			return null;
	}
	
	/**
	 * Removes and returns first data element from list
	 * If list is empty, returns null
	 * @return	T data to be retrieved from list
	 */
	public T retrieveFirstElement() {
		if (size > 0) {
			Node temp = head;
			T data = head.getData();
			
			head.getNext().setPrev(null);
			head = head.getNext();
			temp.setNext(null);
			
			size--;
			temp = null;
			return data;
		}
		else
			return null;
	}
	
	/**
	 * Copies and returns T data from list as ArrayList of type T
	 * @return	Reference to ArrayList<T> containing reference copies of T data elements
	 */
	public ArrayList<T> toArrayList() {
		
		ArrayList<T> temp = new ArrayList<T>(size);
		
		Node currentNode = head;
		int index = 0;
		
		while ((index < size) && (currentNode != null)) {
			temp.add(index, currentNode.getData());
			currentNode = currentNode.getNext();
			index++;
		}
		
		return temp;
	}
	
	
	/**
	 * @return	An iterator of type T for traversing list
	 */
	@Override
	public ListIterator<T> iterator() {
		return new Iterator();
	}
	
	/**
	 * Iterator that traverses BasicDoubleLinkedList<T>
	 * Returns the T data element of each Node as it passes by
	 * @author benwiersma
	 * CMSC204 - Assignment 3
	 */
	protected class Iterator implements ListIterator<T> {

		private Node nextNode,
					 prevNode;
		
		public Iterator() {
			nextNode = head;
			prevNode = null;
		}
		
		/**
		 * Detects whether Iterator has traversed past last element in list
		 * @return	True if another Node exists after Iterator to be traversed past
		 * 			False if reached end of list
		 */
		@Override
		public boolean hasNext() {
			return nextNode != null;
		}

		/**
		 * Returns next element in list and advances Iterator one position
		 * @return	Reference to next T element in list, if it exists
		 */
		@Override
		public T next() {
			T nextData;
			
			if (hasNext()) {
				nextData = nextNode.getData();
				prevNode = nextNode;
				nextNode = nextNode.getNext();
			}
			else
				throw new NoSuchElementException("Illegal call to next() ; iterator is past end of list");
			
			return nextData;
		}

		/**
		 * Detects whether Iterator is at beginning of list
		 * @return	True if another Node exists before Iterator to be traversed past
		 * 			False if at beginning of list
		 */
		@Override
		public boolean hasPrevious() {
			return prevNode != null;
		}

		/**
		 * Returns previous element in list and retreats Iterator one position
		 * @return	Reference to previous T element in list, if it exists
		 */
		@Override
		public T previous() {
			T prevData;
			
			if (hasPrevious()) {
				prevData = prevNode.getData();
				nextNode = prevNode;
				prevNode = prevNode.getPrev();
			}
			else
				throw new NoSuchElementException("Illegal call to previous() ; iterator is before beginning of list");
			
			return prevData;
		}

		@Override
		public int nextIndex() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}

		@Override
		public int previousIndex() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}

		@Override
		public void remove() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}

		@Override
		public void set(T e) throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}

		@Override
		public void add(T e) throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}
		
	}
	
}
