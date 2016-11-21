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
    private String district;
    private String city;

    public Address(Integer houseNo, String postcode, String street, String district, String city){

        //Set the instance variables
        this.houseNo = houseNo;
        this.postcode = postcode;
        this.street =  street;
        this.district = district;
        this.city = city;
    }


    // Get functions here
    public Integer getHouseNo() {return houseNo;}
    public String getPostcode() {return postcode;}
    public String getStreet() {return street;}
    public String getDistrict() {return district;}
    public String getCity() {return city;}

    public boolean insertAddress() {


        DBConnection c = new DBConnection();
        c.openConnection();

        String query = "INSERT INTO Address VALUES (?, ?, ?, ?, ?);";
        String[] queryArgs = {String.valueOf(houseNo), postcode, street, district, city};

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


}
