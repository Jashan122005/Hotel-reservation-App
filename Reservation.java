package model;

import java.util.Date;
public class Reservation {
    private final Customer customer;
    private final IRoom room;
    private final Date checkInDate;
    private final Date checkOutDate;

    public Reservation(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {

        if (customer == null || room == null || checkInDate == null || checkOutDate == null) {
            throw new IllegalArgumentException("Reservation fields cannot be null");
        }

        if (!checkInDate.before(checkOutDate)) {
            throw new IllegalArgumentException("Check-out date must be after check-in date");
        }

        this.customer = customer;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public IRoom getRoom() {
        return room;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    @Override
    public String toString() {
        return "Reservation:\n" +
                "Customer: " + customer +
                "\nRoom: " + room +
                "\nCheck-in: " + checkInDate +
                "\nCheck-out: " + checkOutDate;
    }
}
