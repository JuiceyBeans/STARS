
/**
 * Write a description of class PermitTester here.
 *
 * @author Karthi (Ayush) Suresh
 * @version 9/1/2025
 */
public class PermitTester {
    public static void permitTests() {
        Permit testPermit1 = new Permit(1, "Magnus Arkyve", 6, 9);
        Permit testPermit2 = new Permit(2, "Frederick Fabear", 3, 1);
        Permit testPermit3 = new Permit(3, "Hatsune Miku", 9, 1);

        System.out.println(testPermit1);
        System.out.println("Name: " + testPermit1.getName());
        testPermit1.setPointCount(19);
        System.out.println("Tokens before conversion: " + testPermit1.getTokenCount());
        System.out.println("Points before conversion: " + testPermit1.getPointCount());
        System.out.println("Tokens obtainable from converting points: " + testPermit1.returnPointsToTokens());
        testPermit1.convertPointsToTokens();
        System.out.println("Tokens post conversion: " + testPermit1.getTokenCount());
        System.out.println("Points after conversion: " + testPermit1.getPointCount());


        System.out.println(testPermit2);
        System.out.println("Token count: " + testPermit2.getTokenCount());
        System.out.println("Does permit have enough tokens to use shuttle: " + testPermit2.hasTokensForShuttle());
        testPermit2.addTokens(6);
        System.out.println("Token count: " + testPermit2.getTokenCount());
        System.out.println("Does permit have enough tokens to use shuttle: " + testPermit2.hasTokensForShuttle());
        testPermit2.removeTokens(3);
        System.out.println("Token count: " + testPermit2.getTokenCount());


        System.out.println(testPermit3);
        System.out.println("Rating: " + testPermit3.getRating());
        testPermit3.setRating(1);
        System.out.println("Rating: " + testPermit3.getRating());
        // testPermit3.setRating(13);
    }

    public static void main(String[] args) {
        permitTests();
    }
}
