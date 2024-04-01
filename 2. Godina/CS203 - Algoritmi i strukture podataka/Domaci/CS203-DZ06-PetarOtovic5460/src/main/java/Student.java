public class Student {
    String firstName;
    String lastName;
    int index;
    int grade;

    public Student(String firstName, String lastName, int index, int grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.index = index;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (Index: " + index + ", Grade: " + grade + ")";
    }
}