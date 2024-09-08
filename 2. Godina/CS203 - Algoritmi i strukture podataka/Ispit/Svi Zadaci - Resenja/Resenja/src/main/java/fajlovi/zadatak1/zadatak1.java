package fajlovi.zadatak1;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

//Napisati program koji učitava sve fajlove iz određenog foldera i sortira ih po ekstenziji rastuće. U slučaju
//        da fajlovi imaju istu ekstenziju sortirati ih po veličini opadajuće. Koristiti implementaciju proizvoljnog
//        algoritma sortiranja. Ispisati naziv fajla i veličinu.
//        Fajlove možete učitati u Javi pomoću sledećeg koda:
//        File folder = new File(“folderPath");
//        File[] listOfFiles = folder.listFiles();
//        Primer izlaza:
//        Slika1.jpg 552
//        Dijagram.jpg 120
//        Skica.png 452
//        Tasks.txt 872

public class zadatak1 {
    public static void main(String[] args) {
        // Zamenite putanju sa željenom putanjom do foldera
        String folderPath = "D:\\CS202-Resenja\\Resenja\\src\\main\\java\\fajlovi\\zadatak1";
        File folder = new File(folderPath);
        File[] listOfFiles = folder.listFiles();

        if (listOfFiles == null || listOfFiles.length == 0) {
            System.out.println("Folder je prazan ili ne postoji.");
            return;
        }

        // Sortiranje fajlova prema zadatom kriterijumu
        Arrays.sort(listOfFiles, new Comparator<File>() {
            @Override
            public int compare(File f1, File f2) {
                String ext1 = getFileExtension(f1);
                String ext2 = getFileExtension(f2);

                int extCompare = ext1.compareTo(ext2);
                if (extCompare == 0) {
                    // Ako su ekstenzije iste, poredi se po veličini u opadajućem redosledu
                    long size1 = f1.length();
                    long size2 = f2.length();
                    return Long.compare(size2, size1); // Opadajuće sortiranje
                }

                return extCompare; // Rastuće sortiranje po ekstenziji
            }

            private String getFileExtension(File file) {
                String name = file.getName();
                int lastIndex = name.lastIndexOf('.');
                if (lastIndex == -1) {
                    return ""; // Fajl nema ekstenziju
                }
                return name.substring(lastIndex + 1).toLowerCase();
            }
        });

        // Ispis naziva fajlova i veličine
        for (File file : listOfFiles) {
            if (file.isFile()) {
                System.out.println(file.getName() + " " + file.length());
            }
        }
    }
}
