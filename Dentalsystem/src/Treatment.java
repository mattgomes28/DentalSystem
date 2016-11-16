/**
 * Created by Matheus on 16/11/2016.
 */
public class Treatment {

    // Instance variables according to data model
    private String name;
    private double price;
    private Practitioner practitioner;



    public Treatment(String name, double price, Practitioner p){

        // Set instance vars
        this.name = name;
        this.price = price;
        this.practitioner = p;

    }


    // Get methods
    public String getName(){return name;}
    public double getPrice(){return price;}
    public Practitioner getPractitioner(){return practitioner;}

}
