
public class Student {
    public int studentId; 
    public String firstName;
    public String lastName; 
    public String status; //  ENROLLED, UNDER-REVIEW, and REJECTED

    public Student(int id, String fname, String lname, String status){
        this.studentId = id;
        this.firstName = fname;
        this.lastName = lname;
        this.status = status;
    }

    @Override
    public String toString() {
        String str = "ID:'" + this.studentId + "'";
        str += "\tNAME: '" + this.lastName +", ";
        str += this.firstName + "'";
        str += "\tSTATUS: '" +  this.status +"'";     
        return str;
    }

}