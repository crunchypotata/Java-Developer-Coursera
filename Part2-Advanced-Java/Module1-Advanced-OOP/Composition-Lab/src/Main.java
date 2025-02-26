import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //TODO 8: declare and initialize the object of ClassroomCourse class
        //TODO 9: declare and initialize the Learner object
        //TODO 18: display course list and accept user choice


        //TODO 20: accept user input for learner's name
        System.out.println("Enter your name :");
        String name = in.nextLine();
        //TODO 19:  Declare the object of the course of choice

        Subject subject1 = new Subject("Java", 4);
        Subject subject2 = new Subject("Java Online", 4);
        Subject subject3 = new Subject("JavaScript", 6);
        Subject subject4 = new Subject("JavaScript Online", 6);
        Course course1 = null;

        System.out.println("For an online course, max assignment marks = 30, max quiz marks = 10.");
        System.out.println("For a classroom course, max assignment marks = 100, max quiz marks = 30.");

        System.out.println("Courses:");
        System.out.println("1. Java");
        System.out.println("2. Java Online");
        System.out.println("3. JavaScript");
        System.out.println("4. JavaScript Online");
        System.out.print("Enter choice (1-4): ");
        int ch=in.nextInt();

        if (ch==1 || ch==3)
            course1 = new ClassroomCourse(subject1, "Mark", 1000, "Cambridge", "Winter");
        if (ch==2 || ch==4)
            course1 = new OnlineCourse(subject2, "Mark", 1000);
        Learner learner = new Learner(name, course1);
        //TODO 21: call assignmentScore() method and quizScore() methods
        System.out.print("Enter assignment score: ");
        int assignmentMarks = in.nextInt();
        learner.assignmentScore(assignmentMarks);

        System.out.print("Enter quiz score: ");
        int quizMarks = in.nextInt();
        learner.quizScore(quizMarks);

        //TODO 22: call assignmentScore() method. Display the result as described
        double finalGrade = learner.calculateGrade();
        System.out.println("Final grade: " + finalGrade);

        if (finalGrade >= 5) {
            System.out.println("Successfully passed!");
        } else {
            System.out.println("Course not completed.");
        }
    }
}
