public class Hotel {

    private String hotel_Name;
    private int hotel_ID;
    private String hotel_Address;
    private String hotel_Phone_Number;
    private String hotel_City;
    private String hotel_Country;
    private String hotel_Email;
    private String hotel_Zip_Code;

    public Hotel (String hotel_Name, String hotel_City, String hotel_Country) {
        this.hotel_Name = hotel_Name;
        this.hotel_City = hotel_City;
        this.hotel_Country = hotel_Country;
    }

    public Hotel(String hotel_Name, int hotel_ID, String hotel_Address, String hotel_Phone_Number, String hotel_City, String hotel_Country, String hotel_Email, String hotel_Zip_Code) {
        this.hotel_Name = hotel_Name;
        this.hotel_ID = hotel_ID;
        this.hotel_Address = hotel_Address;
        this.hotel_Phone_Number = hotel_Phone_Number;
        this.hotel_City = hotel_City;
        this.hotel_Country = hotel_Country;
        this.hotel_Email = hotel_Email;
        this.hotel_Zip_Code = hotel_Zip_Code;
    }

    public Hotel (String hotel_Name) {

            this.hotel_Name = hotel_Name;

    }


    public String getHotel_Name() {
        return hotel_Name;
    }

    public void setHotel_Name(String hotel_Name) {
        this.hotel_Name = hotel_Name;
    }

    public int getHotel_ID() {
        return hotel_ID;
    }

    public void setHotel_ID(int hotel_ID) {
        this.hotel_ID = hotel_ID;
    }

    public String getHotel_Address() {
        return hotel_Address;
    }

    public void setHotel_Address(String hotel_Address) {
        this.hotel_Address = hotel_Address;
    }

    public String getHotel_Phone_Number() {
        return hotel_Phone_Number;
    }

    public void setHotel_Phone_Number(String hotel_Phone_Number) {
        this.hotel_Phone_Number = hotel_Phone_Number;
    }

    public String getHotel_City() {
        return hotel_City;
    }

    public void setHotel_City(String hotel_City) {
        this.hotel_City = hotel_City;
    }

    public String getHotel_Country() {
        return hotel_Country;
    }

    public void setHotel_Country(String hotel_Country) {
        this.hotel_Country = hotel_Country;
    }

    public String getHotel_Email() {
        return hotel_Email;
    }

    public void setHotel_Email(String hotel_Email) {
        this.hotel_Email = hotel_Email;
    }

    public String getHotel_Zip_Code() {
        return hotel_Zip_Code;
    }

    public void setHotel_Zip_Code(String hotel_Zip_Code) {
        this.hotel_Zip_Code = hotel_Zip_Code;
    }


    public String toString() {
        return "Name: " + hotel_Name + " " + "Hotel_ID: " + hotel_ID + " " + " Hotel Adress: " + hotel_Address;
    }

//    @Override
//    public String toString() {
//        return "Hotel{" +
//                "hotel_Name='" + hotel_Name + '\'' +
//                ", hotel_ID=" + hotel_ID +
//                ", hotel_Address='" + hotel_Address + '\'' +
//                ", hotel_Phone_Number='" + hotel_Phone_Number + '\'' +
//                ", hotel_City='" + hotel_City + '\'' +
//                ", hotel_Country='" + hotel_Country + '\'' +
//                ", hotel_Email='" + hotel_Email + '\'' +
//                ", hotel_Zip_Code='" + hotel_Zip_Code + '\'' +
//                '}';
    }

