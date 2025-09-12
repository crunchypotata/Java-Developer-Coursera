import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public int max(int[] numbers) {
        // Task 2: Debug the Code Using Breakpoints
        // Breakpoints allow you to pause program execution and inspect variable values.

        int max = Integer.MIN_VALUE;

        for (int num : numbers) {
            // Step 1: Set Breakpoints
            // TODO 1: Open the Library class and locate the max() function.
            // TODO 2: Set a breakpoint at the line:
            // TODO 3: Run the program in debug mode by clicking the Debug icon in IntelliJ.
            // TODO 4: When the program pauses at the breakpoint, inspect the values of num and max in the Variables pane.
            // TODO 5: Use the "Step Over" feature (F8) in IntelliJ to move through the loop.
            // TODO 6: Observe how the condition num < max prevents valid maximum values from being assigned to max.
            // TODO 7: Edit the condition in the max() function:
            // if (num > max) {  // Corrected logic
            if (num < max) {  // Logic error: should be 'num > max'
                // Corrected the condition to ensure the maximum value is identified.
                max = num;  // Step 2: Start Debugging
            }
        }

        return max;
    }
}
