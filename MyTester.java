 
import java.util.*;
/**
 * Write a description of class MyTester here.
 * 
 * @author (MurtazaAlam)
 * @version (09/01/2025)
 */
public class MyTester 
{
    private void doTest1() {
        // Declare and initialize the Resort object
        Resort wayward = new Resort("Wayward Planets");

        // TEST 1: Add planets to the Resort
        System.out.println("Test 1: Adding planets...");
        wayward.addPlanet(1, "Earth", 5, 10);
        wayward.addPlanet(2, "Mars", 7, 5);
        wayward.addPlanet(3, "Venus", 4, 8);
        System.out.println("Expected: 3 planets added successfully.");
        System.out.println("Actual: \n" + wayward);

        // TEST 2: Add permits to the Resort
        System.out.println("\nTest 2: Adding permits...");
        wayward.addPermit(101, "Alice", 6);
        wayward.addPermit(102, "Bob", 5);
        wayward.addPermit(103, "Charlie", 3);
        System.out.println("Expected: 3 permits added successfully.");
        System.out.println("Actual: " + wayward.getPermitDetails(101) + ", " +
                wayward.getPermitDetails(102) + ", " + wayward.getPermitDetails(103));

        // TEST 3: Place permits on planets
        System.out.println("\nTest 3: Placing permits on planets...");
        wayward.addPermitToPlanet(101, "Earth");
        wayward.addPermitToPlanet(102, "Mars");
        wayward.addPermitToPlanet(103, "Venus");
        System.out.println("Expected: Permits placed on their respective planets.");
        System.out.println("Actual: " + wayward);

        // TEST 4: Check travel conditions
        System.out.println("\nTest 4: Checking travel conditions...");
        System.out.println("Permit 101 to Mars (Should pass): " + wayward.canTravel(101, "S001")); // Assume Shuttle S001
        System.out.println("Permit 103 to Mars (Should fail - luxury rating): " + wayward.canTravel(103, "S001"));

        // TEST 5: Travel permits via shuttles
        System.out.println("\nTest 5: Traveling permits...");
        System.out.println("Result: " + wayward.travel(101, "S001")); // Assume Shuttle S001 connects Earth to Mars
        System.out.println("Updated Wayward State: \n" + wayward);

        // TEST 6: Top up tokens
        System.out.println("\nTest 6: Topping up tokens...");
        wayward.topUpTokens(102, 5);
        System.out.println("Expected: Permit 102 has 5 more tokens.");
        System.out.println("Actual: " + wayward.getPermitDetails(102));

        // TEST 7: Convert points to tokens
        System.out.println("\nTest 7: Converting points...");
        wayward.convertPoints(101);
        System.out.println("Expected: Permit 101 converts points to tokens.");
        System.out.println("Actual: " + wayward.getPermitDetails(101));

        // Conclusion
        System.out.println("\nTesting complete!");
    }

    public static void main(String[] args)
    {
        MyTester xx = new MyTester();
        xx.doTest1();
    }
}
