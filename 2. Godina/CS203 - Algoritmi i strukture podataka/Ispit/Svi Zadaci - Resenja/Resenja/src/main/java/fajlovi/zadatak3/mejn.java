package fajlovi.zadatak3;

import java.io.File;

//napisati program koji ucitava sve fajlove iz odredjenog foldera i sortira ih po velicini opadajuce.
//        sortiranje izvrsiti merge sortom. ispisati naziv fajla i velicinu

public class mejn {
    public static void main(String[] args) {
        // Putanja do foldera
        String folderPath = "D:\\MET-Materijali\\2. Godina\\CS203 - Algoritmi i strukture podataka\\Ispit";
        File folder = new File(folderPath);
        File[] listOfFiles = folder.listFiles();

        if (listOfFiles == null || listOfFiles.length == 0) {
            System.out.println("Folder je prazan ili ne postoji.");
            return;
        }

        // Sortiranje fajlova po veličini koristeći Merge Sort
        mergeSort(listOfFiles, 0, listOfFiles.length - 1);

        // Ispis naziva fajlova i veličine
        for (File file : listOfFiles) {
            if (file.isFile()) {
                System.out.println(file.getName() + " " + file.length());
            }
        }
    }

    // Merge Sort funkcija
    private static void mergeSort(File[] files, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            // Sortiraj prvu i drugu polovinu
            mergeSort(files, left, mid);
            mergeSort(files, mid + 1, right);

            // Merge dve polovine
            merge(files, left, mid, right);
        }
    }

    // Funkcija za spajanje dve polovine
    private static void merge(File[] files, int left, int mid, int right) {
        // Pronađi veličinu oba dela
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Napravi privremene nizove
        File[] leftArray = new File[n1];
        File[] rightArray = new File[n2];

        // Kopiraj podatke u privremene nizove
        System.arraycopy(files, left, leftArray, 0, n1);
        System.arraycopy(files, mid + 1, rightArray, 0, n2);

        // Merge privremenih nizova nazad u originalni niz
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i].length() >= rightArray[j].length()) {
                files[k] = leftArray[i];
                i++;
            } else {
                files[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Kopiraj preostale elemente iz leftArray, ako ih ima
        while (i < n1) {
            files[k] = leftArray[i];
            i++;
            k++;
        }

        // Kopiraj preostale elemente iz rightArray, ako ih ima
        while (j < n2) {
            files[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
