import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MorseCodeTreeTest {

	MorseCodeTree tree;
	TreeNode<String> t1,
					 t2;
	
	@BeforeEach
	void setUp() throws Exception {
		tree = new MorseCodeTree();
		t1 = new TreeNode<String>("r");
		t2 = new TreeNode<String>("b");
	}

	@AfterEach
	void tearDown() throws Exception {
		tree = null;
		t1 = t2 = null;
	}

	@Test
	void nodeDataVerification() {
		assertEquals(t1.getData(), tree.fetch(".-."));
		assertEquals(t2.getData(), tree.fetch("-..."));
	}
	
	@Test
	void testRoot() {
		assertEquals("", tree.getRoot().getData());
	}

}
