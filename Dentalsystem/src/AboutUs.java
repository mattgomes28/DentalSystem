import UI.*;
import javax.swing.*;
import java.awt.*;

/**
 * Created by Annie on 20/11/2016.
 */

public class AboutUs extends JFrame {

    private JPanel contentPane;
    private JPanel topMenu;
    private JPanel header;
    private JButton home, appointments, healthCare,
            patients, contact;


    public AboutUs(final int w, final int h) {
        super();

        // Colours we'll need to paint the UI (RGB format)
        final Color bgBlue = new Color(112, 205, 255);
        final Color white = new Color(255, 255, 255);
        final Color transWhite = new Color(255, 255, 255, 100);
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
        topMenu = new JPanel(new GridLayout(1, 5));
        topMenu.setBackground(menuC);
        System.out.println(topMenu.getSize());

        // Creating menu items
        home = new MenuButton(300, 75, "Home", transWhite);
        appointments = new MenuButton(300, 75, "Appointments", transWhite);
        patients = new MenuButton(300, 75, "Patients", transWhite);
        healthCare = new MenuButton(300, 75, "Health Care", transWhite);
        contact = new MenuButton(300, 75, "Contact", transWhite);

        // Add all the top menu listeners


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
        JPanel mainContent = new JPanel(new GridBagLayout());
        JPanel aboutText = new JPanel();
        int insetSize = 20;
        Insets contentMargin = new Insets(insetSize, insetSize, insetSize, insetSize);

        // Constraints and adding the about us info
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = contentMargin;

        Dimension mainTextDim = new Dimension(w - 2 * insetSize, 500);
        aboutText.setPreferredSize(mainTextDim);
        aboutText.setBackground(contentC);
        aboutText.setBorder(BorderFactory.createLineBorder(borderC, 2));

        mainContent.setBackground(transWhite);
        mainContent.add(aboutText, gbc);


        //add about us info
        JTextArea textArea = new JTextArea("The Sheffield Dental Practice is a welcoming environment that allows our" +
                " patients to feel comfortable and get the best dental care they deserve. We provide an accessible " +
                "NHS dentistry and affordable private dental care that our patients can rely on. In addition we offer" +
                " several different health care plans to suit the needs of our patients whether the patient is " +
                "just looking for regular check-ups or whether they require treatment. \n" +
                " Everyone in our practice is very especially caring and friendly. We want our patients to feel" +
                " important from the moment they arrive to the moment they leave");
        aboutText.add(textArea);
        textArea.setBackground(contentC);
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
        this.setResizable(false);
        this.setVisible(true);
    }
}



