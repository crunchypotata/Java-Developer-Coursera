import java.util.Scanner;

public class CoffeeMachine {

    public static void main(String[] args) {

        // Create a Scanner object to read input
        Scanner keyboard = new Scanner(System.in);

        while (true) {
            System.out.println("\nWelcome to the Coffee Machine!");
            System.out.println("Select an option to continue:");
            System.out.println("1. Espresso");
            System.out.println("2. Latte");
            System.out.println("3. Exit");
            System.out.print("Enter your choice (1, 2, or 3): ");

            // Read user's choice
            int choice = keyboard.nextInt();

            switch (choice) {
                case 1:
                    // Initialize the name of Espresso
                    String espressoName = "Espresso";

                    // Initialize the price of Espresso per serving
                    double espressoPrice = 2.50;

                    // Ask the user for the type of roast and store it in espressoRoast
                    System.out.print("What Roast would you like? (light, medium, dark): ");
                    String espressoRoast = keyboard.next();

                    // Ask the user for the number of shots and store it in numberOfShots
                    System.out.print("How many servings would you like? (a number please): ");
                    int numberOfShots = keyboard.nextInt();

                    // TODO 7: surround the myEspresso object with a try-catch block to handle the ArithmeticException.
                    Espresso myEspresso = null;

                    try {
                        myEspresso = new Espresso(espressoName, espressoRoast, espressoPrice, numberOfShots);
                    } catch (ArithmeticException e) {
                        System.out.println(e.getMessage());
                        System.out.print("How many servings would you like? (a number please): ");
                        numberOfShots = keyboard.nextInt();
                    } finally {
                        if (myEspresso == null) {
                            myEspresso = new Espresso(espressoName, espressoRoast, espressoPrice, numberOfShots);
                        }
                    }

                    // TODO 8: declare the myEspresso object before the try block and set it to null.

                    // TODO 9: inside the catch block, ask the user to enter number of shots and store it in numberOfShots

                    // TODO 10: add a finally block, and initialize the myEspresso object again

                    myEspresso.grindBeans();

                    myEspresso.brewCoffee();

                    myEspresso.printInfo();

                    myEspresso.printEspressoDetails();

                    break;
                case 2:

                    // Initialize the name of Latte
                    String latteName = "Latte";

                    // Initialize the price of Latte
                    double lattePrice = 3.50;

                    // Ask the user for the type of roast and store it in latteRoast
                    System.out.print("What Roast would you like? (light, medium, dark): ");
                    String latteRoast = keyboard.next();

                    // Ask the user for the milk type and store it in milkType
                    System.out.print("What milk type would you like? (whole, skim, almond, oat): ");
                    String milkType = keyboard.next();

                    // Ask the user if they want syrup or not
                    System.out.print("Would you like syrup? (yes/ no): ");
                    String syrupWanted = keyboard.next();

                    String syrupFlavor = "no";
                    // if syrupWanted is yes, Ask the user for the syrup flavor and store it in syrupFlavor
                    if (syrupWanted.equals("yes")) {
                        System.out.print("Which flavor would you like? (vanilla, caramel, hazelnut): ");
                        syrupFlavor = keyboard.next();
                    }

                    // TODO 13: surround the myLatte object with a try-catch block to handle the IllegalArgumentException.
                    Latte myLatte = null;
                    try {
                        myLatte = new Latte(latteName, latteRoast, lattePrice, milkType, syrupFlavor);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        System.out.print("What milk type would you like? (whole, skim, almond, oat): ");
                        milkType = keyboard.next();
                    } finally {
                        if (myLatte == null) {
                            myLatte = new Latte(latteName, latteRoast, lattePrice, milkType, syrupFlavor);
                        }
                    }

                    // TODO 14: declare the myLatte object before the try block and set it to null.

                    // TODO 15: inside the catch block, ask the user to enter milkType again

                    // TODO 16: add a finally block, and initialize the myLatte object again

                    myLatte.grindBeans();

                    myLatte.brewCoffee();

                    myLatte.printInfo();

                    myLatte.printLatteDetails();

                    break;
                case 3:
                    System.out.println("Thank you for using the Coffee Machine!");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
        }
    }
}
