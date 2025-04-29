package com.lesson.lab;

import com.lesson.lab.controller.SeatBooking;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Take input using Scanner class
        Scanner keyboard = new Scanner(System.in);
        // Create an object of SeatBooking class
        SeatBooking bookingManager = new SeatBooking();

        while (true) {
            System.out.println("\n1. Add Booking\n2. Cancel Booking\n3. Update Booking\n4. Display Bookings\n5. Exit");
            System.out.print("Choose an option: ");
            // Choose an option
            int choice = -1;
            try {
                choice = keyboard.nextInt();
                keyboard.nextLine(); // Consume newline character
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                keyboard.nextLine(); // Clear invalid input
                continue; // Skip the rest of the loop iteration
            }

            switch (choice) {
                case 1:
                    // TODO 16: add New Seats
                    // use a print statement to instruct the user to enter a seat number for booking.
                    System.out.println("Choose your seat: ");
                    // take the seat number input from the user.
                    String seatNumber = keyboard.next();
                    // pass the seat number to the addNewBooking method to add the
                    bookingManager.addNewBooking(seatNumber);
                    break;
                case 2:
                    // TODO 17: remove Booking
                    // print a message instructing the user to enter the seat number they wish to cancel.
                    System.out.print("Enter Seat Number to cancel: ");
                    // take the seat number input from the user.
                    seatNumber = keyboard.next();
                    // call the cancelBooking method with the provided seat number to cancel the booking.
                    bookingManager.cancelBooking(seatNumber);
                    break;
                case 3:
                    // TODO 18: update booking
                    System.out.print("Enter Seat Number to update: ");
                    String oldSeatNumber = keyboard.next();
                    System.out.print("Enter new Seat Number: ");
                    String newSeatNumber = keyboard.next();
                    bookingManager.updateBooking(oldSeatNumber, newSeatNumber);
                    break;
                case 4:
                    // display the all bookings
                    bookingManager.displayBookings();
                    break;
                case 5:
                    System.out.println("Exiting program.");
                    keyboard.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}


