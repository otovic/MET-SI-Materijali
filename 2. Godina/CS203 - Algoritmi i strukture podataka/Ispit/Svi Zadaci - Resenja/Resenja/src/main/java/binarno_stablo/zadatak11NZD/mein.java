package binarno_stablo.zadatak11NZD;
// Izracunavanje NZD-a proizvoda svih levih listova i proizvoda svih desnih listova
public class mein {
    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();
        tree.add(10);
        tree.add(4);
        tree.add(3);
        tree.add(5);
        tree.add(6);
        tree.add(15);
        tree.add(16);
        tree.add(18);

        System.out.print("Inorder obilazak stabla -> ");
        tree.printInorder(); // 3 4 5 6 10 15 16 18
        System.out.println();

        System.out.println("GCD is: " + tree.findGCD(tree.root)); // 18 ^ 18 -> 18

    }
}
