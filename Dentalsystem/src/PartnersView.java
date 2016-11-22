import UI.ButtonListener;
import UI.GradientPanel;
import UI.ImagePanel;
import UI.MenuButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by Annie on 22/11/2016.
 */
public class PartnersView extends JFrame {

    private JPanel contentPane;
    private JPanel topMenu;
    private JPanel header;
    private JButton home, appointments, healthCare,
            patients, contact;

    public PartnersView(final int w, final int h, final int role) {
        super();

        // Colours we'll need to paint the UI (RGB format)
        final Color bgBlue = new Color(112, 205, 255);
        final Color white = new Color(255, 255, 255);
        final Color transWhite = new Color(255, 255, 255, 100);
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
        topMenu = new JPanel(new GridLayout(1, 5));
        topMenu.setBackground(menuC);
        System.out.println(topMenu.getSize());

        // Creating menu items
        home = new MenuButton(300, 75, "Home", transWhite);
        appointments = new MenuButton(300, 75, "My Appointments", transWhite);
        patients = new MenuButton(300, 75, "Patients", transWhite);

        // Add all menu buttons to top panel
        topMenu.add(home);
        topMenu.add(appointments);
        topMenu.add(patients);
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

        // Add all the top menu listeners
        ButtonListener appointmentsL = new ButtonListener(appointments) {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyAppointmentsPage.showMyAppointmentsPage(mainContent, mainContent.getWidth(), mainContent.getHeight(), role);
                contentPane.repaint();
                contentPane.revalidate();
            }
        };
        appointments.addActionListener(appointmentsL);

        ButtonListener patientsL = new ButtonListener(patients) {
            @Override
            public void actionPerformed(ActionEvent e) {
                PatientsPage.showPatientsPage(mainContent, mainContent.getWidth(), mainContent.getHeight());
                contentPane.repaint();
                contentPane.revalidate();
            }
        };
        patients.addActionListener(patientsL);

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
