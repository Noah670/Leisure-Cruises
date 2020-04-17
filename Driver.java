import java.util.ArrayList;
import java.util.Scanner;
import java.util.SortedMap;

import static java.lang.Integer.parseInt;

/*
 *
 * @author Noah Pohl
 * Driver.java
 *
 */

public class Driver {

    // instance variables (add more as needed)
    private static ArrayList<Ship> shipList = new ArrayList();
    private static ArrayList<Cruise> cruiseList = new ArrayList();
    private static ArrayList<Passenger> passengerList = new ArrayList();

    // add another cruiseList to test
    private static ArrayList<Cruise> testCruiseList = new ArrayList();

    public static void main(String[] args) {

        initializeShipList(); // initial ships
        initializeCruiseList(); // initial cruises
        initializePassengerList(); // initial passengers

        // add loop and code here that accepts and validates user input
        // and takes the appropriate action. include appropriate
        // user feedback and redisplay the menu as needed

        // create a Scanner object for input
        Scanner input = new Scanner(System.in);

        // create a variable which stores the option the user has chosen on the system
        // menu
        String userChoice;

        // a do while loop that allows the user to interact with menu until they want to
        // quit by pressing 'x' or 'X'
        do {
            displayMenu();
            userChoice = input.next();

            // The left side of the menu which options the user must enter numbers 1-6 as an
            // integer
            // the input we received as a string has to be converted to an int by getting
            // the value of the string and reading the value as an int

            // exception handling using a try catch block for parsing the
            try {
                // create an Integer variable that will store the user choice on the left side
                // as an int
                Integer leftUserChoice = Integer.valueOf(userChoice);

                if (leftUserChoice == 1) {
                    // when 1 is entered call the addShip() method to add a ship to the system
                    addShip();
                } else if (leftUserChoice == 2) {
                    // feature not added
                    System.out.println("Sorry this feature is not yet implemented.");
                } else if (leftUserChoice == 3) {
                    // when 3 is entered call the addCruise() method to add a cruise to the system
                    addCruise();
                } else if (leftUserChoice == 4) {
                    // feature not added
                    System.out.println("Sorry this feature is not yet implemented.");
                } else if (leftUserChoice == 5) {
                    // when 5 is entered call the addPassenger() method to add a passenger to the
                    // system
                    addPassenger();
                } else if (leftUserChoice == 6) {
                    // feature not added
                    System.out.println("Sorry this feature is not yet implemented.");
                }
                // catch the exception if the user enters a value that is not an integer
            } catch (NumberFormatException e) {

            }

            // Now the right side of the menu will be checked where the user is able to
            // enter six different String values
            // the user can enter these values in either upper or lowercase value
            if (userChoice.equalsIgnoreCase("A")) {
                // call the printShipList() method with the output of "name"
                printShipList("name");
            } else if (userChoice.equalsIgnoreCase("B")) {
                // call the printShipList() method to print the Ship in Service list that are
                // "active"
                printShipList("active");
            } else if (userChoice.equalsIgnoreCase("C")) {
                // call the printShipList() method to print the full amount of ships with the
                // parameter "full"
                printShipList("full");
            } else if (userChoice.equalsIgnoreCase("D")) {
                // call the printCruiseList() method with the "list" parameter
                printCruiseList("list");
            } else if (userChoice.equalsIgnoreCase("E")) {
                // call the printCruiseList() method with the "details" parameter
                printCruiseList("details");
            } else if (userChoice.equalsIgnoreCase("F")) {
                // calls the printPassengerList() method
                printPassengerList();
            }

        } while (!userChoice.equalsIgnoreCase("x"));

        // Exit message
        System.out.println("Exiting the system...");
        System.out.println("Thank you for using our Luxury Cruise Services.");

    }

    // hardcoded ship data for testing
    // Initialize ship list
    public static void initializeShipList() {
        add("Candy Cane", 20, 40, 10, 60, true);
        add("Peppermint Stick", 10, 20, 5, 40, true);
        add("Bon Bon", 12, 18, 2, 24, false);
        add("Candy Corn", 12, 18, 2, 24, false);
    }

