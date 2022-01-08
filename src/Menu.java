import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    Scanner scanner;
    DataSource ds;
    private int choice;
    String menuOption;

    public Menu() {
        scanner = new Scanner(System.in);
        ds = new DataSource();
        this.choice = choice;
        mainMenu();


    }

    public void mainMenu() {

        System.out.println("Welcome to the holiday booking system");
        System.out.println("");


        boolean runMenu = true;
        while (runMenu) {

            System.out.println("Main Menu");
            System.out.println();
            System.out.println("1. Create a guest");
            System.out.println("2. Search for a guest");
            System.out.println("3. Make a reservation / see hotel");
            System.out.println("4. Add guests to a reservation");
            System.out.println("5. Show guests in a reservation");
            System.out.println("6. Cancel reservation");
            System.out.println("8. Show facilities connected to hotels");
            System.out.println("9. Exit program");


            choice = Integer.parseInt(scanner.nextLine());


            switch (choice) {

                case 1:
                    System.out.println("Guest created with ID = " + createGuest());

                    System.out.println("Do you want to add another guest? Y/N?");
                    String selection = scanner.nextLine();

                    if (selection == "Y" || selection == "y") {
                        createGuest();
                    } else if (selection == "N" || selection == "n") {
                        break;
                    }


                    break;

                case 2:
                    //search for a guest
                    break;

                case 3:
                    searchFreeRoomsAndBook();
                    break;

                case 4:
                    addPeopleToReservation();
                    break;

                case 5:
                    showGuestsByReservation();
                    break;

                case 6:
                    cancelReservation();
                    break;

                case 7:
                    showAllHotels();
                    break;

                case 8:
                    ds.getAllFacilitys(3);
                    break;

                case 9:
                    break;
                case 10:
                    System.out.println("Welcome back, exiting the program");
                    runMenu = false;
            }


        }

    }

    private void makeReservationMenu() {

        System.out.println("1. List all hotels");
        System.out.println("2. List facilitys connected to hotels");
        System.out.println("3. Search for free rooms");

        int reservationOption = Integer.parseInt(scanner.nextLine());

        boolean runReservation = true;

        while(runReservation);

        switch(reservationOption) {
            case 1:
                showAllHotels();
                break;

            case 2:
                ds.getAllFacilitys(3);
                break;
            case 3:
                searchFreeRoomsAndBook();
                break;
            default:
                break;

        }


    }




    private void showAllGuest() {
        ArrayList<Guest> guests = ds.getAllGuests();
        for (Guest guest : guests) {

            System.out.println(guest);
        }
        Output.threadSleep();
    }

    private int createGuest() {
        String firstName;
        System.out.println("Please enter first name for the guest");
        firstName = scanner.nextLine();
        String lastName;
        System.out.println("Enter last name for the guest");
        lastName = scanner.nextLine();
        String phoneNumber;
        System.out.println("Enter the phone number for the guest");
        phoneNumber = scanner.nextLine();
        String emailAdress;
        System.out.println("Enter the email adress for the guest");
        emailAdress = scanner.nextLine();
        String dateOfBirth;
        System.out.println("Enter the birth date for the guest");
        dateOfBirth = scanner.nextLine();
        return ds.createGuest(new Guest(firstName, lastName, phoneNumber, emailAdress, dateOfBirth));
    }

    private void showAllHotels() {
        ArrayList<Hotel> hotels = ds.getAllHotels();
        for (Hotel hotel : hotels) {
            System.out.println(hotel);
        }
        Output.pause();

        Output.emptyScreen();

    }

    public void addPeopleToReservation() {
        System.out.println("Which reservation do you want to add to?");
        int reservationID = Integer.parseInt(scanner.nextLine());
        System.out.println("Which guest do you want to include in the reservation?");
        int addGuestID = Integer.parseInt(scanner.nextLine());
        ds.addGuestToReservation(reservationID, addGuestID);
    }

    public void cancelReservation() {
        System.out.println("Which reservation do you want to cancel?");
        int reservationID = Integer.parseInt(scanner.nextLine());
        ds.cancelReservation(reservationID);
    }




    public void showGuestsByReservation() {

        System.out.println("Please enter a reservation id");
        int reservation_ID;
        reservation_ID = Integer.parseInt(scanner.nextLine());
        ArrayList<Guest> guests = ds.getGuestByReservation(reservation_ID);
        System.out.println("People in reservation with reservation ID " + reservation_ID + " :");
        for (Guest guest : guests) {
            System.out.println(guest);
        }

    }

    public void searchFreeRoomsAndBook() {

        boolean runReservation = true;
        int bookHotel_ID;
        int bookRoomSize;
        String check_In;
        String check_Out;


        while (runReservation) {

            System.out.println("1. Search for availible rooms and book them");

            int reservationChoice = Integer.parseInt(scanner.nextLine());

            switch (reservationChoice) {

                case 1:
                    System.out.println("Which Hotel do you want to search for rooms? Please enter Hotel ID");
                    System.out.println("Here is a list of the hotels:");
                    ArrayList<Hotel> hotels = ds.getAllHotels();
                    for (Hotel hotel : hotels) {
                        System.out.println(hotel);


                        }

                    }

                    bookHotel_ID = Integer.parseInt(scanner.nextLine());


                    System.out.println("Which room size do you want to search for? Press 1 for Single room" +
                            "2 for a double room and 3 for a suite");
                    bookRoomSize = Integer.parseInt(scanner.nextLine());
                    System.out.println("When do you want to check in? Please enter a date in this format: year-month-day");
                    System.out.println("Please remember, at the moment the hotels are only bookable between 220601 - 220731");
                    check_In = scanner.nextLine();
                    System.out.println("When do you want to check out? Please enter a date in this format: year-month-day");
                    check_Out = scanner.nextLine();



                    ds.getFreeRooms(check_Out, check_In, bookHotel_ID, bookRoomSize);

                    if (ds.getCounter() == 0) {
                        System.out.println("No rooms available, do a new search");
                        searchFreeRoomsAndBook();

                    }
                    else {

                        System.out.println("Do you want to book the room? Press 1 for yes, 2 to go back to main menu");
                        reservationChoice = Integer.parseInt(scanner.nextLine());
                    }
                    if (reservationChoice == 1) {


                        System.out.println("Room booked with reservation id  = " + bookRoom(check_In, check_Out, bookRoomSize, bookHotel_ID));
                        System.out.println("Do you want to add a guest to the reservation?");
                        reservationChoice = Integer.parseInt(scanner.nextLine());

                        if (reservationChoice == 1) {
                            addPeopleToReservation();

                        }
                        else if (reservationChoice == 2) {
                            mainMenu();
                        }

                    }



                    break;
            }

    }

        public int bookRoom(String check_In, String check_Out, int bookRoomSize, int bookHotel_ID) {

            System.out.println("Which room number do you choose?");
            int room_Number = Integer.parseInt(scanner.nextLine());

            return ds.createReservation(new Reservation(check_In, check_Out, bookRoomSize, bookHotel_ID, room_Number));


    }

}


