package binarno_stablo.zadatak12;

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

    public int countNonLeaves() {
        return countNonLeaves(root);
    }

    private int countNonLeaves(Node root) {
        if (root == null || (root.getLeft() == null && root.getRight() == null)) {
            return 0;
        }

        return 1 + countNonLeaves(root.getLeft()) + countNonLeaves(root.getRight());
    }

    public int sumOfNonLeaves() {
        return sumOfNonLeaves(root);
    }

    private int sumOfNonLeaves(Node root) {
        if (root == null || (root.getLeft() == null && root.getRight() == null)) {
            return 0;
        }

        return root.getValue() + sumOfNonLeaves(root.getLeft()) + sumOfNonLeaves(root.getRight());
    }

    public double averageOfNonLeaves() {
        return (double) sumOfNonLeaves() / countNonLeaves();
    }

    public boolean isSmallerThanRoot() {
        return isSmallerThanRoot(root);
    }

    private boolean isSmallerThanRoot(Node root) {
        if (averageOfNonLeaves() < root.getValue()) {
            return true;
        } else {
            return false;
        }
    }
}
