package fajlovi.zadatak9;

// Iz fajla se ucitavaju reci
// Reci se sortiraju po duzini opadajuce i sortirana lista reci se zapisuje u fajl
// Primena Selection Sort-a

// Ispiti: Januar A 2018, Januar A 2021

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class zadatak9 {

    public static void main(String[] args) {

        String[] array = {};

        String[] str = {"test", "informatika", "program", "algoritam"};
        selectionSort(str);
        System.out.println(Arrays.toString(str));

        try {

            BufferedReader reader = new BufferedReader(new FileReader("D:\\CS202-Resenja\\Resenja\\src\\main\\java\\fajlovi\\zadatak9\\reci.txt"));
            String line = "";
            System.out.println("Words from file: ");

            while ((line = reader.readLine()) != null) {
                array = line.split(" ");
                System.out.println(Arrays.toString(array));
            }

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        selectionSort(array);
        writeToFile(str);

    }

    private static void selectionSort(String[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j].length() > array[index].length()) {
                    index = j;
                }
            }
            String smallerNumber = array[index];
            array[index] = array[i];
            array[i] = smallerNumber;
        }
    }

    private static void writeToFile(String[] array) {

        try {

            FileWriter writer = new FileWriter("S2-2.txt");

            for (String s : array) {
                writer.write(s + "\n");
            }

            writer.close();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
