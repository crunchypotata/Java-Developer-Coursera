package com.lesson.lab.model;

import java.util.Date;

public class Seat {
    private String seatNumber;
    private boolean isBooked;
    private Date bookingDate;
    private boolean isCanceled;
    public Seat(String seatNumber) {
        this.seatNumber = seatNumber;
        this.isBooked = false;
        this.isCanceled = false;
    }
    public String getSeatNumber() {
        return seatNumber;
    }
    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }
    public boolean isBooked() {
        return isBooked;
    }
    public void setBooked(boolean booked) {
        isBooked = booked;
    }
    public Date getBookingDate() {
        return bookingDate;
    }
    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }
    public boolean isCanceled() {
        return isCanceled;
    }
    public void setCanceled(boolean cancelled) {
        isCanceled = cancelled;
    }
    @Override
    public String toString() {
        return "Seat{" +
               "seatNumber='" + seatNumber + '\'' +
               ", isBooked=" + isBooked +
               ", bookingDate=" + bookingDate +
               ", isCanceled=" + isCanceled +
               '}';
    }
}
