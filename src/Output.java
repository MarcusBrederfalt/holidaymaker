/**
 * Static "help" class, helps with the output to the user. All other classes can use this class.
 * @author marcusbrederfält
 */


import java.util.Scanner;

public class Output {

    public static Scanner scanner = new Scanner(System.in);

      /**
       threadSleep() pauses the program for 2 seconds
     */

    public static void threadSleep() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * emptyScreen() prints ut 50 blank lines.
     */
    public static void emptyScreen() {
        System.out.println("\n".repeat(50));

    }


    public static void pause () {
        System.out.println("Press any key to go back to main menu");
        String menuOption = scanner.nextLine();
    }
}
