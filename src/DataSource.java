import java.sql.*;
import java.util.ArrayList;


public class DataSource {


    private Connection conn = null;

    public DataSource() {
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:booking.db");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public ArrayList<Guest> getAllGuests() {

        ArrayList<Guest> guests = new ArrayList<>();
        String query = "SELECT * FROM guest";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String firstName = resultSet.getString("First_Name");
                String lastName = resultSet.getString("Last_Name");
                String phoneNumber = resultSet.getString("Phone_Number");
                String emailAdress = resultSet.getString("Email_Adress");
                String dateOfBirth = resultSet.getString("Date_Of_Birth");
                int guestID = resultSet.getInt("Guest_ID");
                int reservationID = resultSet.getInt("Reservation_ID");

                guests.add(new Guest(firstName, lastName, phoneNumber, emailAdress, dateOfBirth, guestID,
                        reservationID));

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return guests;
    }

    public int createGuest(Guest newGuest) {

        int incrementID = 0;
        String query = "INSERT INTO guest (First_Name, Last_Name, Phone_Number, Email_Adress, Date_Of_Birth) VALUES(?, ?, ?, ?, ?)";


        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, newGuest.getFirst_Name());
            preparedStatement.setString(2, newGuest.getLast_Name());
            preparedStatement.setString(3, newGuest.getPhoneNumber());
            preparedStatement.setString(4, newGuest.getEmail_Adress());
            preparedStatement.setString(5, newGuest.getDate_Of_Birth());

            preparedStatement.executeUpdate();
            ResultSet generatedkeys = preparedStatement.getGeneratedKeys();

            while (generatedkeys.next()) {
                incrementID = generatedkeys.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return incrementID;

    }

    public ArrayList<Hotel> getAllHotels() {

        ArrayList<Hotel> hotels = new ArrayList<>();
        String query = "SELECT * FROM hotel";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                String hotel_Name = resultSet.getString("Hotel_Name");
                int hotel_ID = resultSet.getInt("Hotel_ID");
                String hotel_Adress = resultSet.getString("Hotel_Address");
                String hotel_PhoneNumber = resultSet.getString("Hotel_Phone_Number");
                String hotel_City = resultSet.getString("Hotel_City");
                String hotel_Country = resultSet.getString("Hotel_Country");
                String hotel_Email_Adress = resultSet.getString("Hotel_Email");
                String hotel_Zip_Code = resultSet.getString("Hotel_Zip_Code");
                hotels.add(new Hotel(hotel_Name, hotel_ID, hotel_Adress, hotel_PhoneNumber, hotel_City, hotel_Country, hotel_Email_Adress, hotel_Zip_Code));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hotels;
    }

    public void getAllFacilitys() {


        String query = "SELECT hotel_facilities.Hotel_Facitilies_Name, " +
                "facility.Facility_Name FROM hotel_facilities INNER JOIN facility ON " +
                "hotel_facilities.Hotel_Facilities_ID = facility.Hotel_Facilities_ID";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

               String hotel_facilities_Name = resultSet.getString("Hotel_Facitilies_Name");
               String facility_Name = resultSet.getString("Facility_Name");
                System.out.println("Facility name: " + facility_Name + "  " + "Type of facility: " + hotel_facilities_Name);




            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}







