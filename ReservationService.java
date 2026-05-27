package service;

import model.Customer;
import model.IRoom;
import model.Reservation;

import java.util.*;

public class ReservationService {

    private static ReservationService instance;

    private boolean isRoomAvailable(IRoom room, Date checkInDate, Date checkOutDate) {
        if (room == null) {
            throw new IllegalArgumentException("Invalid room selection");
        }
        for (Reservation r : reservations) {
            if (r.getRoom().equals(room)) {

                if (checkInDate.before(r.getCheckOutDate()) &&
                        checkOutDate.after(r.getCheckInDate())) {

                    return false;
                }
            }
        }

        return true;
    }

    private final Map<String, IRoom> rooms = new HashMap<>();
    private final Collection<Reservation> reservations = new ArrayList<>();

    private ReservationService() {}

    public static ReservationService getInstance() {
        if (instance == null) {
            instance = new ReservationService();
        }
        return instance;
    }

    // ---------- ROOM METHODS ----------

    public void addRoom(IRoom room) {

        if (rooms.containsKey(room.getRoomNumber())) {
            throw new IllegalArgumentException("Room already exists");
        }

        rooms.put(room.getRoomNumber(), room);
    }
    public IRoom getRoom(String roomId) {
        return rooms.get(roomId);
    }

    public Collection<IRoom> getAllRooms() {
        return rooms.values();
    }

    // ---------- RESERVATION METHODS ----------

    public Reservation reserveRoom(Customer customer, IRoom room,
                                   Date checkInDate, Date checkOutDate) {

        if (checkInDate.before(new Date()) || checkOutDate.before(new Date())) {
            throw new IllegalArgumentException("Cannot book in the past");
        }
        if (!checkInDate.before(checkOutDate)) {
            throw new IllegalArgumentException("Invalid date range");
        }
        if (room == null || !rooms.containsKey(room.getRoomNumber())) {
            throw new IllegalArgumentException("Invalid room selection");
        }

        if (!isRoomAvailable(room, checkInDate, checkOutDate)) {
            throw new IllegalArgumentException("Room not available for selected dates");
        }

        Reservation reservation = new Reservation(customer, room, checkInDate, checkOutDate);
        reservations.add(reservation);
        return reservation;
    }

    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) {

        List<IRoom> availableRooms = new ArrayList<>();

        for (IRoom room : rooms.values()) {

            boolean available = true;

            for (Reservation r : reservations) {
                if (r.getRoom().equals(room)) {

                    if (checkInDate.before(r.getCheckOutDate()) &&
                            checkOutDate.after(r.getCheckInDate())) {

                        available = false;
                        break;
                    }
                }
            }

            if (available) {
                availableRooms.add(room);
            }
        }

        return availableRooms;
    }

    public Collection<Reservation> getCustomersReservation(Customer customer) {

        List<Reservation> result = new ArrayList<>();

        for (Reservation r : reservations) {
            if (r.getCustomer().equals(customer)) {
                result.add(r);
            }
        }

        return result;
    }

    public Collection<Reservation> getAllReservations() {
        return reservations;
    }
}