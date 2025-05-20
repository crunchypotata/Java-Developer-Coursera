
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class LibraryMenu {
    private Library library;
    private UserInteractionLogger logger = new UserInteractionLogger();
    private LibrarySerializer serializer = new LibrarySerializer();  // Added serializer

    public LibraryMenu(Library library) {
        this.library = library;
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // TODO - missing code
            System.out.println("=== Main Menu ===\n");
            System.out.println("1. View All Books");
            System.out.println("2. Sort Books by Title");
            System.out.println("3. Sort Books by Author");
            System.out.println("4. Sort Books by Year");
            System.out.println("5. Sort Books by keyword");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    library.viewAllBooks();
                    logger.logViewAllBooks();
                    break;
                case 2:
                    SortUtil.bubbleSort(library.getBooks(), Comparator.comparing(Book::getTitle));
                    System.out.println("Sorted by title:");
                    library.viewAllBooks();
                    logger.logSort("Title");
                    break;
                case 3:
                    SortUtil.insertionSort(library.getBooks(), Comparator.comparing(Book::getAuthor));
                    System.out.println("Sorted by author:");
                    library.viewAllBooks();
                    logger.logSort("Author");
                    break;
                case 4:
                    SortUtil.quickSort(library.getBooks(), Comparator.comparing(Book::getPublicationYear),
                            0,
                            library.getBooks().size() - 1
                    );
                    System.out.println("Sorted by year:");
                    library.viewAllBooks();
                    logger.logSort("Year");
                    break;
                case 5:
                    System.out.print("Enter keyword to search: ");
                    String keyword = scanner.nextLine();
                    Book foundBook = library.searchBookByKeyword(keyword);
                    if (foundBook != null) {
                        System.out.println("Found: " + foundBook);
                    } else {
                        System.out.println("No book found.");
                    }
                    logger.logSearch(keyword);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    logger.log("Exited program");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
                    logger.log("Invalid menu choice: " + option);
            }
        }
    }
}
