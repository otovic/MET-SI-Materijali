package rekurzija;

//Napisati rekurzivnu funkciju koja određuje koliko puta su u sringu dva susedna karaktera ista.
//        Primer:
//        Ulaz: aataggaccc
//        Izlaz: 4

public class zadatak1 {
    public static int countAdjacentDuplicates(String str, int index) {
        // Bazni slučaj: ako smo došli do kraja stringa, nema više parova za poređenje
        if (index >= str.length() - 1) {
            return 0;
        }

        // Poređenje trenutnog karaktera sa sledećim
        if (str.charAt(index) == str.charAt(index + 1)) {
            // Ako su isti, povećaj brojač i nastavi sa preostalim stringom
            return 1 + countAdjacentDuplicates(str, index + 1);
        } else {
            // Ako nisu isti, nastavi sa preostalim stringom bez povećanja brojača
            return countAdjacentDuplicates(str, index + 1);
        }
    }

    public static void main(String[] args) {
        String input = "aataggaccc";
        int result = countAdjacentDuplicates(input, 0);
        System.out.println("Broj susednih duplikata u stringu je: " + result);
    }
}
