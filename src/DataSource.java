/**
 *  DataSource class
 *  Here the connection to the database is estabhlised in the constructor.
 *  This class does all the communication with the database
 */


import java.sql.*;
import java.util.ArrayList;


public class DataSource {



    private Connection conn = null;

    public DataSource() {




        // in this case the database is namned booking.db
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

    public void getAllFacilitys(int Hotel_ID) {
        int counter = 0;


        String query = "SELECT hotel_facilities.Hotel_Facitilies_Name, " +
                "facility.Facility_Name, hotel.Hotel_Name, hotel.Hotel_ID FROM hotel_facilities INNER JOIN facility ON " +
                "hotel_facilities.Hotel_Facilities_ID = facility.Hotel_Facilities_ID INNER JOIN hotel ON hotel.Hotel_ID = facility.Hotel_ID WHERE hotel.Hotel_ID = ?";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, Hotel_ID);


            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                counter ++;

                String hotel_facilities_Name = resultSet.getString("Hotel_Facitilies_Name");
                String facility_Name = resultSet.getString("Facility_Name");
                String hotelName = resultSet.getString("Hotel_Name");
                int hotel_ID = resultSet.getInt("Hotel_ID");
                System.out.println("Facility name: " + facility_Name + "  " + "Type of facility: " + hotel_facilities_Name + " Belong to hotel: " + hotelName + hotel_ID);

            }
            if (counter == 0) {
                System.out.println("The hotel dont have any facilites");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public ArrayList<Reservation> getAllReservations() {

        ArrayList<Reservation> reservations = new ArrayList<>();
        String query = "SELECT Reservation_ID FROM reservation";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                int reservationID = resultSet.getInt("Reservation_ID");

                reservations.add(new Reservation(reservationID));

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reservations;
    }

    public void addGuestToReservation(int addReservation_ID, int addGuestID) {

        String query = "UPDATE guest SET Reservation_ID = ? WHERE Guest_ID = ?";


        try {
            PreparedStatement statement = conn.prepareStatement(query);

            statement.setInt(1, addReservation_ID);
            statement.setInt(2, addGuestID);

            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void insertGuestToReservation(int addGuestID, int addReservation_ID) {

        String query = "UPDATE reservation SET Guest_ID = ? WHERE Reservation_ID = ?";


        try {
            PreparedStatement statement = conn.prepareStatement(query);

            statement.setInt(1, addGuestID);
            statement.setInt(2, addReservation_ID);

            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }






    public void cancelReservation(int addReservation_ID) {

        String query = "UPDATE reservation SET Check_In = NULL, Check_Out = NULL, Room_ID = NULL, Hotel_ID = NULL, Number_Of_Guests = NULL" +
                ", Guest_ID = NULL, Room_Number = NULL WHERE Reservation_ID = ?";


        try {
            PreparedStatement statement = conn.prepareStatement(query);

            statement.setInt(1, addReservation_ID);

            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }



    }

    public ArrayList<Guest> getGuestByReservation(int reservation_ID) {

        ArrayList<Guest> guests = new ArrayList<>();
        String query = "SELECT First_Name, Last_Name, Phone_Number, Email_Adress, Date_Of_Birth FROM guest WHERE Reservation_ID = ?";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, reservation_ID);
            ResultSet resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                String firstName = resultSet.getString("First_Name");
                String lastName = resultSet.getString("Last_Name");
                String phoneNumber = resultSet.getString("Phone_Number");
                String emailAdress = resultSet.getString("Email_Adress");
                String dateOfBirth = resultSet.getString("Date_Of_Birth");


                guests.add(new Guest(firstName, lastName, phoneNumber, emailAdress, dateOfBirth));

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return guests;
    }



    public int createReservation(Reservation reservation) {

        int incrementID = 0;
        String query = "INSERT INTO reservation (Check_In, Check_Out, Room_ID, Hotel_ID, " +
                "Room_Number)\n" +
                "VALUES (?, ?, ?, ?, ?)";


        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, reservation.getCheck_In());
            preparedStatement.setString(2,reservation.getCheck_Out());
            preparedStatement.setInt(3, reservation.getRoom_ID());
            preparedStatement.setInt(4, reservation.getHotel_ID());
            preparedStatement.setInt(5, reservation.getRoom_Number());


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


    public ArrayList<Room_Location> getFreeRooms(String check_Out, String check_In, int bookHotel_ID, int bookRoomSize) {

        ArrayList<Room_Location> freeRooms = new ArrayList<>();


        String query = "SELECT room_location.room_Number FROM room_location " +
                "LEFT JOIN reservation ON room_location.Room_Number = reservation.Room_Number AND " +
                "reservation.Check_Out >= ? AND reservation.Check_In <= ? WHERE room_location.Hotel_ID = ? AND room_location.Room_ID = ? and reservation.Reservation_ID IS NULL";


        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, check_In);
            preparedStatement.setString(2, check_Out);
            preparedStatement.setInt(3, bookHotel_ID);
            preparedStatement.setInt(4, bookRoomSize);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {


                int room_Number = resultSet.getInt("Room_Number");
                freeRooms.add(new Room_Location(room_Number));

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return freeRooms;
    }

    public ArrayList<Guest> getGuestByLastName(String inputLastName) {

        ArrayList<Guest> guests = new ArrayList<>();

        String query = "SELECT * FROM guest WHERE Last_Name LIKE ? ";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, inputLastName);
            ResultSet resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                String firstName = resultSet.getString("First_Name");
                String lastName = resultSet.getString("Last_Name");
                String phoneNumber = resultSet.getString("Phone_Number");
                String emailAdress = resultSet.getString("Email_Adress");
                String dateOfBirth = resultSet.getString("Date_Of_Birth");
                int guestID = resultSet.getInt("Guest_ID");
                int reservationID = resultSet.getInt("Reservation_ID");


                guests.add(new Guest(firstName, lastName, phoneNumber, emailAdress, dateOfBirth, guestID, reservationID));

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return guests;
    }

    public int createFacility(Facility newFacility) {

        int incrementID = 0;
        String query = "INSERT INTO facility (Hotel_Facilities_ID, Facility_Name, Hotel_ID) VALUES (?, ?, ?)";


        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, newFacility.getHotel_ID());
            preparedStatement.setString(2, newFacility.getFacility_Name());
            preparedStatement.setInt(3, newFacility.getHotel_Facilities_ID());


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




    }
















