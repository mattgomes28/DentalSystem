package DataClasses;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.DateTimeException;
import java.util.ArrayList;

/**
 * Created by Annie on 21/11/2016.
 */
public class Patient {

    // Instance variables according to info model
    private int id;
    private String title;
    private String forename;
    private String surname;
    private String dateOfBirth;
    private String contact;
    private Address address;

    public Patient(String title, String forename, String surname, String dateOfBirth, String contact, Address address){

        //Set the instance variables
        this.title = title;
        this.forename = forename;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.contact = contact;
        this.address = address;

    }

    public Patient(int id, String title, String forename, String surname, String dateOfBirth, String contact, Address address){

        //Set the instance variables
        this.id = id;
        this.title = title;
        this.forename = forename;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.contact = contact;
        this.address = address;

    }


    // Get functions here
    public int getId(){return this.id;}
    public String getTitle() {return title;}
    public String getForename() {return forename;}
    public String getSurname() {return surname;}
    public Address getAddress() {return address;}


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

        String query = "INSERT INTO Patient(title, forename, surname, dateOfBirth, contactNumber, houseNo, postcode) VALUES (?, ?, ?, ?, ?, ?, ?);";
        String[] queryArgs = {title, forename, surname, dateOfBirth, contact, String.valueOf(address.getHouseNo()), address.getPostcode()};

        // If reaches this line then patient was inserted
        c.runUpdate(query, queryArgs);
        c.closeConnection();
        return true;
    }

    public boolean delPatient(){

        // Dont delete if id is not set i.e not in table
        if (this.id != 0){
            String query = "DELETE FROM patient  WHERE id = ?;";
            String[] args = {String.valueOf(this.id)};
            DBConnection c = new DBConnection();
            c.openConnection();
            c.runUpdate(query, args);
            c.closeConnection();
            return true;
        }
        return false;
    }

    /**
     * This function returns all the patients in the
     * Patient table.
     * @return Array of patients or null;
     *
     */
    public static ArrayList<Patient> getPatients(){

        // Preping query
        String query = "SELECT * FROM Patient;";
        String[] args = {};

        DBConnection c = new DBConnection();
        c.openConnection();
        ResultSet rSet = c.runQuery(query, args);

        // Vars we'll need to instanciate
        String title, forename, surname,
                dOB, number;
        Address a;
        int id;

        // Array to store the patient
        ArrayList<Patient> pList = new ArrayList<Patient>();

        // Go through each col and instanciate objs
        try{

            while(rSet.next()){
                // Getting info from table
                id = rSet.getInt(1);
                title = rSet.getString(2);
                forename = rSet.getString(3);
                surname = rSet.getString(4);
                dOB = rSet.getString(5);
                number = rSet.getString(6);
                a = Address.getAddress(rSet.getInt(7), rSet.getString(8));

                pList.add(new Patient(id, title, forename, surname, dOB, number, a));
            }
        }catch(SQLException e){e.printStackTrace();}

        if (!pList.isEmpty()) return pList;
        c.closeConnection();
        return null;
    }

}
