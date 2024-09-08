package binarno_stablo.zadatak4;

//napisati program koji proverava u binarnom stablu pretrage da li je zbir svih vrednosti listova stabla deljiv sa brojem u koreu stabla

public class zadatak4 {
    public static void main(String[] args) {
        // Kreiranje primjera binarnog stabla
        BinarySearchTree bst = new BinarySearchTree();
        bst.root = new BinarySearchTree.TreeNode(5); // Koreni čvor

        bst.root.left = new BinarySearchTree.TreeNode(3);
        bst.root.right = new BinarySearchTree.TreeNode(8);

        bst.root.left.left = new BinarySearchTree.TreeNode(1);
        bst.root.left.right = new BinarySearchTree.TreeNode(4);
        bst.root.right.left = new BinarySearchTree.TreeNode(7);
        bst.root.right.right = new BinarySearchTree.TreeNode(9);

        // Proverava da li je zbir listova deljiv sa vrednošću u korenu
        boolean result = bst.isSumOfLeavesDivisibleByRoot();
        System.out.println("Da li je zbir svih listova deljiv sa brojem u korenu? " + result);
    }
}
