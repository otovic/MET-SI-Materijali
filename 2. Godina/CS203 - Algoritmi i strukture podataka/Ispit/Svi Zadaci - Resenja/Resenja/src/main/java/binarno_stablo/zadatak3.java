package binarno_stablo;

//dato je binarno stablo celih brojeva N.
// napisati funkciju koja ce izracunati koliko listova stable ima vecu vrednost od unetog broja

public class zadatak3 {
    static class TreeNode {
        int value;
        TreeNode left, right;

        TreeNode(int item) {
            value = item;
            left = right = null;
        }
    }

    // Funkcija koja izračunava koliko listova ima veću vrednost od datog broja
    public static int countLeavesGreaterThan(TreeNode root, int number) {
        // Poziv pomoćne rekurzivne funkcije
        return countLeavesGreaterThanHelper(root, number);
    }

    // Pomoćna rekurzivna funkcija
    private static int countLeavesGreaterThanHelper(TreeNode node, int number) {
        // Ako je trenutni čvor null, nema listova
        if (node == null) {
            return 0;
        }

        // Ako je trenutni čvor list
        if (node.left == null && node.right == null) {
            // Vraća 1 ako je vrednost lista veća od broja, inače 0
            return node.value > number ? 1 : 0;
        }

        // Rekurzivno pozivanje za levo i desno podstablo
        return countLeavesGreaterThanHelper(node.left, number) +
                countLeavesGreaterThanHelper(node.right, number);
    }

    public static void main(String[] args) {
        // Kreiranje primer binarnog stabla
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(18);

        // Uneti broj
        int number = 8;

        // Izračunavanje broja listova sa većom vrednošću od unetog broja
        int count = countLeavesGreaterThan(root, number);
        System.out.println("Broj listova sa većom vrednošću od " + number + " je: " + count);
    }
}
