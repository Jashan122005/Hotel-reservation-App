package model;
import java.util.Objects;
public class Room implements IRoom {

    private final String roomNumber;
    private final Double price;
    private final RoomType roomType;

    public Room(String roomNumber, Double price, RoomType roomType) {

        if (roomNumber == null || roomNumber.isEmpty()) {
            throw new IllegalArgumentException("Room number cannot be empty");
        }

        if (price == null || price < 0) {
            throw new IllegalArgumentException("Price must be >= 0");
        }

        if (roomType == null) {
            throw new IllegalArgumentException("Room type cannot be null");
        }

        this.roomNumber = roomNumber;
        this.price = price;
        this.roomType = roomType;
    }

    @Override
    public String getRoomNumber() {
        return roomNumber;
    }

    @Override
    public Double getRoomPrice() {
        return price;
    }

    @Override
    public RoomType getRoomType() {
        return roomType;
    }

    @Override
    public boolean isFree() {
        return price == 0;
    }

    @Override
    public String toString() {
        return "Room Number: " + roomNumber +
                ", Type: " + roomType +
                ", Price: $" + price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room)) return false;
        Room room = (Room) o;
        return roomNumber.equals(room.roomNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomNumber);
    }
}
