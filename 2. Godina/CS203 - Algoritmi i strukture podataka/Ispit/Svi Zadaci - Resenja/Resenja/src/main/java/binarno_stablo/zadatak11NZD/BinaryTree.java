package binarno_stablo.zadatak11NZD;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
    public Node root;

    public BinaryTree() {

    }

    public BinaryTree(Node root) {
        this.root = root;
    }

    public void add(int element) {
        root = addRecursively(root, element);
    }

    private Node addRecursively(Node root, int element) {
        if (root == null) {
            root = new Node(element);
            return root;
        } else if (element < root.value) {
            root.left = addRecursively(root.left, element);
            return root;
        } else if (element > root.value) {
            root.right = addRecursively(root.right, element);
            return root;
        }
        return root;
    }

    public void printInorder() {
        printInorder(root);
    }

    private void printInorder(Node root) {
        if (root != null) {
            printInorder(root.left);
            System.out.print(root.value + " ");
            printInorder(root.right);
        }
    }

    public int findGCD(Node root) {
        int left = nodeToInt(findLeftLeaves(root.left, new ArrayList<>()));
        int right = nodeToInt(findRightLeaves(root.right, new ArrayList<>()));
        return gcd(left, right);
    }

    private int nodeToInt(List<Node> list) {
        int n = 1;

        for (Node node : list) {
            n *= node.value;
        }

        return n;
    }

    private List<Node> findLeftLeaves(Node root, List<Node> list) {
        if (root == null) {
            return list;
        } else if (root.left == null && root.right == null) {
            list.add(root);
        }

        findLeftLeaves(root.left, list);
        findLeftLeaves(root.right, list);

        return list;
    }

    private List<Node> findRightLeaves(Node root, List<Node> list) {
        if (root == null) {
            return list;
        } else if (root.left == null && root.right == null) {
            list.add(root);
        }

        findRightLeaves(root.left, list);
        findRightLeaves(root.right, list);

        return list;
    }

    private int gcd(int m, int n) {
        if (m % n == 0) {
            return n;
        } else {
            return gcd(n, m % n);
        }
    }
}
