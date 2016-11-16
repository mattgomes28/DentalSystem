import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by Matheus on 16/11/2016.
 */
public class Appointment {

    // Instance variables according to info model
    private Date startTime;
    private Date endTime;
    private Practitioner practitioner;
    private Treatment treatment;


    public Appointment(Date startTime, Date endTime, Practitioner practitioner, Treatment treatment){

        // Set the instance variables
        this.startTime = startTime;
        this.endTime = endTime;
        this.practitioner = practitioner;
        this.treatment = treatment;
    }


    // Get functions here
    public Date getStartTime() {return startTime;}
    public Date endTime() {return endTime;}
    public Practitioner getPractitioner() {return practitioner;}
    public Treatment getTreatment() {return treatment;}

}
