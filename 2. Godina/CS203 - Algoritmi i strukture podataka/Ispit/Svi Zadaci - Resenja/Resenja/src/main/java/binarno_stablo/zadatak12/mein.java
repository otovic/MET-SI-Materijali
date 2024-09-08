package binarno_stablo.zadatak12;
// Provera da li je prosecna vrednost unutrasnjih cvorova (koji nisu listovi) stabla manja od broja u korenu stabla
public class mein {
    public static void main(String[] args) {

        BinaryTree tree1 = new BinaryTree();
        tree1.add(5);
        tree1.add(3);
        tree1.add(2);
        tree1.add(1);
        tree1.add(8);
        tree1.add(11);
        tree1.add(4);

        System.out.println("Average of non leaves for first tree: " + tree1.averageOfNonLeaves()); // 4.5
        System.out.println("Is average smaller than root value? " + tree1.isSmallerThanRoot()); // true (4.5 < 5)

        BinaryTree tree2 = new BinaryTree();
        tree2.add(5);
        tree2.add(3);
        tree2.add(10);
        tree2.add(2);
        tree2.add(15);

        System.out.println("Average of non leaves for second tree: " + tree2.averageOfNonLeaves()); // 6.0
        System.out.println("Is average smaller than root value? " + tree2.isSmallerThanRoot()); // false (6.0 > 5)

    }
}
