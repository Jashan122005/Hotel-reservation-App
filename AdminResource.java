package api;

import model.Customer;
import model.IRoom;
import model.Room;
import model.RoomType;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;

public class AdminResource {

    private final CustomerService customerService = CustomerService.getInstance();
    private final ReservationService reservationService = ReservationService.getInstance();

    public void addRoom(String roomNumber, Double price, RoomType roomType) {

        IRoom room;

        if (price == 0) {
            room = new model.FreeRoom(roomNumber, roomType);
        } else {
            room = new Room(roomNumber, price, roomType);
        }

        reservationService.addRoom(room);
    }

    public Collection<IRoom> getAllRooms() {
        return reservationService.getAllRooms();
    }

    public Collection<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    public Collection<model.Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }
}