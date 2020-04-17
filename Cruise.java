/*
 *
 * @author Noah Pohl
 * Cruise.java
 *
 */


public class Cruise {

    // Instance Variables
    private String cruiseName;
    private String cruiseShipName;
    private String departurePort;
    private String destination;
    private String returnPort;

    // Constructor - default
    Cruise() {
    }

    // Constructor - full
    Cruise(String tCruiseName, String tShipName, String tDeparture, String tDestination, String tReturn) {
        cruiseName = tCruiseName;
        cruiseShipName = tShipName;
        departurePort = tDeparture;
        destination = tDestination;
        returnPort = tReturn;
    }

    // Accessors
    public String getCruiseName() {
        return cruiseName;
    }

    public String getCruiseShipName() {
        return cruiseShipName;
    }

    public String getDeparturePort() {
        return departurePort;
    }

    public String getDestination() {
        return destination;
    }

    public String getReturnPort() {
        return returnPort;
    }

    // Mutators
    public void setCruiseName(String tVar) {
        cruiseName = tVar;
    }

    public void setCruiseShipName(String tVar) {
        cruiseShipName = tVar;
    }

    public void setDeparturePort(String tVar) {
        departurePort = tVar;
    }

    public void setDestination(String tVar) {
        destination = tVar;
    }

    public void setReturnPort(String tVar) {
        returnPort = tVar;
    }

    // print cruise details
    public void printCruiseDetails() {

        // complete this method

        // add spacing after Cruise name

        // cruiseNameSpace variable will be used for appropriate spacing
        String cruiseNameSpace = "";
        int spaceCount = 20 - cruiseName.length();
        // for loop to get required spacing
        for (int i = 0; i < spaceCount; i++) {
            cruiseNameSpace = cruiseNameSpace + " ";
        }

        // space out the cruise ship name
        // cruiseShipSpace variable will be used for appropriate spacing
        String cruiseShipSpace = "";
        int cruiseShipCount = 20 - cruiseShipName.length();
        // for loop to get required spacing
        for (int i = 0; i < cruiseShipCount; i++) {
            cruiseShipSpace = cruiseShipSpace + " ";
        }

        // add the necessary spacing after departure
        // departureSpace variable will be used for appropriate spacing
        String departureSpace = "";
        int departureCount = 20 - departurePort.length();
        // for loop to get required spacing
        for (int i = 0; i < departureCount; i++) {
            departureSpace = departureSpace + " ";
        }

        // finally add up the necessary spacing after destination
        // destinationSpace variable will be used for appropriate spacing
        String destinationSpace = "";
        int destinationCount = 20 - destination.length();
        // for loop to get required spacing
        for (int i = 0; i < destinationCount; i++) {
            destinationSpace = destinationSpace + " ";
        }

        // Print out the results of the Cruise details using the correct spacing variables
        System.out.println(cruiseName + cruiseNameSpace + cruiseShipName + cruiseShipSpace + departurePort + departureSpace + destination + destinationSpace + returnPort);

    }

    // method added to print ship's name vice memory address
    @Override
    public String toString() {
        return cruiseName;
    }
}
