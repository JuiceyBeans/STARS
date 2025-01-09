
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
    private final String shuttleCode; // Unique code for the shuttle
    private final Planet fromPlanet; // Source planet
    private final Planet toPlanet; // Destination planet

    // Constructor
    public Shuttle(String shuttleCode, Planet fromPlanet, Planet toPlanet) {
        this.shuttleCode = shuttleCode;
        this.fromPlanet = fromPlanet;
        this.toPlanet = toPlanet;
    }

    // Accessor for shuttle code
    public String getShuttleCode() {
        return shuttleCode;
    }

    // Accessor for source planet
    public Planet getFromPlanet() {
        return fromPlanet;
    }

    // Accessor for destination planet
    public Planet getToPlanet() {
        return toPlanet;
    }

    // Check if a permit can use this shuttle
    public boolean canEnterShuttle(Permit permit) {
        if (permit.getLuxuryRating() < toPlanet.getLuxuryRating()) {
            return false; // Luxury rating too low
        }
        if (toPlanet.isFull()) {
            return false; // Destination planet is full
        }
        if (!fromPlanet.isPermitOnPlanet(permit)) {
            return false; // Permit is not on the source planet
        }
        if (!permit.hasEnoughTokens()) {
            return false; // Not enough tokens
        }
        return true; // All conditions satisfied
    }

    // Process a permit moving to the destination planet
    public String processPermitMovement(Permit permit) {
        if (!canEnterShuttle(permit)) {
            return "Permit cannot use this shuttle due to unsatisfied conditions.";
        }

        fromPlanet.leave(permit); // Remove from source planet
        toPlanet.arrive(permit); // Add to destination planet
        permit.deductTokens(3); // Deduct tokens for the journey
        permit.addPoints(1); // Add points for the journey
        return "Permit " + permit.getId() + " successfully moved to " + toPlanet.getName();
    }

    // Override toString to include shuttle details
    @Override
    public String toString() {
        return "Shuttle [Code: " + shuttleCode +
                ", From: " + fromPlanet.getName() +
                ", To: " + toPlanet.getName() + "]";
    }
}