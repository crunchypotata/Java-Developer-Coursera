import java.io.*;

public class Book implements Serializable {
    private static final long serialVersionUID = 1L;

    private String title;
    private String author;
    private String isbn;

    // Constructor
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    // Getters
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }

    // toString method for easy printing
    @Override
    public String toString() {
        return "Book [title=" + title + ", author=" + author + ", isbn=" + isbn + "]";
    }

    // TODO 6a: Define a static void method named serializeBook with two parameters book of type Book and filePath of type String
    public static void serializeBook(Book book, String filePath) {
        // TODO 6b: create a try-with-resources block
        // TODO 6c: create a new FileOutputStream object with the filePath and a new ObjectOutputStream object with the FileOutputStream object
        try (FileOutputStream fileOut = new FileOutputStream(filePath);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {

            // TODO 6d: use the writeObject() method from the ObjectOutputStream class to write the book object to the file
            out.writeObject(book);
            // TODO 6e: print a message indicating that the book data was serialized
            System.out.println("Serializing of object has done successful");
        }
        catch (IOException ioException) {
            // TODO 6f: catch the IOException and print the stack trace
            System.err.println(ioException.getMessage());

        }
    }

    // TODO 7a: Define a static method named deserializeBook with a single parameter filePath of type String and a return type of Book
    public static Book deserializeBook(String filePath) {
        // TODO 7b: create a Book object and set it to null
        Book book = null;
        // TODO 7c: Create a try-with-resources block
        // TODO 7d: Inside the try-with-resources parenthesis, create a new FileInputStream object with the filePath and a new ObjectInputStream object with the FileInputStream object
        try (FileInputStream fileIn = new FileInputStream(filePath);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            // TODO 7e: read the object from the file and cast it to a Book object
            book = (Book) in.readObject();
            // TODO 7f: Print a message indicating that the book data was deserialized
            System.out.println("Deserialized book data from " + filePath);
        }
        catch (IOException | ClassNotFoundException e) {
            // TODO 7g: Catch the IOException and ClassNotFoundException and print the stack trace
            System.err.println("Error loading settings: " + e.getMessage());
        }
        // TODO 7h: Return the book object

        return book;
    }

}
