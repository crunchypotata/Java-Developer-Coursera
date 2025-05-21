abstract class Course {
    //TODO 3: include instance variables for Course class and complete constructor code
    Subject subject;
    String instructor;
    int fee;
    int assignmentMarks;
    int quizMarks;

    Course(Subject subject, String instructor, int fee) {
        this.subject = subject;
        this.instructor = instructor;
        this.fee = fee;
        this.assignmentMarks = 0;
        this.quizMarks = 0;

    }
}
