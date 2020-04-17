
/**
 * Class representing a node in a Binary Tree
 * @author benwiersma
 *	CMSC204 - 4/16/20
 * @param <T>
 */
public class TreeNode<T> {

	private T data;
	private TreeNode<T> rc;
	private TreeNode<T> lc;
	
	/**
	 * Constructor parameterized with data point
	 * @param dataNode	data to be stored in tree node
	 */
	public TreeNode(T dataNode) {
		data = dataNode;
		rc = null;
		lc = null;
	}
	
	/**
	 * Deep-copy constructor
	 * @param node	tree node to be copied
	 */
	public TreeNode(TreeNode<T> node) {
		data = node.getData();
		this.rc = new TreeNode<>(node.rc);
		this.lc = new TreeNode<>(node.lc);
	}
	
	/**
	 * Retriever method for node data
	 * @return	data stored in tree node
	 */
	public T getData() {
		return data;
	}

	/**
	 * @return the rc
	 */
	public TreeNode<T> getRc() {
		return rc;
	}

	/**
	 * @param rc the rc to set
	 */
	public void setRc(TreeNode<T> rc) {
		this.rc = rc;
	}

	/**
	 * @return the lc
	 */
	public TreeNode<T> getLc() {
		return lc;
	}

	/**
	 * @param lc the lc to set
	 */
	public void setLc(TreeNode<T> lc) {
		this.lc = lc;
	}
	
	
}
