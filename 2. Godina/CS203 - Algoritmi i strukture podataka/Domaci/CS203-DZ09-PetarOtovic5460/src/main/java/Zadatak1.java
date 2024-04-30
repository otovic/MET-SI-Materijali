public class Zadatak1 {
    public static void main(String[] args) {
        DrvoNoud root = new DrvoNoud(1);
        root.left = new DrvoNoud(2);
        root.right = new DrvoNoud(3);
        root.left.left = new DrvoNoud(4);
        root.left.right = new DrvoNoud(5);
        root.right.left = new DrvoNoud(6);
        root.right.right = new DrvoNoud(7);

        int sumLeft = DrvoUtils.sumaLevihListova(root);
        int sumRight = DrvoUtils.sumaDesnihListova(root);

        System.out.println("Suma levih listova: " + sumLeft);
        System.out.println("Suma desnih listova: " + sumRight);
    }
}
