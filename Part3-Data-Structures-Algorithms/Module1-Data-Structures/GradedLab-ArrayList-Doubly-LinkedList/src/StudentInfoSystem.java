import java.util.ArrayList;

public class StudentInfoSystem {
    private static ArrayList<Student> students = new ArrayList<>();


    static boolean addStudent(Student student) {
        // TODO 1: Implement a method to add a new student to the ArrayList
        students.add(student);
        System.out.println("Student added: " + student.getName());
        return true;
    }

    static Student findStudentByName(String name) {
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                return student;
            }
        }
        return null;
    }
}