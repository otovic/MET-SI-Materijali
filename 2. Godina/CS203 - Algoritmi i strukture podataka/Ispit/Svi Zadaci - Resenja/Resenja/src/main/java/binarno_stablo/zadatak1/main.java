package binarno_stablo.zadatak1;

//Napisati metod koji u binarnom stablu pretrage sabira sve elemente koji se nalaze na putu od
//        korena do zadatog čvora.

public class main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Dodajemo čvorove u binarno stablo pretrage
        tree.root = new TreeNode(10);
        tree.root.left = new TreeNode(5);
        tree.root.right = new TreeNode(20);
        tree.root.left.left = new TreeNode(3);
        tree.root.left.right = new TreeNode(7);
        tree.root.right.left = new TreeNode(15);
        tree.root.right.right = new TreeNode(30);

        // Pretpostavimo da želimo naći sumu od korena do čvora sa vrednošću 7
        int target = 7;
        int sum = tree.sumPathToNode(tree.root, target);

        if (sum != 0) {
            System.out.println("Suma elemenata na putu do čvora " + target + " je: " + sum);
        } else {
            System.out.println("Čvor sa vrednošću " + target + " nije pronađen u stablu.");
        }
    }
}
