package binarno_stablo.zadatak5;
// Provera da li je prosecna vrednost listova stabla veca od broja u korenu stabla
public class mejin {
    public static void main(String[] args) {
        BinaryTree tree1 = new BinaryTree();
        tree1.add(5);
        tree1.add(3);
        tree1.add(2);
        tree1.add(1);
        tree1.add(8);
        tree1.add(11);
        tree1.add(4);

        System.out.println("Average of leaves for first tree: " + tree1.averageOfLeaves()); // 5.33
        System.out.println("Is average greater than root value? " + tree1.isGreaterThanRoot()); // true

        BinaryTree tree2 = new BinaryTree();
        tree2.add(8);
        tree2.add(11);
        tree2.add(20);
        tree2.add(3);
        tree2.add(4);
        tree2.add(10);
        tree2.add(7);

        System.out.println("Average of leaves for second tree: " + tree2.averageOfLeaves()); // 12.33
        System.out.println("Is average greater than root value? " + tree2.isGreaterThanRoot()); // true
    }
}
