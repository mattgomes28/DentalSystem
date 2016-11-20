import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.PackedColorModel;
import java.io.File;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by Matheus on 11/11/2016.
 */
public class UsefulFunctions {


    /**
     * This function returns an image object
     * given the name of the image in the
     * resources folder.
     *
     * ** MAKE SURE FOLDER IS MARKED AS RESOURCE FOLDER
     * @param name the name of image as a tring
     * @return the image object if image was found or
     * null if failed to load.
     */
    public static Image getImage(String name){

        Image img = null;

        // Handle file exception here - returns null if
        // exception is caught
        try {
            File imgFile = new File(UsefulFunctions.class.getResource(name).toURI());
            img = ImageIO.read(imgFile);
        }
        catch (Exception e){
            System.out.println("Failed to load image.");
            System.out.println(e);
        }

        return img;
    }

    /**
     * This function will validate the user to grant
     * access to the system based on the member type.
     *
     * @param rSet     The result set of query returned
     *                 from selecting the username from
     *                 User table.
     * @param username The string representing the
     *                 username entered by user.
     * @param password The string representing the
     *                 password entered by the user.
     * @return 0 If username/password invalid
     *         1 If valid secretary
     *         2 If valid hygienist
     *         3 If valid dentist
     */
    public static int validateUser(ResultSet rSet, String username, String password){

        try {

            // No results => invalid username
            if (!rSet.next()) return 0;

            // username is in table here
            String dbUsername = (String) rSet.getObject(1);
            String dbPassword = (String) rSet.getObject(2);
            int memberType    = Integer.parseInt(rSet.getObject(3).toString());


            // Validate credentials against db data
            if (username.equals(dbUsername) && password.equals(dbPassword))
                return memberType;

        }
        catch (Exception e){
            System.out.println("SQL error -> check connection");
            e.printStackTrace();
        }
        return 0;
    }


}
