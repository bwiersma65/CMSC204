import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Makes a concordance for a file or String
 * @author benwiersma
 *
 */
public class ConcordanceDataManager implements ConcordanceDataManagerInterface {

	ConcordanceDataStructure cds;
	
	/**
	 * Creates a concordance from a String
	 */
	@Override
	public ArrayList<String> createConcordanceArray(String input) {
		
		StringTokenizer temp = new StringTokenizer(input);
		cds = new ConcordanceDataStructure(temp.countTokens());
		
		String[] arr = input.split("\n");
		for (int i = 0; i < arr.length; i++) {
			StringTokenizer stkzr = new StringTokenizer(arr[i]);
			while (stkzr.hasMoreTokens()) {
				
				String tok = stkzr.nextToken();
				
				StringBuilder stb = new StringBuilder(tok);
				for (int c = 0; c < stb.length(); c++) {
					if ((!Character.isLetter(stb.charAt(c)) && (Character.compare(stb.charAt(c), '\'') != 0))
						|| Character.compare(stb.charAt(c), '\"') == 0 || Character.compare(stb.charAt(c), '_') == 0)
						stb.deleteCharAt(c);
				}
				
				String newEntry = new String(stb);
				if (2 < newEntry.length() && !newEntry.equalsIgnoreCase("and") && !newEntry.equalsIgnoreCase("the")) {
					cds.add(newEntry, i+1);
				}
			}
		}
		
		return cds.showAll();
	}

	/**
	 * Creates a concordance from a text file
	 */
	@Override
	public boolean createConcordanceFile(File input, File output) throws FileNotFoundException {
		Scanner inFile;
		ObjectOutputStream oos;
		
		if (input.canRead() && output.canWrite()) {
			try {
				inFile = new Scanner(input);
				oos = new ObjectOutputStream(new FileOutputStream(output));
				
				inFile.useDelimiter("");
				String temp = inFile.next();
				
				ArrayList<String> list = createConcordanceArray(temp);
				
				for (String s : list) {
					oos.writeObject(s);
				}
				
				inFile.close();
				oos.close();
			}
			catch (FileNotFoundException e) {
				return false;
			} catch (IOException e) {
				return false;
			}
			
			return true;
		}
		else
			throw new FileNotFoundException();
	}

}
