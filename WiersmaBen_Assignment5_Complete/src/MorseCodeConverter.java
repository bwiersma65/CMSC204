import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Utility class with methods to translate Morse code into English text
 * @author benwiersma
 *	CMSC204 - 4/16/20
 */
public class MorseCodeConverter {

	private static MorseCodeTree tree;
	
	/**
	 * No-arg constructor
	 */
	public MorseCodeConverter() {
	}
	
	/**
	 * Utility method to extract Morse code from a File and return the translated English text
	 * @param codeFile File full of Morse code to be translated
	 * @return Translated English text
	 * @throws FileNotFoundException
	 */
	public static String convertToEnglish(File codeFile) throws FileNotFoundException {
		tree = new MorseCodeTree();
		
		/////////////////////////////////////////
		//	  Retrieve Morse code from file	   //
		///////////////////////////////////////////
		Scanner inFile = new Scanner(codeFile);  //
		String code = "";						 //
		String engText = "";					 //
		while (inFile.hasNextLine()) {			 //
			code = inFile.nextLine();			 //
		}										 //
		///////////////////////////////////////////
		
		/////////////////////////////////////////
		//		Translate code into English    //
		////////////////////////////////////////////
		String[] words = code.split(" / ");		  //
		String[] letters;						  //
		for (int i = 0; i < words.length; i++) {  //
			letters = words[i].split(" ");		  //
			for (String l : letters) {			  //
				engText += tree.fetch(l);		  //
			}									  //
			if (i < words.length-1)				  //
				engText += " ";					  //
		}										  //
		////////////////////////////////////////////
		
		inFile.close();
		return engText;
	}
	
	/**
	 * Utility method to translate provided Morse code into English textS
	 * @param code Morse code to be translated
	 * @return Translated English text
	 */
	public static String convertToEnglish(String code) {
		tree = new MorseCodeTree();
		
		
		String engText = "";
		String[] words = code.split("/");
		String[] letters;
				
		//////////////////////////////////////////
		//		Translate code into English		//
		/////////////////////////////////////////////
		for (int i = 0; i < words.length; i++) {   //
			letters = words[i].trim().split(" ");  //
			for (String l : letters) {			   //
				engText += tree.fetch(l);		   //
			}									   //
			if (i < words.length-1)				   //
				engText += " ";					   //
		}										   //
		/////////////////////////////////////////////
		return engText;
	}
	
	/**
	 * For testing purposes:
	 * Returns String representation of contents of MorseCodeTree
	 * @return Letters of the English alphabet as retrieved from MorseCodeTree in LNR order
	 */
	public static String printTree() {
		tree = new MorseCodeTree();
		String print = "";
		ArrayList<String> list = tree.toArrayList();
		for (String s : list) {
			print = print + s + " ";
		}
		return print;
	}
}
