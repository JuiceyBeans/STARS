import java.util.ArrayList;
import java.util.Objects;

/**This class implements the STARS interface
 *
 * @author A.A.Marczyk, Karthi (Ayush) Suresh
 * @version 09/01/2025
 **/
public class Resort implements STARS
{
    private String location;
    private ArrayList<Planet> planets;
    private ArrayList<Shuttle> shuttles;
    private ArrayList<Permit> permits;

    /** constructor
     */
    public Resort(String loc) 
    {
        location = loc;
        this.planets = new ArrayList<>();
        this.shuttles = new ArrayList<>();
        this.permits = new ArrayList<>();

        loadPlanets();
        setUpShuttles();
        loadPermits();

        Planet home = planets.get(0); // Home is index 0
        for (Permit permit : permits) {
            home.arrive(permit);
        }
    }
    
    /**
     * Returns all of the details of all planets including the permits
     * currently on each planet, or "No permits"
     * @return all of the details of all planets including location 
     * and all permits currently on each planet, or "No permits" 
     */
    public String toString()
    {
        String s = "";

        for (Planet planet : planets) {
            s = s.concat(planet.toString());
//            if ((planet.getId() != planets.getLast().getId())) {
//                s = s.concat("");
//            }
        }



        return s;
    }
    
    /**Returns a String with details of a permit
     * @param permitId - id number of the permit
     * @return the details of the permit as a String, or "No such permit"
     */
    public String getPermitDetails(int permitId)
    {
        if (permits.get(permitId) != null) {
            return permits.get(permitId).toString();
        } else return "No such permit";
    }

    /**Returns the name of the planet which contains the specified permit or null
     * @param tr - the specified permit
     * @return the name of the Planet which contains the permit, or null
     **/
    public String getPermitLocation(int tr)
    {
        for (Planet planet : planets) {
            if (planet.isPermitOnPlanet(permits.get(tr))) {
                return planet.getName();
            }
        }
        return null;
    }
    
    /** Given the name of a planet, returns the planet id number
     * or -1 if planet does not exist
     * @param name of planet
     * @return id number of planet
     */
    public int getPlanetNumber(String ww)
    {
        int p = -1;

        for (Planet planet : planets) {
            if (Objects.equals(planet.getName(), ww)) {
                p = planet.getId();
            }
        }
        return p;
    }
                
    /**Returns a String representation of all the permits on specified planet
     * @return a String representation of all permits on specified planet
     **/
    public String getAllPermitsOnOnePlanet(String planet)
    {
        String s = "\nPermits on " + planet + ":\n";
        
        for (Planet pPlanet: planets) {
            if (Objects.equals(pPlanet.getName(), planet)) {
                s = s.concat(pPlanet.getPermitDetails());
            }
        }
        return s;
    } 

    
    /**Returns true if a Permit is allowed to move using the shuttle, false otherwise
     * A move can be made if:  
     * the rating of the permit  >= the rating of the destination planet
     * AND the destination planet is not full
     * AND the permit has sufficient tokens
     * AND the permit is currently in the source planet
     * AND the permit id is for a permit on the system
     * AND the shuttle code is the code for a shuttle on the system
     * @param trId is the id of the permit requesting the move
     * @param shtlCode is the code of the shuttle journey by which the permit wants to pPermitel
     * @return true if the permit is allowed on the shuttle journey, false otherwise 
     **/
    public boolean canTravel(int trId, String shtlCode) {
        Permit permit = getPermit(trId);
        assert permit != null;
        Shuttle shuttle = getShuttle(shtlCode);
        assert shuttle != null;

        Planet sourcePlanet = shuttle.getSource();
        Planet destinationPlanet = shuttle.getDestination();
        int cost = 3;

        if (!(permit.getRating() >= destinationPlanet.getRating())) {
            System.out.println("Permit rating is lower than destination's rating");
            return false;
        }
        if ((destinationPlanet.isFull())) {
            System.out.println("Destination is at max capacity");
            return false;
        }
        if (!(permit.getTokenCount() >= cost)) {
            System.out.println("Not enough tokens");
            return false;
        }
        if (!(sourcePlanet.isPermitOnPlanet(permit))) {
            System.out.println("Permit is not on the source planet");
            return false;
        }
        if (!(shuttles.contains(shuttle))) {
            System.out.println("Shuttle does not exist");
            return false;
        }

        return true;
    }

