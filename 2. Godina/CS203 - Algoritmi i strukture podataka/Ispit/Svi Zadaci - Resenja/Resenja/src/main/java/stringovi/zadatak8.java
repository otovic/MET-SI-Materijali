package stringovi;
// Pronalazenje najduzeg podstringa sacinjenog samo od zadatog karaktera
// Stampanje pocetne pozicije podstringa, kao i njegove duzine
public class zadatak8 {
    public static void main(String[] args) {

        String str = "aatagggacccaggcatt";
        char ch = 'g';
        System.out.println(str.indexOf(ch) + " " + getLength(str, ch)); // 4 3

    }

    private static int getLength(String str, char ch) {
        int length = 0;

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1) && str.charAt(i) == ch) {
                length++;
            }
        }

        return length;
    }
}
