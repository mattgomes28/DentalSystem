import javax.swing.*;
import java.awt.*;

/**
 * Created by Matheus on 04/11/2016.
 */
public class ImagePanel extends JPanel {

    // Class fields
    private ImageIcon imageIcon;
    private JLabel header;

    public ImagePanel(Image img){


        super(); // Need to init. instance variables

        // Create a new imageIcon and draw it onto panel
        // with JLabel
        Dimension headerSize = new Dimension(img.getWidth(null), img.getHeight(null));
        imageIcon = new ImageIcon(img);
        header = new JLabel();
        header.setIcon(imageIcon);
        header.setPreferredSize(headerSize); header.setSize(headerSize);




        // Panel Settings
        this.add(header);
        this.revalidate();

    }
}
