import com.sun.xml.internal.ws.client.sei.ResponseBuilder;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Matheus on 27/10/2016.
 */
public class WindowTest extends JFrame {

    private JPanel contentPane;
    private JPanel topMenu;


    public WindowTest(int w, int h) {

        // Colours we'll need to paint the UI (RGB format)
        Color lightBlue = new Color(200, 200, 255);
        Color bgBlue = new Color(175, 175, 255);
        Color white = new Color(255,255,255, 0);



        // Layout manager  stuff - GridBag layout is being used

        JPanel contentPane = new JPanel(new GridBagLayout());
        contentPane.setPreferredSize(new Dimension(w, h));
        contentPane.setBackground(bgBlue);
        GridBagConstraints c = new GridBagConstraints(); // For managing UI


        // General configs and properties
        // TBC
        /*
        Box blank = new Box(1);
        blank.setSize(w,50);
        blank.setPreferredSize(new Dimension(w, 50));
        blank.setBackground(white);
        */


        // Top Menu Stuff Here
        JPanel topMenu = new JPanel();
        topMenu.setBackground(Color.black);

        /*
        JButton menuItem  = new JButton("Home"); // Add action listeners later
        menuItem.setBackground(white);
        topMenu.add(menuItem);
        topMenu.setLayout(new GridLayout(1,2,7,10));
        menuItem = new JButton("Appointments");
        menuItem.setBackground(lightBlue);
        topMenu.add(menuItem);
        menuItem = new JButton("Health Care Plan");
        menuItem.setBackground(lightBlue);
        topMenu.add(menuItem);
        menuItem = new JButton("Patients");
        menuItem.setBackground(lightBlue);
        topMenu.add(menuItem);
        menuItem = new JButton("Contact");
        menuItem.setBackground(lightBlue);
        topMenu.add(menuItem);
        menuItem.setOpaque(false 50%);
        menuItem.setContentAreaFilled(false);
        menuItem.setBorderPainted(false);


*/
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.gridy = 0;
        c.gridx = 0;
        c.gridheight = (int) 0.3*h;
        c.gridwidth  = w;
        c.weightx = 1.0;
        c.weighty = 0.3;
        c.fill = GridBagConstraints.HORIZONTAL;
        contentPane.add(topMenu, c);



        this.add(contentPane);
        this.setResizable(false);
        this.pack(); // Size according to elements
        this.repaint(); // Update entire screen


    }
}
