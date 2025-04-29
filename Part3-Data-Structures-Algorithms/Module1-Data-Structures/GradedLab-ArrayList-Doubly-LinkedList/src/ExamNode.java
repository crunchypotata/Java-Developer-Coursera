public class ExamNode {
    String examDetails;
    ExamNode next;
    ExamNode prev;

    public ExamNode(String examDetails) {
        this.examDetails = examDetails;
        this.next = null;
        this.prev = null;
    }
}

