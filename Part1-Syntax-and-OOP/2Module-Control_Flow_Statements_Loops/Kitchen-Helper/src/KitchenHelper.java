public class KitchenHelper {
    // Your method signature
    public static double calculateIngredientQuantity(int serving, double originalQuantity)

    {   // Calculate the adjusted ingredient quantity
        double adjustedQuantity = serving * originalQuantity;
        // replace 0.0 with the adjusted quantity
        return adjustedQuantity;
    }

    // Your method signature
    public static void spiceUpDish(int spiciness)
    {
        // Your code here!
        // Print a message suggesting spices based on the spiceLevel
        switch(spiciness) {
            case 1:
                System.out.println("Little bit spicy");
                break;
            case 2:
                System.out.println("Spicy");
                break;
            case 3:
                System.out.println("Medium spicy");
                break;
            case 4:
                System.out.println("Quate spicy");
                break;
            case 5:
                System.out.println("TOO spicy");
                break;
            default:
                System.out.println("Please, select 1-5 optiion");
                break;
        }
    }

    // Your method signature
    public static void greetGuest(String name, String timeOfDay)
    {
        // Your code here!
        // Print a personalized greeting based on arguments
        // For example, Hi Bob, Good Afternoon!
        if (name == "Harry" && timeOfDay == "Morning") {
            System.out.println("Nice to see you " + name + ", again this "+ timeOfDay);
        } else if (name == "Bob" && timeOfDay == "Afternoon") {
            System.out.println("Thanks for the new visit" + name + ", this "+ timeOfDay);
        } else if (name == "Maria" && timeOfDay == "Evening") {
            System.out.println("Finally, our favourite guest" + name + "is visiting us this "+ timeOfDay);
        } else {
            System.out.println(name + " I see you are the first time here this "+ timeOfDay);
        }
    }

    public static void main(String[] args) {
        // calling the methods with different arguments

        // Replace these arguments with your own values
        double newQuantity = calculateIngredientQuantity(3, 4.6);
        long roundedQuantity = Math.round(newQuantity);
        System.out.println("The adjusted ingredient quantity is: " + roundedQuantity);

        spiceUpDish(4);
        greetGuest("Lily", "Morning");
    }
}