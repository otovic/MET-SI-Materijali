package binarno_stablo.zadatak13;

import java.util.List;

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

    public List<Node> toSortedList(List<Node> list, int indicator) {
        return toSortedList(root, list, indicator);
    }

    private List<Node> toSortedList(Node root, List<Node> list, int indicator) {
        if (root == null) {
            return null;
        }

        if (indicator == 1) {
            toSortedList(root.getLeft(), list, indicator);
            list.add(root);
            toSortedList(root.getRight(), list, indicator);
        } else if (indicator == 2) {
            toSortedList(root.getRight(), list, indicator);
            list.add(root);
            toSortedList(root.getLeft(), list, indicator);
        } else {
            System.out.println("Wrong indicator!");
            System.exit(0);
        }

        return list;
    }
}
