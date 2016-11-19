package DataClasses;

/**
 * Created by Annie on 18/11/2016.
 */
public class HealthcarePlan {


    // Instance variables according to info model
    private String planName;
    private Double monthlyPayment;


    public HealthcarePlan(String planName, Double monthlyPayment) {

        //Set the instance variables
        this.planName = planName;
        this.monthlyPayment = monthlyPayment;

    }


    // Simple functions
    public String getPlanName() {return String.format("%s ", planname);}
    public Double getMonthlyPayment() {return monthlypayment;}


}