    // hardcoded cruise data for testing
    // Initialize cruise list
    public static void initializeCruiseList() {
        Cruise newCruise = new Cruise("Southern Swirl", "Candy Cane", "Miami", "Cuba", "Miami");
        cruiseList.add(newCruise);

        // adding another hardcoded cruise data for testing
        Cruise testCruise = new Cruise("Discover Japan", "Diamond Princess", "Tokyo", "San Diego", "Tokyo");
        cruiseList.add(testCruise);

        Cruise anotherCruise = new Cruise("Test", "Ship Test", "Tokyo", "San Diego", "Tokyo");
        cruiseList.add(testCruise);
    }

    // hardcoded cruise data for testing
    // Initialize passenger list
    public static void initializePassengerList() {
        Passenger newPassenger1 = new Passenger("Neo Anderson", "Southern Swirl", "STE");
        passengerList.add(newPassenger1);

        Passenger newPassenger2 = new Passenger("Trinity", "Southern Swirl", "STE");
        passengerList.add(newPassenger2);

        Passenger newPassenger3 = new Passenger("Morpheus", "Southern Swirl", "BAL");
        passengerList.add(newPassenger3);
    }

    // custom method to add ships to the shipList ArrayList
    public static void add(String tName, int tBalcony, int tOceanView, int tSuite, int tInterior, boolean tInService) {
        Ship newShip = new Ship(tName, tBalcony, tOceanView, tSuite, tInterior, tInService);
        shipList.add(newShip);
    }

    public static void printShipList(String listType) {
        // printShipList() method prints list of ships from the
        // shipList ArrayList. There are three different outputs
        // based on the listType String parameter:
        // name - prints a list of ship names only
        // active - prints a list of ship names that are "in service"
        // full - prints tabbed data on all ships

        if (shipList.size() < 1) {
            System.out.println("\nThere are no ships to print.");
            return;
        }
        if (listType == "name") {
            System.out.println("\n\nSHIP LIST - Name");
            for (int i = 0; i < shipList.size(); i++) {
                System.out.println(shipList.get(i));
            }
        } else if (listType == "active") {
            System.out.println("\n\nSHIP LIST - Active");

            // complete this code block

            // check if any active ships are in inventory

            // countActiveShips will count the total of how many ships are in service
            int countActiveShips = 0;
            // enhanced for loop with activeShips to loop through the entire shipList
            for (Ship activeShips : shipList) {
                // chooseShips returns a boolean value of true if the current active ship is in
                // service
                boolean chooseShips = activeShips.getInService();

                if (activeShips.getInService()) {
                    // If the current ship is in service increase the active ship counter
                    countActiveShips++;
                }

                // If there are no active ships in service
                // countActiveShips will be less or equal to 0 as all the shipList will be false
                if (countActiveShips <= 0) {
                    System.out.println("\nThere are no ships currently in service");
                    return;
                }

                // if the current ship is in service
                if (chooseShips == true) {
                    // prints out each Ship that is currently in service
                    System.out.println(activeShips.getShipName());
                }
            }

        } else if (listType == "full") {
            System.out.println("\n\nSHIP LIST - Full");
            System.out.println("-----------------------------------------------");
            System.out.println("                    Number of Rooms     In");
            System.out.print("SHIP NAME           Bal OV  Ste Int     Service");
            System.out.println("\n-----------------------------------------------");
            for (Ship eachShip : shipList)
                eachShip.printShipData();

        } else
            System.out.println("\n\nError: List type not defined.");
    }

    public static void printCruiseList(String listType) {
        if (cruiseList.size() < 1) {
            System.out.println("\nThere are no cruises to print.");
            return;
        }
        if (listType == "list") {
            System.out.println("\n\nCRUISE LIST");
            for (int i = 0; i < cruiseList.size(); i++) {
                System.out.println(cruiseList.get(i));
            }
        } else if (listType == "details") {
            System.out.println("\n\nCRUISE LIST - Details");
            System.out.println(
                    "------------------------------------------------------------------------------------------");
            System.out.println(
                    "                                      |----------------------PORTS-----------------------|");
            System.out.print("CRUISE NAME         SHIP NAME           DEPARTURE           DESTINATION         RETURN");
            System.out.println(
                    "\n-----------------------------------------------------------------------------------------");
            for (Cruise eachCruise : cruiseList)
                eachCruise.printCruiseDetails();
        } else
            System.out.println("\n\nError: List type not defined.");
    }

