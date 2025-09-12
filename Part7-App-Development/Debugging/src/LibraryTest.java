public class LibraryTest {
    public static void main(String[] args) {
        testAddBook();
        testMaxFunction();
    }

    public static void testAddBook() {
        Library library = new Library();
        Book book = new Book("1984", "George Orwell");
        library.addBook(book);

        if (library.getBooks().size() != 1) {
            System.out.println("Test Failed: Book count mismatch.");
        } else if (!library.getBooks().get(0).getTitle().equals("1984")) {
            System.out.println("Test Failed: Book title mismatch.");
        } else if (!library.getBooks().get(0).getAuthor().equals("George Orwell")) {
            System.out.println("Test Failed: Book author mismatch.");
        } else {
            System.out.println("Test Passed: All conditions are met.");
        }
    }

    public static void testMaxFunction() {
        Library library = new Library();
        int[] numbers = {3, 5, 2, 7, 1};

        int max = library.max(numbers);
        // TODO 8: Save your changes and re-run the LibraryTest class.
        // TODO 9: Confirm that the output for testMaxFunction() now reads:
        // Test Passed: Correct maximum value.
        if (max != 7) {
            System.out.println("Test Failed: Incorrect maximum value. Found: " + max);
        } else {
            System.out.println("Test Passed: Correct maximum value.");
        }
    }
}
