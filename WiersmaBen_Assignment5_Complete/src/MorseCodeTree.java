
import java.util.ArrayList;
/**
 * Class representing a Binary Tree made up of TreeNode<String>
 * Each node represents a letter of the alphabet
 * @author benwiersma
 *	CMSC204 - 4/16/20
 */
public class MorseCodeTree implements LinkedConverterTreeInterface<String> {

	private TreeNode<String> root;
	
	/**
	 * No-arg constructor
	 * Calls buildTree() method
	 */
	public MorseCodeTree() {
		buildTree();
	}
	
	/**
	 * Accessor method for root node
	 */
	@Override
	public TreeNode<String> getRoot() {
		return root;
	}

	/**
	 * Mutator method for root node
	 * @param	newNode new node to be treated as root of tree
	 */
	@Override
	public void setRoot(TreeNode<String> newNode) {
		root = newNode;
	}

	/**
	 * Creates a node to represent whatever letter was passed to method
	 * Inserts node into appropriate place in tree according to provided template
	 * @param	code Morse code
	 * 			letter Letter of the alphabet
	 */
	@Override
	public MorseCodeTree insert(String code, String letter) {
		addNode(root, code, letter);
		return this;
	}

	/**
	 * Adds new node to tree based on Morse code parameter
	 * Algorithm:
	 * 1. If one character
	 * a. If character is "." store new node in left child of current root
	 * b. If character is "-" store new node in right child
	 * 2. If multiple characters
	 * a. If first character is ".", new root becomes left child of current root
	 * b. If first is "-", new root becomes right child
	 * c. Remove first character from code
	 * d. Call addNode method with new root, new code, and data to be stored
	 * 
	 * @param	root root node
	 * 			code Morse code
	 * 			letter Letter of the alphabet
	 */
	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {
		
		//	Base case
		if (code.length() == 1) {
			if (code.equalsIgnoreCase(".")) {
				root.setLc(new TreeNode<String>(letter));
			}
			else {
				root.setRc(new TreeNode<String>(letter));
			}
		}
		//	Recursive caseS
		else {
			
			if (code.charAt(0) == '.') {
				
				addNode(root.getLc(), code.substring(1), letter);
			}
			else {
				
				addNode(root.getRc(), code.substring(1), letter);
			}
		}
	}

	/**
	 * Returns letter found at node in tree as specified by Morse code argument
	 * @param	code Morse code
	 */
	@Override
	public String fetch(String code) {
		return fetchNode(root, code);
	}

	/**
	 * Retrieves data from node found in tree at location specified by provided Morse code
	 * @param	root root node
	 * 			code Morse code
	 */
	@Override
	public String fetchNode(TreeNode<String> root, String code) {
		String result = "";
		
		//	Base case
		if (code.length() == 1) 
		{
			if (code.equalsIgnoreCase("."))
				result = root.getLc().getData();
			else
				result = root.getRc().getData();
		}
		//	Recursive case
		else 
		{
			
			if (code.charAt(0) == '.')
				return fetchNode(root.getLc(), code.substring(1));
			else
				return fetchNode(root.getRc(), code.substring(1));
		}
		
		return result;
	}

	/**
	 * Unsupported operation
	 */
	@Override
	public MorseCodeTree delete(String data) throws UnsupportedOperationException {
		return this;
	}

	/**
	 * Unsupported operation
	 */
	@Override
	public MorseCodeTree update() throws UnsupportedOperationException {
		return this;
	}

	/**
	 * Called by constructor
	 * Builds tree by inserting node representing each letter of the English alphabet into tree at location 
	 * 															   as specified by corresponding Morse code
	 */
	@Override
	public void buildTree() {
		setRoot(new TreeNode<String>(""));
		//Level 1
		insert(".","e");
		insert("-","t");
		//Level 2
		insert("..","i");
		insert(".-","a");
		insert("-.","n");
		insert("--","m");
		//Level 3
		insert("...","s");
		insert("..-","u");
		insert(".-.","r");
		insert(".--","w");
		insert("-..","d");
		insert("-.-","k");
		insert("--.","g");
		insert("---","o");
		//Level 4
		insert("....","h");
		insert("...-","v");
		insert("..-.","f");
		insert(".-..","l");
		insert(".--.","p");
		insert(".---","j");
		insert("-...","b");
		insert("-..-","x");
		insert("-.-.","c");
		insert("-.--","y");
		insert("--..","z");
		insert("--.-","q");
	}

	/**
	 * Creates and returns ArrayList representing contents of tree nodes in LNR order
	 */
	@Override
	public ArrayList<String> toArrayList() {
		ArrayList<String> list = new ArrayList<>();
		LNRoutputTraversal(root,list);
		return list;
	}

	/**
	 * Traverses tree in LNR order
	 * Adds data of each node to provided ArrayList as the node is traversed across
	 * @param	root root node
	 * @param	list ArrayList<String> list to represent contents of tree
	 */
	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {

		if (root != null)
		{
			LNRoutputTraversal(root.getLc(),list);
			list.add(root.getData());
			LNRoutputTraversal(root.getRc(),list);
		}
	}

}
