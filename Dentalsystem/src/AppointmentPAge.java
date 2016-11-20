import DataClasses.CalendarModel;
import UI.ButtonListener;
import UI.SideMenu;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Matheus on 20/11/2016.
 */


public class AppointmentPage {

    /**
     * This function will wipe out
     * everything in the mainContent panel
     * and show the main page.
     * @param mainContent
     */
    public static void showAppointments(JPanel mainContent, int w, int h){

        // Create colors needed for this page
        final Color borderC = new Color(76, 178, 252);
        final Color contentC = new Color(230, 244, 254);

        // remove everything from the main area
        mainContent.removeAll();

        // Add our stuff here
        // Dummy here for the rest of the screen
        mainContent = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        mainContent.setBackground(new Color(0,0,0,0));


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
    }
}
