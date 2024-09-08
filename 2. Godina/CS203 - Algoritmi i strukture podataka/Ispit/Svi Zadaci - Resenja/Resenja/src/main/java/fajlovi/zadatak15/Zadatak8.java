package fajlovi.zadatak15;

// Ucitavanje svih fajlova iz odredjenog foldera
// Sortiranje fajlova po imenu rastuce
// Sortiranje fajlova po velicini opadajuce
// Stampanje naziva fajla i velicine
// Primena proizvoljnog algoritma sortiranja

// Ispit: Januar A 2022

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Zadatak8 {

    public static void main(String[] args) {

        File folder = new File("D:\\NetBeans 8.2\\NetBeansProjects\\CS103-IspitniZadaci");
        File[] listOfFiles = folder.listFiles();

        List<String> str = new ArrayList<>();
        List<Long> list = new ArrayList<>();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                System.out.println("File: " + listOfFiles[i].getName() + " " + listOfFiles[i].length());
                str.add(listOfFiles[i].getName());
                list.add(listOfFiles[i].length());
            } else if (listOfFiles[i].isDirectory()) {
                System.out.println("Directory: " + listOfFiles[i].getName() + " " + listOfFiles[i].length());
                str.add(listOfFiles[i].getName());
                list.add(listOfFiles[i].length());
            }
        }

        bubbleSortStr(str);
        System.out.println("----------------------------");
        bubbleSort(list);
        System.out.println(list);

    }

    private static void bubbleSort(List<Long> list) {
        Long temp;
        boolean sorted = false;

        while (!sorted) {
            sorted = true;
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i).compareTo(list.get(i + 1)) < 0) {
                    temp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, temp);
                    sorted = false;
                }
            }
        }

    }

    private static void bubbleSortStr(List<String> list) {
        String temp;
        boolean sorted = false;

        while (!sorted) {
            sorted = true;
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i).compareTo(list.get(i + 1)) > 0) {
                    temp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, temp);
                    sorted = false;
                }
            }
        }

    }

}
