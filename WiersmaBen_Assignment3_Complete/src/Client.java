import java.util.Comparator;

public class Client {

	public static void main(String[] args) {

		SortedDoubleLinkedList<String> list = new SortedDoubleLinkedList<String>(new StringComparator());
	
		list.add("One");
		
		System.out.println(list.toArrayList());
	}

}

class StringComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		return o1.compareTo(o2);
	}
	
}