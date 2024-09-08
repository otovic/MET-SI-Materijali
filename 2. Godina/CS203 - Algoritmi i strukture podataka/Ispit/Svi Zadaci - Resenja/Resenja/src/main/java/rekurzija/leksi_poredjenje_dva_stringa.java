package rekurzija;

public class leksi_poredjenje_dva_stringa {
    public static void main(String[] args) {

        try {

            System.out.println(compareStrings("Program", "Pista")); // 1
            System.out.println(compareStrings("Auto", "Auto")); // 0
            System.out.println(compareStrings("Start", "Stop")); // -1

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private static int compareStrings(String str1, String str2) {
        if (((str1.charAt(0) == str2.charAt(0)) && str1.length() > 1 && str2.length() == 1) || str1.charAt(0) > str2.charAt(0)) {
            return 1;
        } else if (((str1.charAt(0) == str2.charAt(0)) && str2.length() > 1 && str1.length() == 1) || str1.charAt(0) < str2.charAt(0)) {
            return -1;
        } else if (str1.length() == 1 && str2.length() == 1) {
            return 0;
        } else {
            return compareStrings(str1.substring(1), str2.substring(1));
        }
    }
}
