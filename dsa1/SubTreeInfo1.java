class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

class SubTreeInfo {
    int min, max;
    int size;
    boolean isBST;

    SubTreeInfo(int min, int max, int size, boolean isBST) {
        this.min = min;
        this.max = max;
        this.size = size;
        this.isBST = isBST;
    }
}

class SubTreeInfo1 {
    public static SubTreeInfo findLargestBST(Node root) {
        if (root == null) {
            return new SubTreeInfo(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, true);
        }
        SubTreeInfo left = findLargestBST(root.left);
        SubTreeInfo right = findLargestBST(root.right);

        SubTreeInfo info = null;
        if (left.isBST && right.isBST &&
                (root.data > left.max && root.data < right.min)) {
            info = new SubTreeInfo(Math.min(root.data, Math.min(left.min, right.min)),
                    Math.max(root.data, Math.max(left.max, right.max)),
                    left.size + 1 + right.size,
                    true);
        } else {
            info = new SubTreeInfo(0, 0, Math.max(left.size, right.size), false);
        }

        return info;
    }

    public static void main(String[] args) {
        Node root = new Node(10);

        root.left = new Node(15);
        root.right = new Node(8);

        root.left.left = new Node(12);
        root.left.right = new Node(20);
        root.right.left = new Node(5);
        root.right.right = new Node(9);

        root.left.left.left = new Node(2);
        root.left.left.right = new Node(14);
        root.right.left.left = new Node(4);
        root.right.left.right = new Node(7);

        root.right.right.right = new Node(10);

        System.out.println("The size of the largest BST is " +
                findLargestBST(root).size);
    }
}