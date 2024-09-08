package binarno_stablo.zadatak6;
// Provera da li je zbir svih vrednosti listova stabla deljiv sa brojem u korenu stabla
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

        System.out.println("Sum of leaves for first tree: " + tree1.sumOfLeaves()); // 16
        System.out.println("Is sum divisible by the root value? " + tree1.isDivisible()); // false

        BinaryTree tree2 = new BinaryTree();
        tree2.add(8);
        tree2.add(11);
        tree2.add(15);
        tree2.add(3);
        tree2.add(4);
        tree2.add(10);
        tree2.add(7);

        System.out.println("Sum of leaves for second tree: " + tree2.sumOfLeaves()); // 32
        System.out.println("Is sum divisible by the root value? " + tree2.isDivisible()); // true
    }
}