    public static void printPassengerList() {
        if (passengerList.size() < 1) {
            System.out.println("\nThere are no passengers to print.");
            return;
        }
        System.out.println("\n\nPASSENGER LIST");
        System.out.println("-----------------------------------------------------");
        System.out.print("PASSENGER NAME      CRUISE              ROOM TYPE");
        System.out.println("\n-----------------------------------------------------");
        for (Passenger eachPassenger : passengerList)
            eachPassenger.printPassenger();
    }

    // display text-based menu
    public static void displayMenu() {

        System.out.println("\n\n");
        System.out.println("\t\t\tLuxury Ocean Cruise Outings");
        System.out.println("\t\t\t\t\tSystem Menu\n");
        System.out.println("[1] Add Ship            [A] Print Ship Names");
        System.out.println("[2] Edit Ship           [B] Print Ship In Service List");
        System.out.println("[3] Add Cruise          [C] Print Ship Full List");
        System.out.println("[4] Edit Cruise         [D] Print Cruise List");
        System.out.println("[5] Add Passenger       [E] Print Cruise Details");
        System.out.println("[6] Edit Passenger      [F] Print Passenger List");
        System.out.println("[x] Exit System");
        System.out.println("\nEnter a menu selection: ");
    }

    // Add a New Ship
    public static void addShip() {

        // complete this method
        Scanner addNewShip = new Scanner(System.in);
        System.out.println("Enter a new ship name: ");
        String newShipName = addNewShip.nextLine();

        // check to make sure the ship does not already exist in the system
        for (Ship currentShip : shipList) {
            if (currentShip.getShipName().equalsIgnoreCase(newShipName)) {
                System.out.println("This ship already exists inside of our system, thank you for your service.");
                return; // exits out of the addShip() method
            }
        }

        // get a balcony room
        System.out.println("Please enter the number of balcony rooms on the ship: ");

        // validate balcony room to make sure input is an integer
        while (!addNewShip.hasNextInt()) {
            // if the user does not enter an integer ask them for another input until true
            addNewShip.next();
        }
        // set the input of new Balcony as an integer
        int newBalcony = addNewShip.nextInt();

        // get an Ocean view room
        System.out.println("Please enter the number of Ocean view rooms on the ship: ");

        // validate the Ocean room to make sure input is an integer
        while (!addNewShip.hasNextInt()) {
            // if the user does not input an int ask for input again until true
            addNewShip.next();
        }
        // set the input of new Ocean room as an integer
        int newOceanRoom = addNewShip.nextInt();

        // get the room Suite
        System.out.println("Please enter the number of Room Suites on the ship: ");

        // validate the room suite to make sure input is an integer
        while (!addNewShip.hasNextInt()) {
            // if the user does not input an int ask for input again until true
            addNewShip.next();
        }
        // set the input of new room Suite as an integer
        int newRoomSuite = addNewShip.nextInt();

        // get the Room Interior design
        System.out.println("Please enter the number of Interior rooms on the ship: ");

        // validate the Room interior to make sure input is an integer
        while (!addNewShip.hasNextInt()) {
            // if the user does not input an int ask for input again until true
            addNewShip.next();
        }
        // set the input of new Room interior to an integer
        int newRoomInterior = addNewShip.nextInt();

        // get the Inventory service as a boolean
        System.out.println("Is this ship in service, please enter true or false");

        // validate the Inventory service to make sure input is a boolean
        while (!addNewShip.hasNextBoolean()) {
            // if the user does not input a boolean ask for input again until true
            addNewShip.next();
        }
        // set the input of the new Inventory service
        // assigns the value of InventoryService to either true or false
        boolean newInventoryService = addNewShip.hasNextBoolean();

        // all validations have been passed assign, add the new ship
        Ship newShip = new Ship(newShipName, newBalcony, newOceanRoom, newRoomSuite, newRoomInterior,
                newInventoryService);
        // add newShip to existing shipList
        shipList.add(newShip);

    }

    // Edit an existing ship
    public static void editShip() {

        // This method does not need to be completed
        System.out.println("The \"Edit Ship\" feature is not yet implemented.");

    }

