public class Room_Location {

    private int room_ID;
    private int hotel_ID;
    private int room_Number;

    public Room_Location (int room_ID, int hotel_ID, int room_Number) {
        this.room_ID = room_ID;
        this.hotel_ID = hotel_ID;
        this.room_Number = room_Number;
    }

    public Room_Location(int room_Number) {
        this.room_Number = room_Number;
    }

    public int getRoom_ID() {
        return room_ID;
    }

    public void setRoom_ID(int room_ID) {
        this.room_ID = room_ID;
    }

    public int getHotel_ID() {
        return hotel_ID;
    }

    public void setHotel_ID(int hotel_ID) {
        this.hotel_ID = hotel_ID;
    }

    public int getRoom_Number() {
        return room_Number;
    }

    public void setRoom_Number(int room_Number) {
        this.room_Number = room_Number;
    }

    @Override
    public String toString() {
    return "Room number " + room_Number;
    }
}
