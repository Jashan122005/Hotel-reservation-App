package ui;

import api.AdminResource;
import model.RoomType;

import java.util.Scanner;

public class AdminMenu {

    private static final AdminResource adminResource = new AdminResource();

    public static void start(Scanner scanner) {
        while (true) {
            try {
                System.out.println("\n--- ADMIN MENU ---");
                System.out.println("1. See all customers");
                System.out.println("2. See all rooms");
                System.out.println("3. See all reservations");
                System.out.println("4. Add a room");
                System.out.println("5. Back");

                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1 -> adminResource.getAllCustomers()
                            .forEach(System.out::println);

                    case 2 -> adminResource.getAllRooms()
                            .forEach(System.out::println);

                    case 3 -> adminResource.getAllReservations()
                            .forEach(System.out::println);

                    case 4 -> addRoom(scanner);

                    case 5 -> {
                        return;
                    }

                    default -> System.out.println("Invalid option");
                }

            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        }
    }

    private static void addRoom(Scanner scanner) {
        try {
            System.out.print("Room number: ");
            String roomNumber = scanner.nextLine();

            System.out.print("Price: ");
            double price = Double.parseDouble(scanner.nextLine());

            if (price < 0) {
                System.out.println("Price must be >= 0");
                return;
            }

            System.out.print("Room type (SINGLE/DOUBLE): ");
            String typeInput = scanner.nextLine().toUpperCase();

            RoomType roomType = RoomType.valueOf(typeInput);

            adminResource.addRoom(roomNumber, price, roomType);

            System.out.println("Room added!");

        } catch (IllegalArgumentException e) {
            System.out.println("Invalid room type or input");
        } catch (Exception e) {
            System.out.println("Error adding room");
        }
    }
}