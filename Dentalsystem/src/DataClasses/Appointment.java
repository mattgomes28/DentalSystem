package DataClasses;
import javax.xml.transform.Result;
import java.text.SimpleDateFormat;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Matheus on 16/11/2016.
 */
public class Appointment {

    // Instance variables according to info model
    private String startTime;
    private String endTime;
    private Practitioner practitioner;
    private Treatment treatment;
    private String patient;


    public Appointment(String startTime, String endTime, Practitioner practitioner, String patient, Treatment treatment){

        // Set time variables
        this.startTime = startTime;
        this.endTime = endTime;

        // Set the instance variables
        this.practitioner = practitioner;
        this.treatment = treatment;
        this.patient = patient;

    }


    // Get functions here
    public Practitioner getPractitioner() {return practitioner;}
    public String getPatient() {return patient;}

    // Ugly but oh well
    public String getDate() {
        // Simple parsing from DB date
        String dd, MM, yy;

        dd = startTime.substring(0, 4);
        MM = startTime.substring(5, 7);
        yy = startTime.substring(0, 10);

        return String.format("%s/%s/%s", dd, MM, yy);
    }

    public String getStartTime(){return startTime.substring(11, 19);}
    public String getEndTime(){return endTime.substring(11,19);}


    public boolean insertAppointment(){

        // Check the DB for duplicate appointments
        String checkQuery = String.format("SELECT * FROM Appointment WHERE practitionerID = '%s' AND startTime <= '%s';", practitioner.getId(), startTime);
        DBConnection c = new DBConnection();
        c.openConnection();
        ResultSet rSet = c.runQuery(checkQuery);

        // This is where the actual checking happens
        try {
            if (rSet.next()) return false; // Already in table

            String query = String.format("INSERT INTO Appointment VALUES ('%s', '%s', '%s', '%s');", patient, practitioner.getId(), startTime, endTime);
            c.runUpdate(query);
            c.closeConnection();
            return true;

        }
        catch (SQLException e){e.printStackTrace();}
        return false;


    }

    public void deleteApp(){
        System.out.println("Deleting...");
        String query = String.format("DELETE FROM Appointment WHERE startTime <= '%s' AND practitionerID = '%s'", startTime, practitioner.getId());
        DBConnection c = new DBConnection();
        c.openConnection();
        c.runUpdate(query);
        c.closeConnection();
    }

    // Important static function we'll need to get all appointments
    // in a week
    public static ArrayList<Appointment> getWeekHAppointments(int week) {

        // Create DB connection and open it
        DBConnection c = new DBConnection();
        c.openConnection();

        // Running the sql query here
        String query = String.format("SELECT Patient.forename, Practitioner.forename,  Appointment.startTime, Appointment.endTime FROM Appointment, Patient, Practitioner ");
        query += String.format("WHERE YEARWEEK(startTime)=2016%s AND Practitioner.id = Appointment.practitionerID AND Patient.id = Appointment.patientID AND Practitioner.role LIKE 'Hygienist';", week);
        ResultSet rSet  = c.runQuery(query);

        // Vars we'll need to create the Appointment object
        String startTime, endTime;
        String patient;
        Practitioner practitioner;

        // Array to be returned
        ArrayList<Appointment> apps = new ArrayList<Appointment>();


        try{
            while(rSet.next()){
                patient = rSet.getString(1);
                practitioner = new Practitioner(rSet.getInt(2), "Test", "Test", "Dentist");
                startTime = rSet.getString(3);
                endTime = rSet.getString(4);

                apps.add(new Appointment(startTime, endTime, practitioner, patient, null));
            }
        }
        catch (SQLException e){e.printStackTrace();}

        // Close the connection
        c.closeConnection();


        return apps;
    }

    public static ArrayList<Appointment> getWeekDAppointments(int week) {

        // Create DB connection and open it
        DBConnection c = new DBConnection();
        c.openConnection();

        // Running the sql query here
        String query = String.format("SELECT Patient.forename, Practitioner.id, Practitioner.forename,  Practitioner.surname, Practitioner.role, Appointment.startTime, Appointment.endTime FROM Appointment, Patient, Practitioner ");
        query += String.format("WHERE YEARWEEK(startTime)=2016%s AND Practitioner.id = Appointment.practitionerID AND Patient.id = Appointment.patientID AND Practitioner.role LIKE 'Dentist';", week);
        ResultSet rSet  = c.runQuery(query);

        // Vars we'll need to create the Appointment object
        String startTime, endTime;
        String patient;
        Practitioner practitioner;

        // Array to be returned
        ArrayList<Appointment> apps = new ArrayList<Appointment>();


        try{
            while(rSet.next()){
                patient = rSet.getString(1);
                practitioner = new Practitioner(rSet.getInt(2), rSet.getString(3), rSet.getString(4), rSet.getString(5));
                startTime = rSet.getString(6);
                endTime = rSet.getString(7);

                apps.add(new Appointment(startTime, endTime, practitioner, patient, null));
            }
        }
        catch (SQLException e){e.printStackTrace();}

        // Close the connection
        c.closeConnection();


        return apps;
    }

}
