public class Facility {

    private int hotel_Facilities_ID;
    private String facility_Name;
    private int hotel_ID;

    public Facility (int hotel_Facilities_ID, String facility_Name, int hotel_ID) {
        this.hotel_Facilities_ID = hotel_Facilities_ID;
        this.facility_Name = facility_Name;
        this.hotel_ID = hotel_ID;
    }

    public int getHotel_Facilities_ID() {
        return hotel_Facilities_ID;
    }

    public void setHotel_Facilities_ID(int hotel_Facilities_ID) {
        this.hotel_Facilities_ID = hotel_Facilities_ID;
    }

    public String getFacility_Name() {
        return facility_Name;
    }

    public void setFacility_Name(String facility_Name) {
        this.facility_Name = facility_Name;
    }

    public int getHotel_ID() {
        return hotel_ID;
    }

    public void setHotel_ID(int hotel_ID) {
        this.hotel_ID = hotel_ID;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "hotel_Facilities_ID=" + hotel_Facilities_ID +
                ", facility_Name='" + facility_Name + '\'' +
                ", hotel_ID=" + hotel_ID +
                '}';
    }
}
