package stringovi;

public class zadatak1 {
    // Dat je tekst S i broj K. Naći palindrom koji se pojavljuje k puta.
    public static String palindromeKTimes(String text, int k)
    {
        String[] wordArray = text.split("\\s+");
        String palindromeWord = null;

        for(String word : wordArray)
        {
            if(isPalindrom(word))
            {
                int frequency = countOccurances(wordArray, word);

                if(frequency == k && (palindromeWord == null))
                    palindromeWord = word;
            }
        }

        return palindromeWord;
    }

    private static boolean isPalindrom(String word)
    {
        String reversed = new StringBuilder(word).reverse().toString();
        return word.equals(reversed);
    }

    private static int countOccurances(String[] wordArray, String target)
    {
        int count = 0;

        for(String word : wordArray)
        {
            if(word.equals(target))
                count++;
        }

        return count;
    }

    public static void main(String[] args) {
        String text = "ana voli milovana milovana voli anu";
        int k = 2;
        System.out.println(palindromeKTimes(text, k));
    }
}
