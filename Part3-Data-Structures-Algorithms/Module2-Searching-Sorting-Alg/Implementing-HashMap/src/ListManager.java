
// TODO 1: Import HashMap, Map, and Set types
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.HashMap;


public class ListManager {

    // TODO 2: Create a new hash map named studentsMap //
    HashMap studentsMap = new HashMap();

    public ListManager(Student[] students) {
        /* TODO 3:  Iterate through the studentsArray and add the
                    data to the studentsMap. Use the students'
                    last names as the keys and the student
                    objects as the values  */
        for (int i = 0; i < students.length; i++) {
            studentsMap.put(students[i].lastName, students[i]);
        }
    }

    public void listStudents() {

        // TODO 4: Check if studentsMap is empty.
        if(studentsMap.isEmpty()) {
        // TODO 5: If studentsMap is empty, print an alert saying that
            System.out.println("The system has no students in the waiting list");

        /* TODO 6: If the studentMap is not empty, print a list of all
                   student  */
        } else {
            System.out.println("List of all Students\n");
            Set keys = studentsMap.entrySet();
            for (Object entry : keys) {
                Map.Entry mapEntry = (Map.Entry) entry;
                Student student = (Student)mapEntry.getValue();
                System.out.println(student);
            }
            System.out.println();
        }
    }

    public void findStudent(String lastName) {

        /* TODO 7: Check to see if studentMap contains the
                   lastName as a key If the key is not found. Print an
                   error message and return.*/
        /* TODO 8: Get a reference to the Student whose key is the
                   lastName */
        if(studentsMap.containsKey(lastName)) {
            System.out.println("Student found\n");
            Student student = (Student)studentsMap.get(lastName);
            System.out.println(student);
        // TODO 9: If the student exists, print the Student object
        } else {
            // TODO 10: If the student doesn't exist. Print error message */
            System.out.println("Student with last name " + lastName + " doesn't exist.");

        }
    }


    public void updateStudentStatus(String lastName, String newStatus) {
        /* TODO 12: Use the get() method on studentMap to obtain a
                    reference to the Student object */
        Student student = (Student) studentsMap.get(lastName);
        /* TODO 13: If the student exists, change the status to
                    newStatus, and print a confirmation message. */
        if (student != null) {
            String oldStatus = student.status;
            student.status = newStatus;
            studentsMap.put(lastName,student);
            System.out.println();
            System.out.println("Status for " + lastName + " was updated from " + oldStatus + " to " + newStatus);
        } else {
            // TODO 14: Print an error message if the student doesn't exist.
            System.out.println();
            System.out.println("Student with last name '" + lastName + "' doesn't exist.");

        }
    }


    public void removeStudent(String lastName) {

        /* TODO 16: using the lastName parameter, attempt to remove
                    a student from the studentsMap */
        Student studentRemoved = (Student)studentsMap.remove(lastName);
        if (studentRemoved != null) {

        /* TODO 17:  print a message confirmation and student
                     information if the student was successfully
                     removed. */
            System.out.println("Student (" + lastName + ") was successfully removed");
        } else {

        /* TODO 18: If the student is not removed, print
                    a statement that the student was not removed. */
            System.out.println("Student with last name '" + lastName + "' doesn't exist.");
        }

    }
}