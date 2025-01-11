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
        Resort test = new Resort("Test Planets");

        // TEST 1: Add planets to the Resort
        System.out.println("Test 1: Adding planets...");
        test.addPlanet(6, "Earth", 5, 10);
        test.addPlanet(7, "Mars", 7, 5);
        test.addPlanet(8, "Venus", 4, 8);
        System.out.println("Expected: 3 planets added successfully.");
        System.out.println("Actual: \n" + test);

        // TEST 2: Add permits to the Resort
        System.out.println("\nTest 2: Adding permits...");
        test.addPermit(4, "Alice", 6);
        test.addPermit(5, "Bob", 5);
        test.addPermit(6, "Charlie", 3);
        System.out.println("Expected: 3 permits added successfully.");
        System.out.println("Actual: " + test.getPermitDetails(4) + ", " +
                test.getPermitDetails(5) + ", " + test.getPermitDetails(6));

        // TEST 3: Place permits on planets
        System.out.println("\nTest 3: Placing permits on planets...");
        test.addPermitToPlanet(4, "Earth");
        test.addPermitToPlanet(5, "Mars");
        test.addPermitToPlanet(6, "Venus");
        System.out.println("Expected: Permits placed on their respective planets.");
        System.out.println("Actual: " + test);

        // TEST 4: Check travel conditions
        System.out.println("\nTest 4: Checking travel conditions...");
        System.out.println("Permit 4 to Mars (Should pass): " + test.canTravel(4, "S001")); // Assume Shuttle S001
        System.out.println("Permit 6 to Mars (Should fail - luxury rating): " + test.canTravel(6, "S001"));

        // TEST 5: Travel permits via shuttles
        System.out.println("\nTest 5: Traveling permits...");
        System.out.println("Result: " + test.travel(4, "S001")); // Assume Shuttle S001 connects Earth to Mars
        System.out.println("Updated Wayward State: \n" + test);

        // TEST 6: Top up tokens
        System.out.println("\nTest 6: Topping up tokens...");
        test.topUpTokens(5, 5);
        System.out.println("Expected: Permit 5 has 5 more tokens.");
        System.out.println("Actual: " + test.getPermitDetails(5));

        // TEST 7: Convert points to tokens
        System.out.println("\nTest 7: Converting points...");
        test.convertPoints(4);
        System.out.println("Expected: Permit 4 converts points to tokens.");
        System.out.println("Actual: " + test.getPermitDetails(4));

        // Conclusion
        System.out.println("\nTesting complete!");
    }

    public static void main(String[] args)
    {
        MyTester xx = new MyTester();
        xx.doTest1();
    }
}