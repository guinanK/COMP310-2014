
public class BinaryTreeNode
	<DataType extends Comparable<DataType>>
{
	DataType data;
	BinaryTreeNode<DataType> left, right;
	BinaryTreeNode(DataType data) {
		this.data = data;
	}
	void add(DataType moreData) {
		BinaryTreeNode<DataType> node = findNode(moreData);
		if (data.compareTo(moreData) <= 0) {
			node.right = new BinaryTreeNode<DataType>(moreData);
		}else{
			node.left = new BinaryTreeNode<DataType>(moreData);
		}			
	}
	// Can you write this function?
	// Hint: try doing what you do in the add function
	BinaryTreeNode<DataType> findNode(DataType data) {
		int result = this.data.compareTo(data);
		if(result < 0){
			if(right == null){
				return this;
			}else{
				return right.findNode(data);
			}
		}
			else if(result == 0){
				return this;
			}
			else{
				if(left == null){
					return this;
			}
				else{
					return left.findNode(data);
				}
		}
	}
	public static void main(String[] args) {
		System.out.println("Hello".compareTo("World"));
	}
}
