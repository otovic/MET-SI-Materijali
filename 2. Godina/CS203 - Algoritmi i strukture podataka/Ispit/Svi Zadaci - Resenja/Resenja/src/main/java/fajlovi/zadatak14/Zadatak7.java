package fajlovi.zadatak14;

// Ucitavanje svih fajlova iz odredjenog foldera
// Sortiranje fajlova po velicini opadajuce
// Stampanje naziva fajla i velicine
// Primena Merge Sort-a

// Ispit: Septembar 2021

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Zadatak7 {

    public static void main(String[] args) {

        File folder = new File("D:\\NetBeans 8.2\\NetBeansProjects\\CS103-IspitniZadaci");
        File[] listOfFiles = folder.listFiles();

        List<Long> size = new ArrayList<>();
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                System.out.println("File: " + listOfFiles[i].getName());
                System.out.println("File size: " + listOfFiles[i].length());
                size.add(listOfFiles[i].length());
            } else if (listOfFiles[i].isDirectory()) {
                System.out.println("Directory: " + listOfFiles[i].getName());
                System.out.println("Directory size: " + listOfFiles[i].length());
                size.add(listOfFiles[i].length());
            }
        }

        collectionsSort(size);
        System.out.println(size);

    }

    private static List<Long> mergeSort(List<Long> list) {
        if (list.size() < 2) {
            return list;
        }

        int mid = list.size() / 2;
        return merge(mergeSort(list.subList(0, mid)), mergeSort(list.subList(mid, list.size())));
    }

    private static List<Long> merge(List<Long> left, List<Long> right) {
        long leftIndex = 0L;
        long rightIndex = 0L;
        List<Long> merged = new ArrayList<>();

        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (left.get((int) leftIndex) < right.get((int) rightIndex)) {
                merged.add(left.get((int) leftIndex++));
            } else {
                merged.add(right.get((int) rightIndex++));
            }
        }

        merged.addAll(left.subList((int) leftIndex, left.size()));
        merged.addAll(right.subList((int) rightIndex, right.size()));
        return merged;
    }

    private static void collectionsSort(List<Long> list) {
        Collections.sort(list, Collections.reverseOrder());
    }

}
