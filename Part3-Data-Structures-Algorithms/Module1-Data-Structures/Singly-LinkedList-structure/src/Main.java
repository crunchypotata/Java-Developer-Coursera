public class Main {
    public static void main (String[] arg) {
        LinkedList waitlist = new LinkedList(); // object
        waitlist.addCustomer("Alice", "Party of 2");
        waitlist.addCustomer("Bob", "Party of 3");
        waitlist.addCustomer("Samanta", "Party of 2");
        waitlist.printList();

        waitlist.updateCustomer("Samanta", "Fourth");
        waitlist.printList();

        waitlist.removeCustomer("Bob");
        waitlist.printList();

        waitlist.vipCustomer("Eric", "Party of 4");
        waitlist.vipCustomer("Marta", "Party of 2");
        waitlist.printList();

        waitlist.addCustomer("Mikkey", "Party for 5");
        waitlist.printList();
    }
}
