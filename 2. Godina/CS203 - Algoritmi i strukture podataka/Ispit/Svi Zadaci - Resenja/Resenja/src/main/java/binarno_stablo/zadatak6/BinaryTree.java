package binarno_stablo.zadatak6;

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

    public int sumOfLeaves() {
        return sumOfLeaves(root);
    }

    private int sumOfLeaves(Node root) {
        if (root == null) {
            return 0;
        } else if (root.getLeft() == null && root.getRight() == null) {
            return root.getValue();
        } else {
            return sumOfLeaves(root.getLeft()) + sumOfLeaves(root.getRight());
        }
    }

    public boolean isDivisible() {
        return isDivisible(root);
    }

    private boolean isDivisible(Node root) {
        if (sumOfLeaves() % root.getValue() == 0) {
            return true;
        } else {
            return false;
        }
    }
}