    // Add a New Cruise
    public static void addCruise() {

        // complete this method

        Scanner newCruiseInput = new Scanner(System.in);
        System.out.println("Enter the new cruise name: ");
        String newCruiseName = newCruiseInput.nextLine();

        // check to make sure the cruise does not already exist in the system
        for (Cruise currentCruise : cruiseList) {
            if (currentCruise.getCruiseName().equalsIgnoreCase(newCruiseName)) {
                System.out.println("This cruise already exists within our system, thank you for using our services.");
                return; // exit out of the addCruise() method
            }
        }

        // get the Cruise ship name
        System.out.println("Please enter the name of the Cruise Ship: ");

        // validate the Cruise ship name to make sure input is a String
        while (!newCruiseInput.hasNext()) {
            newCruiseInput.next();
        }
        // set the input of new Cruise Ship name to a String
        String newCruiseShipName = newCruiseInput.nextLine();

        // get the departure port
        System.out.println("Please enter the departure port of the Cruise: ");

        // validate the departure port to make sure input is a String
        while (!newCruiseInput.hasNext()) {
            newCruiseInput.next();
        }
        // set the input of the new departure port to a String
        String newDeparturePort = newCruiseInput.nextLine();

        // get the cruise destination
        System.out.println("Please enter the destination of the cruise: ");

        // validate the destination to make sure input is a String
        while (!newCruiseInput.hasNext()) {
            newCruiseInput.next();
        }
        // set the input of the new destination to a String
        String newDestination = newCruiseInput.nextLine();

        // get the returning port of the cruise
        System.out.println("Please enter the returning port for the cruise: ");

        // validate the destination to make sure input is a String
        while (!newCruiseInput.hasNext()) {
            newCruiseInput.next();
        }
        // set the input of the new returning port to a String
        String newReturningPort = newCruiseInput.next();

        // all validations have now been passed
        // Create the new Cruise with the user inputs

        Cruise newCruise = new Cruise(newCruiseName, newCruiseShipName, newDeparturePort, newDestination,
                newReturningPort);
        // add the new Cruise to the existing cruiseList
        cruiseList.add(newCruise);

    }

    // Edit an existing cruise
    public static void editCruise() {

        // This method does not need to be completed
        System.out.println("The \"Edit Cruise\" feature is not yet implemented.");

    }

    // Add a New Passenger
    public static void addPassenger() {

        Scanner newPassengerInput = new Scanner(System.in);
        System.out.println("Enter the new passenger's name: ");
        String newPassengerName = newPassengerInput.nextLine();

        // ensure new passenger name does not already exist
        for (Passenger eachPassenger : passengerList) {
            if (eachPassenger.getPassengerName().equalsIgnoreCase(newPassengerName)) {
                System.out.println("That passenger is already in the system. Exiting to menu...");
                return; // quits addPassenger() method processing
            }
        }

        // get cruise name for passenger
        System.out.println("Enter cruise name: ");
        String newCruiseName = newPassengerInput.nextLine();

        // ensure cruise exists
        for (Cruise eachCruise : cruiseList) {
            if (!eachCruise.getCruiseName().equalsIgnoreCase(newCruiseName)) {
                // cruise does exist
            } else {
                System.out.println("That cruise does not exist in the system. Exiting to menu...");
                return; // quits addPassenger() method processing
            }
        }

        // get room type
        System.out.println("Enter Room Type (BAL, OV, STE, or INT: ");
        String room = newPassengerInput.nextLine();
        // validate room type
        if ((room.equalsIgnoreCase("BAL")) || (room.equalsIgnoreCase("OV")) || (room.equalsIgnoreCase("STE"))
                || (room.equalsIgnoreCase("INT"))) {
            // validation passed - add passenger
            Passenger newPassenger = new Passenger(newPassengerName, newCruiseName, room.toUpperCase());
            passengerList.add(newPassenger);
        } else {
            System.out.println("Invalid input. Exiting to menu...");
            return; // quits addPassenger() method processing
        }
    }

    // Edit an existing passenger
    public static void editPassenger() {

        // This method does not need to be completed
        System.out.println("The \"Edit Passenger\" feature is not yet implemented.");

    }

    // Method to check if input is a number
    public static boolean isANumber(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i)) == false)
                return false;
        }
        return true;
    }

}
