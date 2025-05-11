
public class WaitingList {

    public static void main(String[] args) {

        Student [] students = new Student[6];

        students[0] = new Student(1, "Bill", "Jones", "UNDER-REVIEW");
        students[1] = new Student(2, "John", "Smith", "UNDER-REVIEW");
        students[2] = new Student(3, "Wally", "Wiggles", "ENROLLED");
        students[3] = new Student(4, "May", "Hanks", "UNDER-REVIEW");
        students[4] = new Student(5, "Jane", "Carson", "UNDER-REVIEW");
        students[5] = new Student(6, "Lori", "Random", "UNDER-REVIEW");

        ListManager listManager = new ListManager(students);

        // TODO 20: Change the studentLastName to "Rad".
        String studentLastName = "Rad";

        // TODO 8: Change the value of option to 5 and run the application.
        // TODO 14: Change the value of option to 6 and run the application.
        // TODO 21: Change the value of option to 7 and run the application.
        // TODO 27: Change the value of option to 8 and run the application.
        int option = 8;

        System.out.println();
        switch (option) {
            case 1:
                listManager.listStudents();
                break;
            case 2:
                listManager.findStudent(studentLastName);
                break;
            case 3:
                listManager.updateStudentStatus(studentLastName, "ENROLLED");
                break;
            case 4:
                listManager.removeStudent(studentLastName);
                break;
            case 5:
                listManager.findFirstStudent();
                break;
            case 6:
                listManager.findLastStudent();
                break;
            case 7:
                listManager.findNextStudent(studentLastName);
                break;
            case 8:
                listManager.findPreviousStudent(studentLastName);
                break;
            default:
                System.out.println("\nInavlid option selected.\n");
        }
        System.out.println();
    }

    
}

