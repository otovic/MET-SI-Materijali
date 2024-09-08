package fajlovi.zadatak5;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

//napisati program koji iz fajla ulaz.txt ucitava sve reci i sortira ih po duzini opadajuce i sortiranu listu reci
// zapisuje u fajl izlaz.txt sortiranje izvrsiti selection sortom
public class majn {
    public static void main(String[] args) {
        String inputFilePath = "D:\\CS202-Resenja\\Resenja\\src\\main\\java\\fajlovi\\zadatak5\\ulaz.txt"; // Putanja do ulaznog fajla
        String outputFilePath = "D:\\CS202-Resenja\\Resenja\\src\\main\\java\\fajlovi\\zadatak5\\izlaz.txt"; // Putanja do izlaznog fajla

        List<String> words = new ArrayList<>();

        // Učitavanje reči iz fajla
        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Podeli liniju na reči i dodaj ih u listu
                String[] lineWords = line.split("\\s+");
                for (String word : lineWords) {
                    words.add(word);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Sortiranje reči po dužini opadajuće koristeći Selection Sort
        selectionSort(words);

        // Upis sortirane liste reči u fajl
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath))) {
            for (String word : words) {
                bw.write(word);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Implementacija Selection Sort algoritma za sortiranje reči po dužini
    private static void selectionSort(List<String> words) {
        int n = words.size();
        for (int i = 0; i < n - 1; i++) {
            // Pretpostavimo da je trenutni minimum prvi ne-sortirani element
            int maxIndex = i;
            for (int j = i + 1; j < n; j++) {
                // Pronađi najveći element u preostalom delu liste
                if (words.get(j).length() > words.get(maxIndex).length()) {
                    maxIndex = j;
                }
            }
            // Zameni pronađeni najveći element sa prvim ne-sortiranim elementom
            String temp = words.get(maxIndex);
            words.set(maxIndex, words.get(i));
            words.set(i, temp);
        }
    }
}
