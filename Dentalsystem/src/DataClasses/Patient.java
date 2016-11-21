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
    private String contact;

    public Patient(Integer id, String title, String forename, String surname, String dateOfBirth, String contact){

        //Set the instance variables
        this.id = id;
        this.title = title;
        this.forename = forename;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.contact = contact;

    }


    // Get functions here
    public Integer getId() {return id;}
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

    public String getContact() {return contact;}

    public boolean insertPatient(){


        DBConnection c = new DBConnection();
        c.openConnection();

        String query = "INSERT INTO Patient VALUES (?, ?, ?, ?, ?, ?);";
        String[] queryArgs = {String.valueOf(id), title, forename, surname, dateOfBirth, contact};

        String checkQuery = "SELECT * FROM Patient WHERE id=?;";
        String[] checkArgs = {String.valueOf(getId())};


        // This is where the actual checking happens
        try {
            ResultSet rSet = c.runQuery(checkQuery, checkArgs);
            if (rSet.next()) return false; // Already in table

            // If reaches this line then patient was inserted
            c.runUpdate(query, queryArgs);
            c.closeConnection();
            return true;

        }
        catch (SQLException e){e.printStackTrace();}
        return false;


    }

}
