import UI.*;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by Matheus on 20/11/2016.
 */
public class SecretaryView extends JFrame {

    private JPanel contentPane;
    private JPanel topMenu;
    private JPanel header;
    private JButton home, appointments, healthCare,
            patients, contact;


    public SecretaryView(final int w,final int h) {
        super();

        // Colours we'll need to paint the UI (RGB format)
        final Color bgBlue = new Color(112, 205, 255);
        final Color white = new Color(255,255,255);
        final Color transWhite = new Color(255,255,255, 100);
        final Color borderC = new Color(76, 178, 252);
        final Color contentC = new Color(230, 244, 254);
        final Color menuC = new Color(90, 210, 240);


        // Gradient drawing in this area
        FlowLayout layout = new FlowLayout(FlowLayout.TRAILING, 0, 0);
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



        // Add all menu buttons to top panel
        topMenu.add(home);
        topMenu.add(appointments);
        topMenu.add(patients);
        topMenu.add(healthCare);
        topMenu.add(contact);
        topMenu.revalidate();

        topMenu.setPreferredSize(new Dimension(w, 60));
        contentPane.add(topMenu);


        // Create the main content pane
        final JPanel mainContent = new JPanel(new GridBagLayout());
        JPanel homeText = new JPanel();
        int insetSize = 20;
        Insets contentMargin = new Insets(insetSize, insetSize, insetSize, insetSize);

        // Constraints and adding the main home thing
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = contentMargin;

        Dimension mainTextDim = new Dimension(w-2*insetSize, 500);
        homeText.setPreferredSize(mainTextDim);
        homeText.setBackground(contentC);
        homeText.setBorder(BorderFactory.createLineBorder(borderC, 2));

        mainContent.setBackground(transWhite);
        mainContent.add(homeText, gbc);



        // Adding the home stuff
        //AppointmentPage.showAppointments(mainContent, 500, 500);

        // Add all the top menu listeners
        ButtonListener appointmentsL = new ButtonListener(appointments) {
            @Override
            public void actionPerformed(ActionEvent e) {
                AppointmentPage.showAppointments(mainContent, mainContent.getWidth(), mainContent.getHeight());
                contentPane.repaint();
                contentPane.revalidate();
            }
        };
        appointments.addActionListener(appointmentsL);


        //add home info
        //JTextField textBox = new JTextField(10);
        JTextArea textArea = new JTextArea("Testing the text", 5, 10);
        //JScrollPane scrollPane = new JScrollPane(textArea);
        homeText.add(textArea);
        textArea.setEditable(false);

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
        //this.setResizable(false);
        this.setVisible(true);
    }
}
