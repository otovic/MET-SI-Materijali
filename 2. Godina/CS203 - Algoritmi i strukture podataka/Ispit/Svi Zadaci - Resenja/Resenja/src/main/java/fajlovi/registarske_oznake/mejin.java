package fajlovi.registarske_oznake;

//napisati program koji ucitava podatke o registarskim oznakama iz fajla u formatu AB-123-CD.
// Sortirati registracije po oznaci grada leksikoografski.
// soritranje pomocu quick sorta. grad su prva dva slova u registarskim oznakama

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class mejin {
    // Metod za učitavanje registarskih oznaka iz fajla
    public static String[] loadRegistrations(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        StringBuilder builder = new StringBuilder();

        while ((line = reader.readLine()) != null) {
            builder.append(line).append("\n");
        }

        reader.close();
        return builder.toString().split("\\s+");
    }

    // Metod za dobijanje oznake grada
    private static String getCityCode(String registration) {
        return registration.substring(0, 2);
    }

    // Metod za Quick Sort
    private static void quickSort(String[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    // Metod za particionisanje niza
    private static int partition(String[] array, int low, int high) {
        String pivot = getCityCode(array[high]);
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (getCityCode(array[j]).compareTo(pivot) <= 0) {
                i++;
                // Swap array[i] and array[j]
                String temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        // Swap array[i + 1] and array[high]
        String temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        try {
            // Putanja do fajla
            String filePath = "D:\\CS202-Resenja\\Resenja\\src\\main\\java\\fajlovi\\registarske_oznake\\oznake.txt";

            // Učitavanje registarskih oznaka
            String[] registrations = loadRegistrations(filePath);

            // Sortiranje registarskih oznaka
            quickSort(registrations, 0, registrations.length - 1);

            // Ispis sortirane liste registarskih oznaka
            for (String registration : registrations) {
                System.out.println(registration);
            }

        } catch (IOException e) {
            System.err.println("Greška pri čitanju fajla: " + e.getMessage());
        }
    }
}
