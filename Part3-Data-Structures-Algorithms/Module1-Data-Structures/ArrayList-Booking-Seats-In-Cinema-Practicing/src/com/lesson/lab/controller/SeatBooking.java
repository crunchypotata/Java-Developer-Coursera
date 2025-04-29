package com.lesson.lab.controller;

import com.lesson.lab.model.Seat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SeatBooking {
    // List to store bookings
    private List<Seat> bookedSeatsList;
    // Constructor
    public SeatBooking() {
        // Initialize the list of booked seats
        // TODO 1 :
          this.bookedSeatsList = new ArrayList<>();

    }
    // Method to add a new seat booking
    public void addNewBooking(String seatNumber) {
        // TODO 2: check if the seat is already booked and not canceled
        for (Seat seat : bookedSeatsList) {
            if (seat.getSeatNumber().equals(seatNumber) && seat.isBooked() && !seat.isCanceled()) {
                System.out.println("Seat " +seatNumber + "is already booked!");
                return;
            }
        }
        // TODO 3 create a new Seat object for the booking,
        Seat newSeat = new Seat(seatNumber);
        // mark the seat as booked,
        newSeat.setBooked(true);
        // set the current date as the booking date
        newSeat.setBookingDate(new Date());
        // TODO 4: add the new seat to the bookedSeatsList
        bookedSeatsList.add(newSeat);
        // TODO 5: confirm the booking to the user
        System.out.println("Seat " + seatNumber + " has been successfully booked!");
     }
    // Method to cancel a booking
    public void cancelBooking(String seatNumber) {
        // TODO 6: iterate through the list of booked seats
        // TODO 7: check if the seat number matches and is not already canceled
        // TODO 8: inform the user if no booking was found for the seat number
        for (Seat seat : bookedSeatsList) {
            if (seat.getSeatNumber().equals(seatNumber) && !seat.isCanceled()) {
                bookedSeatsList.remove(seat);
                // mark the seat as canceled
                seat.setCanceled(true);
                // mark the seat as not booked
                seat.setBooked(false);
                // confirm the cancellation to the user
                System.out.println("Seat " + seat.getSeatNumber() + " has been successfully removed!");
                return;
            }
        System.out.println("No booking found for seat number: " + seatNumber);
        }
    }
    // Method to update a booking seat number
    public void updateBooking(String oldSeatNumber, String newSeatNumber) {
        // TODO 9: iterate through the list of booked seats
        // TODO 10: check if the seat number matches the old seat number and is not canceled
        // TODO 11: update the seat number to the new seat number
        for (Seat seat : bookedSeatsList) {
            if (seat.getSeatNumber().equals(oldSeatNumber) && !seat.isCanceled()) {
                seat.setSeatNumber(newSeatNumber);
                // confirm the update to the user
                System.out.println("Booking updated successfully to new seat number: " + newSeatNumber);
                return;
            }
        }
        // TODO 12: inform the user if no booking was found for the old seat number
        System.out.println("No booking found for seat number: " + oldSeatNumber);
    }

    public void displayBookings() {
        // TODO 13: check if the bookedSeatsList is empty, inform the user that no bookings have been made yet
        if (bookedSeatsList.isEmpty()) {
            System.out.println("No bookings made yet.");
        } else {
        // TODO 14: iterate through the list of booked seats, Check if the seat is booked and not canceled
            for (Seat seat : bookedSeatsList) {
                if (!seat.isCanceled() && seat.isBooked()) {
                    System.out.println("Seat Number: " + seat.getSeatNumber() + ", Booking Date: " + seat.getBookingDate());
                }
                // TODO 15: display the seat number and booking date
            }
        }
    }
}
