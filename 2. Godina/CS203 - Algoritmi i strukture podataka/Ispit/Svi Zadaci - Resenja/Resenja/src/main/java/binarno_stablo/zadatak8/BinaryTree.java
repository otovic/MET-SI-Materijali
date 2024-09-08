package binarno_stablo.zadatak8;

public class BinaryTree {
    private Node root;

    public BinaryTree() {

    }

    public BinaryTree(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public void add(int element) {
        root = addRecursively(root, element);
    }

    private Node addRecursively(Node root, int element) {
        if (root == null) {
            root = new Node(element);
            return root;
        } else if (element < root.getValue()) {
            root.setLeft(addRecursively(root.getLeft(), element));
            return root;
        } else if (element > root.getValue()) {
            root.setRight(addRecursively(root.getRight(), element));
            return root;
        }
        return root;
    }

    public void printInorder() {
        printRecInorder(root);
    }

    private void printRecInorder(Node root) {
        if (root == null) {
            return;
        }

        printRecInorder(root.getLeft());
        System.out.print(root.getValue() + " ");
        printRecInorder(root.getRight());
    }

    public int nodesGreaterThanX(int element) {
        return nodesGreaterThanX(root, element);
    }

    private int nodesGreaterThanX(Node root, int element) {
        if (root == null) {
            return 0;
        }

        int countLeft = nodesGreaterThanX(root.getLeft(), element);
        int countRight = nodesGreaterThanX(root.getRight(), element);

        return (root.getValue() > element ? 1 : 0) + countLeft + countRight;
    }
}
