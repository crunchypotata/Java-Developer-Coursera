import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class IdeaReader {
    public String readIdea(String filePath) {
        String fileContents = "";
        // TODO 1: create a new File class object and pass the filePath as argument in the constructor
        File file = new File (filePath);
        // TODO 2: pass the file object as an argument in the constructor
        try (FileInputStream inputStream = new FileInputStream(file)) {

            // TODO 3: read all the bytes from the file and store it in a byte array
            byte[] fileContentsAsBytes = inputStream.readAllBytes();

            // TODO 4: store the contents in the fileContents variable using a String constructor
            fileContents = new String(fileContentsAsBytes);
        } catch (FileNotFoundException fileNotFoundException) {

            // TODO 5: print an error message if the file is not found on disk
            System.err.println("File Not Found! Please check the file path and try again!");
        } catch (IOException ioException) {
            System.err.println(ioException.getMessage());
        }
        return fileContents;
    }
}
