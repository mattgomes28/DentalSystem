package DataClasses;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Matheus on 16/11/2016.
 */
public class Treatment {

    // Instance variables according to data model
    private String name;
    private Double price;
    private Practitioner practitioner;
    private Double duration;


    public Treatment(String name, double price, Practitioner p, Double duration){

        // Set instance vars
        this.name = name;
        this.price = price;
        this.practitioner = p;
        this.duration = duration;

    }


    // Get methods
    public String getName(){return name;}
    public Double getPrice(){return price;}
    public Practitioner getPractitioner(){return practitioner;}
    public Double getDuration(){return duration;}

    public boolean insertAppointment() {

        // Check the DB for duplicate appointments
        String checkQuery = "SELECT * FROM Treatment WHERE (name = ?);";
        String[] args1 = {String.valueOf(name)};

        DBConnection c = new DBConnection();
        c.openConnection();
        ResultSet rSet = c.runQuery(checkQuery, args1);

        // This is where the actual checking happens
        try {
            if (rSet.next()) return false; // Already in table

            String query = "INSERT INTO Treatment VALUES (?, ?, ?, ?);";
            String[] args2 = {name, String.valueOf(price), String.valueOf(practitioner), String.valueOf(duration)};
            c.runUpdate(query, args2);
            c.closeConnection();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
