package liste.zadatak2;

// Izbacivanje svih elemenata koji se ponavljaju iz kruzne liste celih brojeva, ostavljajuci njihovo prvo pojavljivanje

// Ispit: Oktobar 2020

public class zadatak2 {

    public static void main(String[] args) {

        CircularList list = new CircularList();

        list.add(1);
        list.add(2);
        list.add(1);
        list.add(5);
        list.add(5);
        list.add(1);

        System.out.println("Initial list: ");
        list.print();

        list.deleteDuplicates();

        System.out.println("List without duplicates: ");
        list.print();

    }

}
