package binarno_stablo.zadatak7;
// Provera da li je zbir listova stabla prost broj
public class mejin {
    public static void main(String[] args) {

        BinaryTree tree1 = new BinaryTree();
        tree1.add(5);
        tree1.add(3);
        tree1.add(2);
        tree1.add(1);
        tree1.add(8);
        tree1.add(12);
        tree1.add(4);

        System.out.println("Sum of leaves for first tree: " + tree1.sumOfLeaves()); // 17
        System.out.println("Is sum of leaves prime number? " + tree1.isPrimeNumber(tree1.sumOfLeaves())); // true

        BinaryTree tree2 = new BinaryTree();
        tree2.add(8);
        tree2.add(11);
        tree2.add(15);
        tree2.add(3);
        tree2.add(4);
        tree2.add(10);
        tree2.add(7);

        System.out.println("Sum of leaves for second tree: " + tree2.sumOfLeaves()); // 32
        System.out.println("Is sum of leaves prime number? " + tree2.isPrimeNumber(tree2.sumOfLeaves())); // false

    }
}
