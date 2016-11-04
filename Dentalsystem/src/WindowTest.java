import com.sun.xml.internal.ws.client.sei.ResponseBuilder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Matheus on 27/10/2016.
 */
public class WindowTest extends JFrame {

    private JPanel contentPane;
    private JPanel topMenu;
    private JPanel header;
    private JPanel dummy;
    private JButton home, appointments, healthCare,
                    patients, contact;






    public WindowTest(int w, int h) {

        // Colours we'll need to paint the UI (RGB format)
        Color lightBlue = new Color(200, 200, 255);
        Color bgBlue = new Color(112, 205, 255);
        Color grey = new Color(128, 128, 128, 40);
        Color white = new Color(255,255,255);

        // Layout manager
        GridBagLayout gbl = new GridBagLayout();
        // BoxLayout blTop = new BoxLayout();

        //main window space
        JPanel contentPane = new JPanel(gbl) {
            public void paint(Graphics g) {
                super.paint(g);
                Graphics2D gb = (Graphics2D) g;
                gb.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                GradientPaint gp = new GradientPaint(0, 0, bgBlue, 0, h, white);
                gb.setPaint(gp);
                gb.fillRect(0, 0, w, h);
            }
        };
        contentPane.setPreferredSize(new Dimension(w, h));
        contentPane.setBackground(lightBlue);

        //header
        JPanel header = new JPanel(gbl);
        header.setPreferredSize(new Dimension(w,140));
        header.setBackground(Color.white);

        // Top Menu
        JPanel topMenu = new JPanel(new GridLayout(1, 5));
        topMenu.setPreferredSize(new Dimension(w, 60));
        topMenu.setBackground(bgBlue);


        home  = new JButton("Home"); // Add action listeners later
        home.setBackground(grey);
        ButtonListener homeL = new ButtonListener(home, grey, grey, "Homes");
        home.addActionListener(homeL);
        home.addMouseListener(homeL);
        topMenu.add(home);

        appointments = new JButton("Appointments");
        appointments.setBackground(white);
        ButtonListener appointmentsL = new ButtonListener(appointments, grey, grey, "Appointments");
        appointments.addActionListener(appointmentsL); // Action performed for click
        appointments.addMouseListener(appointmentsL);  // Mouse listener for hovering, exiting
        topMenu.add(appointments);

        healthCare = new JButton("Health Care Plan");
        healthCare.setBackground(white);
        ButtonListener healthCareL = new ButtonListener(healthCare, grey, grey, "Health");
        healthCare.addActionListener(healthCareL);
        healthCare.addMouseListener(healthCareL);
        topMenu.add(healthCare);

        patients = new JButton("Patients");
        patients.setBackground(white);
        ButtonListener patientsL = new ButtonListener(patients, grey,grey, "Patients");
        patients.addActionListener(patientsL);
        patients.addMouseListener(patientsL);
        topMenu.add(patients);


        // For managing UI
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.gridy = 0;
        c.gridx = 0;
        c.weighty = 0;
        c.weightx = 1;
        contentPane.add(header, c);


        c.gridy = 1;
        contentPane.add(topMenu, c);

        dummy = new JPanel();

        dummy.setBackground(new Color(0,0,0,0));
        c.gridy = 2;
        c.weighty = 1;
        contentPane.add(dummy, c);




        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.add(contentPane);
        this.setResizable(false);
        this.pack(); // Size according to elements
        this.repaint(); // Update entire screen


    }
}
