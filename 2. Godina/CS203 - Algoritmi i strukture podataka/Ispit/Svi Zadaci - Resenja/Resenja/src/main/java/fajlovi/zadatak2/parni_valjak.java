package fajlovi.zadatak2;

//Napisati program koji iz fajla ulaz.txt učitava binarne stringove (svaki string je u jednoj liniji
//        teksta), sortira ih po broju jedinica, i sortiranu listu stringova zapisuje u fajl izlaz.txt. Sortiranje
//        izvršiti implementacijom selection sort-a.


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class parni_valjak {
    public static void main(String[] args) {
        List<String> binarniStringovi = new ArrayList<>();

        // Čitanje binarnih stringova iz fajla ulaz.txt
        try (BufferedReader reader = new BufferedReader(new FileReader("D:\\CS202-Resenja\\Resenja\\src\\main\\java\\fajlovi\\zadatak2\\ulaz.txt"))) {
            String linija;
            while ((linija = reader.readLine()) != null) {
                binarniStringovi.add(linija);
            }
        } catch (IOException e) {
            System.out.println("Greška pri čitanju fajla: " + e.getMessage());
        }

        // Sortiranje binarnih stringova po broju jedinica koristeći Selection Sort
        selectionSort(binarniStringovi);

        // Upis sortirane liste u fajl izlaz.txt
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("izlaz.txt"))) {
            for (String binarniString : binarniStringovi) {
                writer.write(binarniString);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Greška pri upisu u fajl: " + e.getMessage());
        }
    }

    // Implementacija Selection Sort-a
    public static void selectionSort(List<String> lista) {
        for (int i = 0; i < lista.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < lista.size(); j++) {
                if (brojJedinica(lista.get(j)) < brojJedinica(lista.get(minIndex))) {
                    minIndex = j;
                }
            }
            // Zamena stringova na pozicijama i i minIndex
            String temp = lista.get(i);
            lista.set(i, lista.get(minIndex));
            lista.set(minIndex, temp);
        }
    }

    // Metoda koja broji broj jedinica u binarnom stringu
    public static int brojJedinica(String binarniString) {
        int count = 0;
        for (char c : binarniString.toCharArray()) {
            if (c == '1') {
                count++;
            }
        }
        return count;
    }
}
