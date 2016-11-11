import javax.swing.*;
import java.awt.*;

/**
 * Created by Matheus on 04/11/2016.
 */
public class MenuButton extends JButton {

    // Class instances
    private int width, height;
    private Color color;

    public MenuButton(int w, int h, String text, Color color){

        // Super init
        super(text);

        // Setting the instance variables
        this.width = w;
        this.height = h;
        this.color = color;

        // Size stuff
        Dimension size = new Dimension(w, h);
        setSize(size);
        setPreferredSize(size);

        // Remove graphics and add our own
        setBackground(color);
        setContentAreaFilled(false);

    }

    public void setDirection(String page){

        // Put the page stuff here
        System.out.println(page);

    }
}
