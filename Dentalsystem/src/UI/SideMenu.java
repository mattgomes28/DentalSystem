package UI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Matheus on 20/11/2016.
 */
public class SideMenu extends JPanel {

    public SideMenu(int width, int height){
        // Init super and instance variables
        super(new GridBagLayout());
        //super(new GridLayout(10, 1));


        // Adjust the size
        Dimension size = new Dimension(width, height);
        this.setPreferredSize(size);
        this.revalidate(); //necessary

    }


}