    /**Returns the result of a permit requesting to move by Shuttle.
     * A move will be successful if:  
     * the luxury rating of the permit  >= the luxury rating of the destination planet
     * AND the destination planet is not full
     * AND the permit has sufficient tokens
     * AND the permit is currently in the source planet
     * AND the permit id is for a permit on the system
     * AND the shuttle code is the code for a shuttle on the system
     * If the shuttle journey can be made, the permit information is removed from the source
     * planet, added to the destination planet and a suitable message returned.
     * If shuttle journey cannot be made, the state of the system remains unchanged
     * and a message specifying the reason is returned.
     * @param pPermitId is the id of the permit requesting the move
     * @param shtlCode is the code of the shuttle journey by which the permit wants to pPermitel
     * @return a String giving the result of the request 
     **/
    public String travel(int pPermitId, String shtlCode )
    {   
        String s = "";
        Permit permit = getPermit(pPermitId);
        Shuttle shuttle = getShuttle(shtlCode);
        assert shuttle != null;
        Planet sourcePlanet = shuttle.getSource();
        Planet destinationPlanet = shuttle.getDestination();

        if (canTravel(pPermitId, shtlCode)) {
            sourcePlanet.leave(permit);
            destinationPlanet.arrive(permit);
            permit.removeTokens(3);
            permit.addPoints(5);
            s = "Successfully moved " + permit.getName() + " from " + sourcePlanet.getName() + " to " + destinationPlanet.getName();
        } else {
            s = "Could not travel!";
        }

        return s;
    }

    /** Add a permit to a planet
     * @param pPermitId Permit ID
     * @param pPlanetName Planet name
     */
    public void addPermitToPlanet(int pPermitId, String pPlanetName) {
        Permit permit = getPermit(pPermitId);
        Planet planet = getPlanet(pPlanetName);
        assert planet != null;

        planet.arrive(permit);
    }

    /** Allows a permit to top up their tokens.This method is not concerned with 
     *  the cost of a credit as currency and prices may vary between resorts.
     *  @param id the id of the permit toping up their tokens
     *  @param tkns the number of tokens purchased to be added to permits information
     */
    public void topUpTokens(int id, int tkns) {
        permits.get(id).addTokens(tkns);
    }
    
    /** Allows the points on a permit to be converted to tokens (4 points = 1 token)
     *  @param id the id of the card toping up their tokens
     */
    public void convertPoints(int id) {
        permits.get(id).convertPointsToTokens();
    }

    /** Add planet to the system
     * @param id Planet ID
     * @param name Planet name
     * @param rating Luxury rating of planet
     * @param capacity Max capacity of planet
     */
    public void addPlanet(int id, String name, int rating, int capacity) {
        planets.add(new Planet(id, name, rating, capacity));
    }
    /** Add planet to the system
     * @param code Shuttle code
     * @param sourcePlanetId ID of source planet
     * @param destinationPlanetId ID of destination planet
     */
    public void addShuttle(String code, int sourcePlanetId, int destinationPlanetId) {
        shuttles.add(new Shuttle(code, planets.get(sourcePlanetId), planets.get(destinationPlanetId)));
    }

    /** Add planet to the system
     * @param id ID of permit
     * @param guestName Guest's name
     * @param rating Luxury rating of guest
     * @param tokenCount Guest's token count. Default: 0
     */
    public void addPermit(int id, String guestName, int rating, int tokenCount) {
        permits.add(new Permit(id, guestName, rating, tokenCount));
    }
    public void addPermit(int id, String guestName, int rating) {
        addPermit(id, guestName, rating, 0);
    }
   
    //***************private methods**************
    private void loadPlanets()
    {
        addPlanet(0, "Home", 1, 256);
        addPlanet(1, "Naboo", 9, 32);
        addPlanet(2, "Caladan", 6, 4);
        addPlanet(3, "Tau Ceti B", 5, 14);
        addPlanet(4, "Giedi Prime", 2, 7);
        addPlanet(5, "Hoth", 1, 17);
    }
    
    private void setUpShuttles() {
        addShuttle("S001", 0, 1);
        addShuttle("S002", 2, 0);
        addShuttle("S003", 4, 3);
        addShuttle("S004", 1, 2);
    }
    
    private void loadPermits() {
        addPermit(0, "Debug Onion", 9, 9);
        addPermit(1, "Magnus Arkyve", 6, 9);
        addPermit(2, "Frederick Fabear", 3, 1);
        addPermit(3, "Hatsune Miku", 9, 1);
    }
 
    /** Returns the permit with the permit id specified by the parameter
     * @return the permit with the specified name
     **/
    public Permit getPermit(int id) {
        return permits.get(id);
    }
    
    
    /** Returns the planet with the name specified by the parameter
     * @return the planet with the specified name
     **/
    private Planet getPlanet(String planetName) {
        Planet p = null;
        
        for (Planet planet : planets) {
            if (Objects.equals(planet.getName(), planetName)) {
                p = planet;
            }
        }
        return p;
    }
    
    /** Returns the shuttle with the code specified by the parameter
     * @return the shuttle with the specified code
     **/
    private Shuttle getShuttle(String shut) {
        Shuttle s = null;
        for (Shuttle shuttle : shuttles) {
            if (Objects.equals(shuttle.getCode(), shut)) {
                s = shuttle;
            }
        }
        return s;
    }
}