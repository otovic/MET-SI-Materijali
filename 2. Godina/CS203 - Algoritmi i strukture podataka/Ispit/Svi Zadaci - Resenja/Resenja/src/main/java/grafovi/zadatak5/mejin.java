package grafovi.zadatak5;

import java.util.Arrays;
// Problem kurseva
// Kao ulaz je dat netezinski usmeren graf
// Odredjivanje rasporeda putem topoloskog sortiranja

public class mejin {
    public static void main(String[] args) {

        System.out.println("Orders are: ");

        Graph g1 = new Graph();

        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};

        System.out.println(Arrays.toString(g1.topologicalSort(numCourses, prerequisites)));

        Graph g2 = new Graph();

        int numOfCourses = 8;
        int[][] p = {{2, 1}, {2, 0}, {1, 0}, {4, 3}, {7, 6}, {7, 5}, {6, 5}};

        System.out.println(Arrays.toString(g2.topologicalSort(numOfCourses, p)));

        Graph g3 = new Graph();
        int num = 2;
        int[][] courses = {{1, 0}};

        System.out.println(Arrays.toString(g3.topologicalSort(num, courses)));

        Graph g4 = new Graph();

        int courseNumber = 3;
        int[][] prerequisitesCourse = {{2, 1}, {2, 0}, {1, 0}};

        System.out.println(Arrays.toString(g4.topologicalSort(courseNumber, prerequisitesCourse)));

        Graph g5 = new Graph();

        int numberOfCourses = 6;
        int[][] pre = {{5, 0}, {5, 1}, {5, 2}, {5, 3}, {5, 4}, {4, 0}, {4, 1}, {4, 2}, {4, 3}, {3, 0}, {3, 1}, {3, 2}, {2, 0}, {2, 1}, {1, 0}};

        System.out.println(Arrays.toString(g5.topologicalSort(numberOfCourses, pre)));

    }
}
