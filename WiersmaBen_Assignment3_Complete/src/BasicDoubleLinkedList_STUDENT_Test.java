import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Comparator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit test cases for BasicDoubleLinkedList.class
 * @author benwiersma
 * CMSC204
 */
class BasicDoubleLinkedList_STUDENT_Test {

	StringComparator comparator;
	BasicDoubleLinkedList<String> list;
	String a;
	String b;
	String c;
	String d;
	String e;
	
	@BeforeEach
	void setUp() throws Exception {
		comparator = new StringComparator();
		list = new BasicDoubleLinkedList<String>();
		a = new String("Apple");
		b = new String("Banana");
		c = new String("Carrot");
		d = new String("Donut");
		e = new String("Eggroll");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		list = null;
		a = b = c = d = e = null;
	}

	/**
	 * Test method for addToEnd method
	 */
	@Test
	void testAddToEnd() {
		list.addToEnd(a);
		assertEquals(a, list.getFirst());
		assertEquals(a, list.getLast());
		list.addToEnd(b);
		assertEquals(a, list.getFirst());
		assertEquals(b, list.getLast());
	}

	/**
	 * Test method for addToFront method
	 */
	@Test
	void testAddToFront() {
		list.addToFront(c);
		assertEquals(c, list.getFirst());
		assertEquals(c, list.getLast());
		list.addToFront(d);
		assertEquals(d, list.getFirst());
		assertEquals(c, list.getLast());
	}

	/**
	 * Test method for getFirst
	 */
	@Test
	void testGetFirst() {
		list.addToFront(a);
		assertEquals("Apple", list.getFirst());
		list.addToFront(b);
		assertEquals("Banana", list.getFirst());
		list.addToEnd(c);
		assertEquals("Banana", list.getFirst());
	}

	/**
	 * Test method for getLast
	 */
	@Test
	void testGetLast() {
		list.addToEnd(d);
		assertEquals("Donut", list.getLast());
		list.addToEnd(e);
		assertEquals("Eggroll", list.getLast());
	}

	/**
	 * Test method for getSize
	 */
	@Test
	void testGetSize() {
		assertEquals(0, list.getSize());
		list.addToFront(a);
		assertEquals(1, list.getSize());
		list.addToEnd(b);
		list.addToEnd(c);
		assertEquals(3, list.getSize());
		list.remove(a, comparator);
		assertEquals(2, list.getSize());
	}

	/**
	 * Test method for remove(T, Comparator<T>)
	 */
	@Test
	void testRemove() {
		list.addToFront(a);
		list.addToEnd(b);
		list.addToEnd(c);
		list.addToEnd(d);
		assertEquals("Donut", list.getLast());
		list.remove(d, comparator);
		assertEquals("Carrot", list.getLast());
		list.remove(a, comparator);
		assertEquals("Banana", list.getFirst());
	}

	/**
	 * Test method for retrieveLastElement
	 */
	@Test
	void testRetrieveLastElement() {
		list.addToFront(a);
		list.addToEnd(b);
		assertEquals(2, list.getSize());
		assertEquals("Apple", list.getFirst());
		assertEquals("Apple", list.retrieveFirstElement());
		assertEquals(1, list.getSize());
		assertEquals("Banana", list.getFirst());
	}

	/**
	 * Test method for retrieveFirstElement
	 */
	@Test
	void testRetrieveFirstElement() {
		list.addToFront(b);
		list.addToEnd(c);
		list.addToEnd(d);
		assertEquals(3,  list.getSize());
		assertEquals("Donut", list.getLast());
		assertEquals("Donut", list.retrieveLastElement());
		assertEquals(2, list.getSize());
		assertEquals("Carrot", list.getLast());
	}

	/**
	 * Test method for toArrayList
	 */
	@Test
	void testToArrayList() {
		ArrayList<String> arrList;
		list.addToFront(a);
		list.addToEnd(d);
		list.addToEnd(e);
		arrList = list.toArrayList();
		assertEquals("Apple", arrList.get(0));
		assertEquals("Donut", arrList.get(1));
		assertEquals("Eggroll", arrList.get(2));
	}

	private class StringComparator implements Comparator<String> {

		@Override
		public int compare(String o1, String o2) {
			return o1.compareTo(o2);
		}
		
	}
	
}
