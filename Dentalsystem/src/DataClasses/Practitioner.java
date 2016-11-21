package DataClasses;

/**
 * Created by Matheus on 16/11/2016.
 */
public class Practitioner {

    // Add these attributes to the info model
    private String forename;
    private String surname;
    private String role;
    private int id;

    public Practitioner(int id, String forename, String surname, String role) {

        // Set the instance vars
        this.forename = forename;
        this.surname = surname;
        this.role = role;
        this.id = id;
    }

    // Simple functions
    public String getName() {return String.format("%s %s", forename, surname);}
    public String getRole() {return role;}
    public int getId() {return id;}
}
