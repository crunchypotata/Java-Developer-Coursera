import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Object of SideKick class
        SideKick sideKickObject = new SideKick();


        // Object of WatADriver class
        WatADriver driverBot = new WatADriver();

        // Object of Scanner class to get input from the user
        Scanner keyboardInput = new Scanner(System.in);

        // integer variable to get choice of user as to which robot to use
        int menuChoice;

        // boolean variable to keep the do-while running
        boolean keepMenuRunning;


        do {

            System.out.println("******* MENU FOR ROBOT CHOICE  *****");
            System.out.println("1. SideKick robot ");
            System.out.println("2. WatADriver robot ");
            System.out.println("**************************************");

            System.out.println("Enter your choice of robot(1 or 2): ");
            menuChoice = keyboardInput.nextInt();



            switch (menuChoice) {
                case 1:
                    /** TODO 1: Use the "sideKickObject", object of Sidekick class
                     *          to display the menu and then take the appropriate
                     *           action as required.
                     **/
                    sideKickObject.setChoice();
                    sideKickObject.takeAction();

                    /** TODO 7: Check if the "SideKick" class has implemented the
                     *          "KungFuSkills" interface which you created in
                     *          TODO 5. If it has implemented it, then call the
                     *          method "kungFuProtection".
                     **/

                    if(sideKickObject instanceof KungFuSkills) {
                        sideKickObject.kungFuProtection();
                    } else {
                        System.out.println("Sorry no KungFu skills available.");
                    }
                    break;

                case 2:
                    /** TODO 2: Use the "driverBot" object of WatADriver class
                     *          to display the menu and then take the appropriate
                     *           action as required.
                     **/
                    driverBot.setChoice();
                    driverBot.takeAction();
                    break;

                default:
                    System.out.println("Invalid choice for a robot.");

            }


            // in case the input skips
            keyboardInput.nextLine();

            // prompt user if continuation is required for loop
            System.out.println("Another run? (enter y for yes/ any value for no):  ");
            //get input
            String userInput = keyboardInput.nextLine();

            // check if input is equal to "y"
            if(userInput.equalsIgnoreCase("y")) {
                // re-run loop
                keepMenuRunning = true;
            } else {
                // stop loop
                keepMenuRunning = false;
            }

        } while (keepMenuRunning);
    }


    /** TODO 3: Create an interface named "KungFuSkills" **/
    interface kungFuSkills {

    }

    /** TODO 4: In the interface "KungFuSkills" created in TODO 5,
     *          get inside the curly braces of the interface  in order
     *          to declare a method named "kungFuProtection()".
     *          Ensure that the  return type of the method is "void".
     **/




}
