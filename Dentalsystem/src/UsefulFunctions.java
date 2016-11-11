import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

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
}
