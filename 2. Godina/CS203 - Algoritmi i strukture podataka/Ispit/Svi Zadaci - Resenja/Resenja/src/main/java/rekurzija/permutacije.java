package rekurzija;

public class permutacije {
    private static void permute(String str, int l, int r) {
        // Kada su svi karakteri u permutaciji, štampaj rezultat
        if (l == r) {
            System.out.println(str);
        } else {
            // Rekurzivno generiši permutacije za sve karaktere
            for (int i = l; i <= r; i++) {
                // Zameni trenutni karakter sa početnim karakterom
                str = swap(str, l, i);
                // Rekurzivno generiši permutacije za preostale karaktere
                permute(str, l + 1, r);
                // Vratiti string na prethodno stanje
                str = swap(str, l, i);
            }
        }
    }

    // Metod za zamenu karaktera na pozicijama i i j
    private static String swap(String str, int i, int j) {
        char[] charArray = str.toCharArray();
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return new String(charArray);
    }

    public static void main(String[] args) {
        String str = "ABC"; // Primer stringa
        int n = str.length();
        permute(str, 0, n - 1);
    }
}
