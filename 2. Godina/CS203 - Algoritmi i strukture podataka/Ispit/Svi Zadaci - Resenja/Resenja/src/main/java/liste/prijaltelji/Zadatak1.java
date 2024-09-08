package liste.prijaltelji;

// Prijatelji sede za kruznim stolom
// Listom je dat njihov redosled sedenja
// Ispisati redosled napustanja stola


import static liste.prijaltelji.Node.addNode;
import static liste.prijaltelji.Node.deleteKthNode;

public class Zadatak1 {

    public static void main(String[] args) {

        Node list = null;

        list = addNode(list, "Sasa");
        list = addNode(list, "David");
        list = addNode(list, "Milica");
        list = addNode(list, "Andjela");

        System.out.println("Before leaving the table: ");
        list.print(list);

        System.out.println("---------------------------------------");

        int k = 1;
        System.out.println("Process of leaving the table: ");
        list = deleteKthNode(list, k);
    }

}
