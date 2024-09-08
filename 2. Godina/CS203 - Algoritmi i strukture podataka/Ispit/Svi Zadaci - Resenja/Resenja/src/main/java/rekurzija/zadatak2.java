package rekurzija;

//Napisati rekurzivnu metodu koja za uneti celi broj vraća novi broj koji se sastoji samo od parnih
//        cifara unetog broja.
//        Ulaz: 1234567
//        Izlaz: 246

public class zadatak2 {
    public static int izdvojiParneCifre(int broj) {
        // Bazni slučaj: ako je broj 0, vrati 0
        if (broj == 0) {
            return 0;
        }

        // Izdvajamo poslednju cifru
        int poslednjaCifra = broj % 10;

        // Ako je poslednja cifra parna, uključi je u rezultat
        if (poslednjaCifra % 2 == 0) {
            // Rekurzivno pozivamo za preostale cifre i dodajemo parnu cifru na kraj
            return izdvojiParneCifre(broj / 10) * 10 + poslednjaCifra;
        } else {
            // Ako nije parna, jednostavno rekurzivno pozivamo za preostale cifre
            return izdvojiParneCifre(broj / 10);
        }
    }

    public static void main(String[] args) {
        int broj = 1234567;
        int rezultat = izdvojiParneCifre(broj);
        System.out.println("Broj sastavljen samo od parnih cifara: " + rezultat);
    }
}
