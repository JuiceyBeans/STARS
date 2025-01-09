import java.util.*;
/**
 * Write a description of class ResortUI here.
 *
 * @author (MurtazaAlam)
 * @version (09/1/2025)
 */
public class ResortUI
{

    private Scanner reader = new Scanner(System.in);
    private STARS wayward = new Resort("Wayward Planets");

    private void runUI()
    {

        int choice = getOption();
        while (choice != 0)
        {
            // process choice
            if      (choice == 1){listAllPlanets();}
            else if (choice == 2){listOnePlanet();}
            else if (choice == 3){findPermitLocation();}
            else if (choice == 4){tryTravel();}
            else if (choice == 5){travelNow();}
            else if (choice == 6){getPermitInfo();}
            else if (choice == 7){updateTokens();}
            else if (choice == 8){convertPoints();}
            // output menu & get choice
            choice = getOption();
        }
        System.out.println("\nThank-you");
    }


    private int getOption()
    {
        System.out.println("What would you like to do ?");
        System.out.println("0. Quit");
        System.out.println("1. List all planet details");
        System.out.println("2. List all permits on one planet");
        System.out.println("3. Find permit location");
        System.out.println("4. Say if permit can move by shuttle");
        System.out.println("5. Move a permit by shuttle");
        System.out.println("6. Get permit details");
        System.out.println("7. Top up tokens");
        System.out.println("8. Convert Points");
        //output menu and get choice
        System.out.println("Enter your choice");
        // read choice
        int option = reader.nextInt();
        reader.nextLine();
        return option;
    }

    // provide the code here
    private void listAllPlanets() {
        System.out.println(wayward.toString());
    }


    // This one has been done for you
    private void listOnePlanet()
    {
        System.out.println("Enter name of planet");
        String ww = reader.nextLine();
        System.out.println(wayward.getAllPermitsOnOnePlanet(ww));
    }

    // provide the code here
    private void findPermitLocation() {
        System.out.print("Enter permit ID: ");
        int permitId = reader.nextInt();
        reader.nextLine(); // Consume newline
        String location = wayward.getPermitLocation(permitId);
        if (location != null) {
            System.out.println("Permit is on planet: " + location);
        } else {
            System.out.println("No such permit found.");
        }
    }

    // This one has been done for you
    private void tryTravel()
    {
        System.out.println("Enter permit id");
        int trav = reader.nextInt();
        reader.nextLine();
        System.out.println("Enter shuttle code");
        String shuttle = reader.nextLine();
        System.out.println(wayward.canTravel(trav,shuttle));
    }

    // Provide the code here
    private void travelNow() {
        System.out.print("Enter permit ID: ");
        int permitId = reader.nextInt();
        reader.nextLine(); // Consume newline
        System.out.print("Enter shuttle code: ");
        String shuttleCode = reader.nextLine();
        String result = wayward.travel(permitId, shuttleCode);
        System.out.println(result);
    }


    // this one has been done for you
    private void getPermitInfo()
    {
        System.out.println("Enter permit id");
        int trav = reader.nextInt();
        System.out.println(wayward.getPermitDetails(trav));
    }

    // provide the code here
    private void updateTokens() {
        System.out.print("Enter permit ID: ");
        int permitId = reader.nextInt();
        System.out.print("Enter number of tokens to add: ");
        int tokens = reader.nextInt();
        reader.nextLine(); // Consume newline
        wayward.topUpTokens(permitId, tokens);
        System.out.println("Tokens updated.");
    }

    // provide the code here
    private void convertPoints() {
        System.out.print("Enter permit ID: ");
        int permitId = reader.nextInt();
        reader.nextLine(); // Consume newline
        wayward.convertPoints(permitId);
        System.out.println("Points converted to tokens.");
    }


    public static void main(String[] args)
    {
        ResortUI xx = new ResortUI();
        xx.runUI();
    }
}