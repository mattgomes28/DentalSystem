import DataClasses.Appointment;
import DataClasses.CalendarModel;
import UI.ButtonListener;
import UI.TransPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Calendar;

/**
 * Created by Matheus on 20/11/2016.
 */


public class AppointmentPage {

    private static int offset = 0;
    private static int calendarMode = 0;

    /**
     * This function will wipe out
     * everything in the mainContent panel
     * and show the main page.
     * @param mainContent
     */
    public static void showAppointments(final JPanel mainContent, int w, int h){

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


        // Create JButtons for side panel
        JButton dentist = new JButton("Dentist");
        JButton hygienist = new JButton("Hygienist");

        // Create both panels in main content
        JPanel left = new JPanel(new GridBagLayout());
        left.setPreferredSize(new Dimension((int) (0.33*w), (int) (0.33*h)));
        final JPanel right = new JPanel();



        // Create JLabel for the Title
        final int thisWeek = Calendar.getInstance().get(Calendar.WEEK_OF_YEAR); // This week's view
        final JLabel title = new JLabel(String.format("Calendar for 2016 week %s", thisWeek + offset));
        title.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));

        // Add listeners to load calendar on main column (right col)
        final JTable calendarD = new JTable();
        calendarD.setModel(new CalendarModel(thisWeek, 2));
        ButtonListener dentistL = new ButtonListener(dentist){


            @Override
            public void actionPerformed(ActionEvent e) {
                calendarMode = 2;
                right.removeAll();
                right.add(title);
                right.add(new JScrollPane(calendarD));
                mainContent.getParent().revalidate();
                mainContent.getParent().repaint();
            }
        };
        dentist.addActionListener(dentistL);

        final JTable calendarH = new JTable();
        calendarH.setModel(new CalendarModel(thisWeek, 1));
        ButtonListener hygienistL = new ButtonListener(hygienist){

            @Override
            public void actionPerformed(ActionEvent e) {
                calendarMode = 1;
                right.removeAll();
                right.add(title);
                right.add(new JScrollPane(calendarH));
                mainContent.getParent().revalidate();
                mainContent.getParent().repaint();
            }
        };
        hygienist.addActionListener(hygienistL);

        // Control for the calendar here
        JButton nextWeek = new JButton("Next Week >");
        JButton prevWeek = new JButton("< Prev Week");

        nextWeek.addActionListener(new ButtonListener(nextWeek) {
            @Override
            public void actionPerformed(ActionEvent e) {
                offset++;
                title.setText(String.format("Calendar for 2016 week %s", thisWeek + offset));
                calendarD.setModel(new CalendarModel(thisWeek + offset, 2));
                calendarH.setModel(new CalendarModel(thisWeek + offset, 1));

                calendarD.revalidate();
                calendarH.revalidate();
            }
        });

        prevWeek.addActionListener(new ButtonListener(nextWeek) {
            @Override
            public void actionPerformed(ActionEvent e) {
                offset--;
                title.setText(String.format("Calendar for 2016 week %s", thisWeek + offset));
                calendarD.setModel(new CalendarModel(thisWeek + offset, 2));
                calendarH.setModel(new CalendarModel(thisWeek + offset, 1));

                calendarD.revalidate();
                calendarH.revalidate();
            }
        });


        // LEFT SIDEBAR STUFF HERE - CALENDAR CONTROL
        JPanel navigation = new JPanel();
        navigation.setBackground(new Color(0,0,0,0));
        navigation.add(prevWeek);
        navigation.add(nextWeek);
        JLabel controlText = new JLabel("Calendar Control");
        controlText.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.insets = new Insets(0, 10, 20, 10);
        left.add(controlText, gbc);
        gbc.gridy = 1;
        left.add(dentist, gbc);
        gbc.gridy = 2;
        left.add(hygienist, gbc);
        gbc.gridy = 3;
        left.add(navigation, gbc);

        // LEFT PANEL - UPDATE CONTROL
        JLabel updateText = new JLabel("Updating Tools");
        updateText.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        JButton bookAppointment = new JButton("Book Appointment"); // EDIT - ADD LISTENER
        JButton deleteAppointment = new JButton("Delete Appointment");
        gbc.gridy = 4;
        left.add(updateText, gbc);
        gbc.gridy = 5;
        left.add(bookAppointment, gbc);
        gbc.gridy = 6;
        left.add(deleteAppointment, gbc);

        // Dummy to push things to top
        gbc.gridy = 7;
        gbc.weighty = 1;
        left.add(new TransPanel(), gbc);

        // Events for data controllers here
        ButtonListener bookAppointmentL = new ButtonListener(bookAppointment) {
            @Override
            public void actionPerformed(ActionEvent e) {
                calendarMode = 0;
                right.removeAll();
                right.add(BookAppointment.getPanel());
                mainContent.getParent().revalidate();
                mainContent.getParent().repaint();
            }
        };
        bookAppointment.addActionListener(bookAppointmentL);

        ButtonListener deleteAppointmentL = new ButtonListener(deleteAppointment) {
            @Override
            public void actionPerformed(ActionEvent e){

                int row = -1;
                CalendarModel model;
                Appointment toDel = null;

                if (calendarMode == 1){
                    // Hygienist selected
                    row = calendarH.getSelectedRow();
                    model = (CalendarModel) calendarH.getModel();

                    // Only delete if element exists
                    if (model.getListSize() > 0) toDel = model.getElement(row);
                }
                else if (calendarMode == 2){
                    // Dentist selected
                    row = calendarD.getSelectedRow();
                    model = (CalendarModel) calendarD.getModel();
                    System.out.println(model.getListSize());
                    // Only delete not empty
                    if (model.getListSize() > 0) toDel = model.getElement(row);
                }

                System.out.println(toDel);
                if (toDel != null){
                    toDel.deleteApp();
                    JOptionPane.showMessageDialog(null, "Appointment Deleted Successfully.");
                    calendarD.repaint();
                    calendarH.repaint();
                }
                else{
                    JOptionPane.showMessageDialog(null, "No rows were selected. Please try again.");
                }
            }
        };
        deleteAppointment.addActionListener(deleteAppointmentL);



        right.add(title);

        // Inset for both columns
        int insetSize = 20;

        // Adding main bits to the panel
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.insets = new Insets(insetSize,insetSize,insetSize + 20,insetSize);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1;
        gbc.weightx = 0;
        left.setBorder(BorderFactory.createLineBorder(borderC, 2));
        left.setBackground(contentC);
        mainContent.add(left, gbc);

        right.setPreferredSize(new Dimension((int) (w*0.66 - 2*insetSize), 500));
        right.setBackground(contentC);
        right.setBorder(BorderFactory.createLineBorder(borderC, 2));


        // Adding both columns to the panel
        gbc.gridy = 0;
        gbc.gridx = 1;
        gbc.weightx = 1;
        mainContent.add(right, gbc);
        mainContent.revalidate();
    }
}
