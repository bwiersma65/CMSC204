import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SortedDoubleLinkedList_STUDENT_Test {
	
	SortedDoubleLinkedList<Book> list;
	BookComparator bookComparator;
	
	Book a;
	Book b;
	Book c;
	Book d;
	Book e;

	@BeforeEach
	void setUp() throws Exception {
		bookComparator = new BookComparator();
		list = new SortedDoubleLinkedList<Book>(bookComparator);
		a = new Book("How To Fish", 49);
		b = new Book("The Count of Montecristo", 473);
		c = new Book("Gladiator", 401);
		d = new Book("Marley and Me", 212);
		e = new Book("2001: A Space Odyssey", 556);
	}

	@AfterEach
	void tearDown() throws Exception {
		bookComparator = null;
		list = null;
		a = b = c = d = e = null;
	}

	@Test
	void testAdd() {
		// alphanum order: e c a d b
		list.add(a);
		list.add(b);
		list.add(c);
		assertEquals(c, list.getFirst());
		assertEquals(b, list.getLast());
		list.add(d);
		list.add(e);
		assertEquals(e, list.getFirst());
		assertEquals(b, list.retrieveLastElement());
		assertEquals(d, list.getLast());
	}

	@Test
	void testRemoveTComparatorOfT() {
		list.add(a);
		list.add(e);
		list.add(b);
		assertEquals(3, list.getSize());
		assertEquals(e, list.getFirst());
		list.remove(e, bookComparator);
		assertEquals(2, list.getSize());
		assertEquals(a, list.getFirst());
	}

	private class Book {
		private String title;
		private int length;
		
		public Book(String title, int length) {
			this.title = title;
			this.length = length;
		}
		
		public String getTitle() {
			return title;
		}
		
		public int getLength() {
			return length;
		}
	}

	private class BookComparator implements Comparator<Book> {

		@Override
		public int compare(Book o1, Book o2) {
			return o1.getTitle().compareTo(o2.getTitle());
		}
		
	}
}