package DataClasses;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.DateTimeException;

/**
 * Created by Annie on 21/11/2016.
 */
public class Patient {

    // Instance variables according to info model
    private Integer id;
    private String title;
    private String forename;
    private String surname;
    private String dateOfBirth;
    private Integer contact;

    public Patient(Integer id, String title, String forename, String surname, String dateOfBirth, Integer contact){

        //Set the instance variables
        this.id = id;
        this.title = title;
        this.forename = forename;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.contact = contact;

    }


    // Get functions here
    public Integer getid() {return id;}
    public String getTitle() {return title;}
    public String getForename() {return forename;}
    public String getSurname() {return surname;}


    // Ugly but oh well
    public String getDob() {
        // Simple parsing from DB date
        String dd, MM, yy;

        dd = dateOfBirth.substring(0, 4);
        MM = dateOfBirth.substring(5, 7);
        yy = dateOfBirth.substring(0, 10);

        return String.format("%s/%s/%s", dd, MM, yy);
    }

    public Integer getContact() {return contact;}

    public boolean insertPatient(){


        DBConnection c = new DBConnection();
        c.openConnection();


        // This is where the actual checking happens
        try {
            if (rSet.next()) return false; // Already in table

            String query = String.format("INSERT INTO Patients VALUES ('%s', '%s', '%s', '%s', '%s', '%s');", id, title, forename, surname, dateOfBirth, contact);
            c.runUpdate(query);
            c.closeConnection();
            return true;

        }
        catch (SQLException e){e.printStackTrace();}
        return false;


    }

}
