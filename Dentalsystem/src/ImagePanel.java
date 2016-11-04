import javax.swing.*;
import java.awt.*;

/**
 * Created by Matheus on 04/11/2016.
 */
public class ImagePanel extends JPanel {

    // Class fields
    Image image;
    int width, height;

    public ImagePanel(Image img, int w, int h){
        // Set the instance variables
        image = img;
        width = w;
        height = h;

        // Panel Settings
        Dimension size = new Dimension(width, height);
        this.setSize(size);
        this.setPreferredSize(size);
    }

    /*
    Get the background image by overriding
    the paintComponent method.
     */
    protected void paintComponent(Graphics g){
        g.drawImage(image, 0, 0, null);
    }

}
