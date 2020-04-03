import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Data element class representing a word from the given text
 * @author benwiersma
 *	CMSC204 - Alexander
 *	3/31/20
 */
public class ConcordanceDataElement implements Comparable<ConcordanceDataElement> {

	/*
	 * Fields
	 */
	private String word;
	private LinkedList<Integer> lineNums;
	
	/**
	 * Constructor parameterized with String representing word from text
	 * @param word word from text to be added to concordance
	 */
	public ConcordanceDataElement(String word) {
		this.word = word.toLowerCase();
		lineNums = new LinkedList<Integer>();
	}
	
	/**
	 * Adds line number of occurence of work to lineNums list
	 * Checks already-present line numbers in list to prevent repeats
	 * @param lineNum
	 */
	public void addPage(int lineNum) {
		ListIterator<Integer> itr = lineNums.listIterator();
		boolean found = false;
		if (!lineNums.contains(lineNum)) {
			while (!found && itr.hasNext()) {
				Integer entry = (Integer) itr.next();
				if (lineNum < entry.intValue()) {
					found = true;
					lineNums.add(Integer.valueOf(lineNum));
				}
			}
			if (!found)
				lineNums.addLast(Integer.valueOf(lineNum));
		}
	}
	
	/**
	 * Retriever for list of line numbers where word appears
	 * @return	reference to linked list of line numbers
	 */
	public LinkedList<Integer> getList() {
		return lineNums;
	}
	
	/**
	 * Retriever for word represented by this data element
	 * @return	word from text
	 */
	public String getWord() {
		return word;
	}
	
	/**
	 * @return	hashcode representing the String object (word from text)
	 */
	public int hashCode() {
		return word.hashCode();
	}
	
	/**
	 * Compares two ConcordanceDataElements based on a comparison between each element's String field
	 * @return	negative integer if this CDE object comes alphabetically before the specified CDE object
	 * 			zero if the specified CDE object is equivalent to this CDE object
	 * 			positive integer if this CDE object comes alphabetically after the specified CDE object 
	 */
	@Override
	public int compareTo(ConcordanceDataElement o) {
		return word.compareToIgnoreCase(o.getWord());
	}
	
	/**
	 * @return String representation of this ConcordanceDataElement
	 */
	public String toString() {
		String s = word;
		ListIterator<Integer> itr = lineNums.listIterator();
		while (itr.hasNext()) {
			if (!itr.hasPrevious())
				s += ": " + itr.next().toString();
			else
				s += ", " + itr.next().toString();
		}
		return s;
	}
	
}
