package fajlovi.zadatak7;

public class Node {
    int index;
    double average;
    Node left;
    Node right;

    public Node() {

    }

    public Node(int index, double average) {
        this.index = index;
        this.average = average;
        left = null;
        right = null;
    }

    @Override
    public String toString() {
        return this.index + " " + this.average;
    }
}
