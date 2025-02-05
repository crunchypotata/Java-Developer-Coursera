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

                    // TODO 8: Create an object of Espresso class using the parameterized constructor
                    Espresso myEspresso = new Espresso(espressoName, espressoRoast, espressoPrice, numberOfShots);
                    // TODO 8: Pass the espressoName, espressoRoast, espressoPrice, and numberOfShots as arguments in the correct order

                    // TODO 9: Call the grindBeans() method on the Espresso object
                    myEspresso.grindBeans();
                    // TODO 10: Call the brewCoffee() method on the Espresso object
                    myEspresso.brewCoffee();
                    // TODO 11: Call the printInfo() method on the Espresso object
                    myEspresso.printInfo();
                    // TODO 12: Call the printEspressoDetails method on the Espresso object
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
                    if(syrupWanted.equals("yes")){
                        System.out.print("Which flavor would you like? (vanilla, caramel, hazelnut): ");
                        syrupFlavor = keyboard.next();
                    }

                    // TODO 20: Create an object of Latte class using the parameterized constructor
                    // TODO 20: Pass the latteName, latteRoast, lattePrice, milkType, and syrupFlavor as arguments in the correct order
                    Latte myLatte = new Latte(latteName, latteRoast, lattePrice, milkType, syrupFlavor);
                    // TODO 21: Call the grindBeans() method on the Latte object
                    myLatte.grindBeans();
                    // TODO 22: Call the brewCoffee() method on the Latte object
                    myLatte.brewCoffee();
                    // TODO 23: Call the printInfo() method on the Latte object
                    myLatte.printInfo();
                    // TODO 24: Call the printLatteDetails() method on the Latte object
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
