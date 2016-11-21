import DataClasses.Appointment;
import DataClasses.Practitioner;
import UI.ButtonListener;
import UI.TransPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by Matheus on 21/11/2016.
 */
public class BookAppointment {

    /**
     * This method will simply get the panel
     * with all the fields for booking an appointment.
     *
     * All the DB connection should be here as well.
     */
    public static JPanel getPanel(){

        //  By now I'm a pro at gridBagLayout
        // so I might as well use it...
        JPanel main = new JPanel(new GridBagLayout());

        // The labels we'll need
        JLabel patientIdL, practitionerIdL,
               dateL, startL, endL;

        final JTextField patientId, practitionerId,
                date, start, end;

        // Create the labels
        patientIdL = new JLabel("Patient ID: ");
        practitionerIdL = new JLabel("Practitioner ID: ");
        dateL = new JLabel("Date: ");
        startL = new JLabel("Start Time: ");
        endL = new JLabel("End Time: ");

        // Create each button for the form
        patientId = new JTextField();
        practitionerId = new JTextField();
        date = new JTextField();
        start = new JTextField();
        end = new JTextField();

        // Set the size of each Text Field
        int colSize = 15;
        patientId.setColumns(colSize);
        practitionerId.setColumns(colSize);
        date.setColumns(colSize);
        start.setColumns(colSize);
        end.setColumns(colSize);


        // Put everything together here
        GridBagConstraints gcb = new GridBagConstraints();

        gcb.anchor = GridBagConstraints.FIRST_LINE_START;
        gcb.insets = new Insets(20, 15, 0, 0);
        gcb.gridx = 0;
        gcb.gridy = 0;

        main.add(patientIdL, gcb);
        gcb.gridx = 1;
        gcb.weightx = 1;
        main.add(patientId, gcb);

        gcb.gridx = 0;
        gcb.gridy = 1;
        gcb.weightx = 0;
        main.add(practitionerIdL, gcb);
        gcb.gridx = 1;
        gcb.weightx = 1;
        main.add(practitionerId, gcb);

        gcb.gridx = 0;
        gcb.gridy = 2;
        gcb.weightx = 0;
        main.add(dateL,gcb);
        gcb.gridx = 1;
        gcb.weightx = 1;
        main.add(date, gcb);

        gcb.gridx = 0;
        gcb.gridy = 3;
        gcb.weightx = 0;
        main.add(startL, gcb);
        gcb.gridx = 1;
        gcb.weightx = 1;
        main.add(start, gcb);

        gcb.gridx = 0;
        gcb.gridy = 4;
        gcb.weightx = 0;
        main.add(endL, gcb);
        gcb.gridx = 1;
        gcb.weightx = 1;
        main.add(end, gcb);

        // Dummy to push everything to the top
        gcb.gridy = 5;
        gcb.weighty = 1;


        // Buttons here
        JButton submit = new JButton("Submit");
        gcb.anchor = GridBagConstraints.CENTER;
        gcb.gridx = 0;
        gcb.gridy = 6;
        gcb.weightx = 1;
        gcb.fill = GridBagConstraints.BOTH;
        main.add(submit, gcb);


        // Add Event listener to button
        ButtonListener submitL = new ButtonListener(submit) {
            @Override
            public void actionPerformed(ActionEvent e) {

                // This will create a new appointment obj and submit it to the db
                Practitioner test = new Practitioner(Integer.parseInt(practitionerId.getText()), "Test", "Test", "Dentist");
                String d = date.getText();
                String startTime = date.getText() + " " + start.getText();
                String endTime = date.getText() + " " + end.getText();


                System.out.println(startTime);
                System.out.println(endTime);

                // The newly created appointment to be inserted
                Appointment newApp = new Appointment(startTime, endTime, test, patientId.getText(), null);

                newApp.insertAppointment();
                JOptionPane.showMessageDialog(null, "Appointment inserted!");

                // Clear fields
                patientId.setText("");
                practitionerId.setText("");
                date.setText("");
                start.setText("");
                end.setText("");

                // Still needs checking here

            }
        };
        submit.addActionListener(submitL);

        // End bit
        main.add(new TransPanel(), gcb);




        return main;
    }

    public static void main(String[] args){
        // testing here.

        JFrame window = new JFrame("Hello World");
        JPanel form = BookAppointment.getPanel();
        form.setPreferredSize(new Dimension(300, 300));
        form.revalidate();
        window.add(form);
        window.pack();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

    }
}
