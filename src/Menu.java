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
            System.out.println("2. Show all guests");
            System.out.println("3. Make a reservation");
       //     System.out.println("3. Add guests to a reservation");
            System.out.println("4. Show guests in a reservation");
            System.out.println("5. Get a list of all the hotels");
            System.out.println("6. Show facilities connected to hotels");
            System.out.println("7. Exit program");


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
                    showAllGuest();
                    break;

                case 3:
                    searchFreeRoomsAndBook();
                    break;

         //       case 3:
           //         addPeopleToReservation();
           //         break;

                case 4:
                    showGuestsByReservation();
                    break;

                case 5:
                    showAllHotels();
                    break;

                case 6:
                    ds.getAllFacilitys(3);
                    break;

                case 7:

                    break;
                case 8:
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

    public int searchFreeRoomsAndBook() {

        boolean runReservation = true;
        int bookHotel_ID;
        int bookRoomSize;
        String check_In;
        String check_Out;


        while (runReservation) {

            System.out.println("1. Search for availible rooms");
            System.out.println("2. Book a room");


            int reservationChoice = Integer.parseInt(scanner.nextLine());

            switch (reservationChoice) {

                case 1:
                    System.out.println("Which Hotel do you want to book? Please enter Hotel ID");
                    bookHotel_ID = Integer.parseInt(scanner.nextLine());


                    System.out.println("Which room size do you want to search for? Press 1 for Single room" +
                            "2 for a double room and 3 for a suite");
                    bookRoomSize = Integer.parseInt(scanner.nextLine());
                    System.out.println("When do you want to check in? Please enter a date in this format year-month-day");
                    check_In = scanner.nextLine();
                    System.out.println("When do you want to check out? Please enter a date in this format year-month-day");
                    check_Out = scanner.nextLine();
                    ds.getFreeRooms(check_Out, check_In, bookHotel_ID, bookRoomSize);
                    System.out.println("Do you want to book the room? Press 1 or yes, 2 to go back to main menu");
                    reservationChoice = Integer.parseInt(scanner.nextLine());

                    if (reservationChoice == 1) {

                        int guestID = 51;
                        int roomNumber = 1108;

                        return ds.createReservation(new Reservation(check_In, check_Out, bookRoomSize, bookHotel_ID, guestID, roomNumber));

                    }



                    break;




            }






        }

            return 1;

    }

}


