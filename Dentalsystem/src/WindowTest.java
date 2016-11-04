import com.sun.xml.internal.ws.client.sei.ResponseBuilder;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Matheus on 27/10/2016.
 */
public class WindowTest extends JFrame {

    private JPanel contentPane;
    private JPanel topMenu;
    private JPanel header;


    public WindowTest(int w, int h) {

        // Colours we'll need to paint the UI (RGB format)
        Color lightBlue = new Color(200, 200, 255);
        Color bgBlue = new Color(175, 175, 255);
        Color white = new Color(255,255,255, 20);



        // Layout manager  stuff - GridBag layout is being used

        JPanel contentPane = new JPanel(new GridBagLayout());
        contentPane.setPreferredSize(new Dimension(w, h));
        contentPane.setBackground(lightBlue);
        GridBagConstraints c = new GridBagConstraints(); // For managing UI


        // General configs and properties
        // TBC

        //header bit for logo
        JPanel header = new JPanel();
        header.setPreferredSize(new Dimension(w,140));
        header.setBackground(Color.white);

        // Top Menu Stuff Here
        JPanel topMenu = new JPanel();
        topMenu.setPreferredSize(new Dimension(w, 60));
        topMenu.setBackground(bgBlue);



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




        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridy = 0;
        c.gridx = 0;
        c.weightx = 1.0;
        c.weighty = 0.3;

        contentPane.add(header, c);

        c.gridy = 1;
        contentPane.add(topMenu, c);


        this.add(contentPane);
        this.setResizable(false);
        this.pack(); // Size according to elements
        this.repaint(); // Update entire screen


    }
}
