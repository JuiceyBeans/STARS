  


/**
 * Details of your team
 * 
 * @author Karthi (Ayush) Suresh
 * @version 29/12/2024
 */
public class Teamwork
{
    private String[] details = new String[6];
    
    public Teamwork()
    {   // In each line replace the contents of the String 
        // with the details of your team
        // It will help us if the surname of programmer1 comes
        // alphabetically before the surname of programmer2
        // If there is only 1 team member, please complete details 
        // for programmer1
        
        details[0] = "Suresh";
        details[1] = "Ayush";
        details[2] = "23012077";
        details[3] = "Alam";
        details[4] = "Murtaza";
        details[5] = "21088013";
    }
    
    public String[] getTeamDetails()
    {
        return details;
    }
    
    public void displayDetails()
    {
        for(String temp:details)
        {
            System.out.println(temp.toString());
        }
    }
}
        
