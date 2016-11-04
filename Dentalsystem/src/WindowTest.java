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

        // Layout manager
        GridBagLayout gbl = new GridBagLayout();
        GridLayout glMenu = new GridLayout(1,0,0,10);
       // BoxLayout blTop = new BoxLayout();

        //main window space
        JPanel contentPane = new JPanel(gbl);
        contentPane.setPreferredSize(new Dimension(w, h));
        contentPane.setBackground(lightBlue);

        //header
        JPanel header = new JPanel(gbl);
        header.setPreferredSize(new Dimension(w,140));
        header.setBackground(Color.white);

        // Top Menu
        JPanel topMenu = new JPanel(gbl);
        topMenu.setPreferredSize(new Dimension(w, 60));
        topMenu.setBackground(bgBlue);


        JButton menuItem  = new JButton("Home"); // Add action listeners later
        menuItem.setBackground(white);
        topMenu.add(menuItem);
        topMenu.setLayout(glMenu);

        menuItem = new JButton("Appointments");
        menuItem.setBackground(white);
        topMenu.add(menuItem);
        topMenu.setLayout(glMenu);

        menuItem = new JButton("Health Care Plan");
        menuItem.setBackground(white);
        topMenu.add(menuItem);
        topMenu.setLayout(glMenu);

        menuItem = new JButton("Patients");
        menuItem.setBackground(white);
        topMenu.add(menuItem);

        menuItem = new JButton("Contact");
        menuItem.setBackground(white);
        topMenu.add(menuItem);
        topMenu.setLayout(glMenu);


        // For managing UI
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTH;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridy = 0;
        c.gridx = 0;
        c.weightx = 1.0;
        contentPane.add(header, c);

        c.gridy = 1;
        c.weightx = 0.0;
        c.fill = GridBagConstraints.HORIZONTAL;
        contentPane.add(topMenu, c);


        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.add(contentPane);
        this.setResizable(false);
        this.pack(); // Size according to elements
        this.repaint(); // Update entire screen


    }
}
