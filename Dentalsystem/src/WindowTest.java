import javax.swing.*;
import java.awt.*;

/**
 * Created by Matheus on 27/10/2016.
 */
public class WindowTest extends JFrame {

    private JPanel contentPane;
    private JMenuBar topMenu;

    public WindowTest(int width, int height){

        // Colours we'll need to paint the UI (RGB format)
        Color lightBlue = new Color(200, 200, 255);
        Color bgBlue    = new Color(175, 175, 255);


        // Layout manager  stuff - GridBag layout is being used
        contentPane = new JPanel(new GridBagLayout());
        contentPane.setSize(width, height);
        contentPane.setPreferredSize(new Dimension(width, height));
        contentPane.setBackground(bgBlue);
        GridBagConstraints c = new GridBagConstraints(); // For managing UI

        // General configs and properties
        // TBC

        // Top Menu Stuff Here
        topMenu = new JMenuBar();
        topMenu.setPreferredSize(new Dimension(width, Math.round(height*0.1f)));

        JMenuItem menuItem = new JMenuItem("Home"); // Add action listeners later
        menuItem.setBackground(lightBlue);
        topMenu.add(menuItem);
        menuItem = new JMenuItem("Appointments");
        menuItem.setBackground(lightBlue);
        topMenu.add(menuItem);
        menuItem = new JMenuItem("Health Care Plan");
        menuItem.setBackground(lightBlue);
        topMenu.add(menuItem);
        menuItem = new JMenuItem("Contact");
        menuItem.setBackground(lightBlue);
        topMenu.add(menuItem);


        this.setJMenuBar(topMenu);
        this.setResizable(false);
        this.add(contentPane);
        this.pack(); // Size according to elements
        this.repaint(); // Update entire screen
    }
}
