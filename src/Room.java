public class Room {

    private int room_ID;
    private String room_Type;
    private int room_Capacity;
    private int room_Amount;

    public Room(int room_ID, String room_Type, int room_Capacity, int room_Amount) {
        this.room_ID = room_ID;
        this.room_Type = room_Type;
        this.room_Capacity = room_Capacity;
        this.room_Amount = room_Amount;
    }

    public int getRoom_ID() {
        return room_ID;
    }

    public void setRoom_ID(int room_ID) {
        this.room_ID = room_ID;
    }

    public String getRoom_Type() {
        return room_Type;
    }

    public void setRoom_Type(String room_Type) {
        this.room_Type = room_Type;
    }

    public int getRoom_Capacity() {
        return room_Capacity;
    }

    public void setRoom_Capacity(int room_Capacity) {
        this.room_Capacity = room_Capacity;
    }

    public int getRoom_Amount() {
        return room_Amount;
    }

    public void setRoom_Amount(int room_Amount) {
        this.room_Amount = room_Amount;
    }

    @Override
    public String toString() {
        return "Room{" +
                "room_ID=" + room_ID +
                ", room_Type='" + room_Type + '\'' +
                ", room_Capacity=" + room_Capacity +
                ", room_Amount=" + room_Amount +
                '}';
    }
}
