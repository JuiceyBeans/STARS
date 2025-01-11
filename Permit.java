/**
 * A Permit has an id number, name, a luxury rating, tokens and points.
 * 
 * @author Karthi (Ayush) Suresh
 * @version 9/1/2025
 */
public class Permit {
    private int id; // todo dont allow to use same id for multiple permits
    private String guestName;
    private int rating;
    private int tokenCount;
    private int pointCount;

    // MAN IT SURE WOULD BE NICE TO BE ABLE TO AUTOGEN GETTERS AND SETTERS
    // Update: You CAN actually do this with IntelliJ, hell yeah

    public Permit(int id, String guestName, int rating, int tokenCount) {
        this.id = id;
        this.guestName = guestName;
        if (rating < 1 || rating > 10) {
            throw new IllegalArgumentException("Rating needs to be between 1 and 10");
        }
        this.rating = rating;
        this.tokenCount = tokenCount;
        this.pointCount = 0;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return guestName;
    }
    public void setName(String name) {
        this.guestName = name;
    }
    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        if (rating <= 10 && rating >= 1) {
            this.rating = rating;
        } else {
            throw new IllegalArgumentException("Rating needs to be between 1 and 10");
        }
    }
    public int getTokenCount() {
        return tokenCount;
    }
    public void setTokenCount(int tokenCount) {
        this.tokenCount = tokenCount;
    }
    public int getPointCount() {
        return pointCount;
    }
    public void setPointCount(int pointCount) {
        this.pointCount = pointCount;
    }

    public void addTokens(int tokens) {
        this.tokenCount = this.tokenCount + tokens;
    }
    public void removeTokens(int tokens) {
        this.tokenCount = this.tokenCount - tokens;
    }
    public void addPoints(int points) {
        this.pointCount = this.pointCount + points;
    }
    public void removePoints(int points) {
        this.pointCount = this.pointCount - points;
    }

    /**
     * @return How many tokens can be obtained by converting points
     */
    public int returnPointsToTokens() {
        return this.pointCount / 4;
    }
    public void convertPointsToTokens() {
        while (pointCount >= 4) {
            tokenCount += 1;
            pointCount -= 4;
        }
    }

    public boolean hasTokensForShuttle(int shuttleCost) {
        int tokenCount = this.getTokenCount();
        return tokenCount >= shuttleCost;
    }
    public boolean hasTokensForShuttle() {
        return hasTokensForShuttle(3);
    }

    public void shuttleEntry() { // a method to make changes to permit details when a shuttle is entered
        int shuttleCost = 3;
        if (hasTokensForShuttle(shuttleCost)) {
            removeTokens(shuttleCost);
            pointCount += 1;
        } else {
            throw new IllegalArgumentException("Not enough tokens to use the shuttle");
        }
    }

    @Override
    public String toString() {
        return "Permit{" +
                "id=" + id +
                ", guestName='" + guestName + '\'' +
                ", rating=" + rating +
                ", tokenCount=" + tokenCount +
                ", pointCount=" + pointCount +
                '}';
    }
}