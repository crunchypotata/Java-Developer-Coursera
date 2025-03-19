import java.io.File;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class IdeaWriter {
    public void writeIdea(String filePath, String fileContents) {
        // TODO 7: create a new File class object and pass in the filePath as an argument in the constructor
        File file = new File(filePath);
        // TODO 8: convert the fileContents String into an array of bytes
        byte[] fileContentsAsBytes = fileContents.getBytes();
        // TODO 9: pass in the file object in the FileOutputStream constructor
        try (FileOutputStream outputStream = new FileOutputStream(file)) {

            // TODO 10: call the write() method and pass in the array of bytes to write them out to a file
            outputStream.write(fileContentsAsBytes);
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("File not found! Please check the path and try again!");
        } catch (IOException ioException) {
            System.err.println(ioException.getMessage());
        }
    }
}
