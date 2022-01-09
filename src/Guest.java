public class Guest {

    private String first_Name;
    private String last_Name;
    private String phoneNumber;
    private String email_Adress;
    private String date_Of_Birth;
    private int guest_ID;
    private int reservation_ID;



    public Guest (String first_Name, String last_Name, String phoneNumber, String email_Adress, String date_Of_Birth,
                  int guest_ID, int reservation_ID) {
        this.first_Name = first_Name;
        this.last_Name = last_Name;
        this.phoneNumber = phoneNumber;
        this.email_Adress = email_Adress;
        this.date_Of_Birth = date_Of_Birth;
        this.guest_ID = guest_ID;
        this.reservation_ID = reservation_ID;

    }

    public Guest (String first_Name, String last_Name, String phoneNumber, String email_Adress, String date_Of_Birth) {
        this.first_Name = first_Name;
        this.last_Name = last_Name;
        this.phoneNumber = phoneNumber;
       this.email_Adress = email_Adress;
       this.date_Of_Birth = date_Of_Birth;
    }

    public String getFirst_Name() {
        return first_Name;
    }

    public void setFirst_Name(String first_Name) {
        this.first_Name = first_Name;
    }

    public String getLast_Name() {
        return last_Name;
    }

    public void setLast_Name(String last_Name) {
        this.last_Name = last_Name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail_Adress() {
        return email_Adress;
    }

    public void setEmail_Adress(String email_Adress) {
        this.email_Adress = email_Adress;
    }

    public String getDate_Of_Birth() {
        return date_Of_Birth;
    }

    public void setDate_Of_Birth(String date_Of_Birth) {
        this.date_Of_Birth = date_Of_Birth;
    }

    public int getGuest_ID() {
        return guest_ID;
    }

    public void setGuest_ID(int guest_ID) {
        this.guest_ID = guest_ID;
    }

    public int getReservation_ID() {
        return reservation_ID;
    }

    public void setReservation_ID(int reservation_ID) {
        this.reservation_ID = reservation_ID;
    }




    @Override
    public String toString() {
        return "First name: " + first_Name + " " + "Last name: " + last_Name + " " + "Phone number: " + phoneNumber + " " + "Email adress: " + email_Adress + " " + "Date of birth: "+ date_Of_Birth +
                " " + "Guest ID: " + guest_ID + " " + "Reservation ID: " + reservation_ID ;
    }
}
