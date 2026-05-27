package ui;

import api.HotelResource;
import model.IRoom;
import model.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MainMenu {

    private static final HotelResource hotelResource = new HotelResource();
    private static final Scanner scanner = new Scanner(System.in);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    static {
        dateFormat.setLenient(false);
    }

    public static void main(String[] args) {
        start(scanner);
    }

    public static void start(Scanner scanner) {
        while (true) {
            try {
                System.out.println("\n--- MAIN MENU ---");
                System.out.println("1. Find and reserve a room");
                System.out.println("2. See my reservations");
                System.out.println("3. Create an account");
                System.out.println("4. Admin");
                System.out.println("5. Exit");

                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1 -> findAndReserveRoom();
                    case 2 -> viewReservations();
                    case 3 -> createAccount();
                    case 4 -> AdminMenu.start(scanner);
                    case 5 -> System.exit(0);
                    default -> System.out.println("Invalid option");
                }

            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        }
    }

    private static void createAccount() {
        try {
            System.out.print("Email: ");
            String email = scanner.nextLine();

            System.out.print("First Name: ");
            String firstName = scanner.nextLine();

            System.out.print("Last Name: ");
            String lastName = scanner.nextLine();

            hotelResource.createCustomer(email, firstName, lastName);
            System.out.println("Account created!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void viewReservations() {
        try {
            System.out.print("Enter email: ");
            String email = scanner.nextLine();

            Collection<Reservation> reservations =
                    hotelResource.getCustomersReservations(email);

            if (reservations.isEmpty()) {
                System.out.println("No reservations found");
            } else {
                reservations.forEach(System.out::println);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void findAndReserveRoom() {
        try {
            Date checkIn = getDate("Enter check-in date (dd/MM/yyyy): ");
            Date checkOut = getDate("Enter check-out date (dd/MM/yyyy): ");

            if (!checkIn.before(checkOut)) {
                System.out.println("Invalid date range");
                return;
            }

            Collection<IRoom> rooms =
                    hotelResource.findRooms(checkIn, checkOut);

            if (rooms.isEmpty()) {
                System.out.println("No rooms found. Checking alternative dates...");

                Calendar cal = Calendar.getInstance();
                cal.setTime(checkIn);
                cal.add(Calendar.DATE, 7);
                Date newCheckIn = cal.getTime();

                cal.setTime(checkOut);
                cal.add(Calendar.DATE, 7);
                Date newCheckOut = cal.getTime();

                rooms = hotelResource.findRooms(newCheckIn, newCheckOut);

                if (rooms.isEmpty()) {
                    System.out.println("No rooms available");
                    return;
                }

                System.out.println("Recommended rooms:");
                rooms.forEach(System.out::println);

                checkIn = newCheckIn;
                checkOut = newCheckOut;

            } else {
                rooms.forEach(System.out::println);
            }

            System.out.print("Enter room number to book: ");
            String roomNumber = scanner.nextLine();

            IRoom room = hotelResource.getRoom(roomNumber);
            if (room == null) {
                System.out.println("Room not found");
                return;
            }

            System.out.print("Enter your email: ");
            String email = scanner.nextLine();

            hotelResource.bookRoom(email, room, checkIn, checkOut);
            System.out.println("Reservation successful!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static Date getDate(String message) throws ParseException {
        System.out.print(message);
        Date date = dateFormat.parse(scanner.nextLine());

        if (date.before(new Date())) {
            throw new IllegalArgumentException("Date cannot be in the past");
        }

        return date;
    }
}