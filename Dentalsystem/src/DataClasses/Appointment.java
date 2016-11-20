package DataClasses;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

        // Set the instance variables
        this.startTime = startTime;
        this.endTime = endTime;
        this.practitioner = practitioner;
        this.treatment = treatment;
        this.patient = patient;
    }


    // Get functions here
    public String getStartTime() {return startTime;}
    public String getEndTime() {return endTime;}
    public Practitioner getPractitioner() {return practitioner;}
    public Treatment getTreatment() {return treatment;}
    public String getPatient() {return patient;}


    // Important static function we'll need to get all appointments
    // in a week
    public static ArrayList<Appointment> getWeekAppointments(int week) {

        // Create DB connection and open it
        DBConnection c = new DBConnection();
        c.openConnection();

        // Running the sql query here
        String query = String.format("SELECT * FROM Appointment WHERE YEARWEEK(startTime)=2016%s", week);
        ResultSet rSet  = c.runQuery(query);

        // Vars we'll need to create the Appointment object
        String startTime, endTime, patient;
        Practitioner practitioner;

        // Array to be returned
        ArrayList<Appointment> apps = new ArrayList<Appointment>();


        try{
            while(rSet.next()){
                patient = rSet.getString(1);
                practitioner = new Practitioner("Test", "Test", rSet.getString(2));
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

}
