
import java.sql.ResultSet;

public class Test {

    public static void main(String[] args){

        // Testing out header
        //WindowTest window = new WindowTest(960, 900);


        // Test DB
        DBConnection conn = new DBConnection("admin", "admin", "dentalsystem");
        conn.openConnection(); // Hopefully no errors


        // Testing user login stuff
        String username = "matheus";
        String password = "password";

        // View values in the user table
        ResultSet r = conn.runQuery(String.format("SELECT * FROM User WHERE username='%s'", username));
        System.out.println(UsefulFunctions.validateUser(r, username, password));


        conn.closeConnection();




    }
}
