package liste.zadatak1;

// Tekst ucitan iz fajla se razdvaja na reci i ubacuje u listu reci
// Izbacivanje svih duplikata iz liste, ostavljajuci prvo pojavljivanje reci

// Ispiti: Januar B 2020, Januar A 2021

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class zadatak1 {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        try {

            BufferedReader bf = new BufferedReader(new FileReader("D:\\CS202-Resenja\\Resenja\\src\\main\\java\\liste\\zadatak1\\reci.txt"));
            String s = "";
            while ((s = bf.readLine()) != null) {
                list.addAll(Arrays.asList(s.split("-")));
            }

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("Initial list: ");
        System.out.println(list);

        List<String> newList = deleteDuplicates(list);

        System.out.println("List without duplicates: ");
        System.out.println(newList);

    }

    private static List deleteDuplicates(List<String> list) {
        List<String> newList = new ArrayList<>();

        for (String i : list) {
            boolean duplicate = false;
            for (String j : newList) {
                if (j.equals(i)) {
                    duplicate = true;
                    break;
                }
            }
            if (!duplicate) {
                newList.add(i);
            }
        }

        return newList;
    }

}
