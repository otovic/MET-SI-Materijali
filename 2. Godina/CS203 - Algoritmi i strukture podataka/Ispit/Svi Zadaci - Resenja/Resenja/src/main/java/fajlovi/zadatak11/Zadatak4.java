package fajlovi.zadatak11;

// Iz fajla se ucitavaju reci
// Reci se sortiraju leksikografski (kao u recniku)
// Korisnik bira da li zeli rastuce ili opadajuce sortiranje
// Primena Merge Sort-a

// Ispiti: April 2020, Oktobar 2020

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Zadatak4 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] array = new String[]{};
        String[] str = {"kamion", "traktor", "automobil", "brod", "jahta"};

        try {

            BufferedReader reader = new BufferedReader(new FileReader("D:\\CS202-Resenja\\Resenja\\src\\main\\java\\fajlovi\\zadatak11\\reci.txt"));
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

        System.out.println("Enter sorting: ");
        System.out.println("1 -> Merge Sort -> Ascending");
        System.out.println("2 -> Merge Sort -> Descending");
        System.out.print("Enter: ");
        String choice = input.next();

        if (choice.equals("1")) {
            mergeSortAscending(str);
            System.out.println(Arrays.toString(str));
        } else if (choice.equals("2")) {
            mergeSortDescending(str);
            System.out.println(Arrays.toString(str));
        } else {
            System.out.println("Wrong input!");
        }

        input.close();
    }

    private static void mergeSortAscending(String[] array) {
        if (array.length >= 2) {
            String[] left = new String[array.length / 2];
            String[] right = new String[array.length - array.length / 2];

            for (int i = 0; i < left.length; i++) {
                left[i] = array[i];
            }

            for (int i = 0; i < right.length; i++) {
                right[i] = array[i + array.length / 2];
            }

            mergeSortAscending(left);
            mergeSortAscending(right);
            mergeAscending(array, left, right);
        }
    }

    private static void mergeSortDescending(String[] array) {
        if (array.length >= 2) {
            String[] left = new String[array.length / 2];
            String[] right = new String[array.length - array.length / 2];

            for (int i = 0; i < left.length; i++) {
                left[i] = array[i];
            }

            for (int i = 0; i < right.length; i++) {
                right[i] = array[i + array.length / 2];
            }

            mergeSortDescending(left);
            mergeSortDescending(right);
            mergeDesceding(array, left, right);
        }
    }

    private static void mergeAscending(String[] array, String[] left, String[] right) {
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

    private static void mergeDesceding(String[] array, String[] left, String[] right) {
        int a = 0;
        int b = 0;

        for (int i = 0; i < array.length; i++) {
            if (b >= right.length || (a < left.length && left[a].compareToIgnoreCase(right[b]) > 0)) {
                array[i] = left[a];
                a++;
            } else {
                array[i] = right[b];
                b++;
            }
        }
    }

}
