package DataClasses; /**
 * Created by Matheus on 14/11/2016.
 */
import DataClasses.Appointment;

import java.sql.*;
import java.util.ArrayList;

public class DBConnection {


    // JDBC Driver and Connection stuff
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private Connection connection;


    // Properties for connection
    private final String USER;
    private final String PASSWORD;
    private final String DB_URL;

    public DBConnection(String userName, String password, String dbName){

        // Setting instance variables (credentials)
        this.USER = userName;
        this.PASSWORD = password;
        this.DB_URL = "jdbc:mysql://localhost/"+dbName;
    }

    public DBConnection(){
        // Init with default credentials
        this("root", "", "dentalsystem");
    }


    public void openConnection(){


        // Initialize the connection here
        try {
            // Add the class of driver
            Class.forName(DRIVER);

            // get Connection from Driver wrapper
            System.out.println("Connection to the database...");
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        }

        // SQL error -> Failed to connect to db.
        catch (SQLException e){
            System.out.println("Failed to connect");
            System.out.println(e);
        }

        // Class exception -> driver jar not loaded
        catch (ClassNotFoundException c){
            System.out.println("Failed to load class, add jar");
        }
    }


    public void closeConnection(){

        try{
            connection.close();
        }
        // Null pointer -> Exception raised in connection
        // SQLException -> Wrong properties (E.g wrong password)
        catch (Exception e){
            System.out.println("Couldn't close, null pointer or no connection");
        }
    }


    public ResultSet runQuery(String query){

        try{
            // Statement to exec query
            Statement st = connection.createStatement();
            return st.executeQuery(query);
        }
        catch(SQLException s){
            System.out.println("Failed to create statement... Check connection");
            System.out.println(s);
        }

        // Null if all fails
        return null;
    }

    /**
     * This function will return a practitioner obj
     * given the id.
     * @param id The id of practitioner in DB.
     * @return practitioner obj, null if all fails.
     */
    public Practitioner getPractitioner(int id){

        try {
            // If the connection is closed return null
            if (connection.isClosed()) return null;

            // Run the query to select all the practitioners
            ResultSet rSet = runQuery(String.format("SELECT * FROM Practitioner WHERE id='%s';", id));

            // Vars we need to define the practitioner
            String fName, sName, role;

            // Run through the result set getting row info
            rSet.next();
            fName = rSet.getString(2);
            sName = rSet.getString(3);
            role  = rSet.getString(4);

            // Add new instance to practitioners
            return new Practitioner(fName, sName, role);
        }
        catch (SQLException e){
            System.out.println("no practitioner returned...");
            e.printStackTrace(); // For debugging
        }

        // If all fails or no practitioners
        return null;
    }




}
