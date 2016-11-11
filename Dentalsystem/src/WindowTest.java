import javax.imageio.ImageIO;
import javax.jws.soap.SOAPBinding;
import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * Created by Matheus on 27/10/2016.
 */
public class WindowTest extends JFrame {

    private JPanel contentPane;
    private JPanel topMenu;
    private JPanel header;
    private JButton home, appointments, healthCare,
                    patients, contact;


    public WindowTest(final int w,final int h) {
        super();

        // Colours we'll need to paint the UI (RGB format)
        final Color bgBlue = new Color(112, 205, 255);
        final Color white = new Color(255,255,255);
        final Color transWhite = new Color(255,255,255, 100);
        final Color borderC = new Color(76, 178, 252);
        final Color contentC = new Color(230, 244, 254);
        final Color menuC = new Color(90, 210, 240);


        // Gradient drawing in this area
        FlowLayout layout = new FlowLayout(FlowLayout.LEADING, 0, 0);
        contentPane = new GradientPanel(layout, w, h, 0, 100, bgBlue, 0, h, white);
        contentPane.setPreferredSize(new Dimension(w, h));


        // Loading the header image
        header = new ImagePanel(UsefulFunctions.getImage("header.jpg"));



        // Top menu stuff here
        topMenu = new JPanel(new GridLayout(1,5));
        topMenu.setBackground(menuC);
        System.out.println(topMenu.getSize());

        // Creating menu items
        home = new MenuButton(300, 75, "Home", transWhite);
        appointments = new MenuButton(300, 75, "Appointments", transWhite);
        patients = new MenuButton(300, 75, "Patients", transWhite);
        healthCare = new MenuButton(300, 75, "Health Care", transWhite);
        contact = new MenuButton(300, 75, "Contact", transWhite);

        topMenu.add(home);
        topMenu.add(appointments);
        topMenu.add(patients);
        topMenu.add(healthCare);
        topMenu.add(contact);
        topMenu.revalidate();

        topMenu.setPreferredSize(new Dimension(w, 60));
        contentPane.add(topMenu);


        // Dummy here for the rest of the screen
        JPanel mainContent = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        mainContent.setBackground(new Color(0,0,0,0));


        // The Two Columns of Main Page
        JPanel left = new JPanel(),
               right = new JPanel();

        int insetSize = 20;
        Dimension colDim = new Dimension(w/2-2*insetSize, 500);


        left.setPreferredSize(colDim);
        left.setBackground(contentC);
        left.setBorder(BorderFactory.createLineBorder(borderC, 2));

        right.setPreferredSize(colDim);
        right.setBackground(contentC);
        right.setBorder(BorderFactory.createLineBorder(borderC, 2));

        // Adding both columns to the panel
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.insets = new Insets(insetSize,insetSize,insetSize + 20,insetSize);
        mainContent.add(left, gbc);

        gbc.gridx = 1;
        mainContent.add(right, gbc);


        // The Footer Section Goes here
        JPanel footer = new JPanel();
        footer.setBackground(white);
        footer.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0, borderC));
        footer.setPreferredSize(new Dimension(w, 100));





        contentPane.add(mainContent);
        contentPane.add(footer, BorderLayout.SOUTH);


        // Main window settings
        this.setName("Dental System - The Prototype");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(contentPane);
        this.pack();
        this.revalidate();
        this.setResizable(false);
        this.setVisible(true);
    }
}
