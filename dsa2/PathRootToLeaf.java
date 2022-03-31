import java.util.ArrayDeque;
import java.util.Deque;

class Node {
    int data;
    Node left = null, right = null;

    Node(int data) {
        this.data = data;
    }
}

class Pair<U, V> {
    public final U first;
    public final V second;

    private Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }

    public static <U, V> Pair<U, V> of(U a, V b) {

        return new Pair<>(a, b);
    }
}

class PathRootToLeaf {
    public static void printRootToleafPathIterative(Node root) {

        if (root == null) {
            return;
        }

        Deque<Pair<Node, String>> stack = new ArrayDeque<>();

        stack.add(Pair.of(root, ""));

        while (!stack.isEmpty()) {

            Pair<Node, String> pair = stack.pollLast();

            Node curr = pair.first;
            String path = pair.second;

            String separator = (path.equals("")) ? "\n" : " —> ";
            path += (separator + curr.data);

            if (curr.left == null && curr.right == null) {
                System.out.print(path);
            }

            if (curr.right != null) {
                stack.add(Pair.of(curr.right, path));
            }

            if (curr.left != null) {
                stack.add(Pair.of(curr.left, path));
            }
        }
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.left = new Node(8);
        root.right.right.right = new Node(9);

        printRootToleafPathIterative(root);
    }
}