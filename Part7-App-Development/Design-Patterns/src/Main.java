import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

    /*TODO 9: declare local string variables inside the main() method - cpu, ram, storage and card*/
	/*TODO 10: Use Scanner class to accept input for cpu variable from the user with nextLine() method*/
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter CPU");
        cpu = scanner.nextLine();
        /*TODO 11: Similarly, accept inputs for ram, storage and graphics card.*/
        /* TODO 12: Add the attributes to myPC which is  the new object of the Assembler class with the setter methods in Builder class.*/

            Assembler myPC = new Assembler.Builder()
                    .setCpu(cpu)
                    .setRam(ram)
                    .setStorage(storage)
                    .setGraphicsCard(card)
                    .build();

            System.out.println("Your chosen PC Configuration:");
            /*TODO 13: Print the attributes of myPC by calling the getter methods.*/

        }
}
