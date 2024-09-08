package fajlovi.zadatak4;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//tekst ucitan iz fajla input.txt ubaciti u listu reci. Iz formirane liste izbaciti sve duplikate te reci i ostaviti samo prvo pojavljivanje

public class mejn {
    public static void main(String[] args) {
        String filePath = "D:\\CS202-Resenja\\Resenja\\src\\main\\java\\fajlovi\\zadatak4\\input.txt"; // Putanja do vašeg fajla
        List<String> wordList = new ArrayList<>();
        Set<String> seenWords = new HashSet<>();

        // Učitavanje reči iz fajla
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Podeli liniju na reči i dodaj ih u listu
                String[] words = line.split("\\s+");
                for (String word : words) {
                    // Dodaj reč u listu ako nije viđena pre
                    if (seenWords.add(word)) {
                        wordList.add(word);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Ispis reči bez duplikata
        for (String word : wordList) {
            System.out.println(word);
        }

        // Ako želite da sačuvate rezultat u fajl, možete dodati sledeći deo:
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"))) {
            for (String word : wordList) {
                bw.write(word);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
