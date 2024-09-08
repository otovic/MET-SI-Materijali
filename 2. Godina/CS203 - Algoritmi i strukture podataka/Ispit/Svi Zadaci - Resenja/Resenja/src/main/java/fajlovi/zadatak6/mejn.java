package fajlovi.zadatak6;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//napisati program koji iz fajla ulaz.txt ucitava reci sortira ih po duzini opadajuce i sortiranu
// listu reci zapisuje u fajl izlaz.txt. sortiranje izvrsiti implemetacijom seleksn sorta

public class mejn {
    public static void main(String[] args) {
        String inputFilePath = "D:\\CS202-Resenja\\Resenja\\src\\main\\java\\fajlovi\\zadatak6\\ulaz.txt";
        String outputFilePath = "D:\\CS202-Resenja\\Resenja\\src\\main\\java\\fajlovi\\zadatak6\\izlaz.txt";

        try {
            // Učitaj reči iz fajla
            List<String> words = loadWordsFromFile(inputFilePath);

            // Sortiraj reči koristeći Selection Sort
            selectionSort(words);

            // Zapiši sortirane reči u fajl
            writeWordsToFile(outputFilePath, words);

            System.out.println("Reči su uspešno sortirane i upisane u fajl.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Učitavanje reči iz fajla
    private static List<String> loadWordsFromFile(String filePath) throws IOException {
        List<String> words = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] lineWords = line.split("\\s+");
                Collections.addAll(words, lineWords);
            }
        }
        return words;
    }

    // Sortiranje reči koristeći Selection Sort
    private static void selectionSort(List<String> words) {
        int n = words.size();
        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (words.get(j).length() > words.get(maxIndex).length()) {
                    maxIndex = j;
                }
            }
            // Zameni reči na pozicijama i i maxIndex
            Collections.swap(words, i, maxIndex);
        }
    }

    // Zapisivanje reči u fajl
    private static void writeWordsToFile(String filePath, List<String> words) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (String word : words) {
                bw.write(word);
                bw.newLine();
            }
        }
    }
}
