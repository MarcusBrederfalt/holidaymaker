import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    Scanner scanner;
    DataSource ds;
    private int choice;

    public Menu() {
        scanner = new Scanner(System.in);
        ds = new DataSource();
        this.choice = choice;
        mainMenu();


    }

    public void mainMenu() {

        System.out.println("Welcome to the holiday booking system");
        System.out.println("Please make a choice");

        boolean runMenu = true;
        while (runMenu) {

            System.out.println("1. Create a guest");
            System.out.println("2. Show all guests");
            System.out.println("3. Add guests to reservation");
            System.out.println("4. Show all hotels");
            System.out.println("5. Show facilities connected to hotels");
            System.out.println("6. Exit program");


            choice = Integer.parseInt(scanner.nextLine());


            switch (choice) {

                case 1:
                    System.out.println("Guest created with ID = " + createGuest() + " in database");

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
                    addPeopleToReservation();
                    break;

                case 4:
                    ds.getAllFacilitys(2);
                    break;

                case 5:

                    break;

                case 6:
                    System.out.println("Welcome back, exiting the program");
                    System.exit(0);
            }


        }

    }

    private void showAllGuest() {
        ArrayList<Guest> guests = ds.getAllGuests();
        for (Guest guest : guests) {
            System.out.println(guest);
        }
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

    public void addPeopleToReservation () {
        System.out.println("Which reservation do you want to add to?");
        int reservationID = Integer.parseInt(scanner.nextLine());
        System.out.println("Which guest do you want to include in the reservation?");
        int addGuestID = Integer.parseInt(scanner.nextLine());
        ds.addGuestToReservation(reservationID, addGuestID);
    }



    }


