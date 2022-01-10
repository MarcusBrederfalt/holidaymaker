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
            System.out.println("2. Search for a guest by last name");
            System.out.println("3. Make a reservation");
            System.out.println("4. Add guests to a reservation");
            System.out.println("5. Show guests in a reservation");
            System.out.println("6. Cancel reservation");
            System.out.println("8. Manage facilities connected to hotels");
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
                        System.out.println("Going back to main menu");
                        Output.threadSleep();
                        Output.emptyScreen();
                        break;
                    }


                    break;

                case 2:
                    showGuestsByLastName();
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
                    manageFacilities();
                    break;

                case 9:
                    System.out.println("Welcome back, exiting the program");
                    runMenu = false;
                    break;


            }


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




    }

    public void addPeopleToReservation() {
        System.out.println("Which reservation do you want to add to?");
        int reservationID = Integer.parseInt(scanner.nextLine());
        System.out.println("Which guest do you want to include in the reservation?");
        int addGuestID = Integer.parseInt(scanner.nextLine());
        ds.addGuestToReservation(reservationID, addGuestID);
        System.out.println("Guest with ID " + addGuestID + " added to reservation with ID " + reservationID);
        System.out.println("Going back to main menu");
        Output.threadSleep();
        Output.emptyScreen();


    }

    public void addGuestToReservation() {

        System.out.println("Which reservation do you want to add the guest to?");
        int reservationID = Integer.parseInt(scanner.nextLine());
        System.out.println("Which guest do you want to book?");
        int addGuestID = Integer.parseInt(scanner.nextLine());

        ds.insertGuestToReservation(addGuestID, reservationID);
        ds.addGuestToReservation(reservationID, addGuestID);

        System.out.println("Going back to main menu");
        mainMenu();


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

    public void showGuestsByLastName() {

        System.out.println("Please enter a last name you want to search for");
        String last_Name = scanner.nextLine();

        ArrayList<Guest> guests = ds.getGuestByLastName(last_Name);
        System.out.println("People in reservation with last name " + last_Name+ " :");
        for (Guest guest : guests) {
            System.out.println(guest);
            Output.threadSleep();
        }



        if (guests.size() == 0) {
            System.out.println("No guests with that last name");
            System.out.println("Going back to main menu");
            Output.threadSleep();
            Output.emptyScreen();
        }

    }



    public void searchFreeRoomsAndBook() {

        boolean runReservation = true;
        int bookHotel_ID;
        int bookRoomSize;
        int reservationChoice = 0;
        String check_In;
        String check_Out;


        while (runReservation) {


            System.out.println("Search for availible rooms and book them");
            System.out.println("Which Hotel do you want to search for rooms? Please enter Hotel ID");
            System.out.println("Here is a list of the hotels:");
            ArrayList<Hotel> hotels = ds.getAllHotels();
            for (Hotel hotel : hotels) {
                System.out.println(hotel);


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



            ArrayList<Room_Location> freeRoom = ds.getFreeRooms(check_Out, check_In, bookHotel_ID, bookRoomSize);

            for (Room_Location location : freeRoom) {
                System.out.println(location);

            }

            if (freeRoom.size() == 0) {
                System.out.println("No rooms free");
                System.out.println("Please do another search, going back to main menu");

            } else {

                System.out.println("Do you want to book a room? Press 1 for yes, 2 to go back to main menu");
                reservationChoice = Integer.parseInt(scanner.nextLine());

                switch (reservationChoice) {

                    case 1:

                        System.out.println("Room booked with reservation id  = " + bookRoom(check_In, check_Out, bookRoomSize, bookHotel_ID));
                        System.out.println("Do you want to add a guest to the reservation? Press 1 for yes or 2 to go back to the main menu");
                        reservationChoice = Integer.parseInt(scanner.nextLine());

                        if (reservationChoice == 1) {

                            addGuestToReservation();

                        } else if (reservationChoice == 2) {
                            mainMenu();
                        }

                        break;

                    case 2:
                        mainMenu();
                        break;

                    default:
                        break;


                }

            }


        }

    }

        public int bookRoom (String check_In, String check_Out,int bookRoomSize, int bookHotel_ID){

            System.out.println("Which room number do you choose?");
            int room_Number = Integer.parseInt(scanner.nextLine());

            return ds.createReservation(new Reservation(check_In, check_Out, bookRoomSize, bookHotel_ID, room_Number));


        }

        public void manageFacilities() {

            System.out.println("Manage facilities");
            System.out.println("1. List facilities connected to hotels");
            System.out.println("2. Add facility to hotel");


            boolean runManageFacilities = true;
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1:
                    System.out.println("Here is a list of the hotels: ");
                    showAllHotels();
                    System.out.println();
                    System.out.println("Please enter a hotel id to see facilities");
                    int hotel_ID = Integer.parseInt(scanner.nextLine());
                    ds.getAllFacilitys(hotel_ID);
                    System.out.println("Press 1 to add a facility or press 2 to go back to main menu");
                    choice = Integer.parseInt(scanner.nextLine());
                    if (choice == 1) {
                        addFacility();

                    } else if (choice == 2) {
                        addFacility();
                        break;


                    }

            }
        }
            private int addFacility () {

                System.out.println("Please enter the hotel ID");
                int hotel_ID = Integer.parseInt(scanner.nextLine());

                System.out.println("The name of the facility");
                String facilityName = scanner.nextLine();

                System.out.println("What type of facility is it?");
                System.out.println("Press 1 for pool, 2 for evening entertainment, 3 for restaurant or 4 for childrens club");

                int facilityID = Integer.parseInt(scanner.nextLine());
                System.out.println("Facility added!");
                System.out.println("Going back to Main menu");
                Output.threadSleep();
                Output.emptyScreen();


                return ds.createFacility(new Facility(hotel_ID, facilityName, facilityID));





            }





        }

