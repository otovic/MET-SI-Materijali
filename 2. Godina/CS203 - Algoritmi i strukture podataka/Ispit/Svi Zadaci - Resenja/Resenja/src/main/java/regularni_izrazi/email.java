package regularni_izrazi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class email {
    private static final String EMAIL_REGEX = "^[a-zA-Z][a-zA-Z0-9._-]{1,}[a-zA-Z0-9]@[a-zA-Z]+([.][a-zA-Z]+)+$";

    public static void main(String[] args) {
        // Testiranje nekih primera email adresa
        String[] testEmailovi = {
                "ime.prezime@google.com",
                "korisnik123@metropolitan.ac.rs",
                "invalid-email@com",
                "user@domain..com",
                "1user@domain.com",
                "user@domain.c"
        };

        for (String email : testEmailovi) {
            if (proveriEmail(email)) {
                System.out.println(email + " je važeća email adresa.");
            } else {
                System.out.println(email + " nije važeća email adresa.");
            }
        }
    }

    // Metoda koja proverava da li je email validan prema regularnom izrazu
    public static boolean proveriEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
