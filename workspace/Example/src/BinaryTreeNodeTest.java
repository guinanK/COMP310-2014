import static org.junit.Assert.*;

import org.junit.Test;

public class BinaryTreeNodeTest {
	
	@Test
	public void testAdd(){
		BinaryTreeNode<String> root = new BinaryTreeNode<String>("dog");
		root.add("cat");
		root.add("fish");
		root.add("turtle");
		root.add("snake");
		assertEquals("cat",root.left.data);
		assertEquals("fish",root.right.data);
		assertEquals("turtle",root.right.right.data);
		assertEquals("snake", root.right.right.left.data);
		assertTrue(root.contains("snake"));
		assertTrue(root.contains("cat"));
		assertTrue(root.contains("dog"));
		assertTrue(root.contains("turtle"));
		assertTrue(root.contains("fish"));
	}

}
