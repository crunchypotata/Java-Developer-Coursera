import com.sun.jdi.InvalidTypeException;

public class Coffee {

    // Attributes to store information about the coffee
    String name;                // for example, "Espresso", "Latte", "Mocha"
    String roast;               // for example, "light", "medium", "dark"
    int caffeineLevelInMg;      // calculated based on the roast
    double price;               // in dollars, for example, 2.50

    // Constructor to create a new coffee object with the given information
    public Coffee(String name, String roast, double price) {
        this.name = name;
        this.roast = roast;
        this.price = price;

        // TODO 3: surround the setCaffeineLevel() method call with a try-catch block to handle the exception

        // TODO 4: inside the catch block, set the caffeineLevelInMg to 50

        // The constructor calls the method to set the caffeine level based on the roast
        try {
            setCaffeineLevel();
        } catch (InvalidTypeException e) {
            caffeineLevelInMg = 50;

        }
    }

    // TODO 2: declare that the setCaffeineLevel() method throws a InvalidTypeException
    // Method to set the caffeine level of the coffee based on the roast
    public void setCaffeineLevel() throws InvalidTypeException  {
        if (roast.equals("light")) {
            caffeineLevelInMg = 50;
        } else if (roast.equals("medium")) {
            caffeineLevelInMg = 100;
        } else if (roast.equals("dark")) {
            caffeineLevelInMg = 150;
        } else {
            // TODO 1: remove this statement & throw a "InvalidTypeException" with a message
            throw new InvalidTypeException("invalid roast: " + roast + " please select a valid roast type!");

        }
    }

    // Methods to simulate coffee preparation
    public void grindBeans() {
        System.out.println("\nGrinding beans for " + roast + "...");
    }

    public void brewCoffee() {
        System.out.println("\nBrewing your favorite " + name + "...");
    }

    // Method to print the information about the coffee
    public void printInfo() {
        System.out.println("\nYou ordered a " + name + " with a " + roast + " roast.");
        System.out.println("The caffeine level in your coffee is " + caffeineLevelInMg + " mg.");
    }
}
