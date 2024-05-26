package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] studentIDs = {197354883, 933185971, 132489992, 134152075, 216500325, 106500325, 216510325, 197354884};
        int size = 19;
        Integer[] hashTable = new Integer[size];
        Arrays.fill(hashTable, null);
        for (int id : studentIDs) {
            int hash = id % size;
            int org = hash;
            while (hashTable[hash] != null) {
                hash = (hash + 1) % size;
                if (hash == org) throw new RuntimeException("Hash table is full!");
            }
            hashTable[hash] = id;
        }
        for (int i = 0; i < size; i++) {
            System.out.println("Index " + i + ": " + hashTable[i]);
        }
    }
}