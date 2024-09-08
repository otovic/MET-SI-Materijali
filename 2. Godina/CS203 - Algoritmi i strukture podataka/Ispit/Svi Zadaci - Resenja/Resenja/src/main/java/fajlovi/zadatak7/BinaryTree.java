package fajlovi.zadatak7;

public class BinaryTree {
    Node root;

    public BinaryTree() {

    }

    public BinaryTree(Node root) {
        this.root = root;
    }

    public void insert(Node root, Node element) {
        if (element.average < root.average) {
            if (root.left != null) {
                insert(root.left, element);
            } else {
                root.left = new Node(element.index, element.average);
            }
        } else if (element.average > root.average) {
            if (root.right != null) {
                insert(root.right, element);
            } else {
                root.right = new Node(element.index, element.average);
            }
        }
    }

    public void printInorder(Node root) {
        if (root != null) {
            printInorder(root.left);
            System.out.print(" " + root.toString());
            printInorder(root.right);
        }
    }

    public Node findNode(Node root, int index) {
        if (root == null) {
            return null;
        }

        if (root.index == index) {
            return root;
        }

        Node leftFind = findNode(root.left, index);
        if (leftFind != null) {
            return leftFind;
        }

        Node rightFind = findNode(root.right, index);
        return rightFind;
    }

    public void cloneTree(Node root, Node element) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            element.left = new Node();
            element.left.index = root.left.index;
            element.left.average = root.left.average;
            cloneTree(root.left, element.left);
        }

        if (root.right != null) {
            element.right = new Node();
            element.right.index = root.right.index;
            element.right.average = root.right.average;
            cloneTree(root.right, element.right);
        }

    }

    public int countLeaves(Node root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return 1;
        } else {
            return countLeaves(root.left) + countLeaves(root.right);
        }
    }

    public Node getHighest(Node root) {
        Node current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current;
    }
}
