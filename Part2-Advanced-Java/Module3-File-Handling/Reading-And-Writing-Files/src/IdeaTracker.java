import java.util.Scanner;

public class IdeaTracker {
    public static void main(String[] args) {

        /*TODO 11: run your code using the IDE! Your program should be able to read in the file already given in the
         *  project or write out a new file as specified in the console menu.
         */

        // Create a Scanner object to read input
        Scanner keyboard = new Scanner(System.in);

        while (true) {
            // show a menu to the user to simplify input
            System.out.println("\nWelcome to the Idea Tracker!");
            System.out.println("Select an option to continue:");
            System.out.println("1. Read a file");
            System.out.println("2. Write a file");
            System.out.println("3. Exit");
            System.out.print("Enter your choice (1, 2, or 3): ");

            // Read user's choice
            int choice = keyboard.nextInt();
            keyboard.nextLine();

            switch (choice) {
                // TODO 6: Run the main() method and select 1 as the input for the menu to read a file
                case 1:
                    // Initialize a IdeaReader object
                    IdeaReader ideaReader = new IdeaReader();

                    // Ask the user for the path of the file to read and save the path in a variable
                    System.out.print("Please enter the file of the path to read: ");
                    String filePath = keyboard.nextLine();

                    // call the readIdea() method to read the file and store the contents in a variable
                    String contentsReadFromFile = ideaReader.readIdea(filePath);

                    System.out.println("--------------------------------------------------");
                    // print out the file contents
                    System.out.println(contentsReadFromFile);
                    System.out.println("--------------------------------------------------");

                    break;
                case 2:
                    // consume the leftover newline character from the previous input
                    keyboard.nextLine();

                    // Initialize a IdeaWriter object
                    IdeaWriter ideaWriter = new IdeaWriter();

                    // Ask the user for the name of the idea and store it in a variable
                    System.out.println("Please enter the name of the idea: ");
                    String ideaName = keyboard.nextLine();

                    //  create a variable and prepend src/ and append .txt to the name of the file
                    String ideaFilePath = "src/" + ideaName + ".txt";

                    // ask the user to enter some description of the project and store it in a variable
                    System.out.println("Please enter some description for the project: ");
                    String ideaDescription = keyboard.nextLine();

                    // call the writeIdea() method to write everything to a new file
                    ideaWriter.writeIdea(ideaFilePath, ideaDescription);

                    break;
                case 3:
                    System.out.println("Thank you for using the Idea Tracker!");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
        }
    }
}
