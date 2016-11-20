import DataClasses.CalendarModel;
import UI.*;

import javax.swing.*;
import java.awt.*;

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
        contentPane.add(header);

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


        // Creating the side menu for the secretary
//        UI.MenuButton hygienist = new UI.MenuButton((int) 0.33*w - 10, 50, "Hygienist", new Color(0,0,0));
//        UI.MenuButton dentist   = new UI.MenuButton((int) 0.33*w - 10, 50, "Dentist", new Color(0,0,0));

        // Create JButtons for side panel
        JButton dentist = new JButton("Dentist");
        JButton hygienist = new JButton("Hygienist");

        // List of buttons on side and other configs
        JButton[] sideButtons = {hygienist, dentist};

        // Create both panels in main content
        JPanel left  = new SideMenu((int) 0.33*w, (int) 0.33*h, sideButtons);
        JPanel right = new JPanel();

        // Add listeners to load calendar on main column (right col)
        int thisWeek = 47; // This week's view
        JTable calendarD = new JTable();
        calendarD.setModel(new CalendarModel(thisWeek, 2));
        ButtonListener dentistL = new ButtonListener(dentist, new JScrollPane(calendarD), right);
        dentist.addActionListener(dentistL);

        JTable calendarH = new JTable();
        calendarH.setModel(new CalendarModel(thisWeek, 1));
        ButtonListener hygienistL = new ButtonListener(hygienist, new JScrollPane(calendarH), right);
        hygienist.addActionListener(hygienistL);


        // Inset for both columns
        int insetSize = 20;


        // Adding main bits to the panel
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.insets = new Insets(insetSize,insetSize,insetSize + 20,insetSize);
        gbc.gridx = 0;
        gbc.gridy = 0;
        left.setBorder(BorderFactory.createLineBorder(borderC, 2));
        left.setBackground(contentC);
        left.setPreferredSize(new Dimension((int) (w*0.33 - 2*insetSize), 500));
        mainContent.add(left, gbc);

        right.setPreferredSize(new Dimension((int) (w*0.66 - 2*insetSize), 500));
        right.setBackground(contentC);
        right.setBorder(BorderFactory.createLineBorder(borderC, 2));

        // Adding both columns to the panel
        gbc.gridy = 0;
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
        this.setTitle("Dental System - The Prototype");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(contentPane);
        this.pack();
        this.revalidate();
        this.setResizable(false);
        this.setVisible(true);
    }
}
