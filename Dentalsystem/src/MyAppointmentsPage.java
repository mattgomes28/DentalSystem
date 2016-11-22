import DataClasses.CalendarModel;
import UI.TransPanel;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Matheus on 20/11/2016.
 */


public class MyAppointmentsPage {

    private static int offset = 0;
    private static int calendarMode = 0;

    /**
     * This function will wipe out
     * everything in the mainContent panel
     * and show the main page.
     * @param mainContent
     */
    public static void showMyAppointmentsPage(final JPanel mainContent, int w, int h, int role){

        // Create colors needed for this page
        final Color borderC = new Color(76, 178, 252);
        final Color contentC = new Color(230, 244, 254);

        System.out.println(String.format("W: %s, H: %s", w, h));

        // remove everything from the main area
        mainContent.removeAll();

        // Add our stuff here
        GridBagConstraints gbc = new GridBagConstraints();
        mainContent.setBackground(new Color(0,0,0,0));
        mainContent.setPreferredSize(new Dimension(w,h));

        // Create both panels in main content
        final JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));



        // Inset for both columns
        int insetSize = 20;

        // Adding main bits to the panel
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.insets = new Insets(insetSize,insetSize,insetSize ,insetSize);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1;
        gbc.weightx = 0;


        content.setBackground(contentC);
        content.setBorder(BorderFactory.createLineBorder(borderC, 2));

        // Title for the top
        JLabel title = new JLabel("My Appointments Today");
        title.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        content.add(title);

        // Get the date stuff here
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String today = sdf.format(Calendar.getInstance().getTime());

        CalendarModel tableModel = new CalendarModel(2, today, 0, role);
        JTable appointmentTable = new JTable();
        appointmentTable.setModel(tableModel);
        content.add(new JScrollPane(appointmentTable));


        // Adding both columns to the panel
        gbc.gridy = 0;
        gbc.gridx = 1;
        gbc.weightx = 1;
        mainContent.add(content, gbc);
        mainContent.revalidate();
    }
}
