package fajlovi.zadatak13;

// Iz fajla se ucitavaju reci
// Reci se sortiraju rastuce i sortirana lista reci se zapisuje u fajl
// Primena Quick Sort-a

// Ispit: Jun A 2021

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Zadatak6 {

    public static void main(String[] args) {

        String[] array = new String[]{};

        try {

            BufferedReader reader = new BufferedReader(new FileReader("D:\\CS202-Resenja\\Resenja\\src\\main\\java\\fajlovi\\zadatak13\\asd.txt"));
            String line = "";
            System.out.println("Words from file: ");

            while ((line = reader.readLine()) != null) {
                array = line.split("-");
                System.out.println(Arrays.toString(array));
            }

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        quickSort(array, 0, array.length - 1);
        writeToFile(array);

    }

    private static void quickSort(String[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int partition(String[] arr, int low, int high) {
        String pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {
            if (arr[j].compareTo(pivot) < 0) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return (i + 1);
    }

    private static void writeToFile(String[] array) {

        try {

            FileWriter writer = new FileWriter("S6-2.txt");

            for (String s : array) {
                writer.write(s + " ");
            }

            writer.close();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
