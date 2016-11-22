package DataClasses;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Annie on 21/11/2016.
 */
public class Address {

    // Instance variables according to info model
    private Integer houseNo;
    private String postcode;
    private String street;
    private String county;
    private String city;

    public Address(Integer houseNo, String postcode, String street, String district, String city){

        //Set the instance variables
        this.houseNo = houseNo;
        this.postcode = postcode;
        this.street =  street;
        this.county = district;
        this.city = city;
    }


    // Get functions here
    public Integer getHouseNo() {return houseNo;}
    public String getPostcode() {return postcode;}
    public String getStreet() {return street;}
    public String getCounty() {return county;}
    public String getCity() {return city;}

    public boolean insertAddress() {


        DBConnection c = new DBConnection();
        c.openConnection();

        String query = "INSERT INTO Address VALUES (?, ?, ?, ?, ?);";
        String[] queryArgs = {String.valueOf(houseNo), postcode, street, county, city};

        String checkQuery = "SELECT * FROM Address WHERE houseNo=? AND postcode=? ;";
        String[] checkArgs = {String.valueOf(houseNo), postcode};


        // This is where the actual checking happens
        try {
            ResultSet rSet = c.runQuery(checkQuery, checkArgs);
            if (rSet.next()) return false; // Already in table

            // If reaches this line then patient was inserted
            c.runUpdate(query, queryArgs);
            c.closeConnection();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;


    }


    public static Address getAddress(int houseNo, String postcode){

        String query = "SELECT * FROM address WHERE (houseNo=? AND postcode LIKE ?);";
        String[] args = {String.valueOf(houseNo), postcode};
        DBConnection c = new DBConnection();
        c.openConnection();
        ResultSet rSet = c.runQuery(query, args);

        Address a = null;

        // See if we have address in table
        try{
            if (!rSet.next()) return null;

            a = new Address(houseNo, postcode, rSet.getString(3), rSet.getString(4), rSet.getString(5));

        }
        catch (SQLException e){ e.printStackTrace();}
        c.closeConnection();
        return a;

    }


}
