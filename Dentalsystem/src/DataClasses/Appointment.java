package DataClasses;

import java.sql.Date;
import java.sql.Timestamp;

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
    public String endTime() {return endTime;}
    public Practitioner getPractitioner() {return practitioner;}
    public Treatment getTreatment() {return treatment;}
    public String getPatient() {return patient;}

}
