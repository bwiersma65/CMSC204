import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * A hashtable representing a concordance
 * @author benwiersma
 *
 */
public class ConcordanceDataStructure implements ConcordanceDataStructureInterface {

	private final double LOADING_FACTOR = 1.5;
	private int tableSize;
	private ArrayList<LinkedList<ConcordanceDataElement>> hashTable;
	
	/**
	 * Constructor
	 * @param num
	 */
	public ConcordanceDataStructure(int num) {
		int i = (int) (num / LOADING_FACTOR);
		tableSize = fourKPlus3(i);
		hashTable = new ArrayList<>(tableSize);
		for (int j = 0; j < tableSize; j++) {
			hashTable.add(new LinkedList<ConcordanceDataElement>());
		}
	}
	/**
	 * Constructor
	 * @param test
	 * @param size
	 */
	public ConcordanceDataStructure(String test, int size) {
		tableSize = size;
		hashTable = new ArrayList<>(tableSize);
		for (int j = 0; j < tableSize; j++) {
			hashTable.add(new LinkedList<ConcordanceDataElement>());
		}
	}
	
	/**
	 * Retriever for tableSize field
	 */
	@Override
	public int getTableSize() {
		return hashTable.size();
	}

	/**
	 * Returns the words that make up the concordance
	 */
	@Override
	public ArrayList<String> getWords(int index) {
		ArrayList<String> words = new ArrayList<String>(hashTable.get(index).size());
		ListIterator<ConcordanceDataElement> itr = hashTable.get(index).listIterator();
		while (itr.hasNext()) {
			words.add(itr.next().getWord());
		}
		return words;
	}

	/**
	 * Returns list of page numbers for each word in row of hashTable
	 */
	@Override
	public ArrayList<LinkedList<Integer>> getPageNumbers(int index) {
		ArrayList<LinkedList<Integer>> pageNums = new ArrayList<>();

		for (int i = 0; i < hashTable.get(index).size(); i++) {
			pageNums.add(new LinkedList<Integer>(hashTable.get(index).get(i).getList()));
		}

		return pageNums;
	}

	/**
	 * Does one of two things:
	 * 		1) If specified word exists in concordance, the specified line number is added to that word's list of occurrences 
	 * 		   (unless specified line number already exists in list of occurrences)
	 * 		2) If specified word is not yet in concordance, is it added along with the specific line number
	 */
	@Override
	public void add(String word, int lineNum) {
		int primaryStorageIndex = Math.abs(word.hashCode()) % tableSize;
		int wordIndex = -1;
		
		boolean inList = false;
		for (LinkedList<ConcordanceDataElement> list : hashTable) {
			for (ConcordanceDataElement cde : list) {
				if (cde.getWord().equalsIgnoreCase(word)) {
					inList = true;
					wordIndex = list.indexOf(cde);
					break;
				}
			}
			if (inList)
				break;
		}
		
		if (!inList) {
			ConcordanceDataElement newEntry = new ConcordanceDataElement(word);
			newEntry.addPage(lineNum);
			if (hashTable.get(primaryStorageIndex).isEmpty())
				hashTable.get(primaryStorageIndex).add(newEntry);
			else {
				ListIterator<ConcordanceDataElement> itr = hashTable.get(primaryStorageIndex).listIterator();
				int insertIndex = 0;
				boolean inserted = false;
				while (!inserted && itr.hasNext()) {
					ConcordanceDataElement temp = itr.next();
					if (newEntry.compareTo(temp) < 0) {
						hashTable.get(primaryStorageIndex).add(insertIndex, newEntry);
						inserted = true;
					}
					insertIndex++;
				}
				if (!inserted) {
					hashTable.get(primaryStorageIndex).addLast(newEntry);
					inserted = true;
				}
			}
		}
		else {
			hashTable.get(primaryStorageIndex).get(wordIndex).addPage(lineNum);
		}
		
		for (LinkedList<ConcordanceDataElement> list : hashTable) {
			Collections.sort(list, new ConcordanceComparator());
		}
	}
	
	/**
	 * Shows visual representation of concordance
	 */
	@Override
	public ArrayList<String> showAll() {
		ArrayList<ConcordanceDataElement> temp = new ArrayList<>();
		ArrayList<String> all = new ArrayList<>();
		
		for (LinkedList<ConcordanceDataElement> list : hashTable) {
			ListIterator<ConcordanceDataElement> itr = list.listIterator();
			while (itr.hasNext()) {
				temp.add(itr.next());
			}
		}
		
		Collections.sort(temp, new ConcordanceComparator());
		
		for (ConcordanceDataElement cde : temp)
			all.add(cde.toString() + "\n");
		
		return all;
	}

	/**
	 * Calculates next 4K+3 prime above specified integer
	 * @param n
	 * @return	4K+3 prime
	 */
	private int fourKPlus3 (int n) {
		boolean fkp3 = false;
		boolean isPrime = false;
		int prime, highDivisor, d;
		
		prime = n;
		if (prime % 2 == 0)
			prime++;
		
		while (!fkp3) {
			while (!isPrime) {
				highDivisor = (int) (Math.sqrt(prime) + 0.5);
				for (d = highDivisor; d > 1; d--) {
					if (prime % d == 0)
						break;
				}
				if (d != 1)
					prime = prime + 2;
				else
					isPrime = true;
			}
			
			if ((prime - 3) % 4 == 0)
				fkp3 = true;
			else {
				prime = prime + 2;
				isPrime = false;
			}
		}
		
		return prime;
	}
	
	/**
	 * Comparator class for use in comparing ConcordanceDataElements
	 * @author benwiersma
	 *
	 */
	private class ConcordanceComparator implements Comparator<ConcordanceDataElement> {

		@Override
		public int compare(ConcordanceDataElement o1, ConcordanceDataElement o2) {
			return o1.compareTo(o2);
		}
		
	}
}
