 
/**
 * A Permit has an id number, name, a luxury rating, tokens and points.
 * 
 * @author Karthi (Ayush) Suresh
 * @version 29/12/2024
 */
public class Permit {
    public int id;
    public String guestName;
    public int rating;
    public int tokenCount;
    public int pointCount;
 
    // MAN IT SURE WOULD BE NICE TO BE ABLE TO AUTOGEN GETTERS AND SETTERS
    // Update: You CAN actually do this with IntelliJ, hell yeah

    public Permit(int id, String guestName, int rating, int tokenCount, int pointCount) {
        this.id = id;
        this.guestName = guestName;
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
    public String getPointCount() {
        return pointCount;
    }
    public void setPointCount(int id) {
        this.pointCount = pointCount;
    }
}
