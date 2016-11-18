package DataClasses;

/**
 * Created by Matheus on 16/11/2016.
 */
public class Practitioner {

    // Add these attributes to the info model
    private String forename;
    private String surname;
    private String role;

    public Practitioner(String forename, String surname, String role) {

        // Set the instance vars
        this.forename = forename;
        this.surname = surname;
        this.role = role;
    }

    // Simple functions
    public String getName() {return String.format("%s %s", forename, surname);}
    public String getRole() {return role;}
}
