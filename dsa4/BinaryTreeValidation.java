
class Node {
	int data;
	Node left, right;

	public Node(int item) {
		data = item;
		left = right = null;
	}
}

public class BinaryTreeValidation {

	Node root;

	boolean isBST() {
		prev = null;
		return isBST(root);
	}

	boolean isBST(Node node) {

		if (node != null) {
			if (!isBST(node.left))
				return false;

			if (prev != null && node.data <= prev.data)
				return false;
			prev = node;
			return isBST(node.right);
		}
		return true;
	}

	public static void main(String args[]) {
		BinaryTreeValidation tree = new BinaryTreeValidation();
		tree.root = new Node(4);
		tree.root.left = new Node(2);
		tree.root.right = new Node(5);
		tree.root.left.left = new Node(1);
		tree.root.left.right = new Node(3);

		if (tree.isBST())
			System.out.println("IS BST");
		else
			System.out.println("Not a BST");
	}
}
