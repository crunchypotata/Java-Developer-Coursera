import java.util.Stack;

public class BrowserHistoryManager {
    public static void main(String[] args) {
        Stack<String> history = new Stack<>();

        // TODO 1: add 3 websites to the history
        history.push("google.com");
        history.push("facebook.com");
        history.push("youtube.com");

        // Display history after adding websites
        System.out.println("History :" + history);

        // TODO 2: peek the last visited website

        String topValue = history.peek();
        System.out.println("Last visited website: " + topValue);

        // TODO 3: go back to the previous website by popping

        String topV = history.pop();
        System.out.println("Removed website is : " + topV);


        // Display the stack after popping
        System.out.println("Stack after pop: " + history);

    }
}