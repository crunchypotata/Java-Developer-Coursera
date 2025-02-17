// Inherit from Coffee using the extends keyword
public class Espresso extends Coffee {

    // Declare an attribute to store the number of shots (int)
    int numberOfShots;

    // Constructor to initialize all attributes
    public Espresso(String name, String roast, double price, int numberOfShots) {
        // Use super to call the Coffee constructor
        super(name, roast, price);

        // Initialize numberOfShots using this
        this.numberOfShots = numberOfShots;
    }

    // TODO 1: Override the grindBeans() method to simulate grinding the espresso beans finely

    @Override
    public void grindBeans() {
        System.out.println("\nGrinding the espresso beans finely...");
    }

    // TODO 2: Override the brewCoffee() method to simulate brewing under high pressure

    @Override
    public void brewCoffee() {
        System.out.println("Brewing the espresso under high pressure…");
    }

    // TODO 3: Override the printInfo() method to print the common and specific details of espresso including the bill
    @Override
    public void printInfo() {
        // TODO 4: Call the printInfo() method from the Coffee class using super
        super.printInfo();
        // TODO 5: Cut the print statements from the printEspressoDetails() method and paste them here
        System.out.println("You asked for " + numberOfShots + " servings!");
        System.out.println("Every serving of Espresso costs " + price + "$. " +
                "Your total bill is " + (price * numberOfShots) + "$.");
    }
}
