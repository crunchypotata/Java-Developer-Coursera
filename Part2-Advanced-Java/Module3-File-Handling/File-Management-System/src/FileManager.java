import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.io.IOException;

public class FileManager {

    // Define the copyFile method with two parameters: sourcePath and targetPath
    private static void copyFile(String sourcePath, String targetPath) {

        // Convert the sourcePath string into a Path object
        Path source = Paths.get(sourcePath);

        // TODO: Convert the targetPath string into a Path object
        Path target = Paths.get(targetPath);
        // Use a try-catch block to handle potential I/O exceptions
        try {
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
            // TODO: Copy the source file to the target location, replacing any existing file


            // TODO: Print a message indicating that the file has been successfully copied
            System.out.println("File has been copied from " + sourcePath + " to " + targetPath);
        } catch (IOException e) {

            // TODO: If an IOException occurs, print an error message with the exception's message
            System.out.println("I/O error" + e.getMessage());
            // Print the stack trace of the exception for debugging purposes
            e.printStackTrace();
        }
    }

    // Main method to test the copyFile function
    public static void main(String[] args) {
        // Specify the source and target file paths
        String sourceFile = "./source_folder/textFile1.txt";
        String targetFile = "./target_folder/textFile1.txt";

        // Call the copyFile method with the specified source and target paths
        copyFile(sourceFile, targetFile);
    }
}
