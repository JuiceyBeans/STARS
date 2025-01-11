import java.util.ArrayList;
/**
 * A planet is part of a STARS resort.Each planet has a name,  a luxury rating
 * and a capacity which represents the maximum number of permits(people) who can be on the  
 * planet at any one time. Each planet must maintain a list of all permits(people)
 * currently on the planet. These lists are updated whenever permits arrive or leave 
 * a planet,so that it is always possible to say how many permits(people) are on the planet
 * and who they are.
 *
 * @author (Murtaza Alam)
 * @version (09/1/2025)
 */

/**
 * Represents a planet in the STARS resort.
 * Each planet has a name, a luxury rating, a capacity, and a list of permits (guests).
 */
public class Planet {
    private final int id; // Unique ID of the planet
    private final String name; // Planet's name
    private final int rating; // Rating from 1 to 10
    private final int capacity; // Max number of permits allowed on the planet
    private final ArrayList<Permit> permits; // List of permits currently on the planet

    // Constructor
    public Planet(int id, String name, int rating, int capacity) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.capacity = capacity;
        this.permits = new ArrayList<>();
    }

    // Accessor for planet reference number
    public int getId() {
        return id;
    }

    // Accessor for planet name
    public String getName() {
        return name;
    }

    // Accessor for luxury rating
    public int getRating() {
        return rating;
    }

    // Check if the planet has reached its capacity
    public boolean isFull() {
        return permits.size() >= capacity;
    }

    // Add a permit to the planet
    public boolean arrive(Permit permit) {
        if (isFull()) {
            return false; // Cannot add more permits, planet is full
        }
        permits.add(permit);
        return true;
    }

    // Remove a permit from the planet
    public boolean leave(Permit permit) {
        return permits.remove(permit); // Removes and returns true if found
    }

    // Check if a specific permit is on the planet
    public boolean isPermitOnPlanet(Permit permit) {
        return permits.contains(permit);
    }

    // Find a permit on the planet by ID
    public Permit findPermitById(int permitId) {
        for (Permit permit : permits) {
            if (permit.getId() == permitId) { // Assuming Permit class has getId()
                return permit;
            }
        }
        return null; // Permit not found
    }

    // Return details of all permits currently on the planet
    public String getPermitDetails() {
        StringBuilder details = new StringBuilder();
        for (Permit permit : permits) {
            details.append(permit.toString()).append("\n");
        }
        return details.toString();
    }

    // Override toString to include planet details and list of permits
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Planet Name: ").append(name)
                .append(", Rating: ").append(rating)
                .append(", Capacity: ").append(capacity)
                .append(", Current Permits: ").append(permits.size()).append("\n");

        if (!permits.isEmpty()) {
            builder.append("Permits for " + name + ":\n");
            for (Permit permit : permits) {
                builder.append("  ").append(permit.toString()).append("\n");
            }
            builder.append("\n");
        } else {
            builder.append("No permits on this planet\n\n");
        }

        return builder.toString();
    }
}