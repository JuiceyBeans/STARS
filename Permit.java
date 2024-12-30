 
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
    public String testField;

    // MAN IT SURE WOULD BE NICE TO BE ABLE TO AUTOGEN GETTERS AND SETTERS
    // Update: You CAN actually do this with IntelliJ, hell yeah

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
            System.out.println("[ERROR] Rating needs to be between 1 and 10");
        }
    }
    public int getTokenCount() {
        return tokenCount;
    }
    public void setTokenCount(int tokenCount) {
        this.tokenCount = tokenCount;
    }
}