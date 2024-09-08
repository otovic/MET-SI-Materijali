package rekurzija;

//napisati rekurzivnu funckiju koja broji koliko ima karaktera koji nisu slova u stringu

public class zadatak3 {
    public static int countNonLetters(String str) {
        return countNonLettersHelper(str, 0);
    }

    // Pomoćna rekurzivna funkcija
    private static int countNonLettersHelper(String str, int index) {
        // Ako je indeks veći ili jednak dužini stringa, vraćamo 0 (kraj rekurzije)
        if (index >= str.length()) {
            return 0;
        }

        // Trenutni karakter
        char currentChar = str.charAt(index);

        // Proveravamo da li je trenutni karakter slovo
        boolean isLetter = Character.isLetter(currentChar);

        // Ako trenutni karakter nije slovo, dodajemo 1, inače dodajemo 0
        int count = isLetter ? 0 : 1;

        // Rekurzivno pozivanje za sledeći karakter
        return count + countNonLettersHelper(str, index + 1);
    }

    public static void main(String[] args) {
        // Testiranje funkcije
        String testString = "Hello, World! 123";
        int nonLetterCount = countNonLetters(testString);
        System.out.println("Broj karaktera koji nisu slova: " + nonLetterCount);
    }
}
