package binarno_stablo.zadatak2;

//dato je binarno stablo celih brojeva. napisati funkciju koja ce izracunati zbit sadrzaja unutrsanjih cvorova stabla. (cvorova koji nisu listovi)

public class mejn {
    public static void main(String[] args) {
        // Kreiranje stabla za testiranje
        Cvor koren = new Cvor(10);
        koren.levo = new Cvor(5);
        koren.desno = new Cvor(15);
        koren.levo.levo = new Cvor(2);
        koren.levo.desno = new Cvor(7);
        koren.desno.desno = new Cvor(20);

        // Izračunavanje zbira unutrašnjih čvorova
        int zbir = zbirUnutrasnjihCvorova(koren);
        System.out.println("Zbir sadržaja unutrašnjih čvorova je: " + zbir);
    }

    // Metoda koja izračunava zbir sadržaja unutrašnjih čvorova
    public static int zbirUnutrasnjihCvorova(Cvor koren) {
        if (koren == null) {
            return 0;
        }

        // Ako čvor ima bar jedno dete, on je unutrašnji čvor
        boolean jeUnutrasnji = (koren.levo != null || koren.desno != null);

        // Ako je čvor unutrašnji, uključujemo njegovu vrednost u zbir
        int zbir = jeUnutrasnji ? koren.vrednost : 0;

        // Rekurzivno dodajemo zbir iz leve i desne grane
        zbir += zbirUnutrasnjihCvorova(koren.levo);
        zbir += zbirUnutrasnjihCvorova(koren.desno);

        return zbir;
    }
}
