package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.Date;

public class HotelResource {

    private final CustomerService customerService = CustomerService.getInstance();
    private final ReservationService reservationService = ReservationService.getInstance();

    public void createCustomer(String email, String firstName, String lastName) {
        customerService.addCustomer(email, firstName, lastName);
    }

    public Customer getCustomer(String email) {
        return customerService.getCustomer(email);
    }

    public IRoom getRoom(String roomNumber) {
        return reservationService.getRoom(roomNumber);
    }

    public Reservation bookRoom(String email, IRoom room,
                                Date checkInDate, Date checkOutDate) {

        Customer customer = customerService.getCustomer(email);

        if (customer == null) {
            throw new IllegalArgumentException("Customer not found");
        }

        return reservationService.reserveRoom(customer, room, checkInDate, checkOutDate);
    }

    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) {
        return reservationService.findRooms(checkInDate, checkOutDate);
    }

    public Collection<Reservation> getCustomersReservations(String email) {

        Customer customer = customerService.getCustomer(email);

        if (customer == null) {
            throw new IllegalArgumentException("Customer not found");
        }

        return reservationService.getCustomersReservation(customer);
    }
}