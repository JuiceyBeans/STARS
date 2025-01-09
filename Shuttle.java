
/**
 * A shuttle provides a one-way connection between two planets. It
 * has a Shuttle code and information about both the source and
 * the destination planet
 *
 * @author (Murtaza Alam)
 * @version (a version number or a date)
 */

/**
 * Represents a shuttle connecting two planets in the STARS resort.
 * Each shuttle has a unique code and connects a source planet to a destination planet.
 */
public class Shuttle {
    private final String code; // Unique code for the shuttle
    private final Planet sourcePlanet; // Source planet
    private final Planet destinationPlanet; // Destination planet

    // Constructor
    public Shuttle(String code, Planet sourcePlanet, Planet destinationPlanet) {
        this.code = code;
        this.sourcePlanet = sourcePlanet;
        this.destinationPlanet = destinationPlanet;
    }

    // Accessor for shuttle code
    public String getCode() {
        return code;
    }

    // Accessor for source planet
    public Planet getSource() {
        return sourcePlanet;
    }

    // Accessor for destination planet
    public Planet getDestination() {
        return destinationPlanet;
    }

    // Check if a permit can use this shuttle
    public boolean canEnterShuttle(Permit permit) {
        if (permit.getRating() < destinationPlanet.getRating()) {
            return false; // Luxury rating too low
        }
        if (destinationPlanet.isFull()) {
            return false; // Destination planet is full
        }
        if (!sourcePlanet.isPermitOnPlanet(permit)) {
            return false; // Permit is not on the source planet
        }
        if (!permit.hasTokensForShuttle()) {
            return false; // Not enough tokens
        }
        return true; // All conditions satisfied
    }

    // Process a permit moving to the destination planet
    public String processPermitMovement(Permit permit) {
        if (!canEnterShuttle(permit)) {
            return "Permit cannot use this shuttle due to unsatisfied conditions.";
        }

        sourcePlanet.leave(permit); // Remove from source planet
        destinationPlanet.arrive(permit); // Add to destination planet
        permit.removeTokens(3); // Deduct tokens for the journey
        permit.addPoints(1); // Add points for the journey
        return "Permit " + permit.getId() + " successfully moved to " + destinationPlanet.getName();
    }

    // Override toString to include shuttle details
    @Override
    public String toString() {
        return "Shuttle [Code: " + code +
                ", From: " + sourcePlanet.getName() +
                ", To: " + destinationPlanet.getName() + "]";
    }
}