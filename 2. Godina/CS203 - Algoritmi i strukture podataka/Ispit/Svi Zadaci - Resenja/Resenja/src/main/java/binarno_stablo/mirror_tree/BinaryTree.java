package binarno_stablo.mirror_tree;

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

    public void mirror() {
        root = mirror(root);
    }

    private Node mirror(Node root) {
        if (root == null) {
            return root;
        }

        Node left = mirror(root.left);
        Node right = mirror(root.right);

        root.left = right;
        root.right = left;

        return root;
    }
}
