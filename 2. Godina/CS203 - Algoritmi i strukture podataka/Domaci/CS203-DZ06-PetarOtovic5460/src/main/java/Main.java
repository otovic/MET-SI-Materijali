import java.util.*;
public class Main {
    public static void bucketSort(Student[] students) {
        int maxGrade = Integer.MIN_VALUE;
        for (Student student : students) if (student.grade > maxGrade) maxGrade = student.grade;

        List<Student>[] buckets = new ArrayList[maxGrade + 1];
        for (int i = 0; i <= maxGrade; i++) buckets[i] = new ArrayList<>();

        for (Student student : students) buckets[student.grade].add(student);

        System.out.println("Sorted students:");
        for (List<Student> bucket : buckets) for (Student student : bucket) System.out.println(student);
    }

    public static void main(String[] args) {
        Student[] students = {
                new Student("Dzoni", "Ocokuljic", 1, 7),
                new Student("Jasna", "Smith", 2, 9),
                new Student("Zdenka", "Svetlanovic", 3, 7),
                new Student("Bob", "Brown", 4, 6),
                new Student("Marko", "Micic", 5, 10)
        };

        bucketSort(students);
    }
}