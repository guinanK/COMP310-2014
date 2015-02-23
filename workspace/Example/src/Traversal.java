//Visitor design pattern tortured into doing basic tree
//traversal
public class Traversal<DataType> {
	public interface Visitor<DataType> {
		void visit(BinaryTreeNode<DataType> node);
	}

	public static class BinaryTreeNode<DataType> {
		DataType data;
		BinaryTreeNode<DataType> left, right;

		void accept(Visitor<DataType> v) {
			v.visit(this);
		}
	}

	public static class PrefixVisitor<DataType> implements Visitor<DataType> {

		@Override
		public void visit(BinaryTreeNode<DataType> node) {
			System.out.println(node.data);
			if(node.left != null){
				node.left.accept(this);
			}
			if(node.right != null){
				node.right.accept(this);
			}
		}
		
	}
	public static class PostfixVisitor<DataType> implements Visitor<DataType> {

		@Override
		public void visit(BinaryTreeNode<DataType> node) {
			if(node.left != null){
				node.left.accept(this);
			}
			if(node.right != null){
				node.right.accept(this);
			}
			System.out.println(node.data);
		}
		
	}
	public static class InfixVisitor<DataType> implements Visitor<DataType> {

		@Override
		public void visit(BinaryTreeNode<DataType> node) {
			if(node.left != null){
				node.left.accept(this);
			}
			System.out.println(node.data);
			if(node.right != null){
				node.right.accept(this);
			}
		}
		
	}
	
	public static void main(String[] args){
		BinaryTreeNode<String> root = new BinaryTreeNode<String>();
		root.data = "Ian";
		root.left = new BinaryTreeNode<String>();
		root.left.data = "Andy";
		root.right = new BinaryTreeNode<String>();
		root.right.data = "Joey";
		root.left.left = new BinaryTreeNode<String>();
		root.left.left.data = "amanda";
		root.left.right = new BinaryTreeNode<String>();
		root.left.right.data = "zack";
		root.right.left= new BinaryTreeNode<String>();
		root.right.left.data = "tyler";
		root.right.right = new BinaryTreeNode<String>();
		root.right.right.data = "mallory";
		System.out.println("~~~~~~Prefix~~~~~~");
		PrefixVisitor<String> visit = new PrefixVisitor<String>();
		root.accept(visit);
		System.out.println("~~~~~~Postfix~~~~~~");
		PostfixVisitor<String> visit2 = new PostfixVisitor<String>();
		root.accept(visit2);
		System.out.println("~~~~~~Infix~~~~~~");
		InfixVisitor<String> visit3 = new InfixVisitor<String>();
		root.accept(visit3);
		
	}
}
