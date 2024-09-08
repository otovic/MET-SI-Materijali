package fajlovi.zadatak7;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Iz fajla se ucitava lista studenata sa prosecnim ocenama
// U jednom redu je zapisan indeks studenta i prosecna ocena
// Formiranje binarnog stabla od ucitanih podataka
// Pretraga studenata po indeksu
// Prikaz studenta sa najvecom prosecnom ocenom
public class mejin {
    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();
        List<Node> nodeList = new ArrayList<>();
        Node root;

        try {

            BufferedReader reader = new BufferedReader(new FileReader("D:\\CS202-Resenja\\Resenja\\src\\main\\java\\fajlovi\\zadatak7\\studenti.txt"));
            String s = "";
            while ((s = reader.readLine()) != null) {
                String[] array = s.split("[ ]");
                System.out.println(array[0] + " " + array[1]);
                nodeList.add(new Node(Integer.parseInt(array[0]), Double.parseDouble(array[1])));
            }

            reader.close();

            root = nodeList.get(0);
            for (int i = 1; i < nodeList.size(); i++) {
                tree.insert(root, nodeList.get(i));
            }

            System.out.print("Trazim indeks: ");
            System.out.println(tree.findNode(root, 5460));
            System.out.println("Najveci prosek: " + tree.getHighest(root));

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
