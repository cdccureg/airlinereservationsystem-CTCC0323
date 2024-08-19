package airlinereservationsystem;
import java.util.Scanner;

// Main class that handles the airline reservation system
public class AirlineReservationSystem {
    private static int FIRST_CLASS_SEATS = 5;  // Number of seats in First Class
    private static int ECONOMY_SEATS = 5;      // Number of seats in Economy
    private static boolean[] firstClass = new boolean[FIRST_CLASS_SEATS];  // Array to track seat availability in First Class
    private static boolean[] economy = new boolean[ECONOMY_SEATS];        // Array to track seat availability in Economy

    // Main method to start the program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Scanner for user input
        while (true) {  // Main loop to keep the program running until the user chooses to exit
            System.out.println("\nWelcome to Lawin Airlines!");
            System.out.println("1. View Seat Availability");
            System.out.println("2. Book a Seat");
            System.out.println("3. Exit");
            System.out.print("Please select an option: ");
            int option = scanner.nextInt();  // Get user's choice

            // Handle user's menu selection
            switch (option) {
                case 1:
                    viewSeats();  // View the status  of all seats
                    break;
                case 2:
                    bookSeat(scanner);  // Book a seat in the desired class
                    break;
                case 3:
                    System.out.println("Thank you for choosing Lawin Airlines!");
                    return;  // Exit the program
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Display the status of all seats in both First Class and Economy
    private static void viewSeats() {
        System.out.println("\nFirst Class Seats:");
        for (int i = 0; i < FIRST_CLASS_SEATS; i++) {
            System.out.print("Seat " + (i + 1) + ": " + (firstClass[i] ? "Taken" : "Available") + "\n");
        }

        System.out.println("\nEconomy Seats:");
        for (int i = 0; i < ECONOMY_SEATS; i++) {
            System.out.print("Seat " + (i + 1) + ": " + (economy[i] ? "Taken" : "Available") + "\n");
        }
    }

    // Allow the user to book a seat in First Class or Economy
    private static void bookSeat(Scanner scanner) {
        System.out.print("\nSelect Class (1 for First Class, 2 for Economy): ");
        int classChoice = scanner.nextInt();  // Get user's choice of class

        if (classChoice == 1) {
            System.out.println("You selected First Class.");
            bookSeatInClass(scanner, firstClass, FIRST_CLASS_SEATS, "First Class");
        } else if (classChoice == 2) {
            System.out.println("You selected Economy.");
            bookSeatInClass(scanner, economy, ECONOMY_SEATS, "Economy");
        } else {
            System.out.println("Invalid class selection.");
        }
    }

    // Book a seat in the specified class
    private static void bookSeatInClass(Scanner scanner, boolean[] seats, int totalSeats, String className) {
        viewSeatsInClass(seats, totalSeats, className);  // Show available seats in the selected class

        System.out.print("Enter seat number to book: ");
        int seatNumber = scanner.nextInt();  // Get user's seat choice.

        if (seatNumber < 1 || seatNumber > totalSeats) {
            System.out.println("Invalid seat number.");  // Check if the seat number is valid
        } else if (seats[seatNumber - 1]) {
            System.out.println("Sorry, this seat is already taken.");  // Check if the seat is already taken
        } else {
            seats[seatNumber - 1] = true;  // Mark the seat as taken
            System.out.println("Seat " + seatNumber + " in " + className + " has been successfully booked.");
        }
    }

    // Display the status of seats in the specified class
    private static void viewSeatsInClass(boolean[] seats, int totalSeats, String className) {
        System.out.println("\n" + className + " Seats:");
        for (int i = 0; i < totalSeats; i++) {
            System.out.print("Seat " + (i + 1) + ": " + (seats[i] ? "Taken" : "Available") + "\n");
        }
    }
}