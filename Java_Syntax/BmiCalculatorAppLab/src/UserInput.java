import java.util.Scanner;

// The UserInput class implements methods that are used to obtain user inputs for BMI calculation
public class UserInput {

    // Obtains user input for the preferred BMI system
    public String obtainBMISystem() {
        // Display the welcome message to the user
        System.out.println("Welcome to the BMI calculator app!");
        System.out.print("Please select the preferred BMI calculation system (Imperial/Metric):");

        // Scanner that captures user input for the preferred BMI system
        Scanner input = new Scanner(System.in);
        // Reading the line of user input from the Scanner in to a String variable
        String bmiSystem = input.next();

        // Checking if a valid BMI system has been entered by the user
        if (!(bmiSystem.equalsIgnoreCase("Imperial") ||
                bmiSystem.equalsIgnoreCase("Metric"))) {
            // If not, return an empty String from the method
            return "";
        }

        // Otherwise (if not invalid) return the user entered BMI system
        return bmiSystem;
    }

    // Obtains user input for the weight in Pounds or Kilos, based on the entered BMI system
    public double obtainWeight(String bmiSystem) {
        // Variable to store the weight value
        double weight = 0;
        // Variable to indicate if the user input is valid or not
        boolean isInvalidInput = true;

        // The loop that controls obtaining user input for weight until a valid value is entered
        while (isInvalidInput) {
            // Scanner that captures user input for the weight value
        Scanner input = new Scanner(System.in);
            // A Switch statement that determines if weight should be obtained in Pounds or Kilos based on the BMI system
            switch (bmiSystem.toUpperCase()) {
                // The case of IMPERIAL BMI system
                case "IMPERIAL":
                    // Display the message to obtain weight in Pounds
                    System.out.print("Enter weight in Pounds:");
                    // Break out of the switch statement
                    break;
                // The case of METRIC BMI system
                case "METRIC":
                    // Display the message to obtain weight in Kilos
                    System.out.print("Enter weight in Kilos:");
                    // Break out of the switch statement
                    break;
                // The case of empty BMI system due to invalid user input
                case "":
                    // Display the message to ask the user to enter a valid value for BMI system
                    System.out.println("Please Enter a valid BMI System as input");
                    // Break out of the switch statement
                    break;
            }

            // An if statement that checks if the user has entered a valid value (double value) for weight
            if (input.hasNextDouble()) {
                // Read the double weight value from the Scanner object "input"
                weight = input.nextDouble();
                // Set that the user input is not invalid
                isInvalidInput = false;
            } else {
                // Display a message asking the user to input a valid value, in case of invalid user input
                System.out.println("Please enter a valid weight");
                // Set the weight to 0
                weight = 0;
            }
        }

        // Return the weight value
        return weight;
    }

    // Please implement the obtainHeight() method to obtains user input for the height in Inches or Meters, based on the entered BMI system
    public double obtainHeight(String bmiSystem) {

        double height = 0;
        boolean isInvalidInput = true;

        // The loop that controls obtaining user input for height until a valid value is entered
        while (isInvalidInput) {
            // Scanner that captures user input for the weight value
            Scanner input = new Scanner(System.in);
            // A Switch statement that determines if weight should be obtained in Pounds or Kilos based on the BMI system
                switch (bmiSystem.toUpperCase()) {
                    // The case of IMPERIAL BMI system
                    case "IMPERIAL":
                        // Display the message to obtain weight in Pounds
                        System.out.print("Enter height in Inches:");
                        // Break out of the switch statement
                        break;
                    // The case of METRIC BMI system
                    case "METRIC":
                        // Display the message to obtain weight in Kilos
                        System.out.print("Enter height in Meters:");
                        // Break out of the switch statement
                        break;
                    // The case of empty BMI system due to invalid user input
                    case "":
                        // Display the message to ask the user to enter a valid value for BMI system
                        System.out.println("Please Enter a valid BMI System as input");
                        // Break out of the switch statement
                        break;
                }

                // An if statement that checks if the user has entered a valid value (double value) for weight
                if (input.hasNextDouble()) {
                    // Read the double weight value from the Scanner object "input"
                    height = input.nextDouble();
                    // Set that the user input is not invalid
                    isInvalidInput = false;
                } else {
                    // Display a message asking the user to input a valid value, in case of invalid user input
                    System.out.println("Please enter a valid height");
                    // Set the weight to 0
                    height = 0;
                }
            }
        return height;

    }
}

