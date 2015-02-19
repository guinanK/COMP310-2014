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
		
		assertEquals("snake",root.findNode("snake"));
		assertEquals("cat",root.findNode("cat"));
		assertEquals("dog",root.findNode("dog"));
		assertEquals("turtle",root.findNode("turtle"));
		assertEquals("fish",root.findNode("fish"));
	}

}
