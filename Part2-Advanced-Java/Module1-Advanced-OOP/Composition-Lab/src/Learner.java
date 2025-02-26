//TODO 12: make Learner class implement Assessment interface
public class Learner implements Assessments{
    //TODO 1: declare instance variables

    String name;
    Course course;
    double gradeScore = 0.0;

        //TODO 2: complete constructor
    Learner(String name, Course course) {
        this.name = name;
        this.course = course;
    }

    public String toString() {
        return "Name: " + this.name + " " + "Course: " + this.course.subject.title;
    }


    //TODO 13: override assignmentScore() method

    @Override
    public void assignmentScore(int marks) {
        this.course.assignmentMarks = marks;
    }

    //TODO 14: override quizScore() method

    @Override
    public void quizScore(int marks) {
        this.course.quizMarks = marks;
    }

    public double calculateGrade() {
        int maxAssignmentMarks, maxQuizMarks;
        //TODO 17: calculate gradeScore as per the instructions above

        if (this.course.subject.title.contains("Online")) {
            maxAssignmentMarks = 30;
            maxQuizMarks = 10;
        } else {
            maxAssignmentMarks = 100;
            maxQuizMarks = 30;
        }

        double normalizedAssignmentScore = ((double) this.course.assignmentMarks / maxAssignmentMarks) * 10;
        double normalizedQuizScore = ((double) this.course.quizMarks / maxQuizMarks) * 10;

        this.gradeScore = (normalizedAssignmentScore + normalizedQuizScore) / 2;
        return this.gradeScore;
    }
}


