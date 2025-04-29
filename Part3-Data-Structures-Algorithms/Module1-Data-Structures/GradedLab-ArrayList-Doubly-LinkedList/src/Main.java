import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Options:");
            System.out.println("1. Add Student");
            System.out.println("2. Add Exam");
            System.out.println("3. View Next Exam");
            System.out.println("4. View Previous Exam");
            System.out.println("5. View Student Schedule");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    // Task 1: Add a new student
                    System.out.print("Enter student name: ");
                    String studentName = scanner.nextLine();
                    Student student = new Student(studentName);
                    StudentInfoSystem.addStudent(student);
                    break;
                case 2:
                    // Task 2: Add exam schedule for a student
                    System.out.print("Enter student name: ");
                    String nameForExam = scanner.nextLine();
                    Student studentForExam = StudentInfoSystem.findStudentByName(nameForExam);
                    if (studentForExam != null) {
                        System.out.print("Enter exam date (e.g., 2023-10-15): ");
                        String examDate = scanner.nextLine();
                        System.out.print("Enter exam location (e.g., Room 101): ");
                        String examLocation = scanner.nextLine();
                        studentForExam.getExamSchedule().addExam(examDate + " - " + examLocation);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 3:
                    // Task 3: Navigate to Next Exam Schedule
                    System.out.print("Enter student name: ");
                    String nameForNextExam = scanner.nextLine();
                    Student studentForNextExam = StudentInfoSystem.findStudentByName(nameForNextExam);
                    if (studentForNextExam != null) {
                        studentForNextExam.getExamSchedule().viewNextExam();
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 4:
                    // Task 4: Navigate to a previous exam schedule
                    System.out.print("Enter student name: ");
                    String nameForPreviousExam = scanner.nextLine();
                    Student studentForPreviousExam = StudentInfoSystem.findStudentByName(nameForPreviousExam);
                    if (studentForPreviousExam != null) {
                        studentForPreviousExam.getExamSchedule().viewPreviousExam();
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 5:
                    // View all exam schedule for a student
                    System.out.print("Enter student name: ");
                    String nameForSchedule = scanner.nextLine();
                    Student studentForSchedule = StudentInfoSystem.findStudentByName(nameForSchedule);
                    if (studentForSchedule != null) {
                        studentForSchedule.getExamSchedule().viewAllExamSchedule();
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

