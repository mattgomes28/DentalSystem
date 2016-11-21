package DataClasses;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Annie on 18/11/2016.
 */
public class HealthcarePlan {


    // Instance variables according to info model
    private String planName;
    private Treatment[] treatList;
    private Double monthlyPayment;



    public HealthcarePlan (String planName, Treatment[] treatList, Double monthlyPayment) {

        //Set the instance variables
        this.planName = planName;
        this.treatList = treatList;
        this.monthlyPayment = monthlyPayment;


    }


    // Simple functions
    public String getPlanName() {return String.format("%s ", planName);}
    public Double getMonthlyPayment() {return monthlyPayment;}
    public Treatment[] getTreatList() {return treatList;}

    public boolean insertPlans() {

        // Check the DB for duplicate plans
        String checkQuery = "SELECT * FROM Appointment WHERE (planName = ? AND treatList = ?);";
        String[] args1 = {String.valueOf(planName), String.valueOf(treatList)};

        DBConnection c = new DBConnection();
        c.openConnection();
        ResultSet rSet = c.runQuery(checkQuery, args1);

        // This is where the actual checking happens
        try {
            if (rSet.next()) return false; // Already in table

            String query = "INSERT INTO Appointment VALUES (?, ?, ?);";
            String[] args2 = {planName, String.valueOf(planName), String.valueOf(treatList)};
            c.runUpdate(query, args2);
            c.closeConnection();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }
}



