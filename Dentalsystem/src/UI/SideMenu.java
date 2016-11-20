package UI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Matheus on 20/11/2016.
 */
public class SideMenu extends JPanel {


    // Variables we'll need
    private JButton[] buttons;

    public SideMenu(int width, int height, JButton[] buttonList){
        // Init super and instance variables
        super(new GridLayout(10, 1));


        // Adjust the size
        Dimension size = new Dimension(width, height);
        this.setPreferredSize(size);

        // Just add all the buttons to the component
        for(JButton button : buttonList){this.add(button);}
        this.revalidate(); // necessary

    }


}
