import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

    /*TODO 9: declare local string variables inside the main() method - cpu, ram, storage and card*/
        String cpu, ram, storage, card;
	/*TODO 10: Use Scanner class to accept input for cpu variable from the user with nextLine() method*/
        try ( Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter CPU: ");
            cpu = scanner.nextLine();
            /*TODO 11: Similarly, accept inputs for ram, storage and graphics card.*/
            System.out.println("Enter RAM: ");
            ram = scanner.nextLine();
            System.out.println("Enter Storage: ");
            storage = scanner.nextLine();
            System.out.println("Enter card: ");
            card = scanner.nextLine();
            /* TODO 12: Add the attributes to myPC which is  the new object of the Assembler class with the setter methods in Builder class.*/

            Assembler myPC = new Assembler.Builder()
                    .setCpu(cpu)
                    .setRam(ram)
                    .setStorage(storage)
                    .setGraphicsCard(card)
                    .build();

            System.out.println("Your chosen PC Configuration:");
            /*TODO 13: Print the attributes of myPC by calling the getter methods.*/
            System.out.println("Your CPU: " + myPC.getCpu());
            System.out.println("Your RAM: " + myPC.getRam());
            System.out.println("Your Storage: " + myPC.getStorage());
            System.out.println("Your Graphic card: " + myPC.getGraphicsCard());
        }
    }
}
