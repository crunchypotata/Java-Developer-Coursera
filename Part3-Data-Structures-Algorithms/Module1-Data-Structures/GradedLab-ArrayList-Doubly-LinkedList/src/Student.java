public class Student {
    private String name;
    private ExamSchedule examSchedule;

    public Student(String name) {
        this.name = name;
        this.examSchedule = new ExamSchedule();
    }

    public String getName() {
        return name;
    }

    public ExamSchedule getExamSchedule() {
        return examSchedule;
    }
}