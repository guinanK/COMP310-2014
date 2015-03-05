public class BinaryTreeNode<DataType extends Comparable<DataType>> {
	DataType data;
	BinaryTreeNode<DataType> left, right;

	BinaryTreeNode(DataType data) {
		this.data = data;
	}

	void add(DataType moreData) {
		// figure out which side to place it
		if (data.compareTo(moreData) <= 0) {
			// it goes to the right
			if (right == null) {
				// create a node with the data and call it a day
				right = new BinaryTreeNode<DataType>(moreData);
			} else {
				// keep looking recursively
				right.add(moreData);
			}
		} else {
			// it goes to the left
			if (left == null) {
				// create a node and call it a day
				left = new BinaryTreeNode<DataType>(moreData);
			} else {
				// keep looking recursively
				left.add(moreData);
			}
		}
	}

	BinaryTreeNode<DataType> findParentNode(DataType dataType) {
		if (!contains(dataType)) {
			return null;
		}
		int result = this.data.compareTo(dataType);
		if (result < 0) {
			if (right.data.equals(dataType)) {
				return this;
			}
			return right.findParentNode(dataType);
		} else if (result > 0) {
			if (left.data.equals(dataType)) {
				return this;
			}
			return left.findParentNode(dataType);
		}

		return this;
	}

	BinaryTreeNode<DataType> findNode(DataType dataType) {
		BinaryTreeNode<DataType> parentNode = findParentNode(dataType);
		if (parentNode == null) {
			return null;
		} else if (parentNode.left != null
				&& parentNode.left.data.equals(dataType)) {
			return parentNode.left;
		} else if (parentNode.right != null
				&& parentNode.right.data.equals(dataType)) {
			return parentNode.right;
		} else if (parentNode.data.equals(dataType)) {
			return parentNode;
		}
		return null;
	}

	boolean remove(DataType dataType) {

		BinaryTreeNode<DataType> parent = findParentNode(dataType);
		if (parent == null) {
			return false;
		}
		if (parent.left != null && parent.left.data.equals(dataType)) {
			if (parent.left.left == null && parent.left.right == null) {
				parent.left = null;
			} else if (parent.left.left != null && parent.left.right == null) {
				parent.left = parent.left.left;
			} else if (parent.left.left == null) {
				parent.left = parent.left.right;
			} else {
				DataType largestData = parent.left.left.largestValue();
				parent.left.remove(largestData);
				parent.left.data = largestData;
			}
		} else if (parent.right != null && parent.right.data.equals(dataType)) {
			if (parent.right.left == null && parent.right.right == null) {
				parent.right = null;
			}

			else if (parent.right.left != null && parent.right.right == null) {
				parent.right = parent.right.left;
			} else if (parent.right.left == null) {
				parent.right = parent.right.right;

			} else {
				DataType largestData = parent.right.left.largestValue();
				parent.right.remove(largestData);
				parent.right.data = largestData;
			}
		}

		else {

			if (parent.left == null && parent.right == null) {
				parent.data = null;
			}

			else if (parent.left != null && parent.right == null) {
				DataType data = parent.left.data;
				parent.remove(data);
				parent.data = data;
			} else if (parent.left == null && parent.right != null) {
				DataType data = parent.right.data;
				parent.remove(data);
				parent.data = data;
			}

			else {
				DataType largestData = parent.left.largestValue();
				parent.remove(largestData);
				parent.data = largestData;
			}
		}
		return true;
	}

	DataType largestValue() {
		if (right == null) {
			return data;
		}
		return right.largestValue();
	}	
	boolean contains(DataType moreData) {
		int result = this.data.compareTo(moreData);
		if (result < 0) {
			return right != null && right.contains(moreData);
		} else {
			return result == 0 || left != null && left.contains(moreData);
		}
	}

	public static void main(String[] args) {
		System.out.println("Hello".compareTo("World"));
	}
}
