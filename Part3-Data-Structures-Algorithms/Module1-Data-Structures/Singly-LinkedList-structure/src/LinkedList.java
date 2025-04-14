public class LinkedList {
    Node head;
    LinkedList() {
        this.head = null;
    }


    //Adding item in the end of LinkedList
    void addCustomer(String name, String details) {
        Node newNode = new Node(name, details);
        //If the list is empty, the new client become the head
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            // Traverse to the end of the list
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    void updateCustomer(String customerName, String newDetails) {
        Node current = head;
        while (current != null) {
            if (current.name.equals(customerName)) {
                current.details = newDetails; // Update the customer’s details
                return;
            }
            current = current.next;
        }
    }

    // Method to remove a specific customer from the linkedlist
    void removeCustomer(String customerName) {
        if (head == null) return; // If the waitlist is empty, there's nothing to remove
        // If the customer to remove is at the head of the list
        if (head.name.equals(customerName)) {
            head = head.next; // Move the head to the next customer
            return;
        }
        Node current = head;
        while (current.next != null && !current.next.name.equals(customerName)) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next; // Bypass the node to remove the customer
        }
    }
    // Adding item in the start of LinkedList
    void vipCustomer(String name, String details) {
        //Step 1: Create the new node the head
        Node newNode = new Node(name, details);
        //Step 2: Point it to the current head of the list.
        newNode.next = head;
        // Step 3: Update the Head to the New Node
        head = newNode;
    }

    void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.name + " (" + current.details + ")");
            current = current.next;
            if (current != null) {
                System.out.print(" -> ");
            }
        }
        System.out.println(" ");
    }

}
