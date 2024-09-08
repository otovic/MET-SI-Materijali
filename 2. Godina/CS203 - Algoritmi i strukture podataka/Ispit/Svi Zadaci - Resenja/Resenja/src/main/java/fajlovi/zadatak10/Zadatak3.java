package fajlovi.zadatak10;

// Iz fajla se ucitavaju reci
// Reci se sortiraju po duzini opadajuce i sortirana lista reci se zapisuje u fajl
// Primena Insertion Sort-a

// Ispit: Januar B 2021

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Zadatak3 {

    public static void main(String[] args) {

        String[] array = new String[]{};

        try {

            BufferedReader reader = new BufferedReader(new FileReader("D:\\CS202-Resenja\\Resenja\\src\\main\\java\\fajlovi\\zadatak10\\reci.txt"));
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

        insertionSort(array);
        writeToFile(array);

    }
    
    private static void insertionSort(String[] array) {
        int n = array.length;
        
        for (int i = 1; i < n; i++) {
            String temp = array[i];
            int j = i - 1;
            while (j >= 0 && temp.length() > array[j].length()) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
    }

    private static void writeToFile(String[] array) {

        try {

            FileWriter writer = new FileWriter("S3-2.txt");

            for (String s : array) {
                writer.write(s + " ");
            }

            writer.close();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
