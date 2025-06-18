import java.util.Locale;

public class Main {
    public static void main(String[] args) {

        String firstName = "Sandy";
        String lastName = "Jones";
        String movieTitle = "The Source Code";
        int numberOfTicket = 8;
        double pricePerTicket = 10.57;
//        System.out.println("First Name: " + firstName);
//        System.out.println("Last Name: " + lastName);
//        System.out.println("Movie: " + movieTitle);

        double totalPrice = numberOfTicket * pricePerTicket;
        String userName = firstName.toLowerCase()+lastName.toLowerCase();
        System.out.println("Congratulations!! You have successfully booked the tickets\n");
        System.out.println("Username: " + userName);
        System.out.println("Movie: " + movieTitle.toUpperCase());
        System.out.println("Number of Tickets: " + numberOfTicket);

        System.out.println("Price per ticket: $" + pricePerTicket);
        System.out.println("Total price of " + numberOfTicket + " tickets: $" + totalPrice);
        System.out.println();
        System.out.println("Thank you for choosing us for booking your movie tickets\n" +
                "Enjoy your movie!!!");




    }
}
