class Student extends Person implements StudentInterface {
    //TODO 5: add subject and marks attributes
    String subject;
    int marks;

    Student(String name, int age, String subject, int marks) {
        //TODO 6: complete the constructor code
        this.name = name;
        this.age = age;
        this.subject = subject;
        this.marks = marks;
    }

    @Override
    void getDetails() {
        super.getDetails();
        //TODO 7: insert print statements for subject and marks attributes
        System.out.println("Subject: " + this.subject);
        System.out.println("Marks: "+ this.marks);
    }

    @Override
    public void result() {
        //TODO 8: print Pass if marks>50, fail otherwise
        if (this.marks >= 50) {
            System.out.println("Result: Pass");
        } else {
            System.out.println("Result: Fail");
        }
    }

    @Override
    public void fee(int extra) {
        //TODO 9: override fee() method to print the message
        // the student has paid the specified fee as the argument.
        System.out.println("You need paid specified fee: " + extra);
    }
}