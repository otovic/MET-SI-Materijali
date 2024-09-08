package fajlovi.zadatak8;

// Iz fajla se ucitavaju podaci o studentima
// Ucitavaju se indeks, ime, prezime i prosek
// Lista studenata se sortira po proseku, opadajuce
// Primena Quick Sort-a

// Ispit: Jun A 2020

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class zadatak8 {

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        List<Integer> average = new ArrayList<>();

        Student s1 = null;
        Student s2 = null;
        Student s3 = null;
        int averageS1 = 0;
        int averageS2 = 0;
        int averageS3 = 0;

        try {

            BufferedReader reader = new BufferedReader(new FileReader("D:\\CS202-Resenja\\Resenja\\src\\main\\java\\fajlovi\\zadatak8\\studenti.txt"));
            String s;
            while ((s = reader.readLine()) != null) {
                String[] array = s.split("-");
                if (array[0].equals("1")) {
                    String indeks = array[1];
                    String ime = array[2];
                    String prezime = array[3];
                    int prosek = Integer.parseInt(array[4]);
                    s1 = new Student(indeks, ime, prezime, prosek);
                    averageS1 = s1.getProsek();
                } else if (array[0].equals("2")) {
                    String indeks = array[1];
                    String ime = array[2];
                    String prezime = array[3];
                    int prosek = Integer.parseInt(array[4]);
                    s2 = new Student(indeks, ime, prezime, prosek);
                    averageS2 = s2.getProsek();
                } else if (array[0].equals("3")) {
                    String indeks = array[1];
                    String ime = array[2];
                    String prezime = array[3];
                    int prosek = Integer.parseInt(array[4]);
                    s3 = new Student(indeks, ime, prezime, prosek);
                    averageS3 = s3.getProsek();
                }
            }

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        students.add(s1);
        students.add(s2);
        students.add(s3);

        System.out.println("Students are: ");
        for (Student s : students) {
            System.out.println(s);
        }

        average.add(averageS2);
        average.add(averageS1);
        average.add(averageS3);

        quickSort(average, 0, 0);

        System.out.println("Their average grade is: ");
        System.out.println(average);

    }

    private static void quickSort(List<Integer> list, int left, int right) {
        int q;
        if (right > left) {
            q = partition(list, left, right);
            quickSort(list, left, q - 1);
            quickSort(list, q + 1, right);
        }
    }

    private static int partition(List<Integer> list, int left, int right) {
        int p = list.get(left);
        int i = left;
        int j = right + 1;
        for (;;) {
            while (list.get(i) < p) {
                if (i >= right) {
                    break;
                }
            }

            while (list.get(j--) > p) {
                if (j <= left) {
                    break;
                }
            }

            if (i >= j) {
                break;
            } else {
                Collections.swap(list, i, j);
            }
        }

        if (j == left) {
            return j;
        }

        Collections.swap(list, left, j);
        return j;
    }

}
