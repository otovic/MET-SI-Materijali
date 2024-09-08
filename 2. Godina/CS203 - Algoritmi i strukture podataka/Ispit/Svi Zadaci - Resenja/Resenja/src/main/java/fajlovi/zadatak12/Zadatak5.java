package fajlovi.zadatak12;

// Iz fajla se ucitavaju reci
// Reci se sortiraju rastuce i sortirana lista reci se zapisuje u fajl
// Primena Merge Sort-a

// Ispit: April 2021

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Zadatak5 {

    public static void main(String[] args) {

        String[] array = new String[]{};

        try {

            BufferedReader reader = new BufferedReader(new FileReader("D:\\CS202-Resenja\\Resenja\\src\\main\\java\\fajlovi\\zadatak12\\reci.txt"));
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

        mergeSort(array);
        writeToFile(array);

    }

    private static void mergeSort(String[] array) {
        if (array.length >= 2) {
            String[] left = new String[array.length / 2];
            String[] right = new String[array.length - array.length / 2];

            for (int i = 0; i < left.length; i++) {
                left[i] = array[i];
            }

            for (int i = 0; i < right.length; i++) {
                right[i] = array[i + array.length / 2];
            }

            mergeSort(left);
            mergeSort(right);
            merge(array, left, right);
        }
    }

    private static void merge(String[] array, String[] left, String[] right) {
        int a = 0;
        int b = 0;

        for (int i = 0; i < array.length; i++) {
            if (b >= right.length || (a < left.length && left[a].compareToIgnoreCase(right[b]) < 0)) {
                array[i] = left[a];
                a++;
            } else {
                array[i] = right[b];
                b++;
            }
        }
    }

    private static void writeToFile(String[] array) {

        try {

            FileWriter writer = new FileWriter("S5-2.txt");

            for (String s : array) {
                writer.write(s + " ");
            }

            writer.close();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
