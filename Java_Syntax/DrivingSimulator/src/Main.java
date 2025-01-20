import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // TODO 1: Declare the necessary variables for the car's state and add scanner object
        boolean isEngineOn = false;
        String gear = "P";
        int speed = 0;
        int choice = 0;
        Scanner keyBoard = new Scanner(System.in);


        while (choice != 5) {
            // TODO 2: Display the current state of the car (engine state, gear, speed)
            System.out.println();
            System.out.println("------ Car Dashboard ------");
            System.out.println("Speed: " + speed);
            System.out.println("Engine running: " + isEngineOn);
            System.out.println("Gear: " + gear);
            System.out.println("------ End Car Dashboard ------");
            System.out.println();

            // TODO 3: Add print statements for each variable you want to display or options available to the user
            System.out.println("Menu:");
            System.out.println("1. Turn on/off the engine");
            System.out.println("2. Change gear (P, D, R)");
            System.out.println("3. Accelerate");
            System.out.println("4. Brake");
            System.out.println("5. Exit");


            // TODO 4: Prompt the user for their choice and store it in the 'choice' variable
            System.out.print("Enter your choice (only number): ");
            choice = keyBoard.nextInt();

            System.out.print("Menu item selected : " + choice);
            System.out.println();

            // TODO 5: Implement a switch statement to handle the different menu choices
            switch (choice) {
                case 1:
                    isEngineOn = !isEngineOn;
                    break;
                case 2:
                    System.out.print("Enter gear (P, D, R): ");
                    gear = keyBoard.next();
                    break;
                case 3:
                    if (isEngineOn && !gear.equals("P")) {
                        speed += 10; // speed = speed+10
                    } else {
                        System.out.println("Cannot accelerate while engine is off or in Park (P) gear.");
                    }
                    break;
                case 4:
                    if (isEngineOn && speed > 0) {
                        speed -= 5;
                    } else {
                        System.out.println("Speed to low");
                    }
                    break;
                case 5:
                    if (choice == 5) {
                        System.out.println("Bye!");
                        System.exit(0);
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    // TODO 6: Make sure the program runs until the user decides it's time to stop. Consider enclosing TODO 2 -> TODO 5 above in a while loop!
            }
        }
    }
}
