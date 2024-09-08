package binarno_stablo.zadatak4;

public class BinarySearchTree {
    static class TreeNode {
        int value;
        TreeNode left, right;

        TreeNode(int item) {
            value = item;
            left = right = null;
        }
    }

    TreeNode root;

    // Metod za prikupljanje zbir svih listova
    private int sumOfLeaves(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // Ako je čvor list, vraća njegovu vrednost
        if (node.left == null && node.right == null) {
            return node.value;
        }

        // Rekurzivno sabira listove u levo i desno podstablo
        return sumOfLeaves(node.left) + sumOfLeaves(node.right);
    }

    // Metod za proveru da li je zbir listova deljiv sa vrednošću u korenu
    public boolean isSumOfLeavesDivisibleByRoot() {
        if (root == null) {
            throw new IllegalStateException("Stablo je prazno");
        }

        int sumOfLeaves = sumOfLeaves(root);
        return sumOfLeaves % root.value == 0;
    }
}
