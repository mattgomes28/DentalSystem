import DataClasses.Patient;
import DataClasses.PatientModel;
import UI.ButtonListener;
import UI.TransPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by Annie on 21/11/2016.
 */
public class PatientsPage {
    private static boolean isTableView = true;
    public static void showPatientsPage(final JPanel mainContent, int w, int h){

        // Create colors needed for this page
        final Color borderC = new Color(76, 178, 252);
        final Color contentC = new Color(230, 244, 254);
        final int insetSize = 20; // Inset size in px;

        // Remove everything from main content
        mainContent.removeAll();

        // Create the layout stuff here
        GridBagConstraints gbc = new GridBagConstraints();
        mainContent.setBackground(new Color(0,0,0,0));
        mainContent.setPreferredSize(new Dimension(w, h));


        // Create the left panel buttons here - MAIN BUTTONS
        final JButton register = new JButton("Register Patient");
        JButton delete = new JButton("Delete Patient");
        JButton modify = new JButton("Modify Patient");
        final JButton viewPatients = new JButton("View Patients/Refresh");


        // Left and right main panels to hold content
        JPanel left = new JPanel(new GridBagLayout());
        final JPanel right = new JPanel(); // undefined layout, need decide
        right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
        right.setAlignmentX(Component.CENTER_ALIGNMENT);

        left.setBackground(contentC);
        left.setBorder(BorderFactory.createLineBorder(borderC, 2));
        right.setBackground(contentC);
        right.setBorder(BorderFactory.createLineBorder(borderC, 2));

        left.setPreferredSize(new Dimension((int) (0.33*w -2*insetSize), h));
        right.setPreferredSize(new Dimension((int) (0.66*w - 2*insetSize), h));

        // JLabel for the title of menu
        JLabel menuTitle = new JLabel("Patient Control");
        menuTitle.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));

        // Start adding stuff to the left menu
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 10, 20, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        left.add(menuTitle, gbc);
        gbc.gridy = 1;
        left.add(register, gbc);
        gbc.gridy = 2;
        left.add(delete, gbc);
        gbc.gridy = 3;
        left.add(modify, gbc);


        // JLabel for viewing the table
        final JLabel patientsView = new JLabel("View Options");
        patientsView.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));

        gbc.gridy = 4;
        left.add(patientsView, gbc);
        gbc.gridy = 5;
        left.add(viewPatients, gbc);

        gbc.gridy = 6; // Dummy to push to top
        gbc.weighty = 1;
        left.add(new TransPanel(), gbc);


        // Adding stuff to the right menu (mainly the patients)
        final PatientModel tableModel = new PatientModel(Patient.getPatients());
        final JTable patientTable = new JTable();
        patientTable.setModel(tableModel);

        // Title of the face
        final JLabel rightTitle = new JLabel("List of Patients Registered");
        rightTitle.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));

        right.add(rightTitle);
        right.add(new JScrollPane(patientTable));


        // Button listeners here
        ButtonListener registerL = new ButtonListener(register) {
            @Override
            public void actionPerformed(ActionEvent e) {

                right.removeAll(); // Remove content
                isTableView = false;
                // Add title
                JLabel newTitle = new JLabel("-- Register A New Patient --");
                newTitle.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
                right.add(newTitle);

                JPanel registration = RegisterPatient.getPanel(viewPatients);
                right.add(registration);
                mainContent.getParent().revalidate();
                mainContent.getParent().repaint();
            }
        };
        register.addActionListener(registerL);

        ButtonListener viewPatientsL = new ButtonListener(viewPatients) {
            @Override
            public void actionPerformed(ActionEvent e) {
                right.removeAll();
                isTableView = true;

                // Refresh list
                PatientModel m = new PatientModel(Patient.getPatients());
                patientTable.setModel(m);
                patientTable.revalidate();

                right.add(rightTitle);
                right.add(new JScrollPane(patientTable));

                mainContent.getParent().revalidate();
                mainContent.getParent().repaint();
            }
        };
        viewPatients.addActionListener(viewPatientsL);

        ButtonListener deleteL = new ButtonListener(delete) {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isTableView) JOptionPane.showMessageDialog(null, "Please view patients and select patient to delete!");
                else{
                    int row = patientTable.getSelectedRow();
                    if (row == -1) JOptionPane.showMessageDialog(null, "Please select a row (patient) to delete!");
                    else{
                        PatientModel model = (PatientModel) patientTable.getModel();
                        model.getPatients().get(row).delPatient();
                        JOptionPane.showMessageDialog(null, "Patient deleted. Refresh list to view changes.");
                        viewPatients.doClick();
                    }
                }
            }
        };
        delete.addActionListener(deleteL);

        ButtonListener modifyL = new ButtonListener(modify) {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the patient
                Patient p = null;
                if (!isTableView) JOptionPane.showMessageDialog(null, "Please view patients and select patient to modify!");
                else{
                    int row = patientTable.getSelectedRow();
                    if (row == -1) JOptionPane.showMessageDialog(null, "Please select a row (patient) to modify!");
                    else{
                        PatientModel model = (PatientModel) patientTable.getModel();
                        p = model.getPatients().get(row);

                        right.removeAll();

                        // New Title
                        JLabel newTitle = new JLabel("Modify A Patient");
                        newTitle.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
                        right.add(newTitle);
                        right.add(ModifyPatient.getPanel(p, viewPatients));

                        mainContent.getParent().revalidate();
                        mainContent.getParent().repaint();
                    }
                }
            }
        };
        modify.addActionListener(modifyL);




        // Then add the main stuff
        GridBagConstraints mainGbc = new GridBagConstraints(); // new one so values dont get messed
        mainGbc.anchor = GridBagConstraints.FIRST_LINE_START;
        mainGbc.insets = new Insets(insetSize, insetSize, insetSize, insetSize);
        mainGbc.fill = GridBagConstraints.BOTH;
        mainGbc.gridx = 0;
        mainGbc.gridy = 0;
        mainGbc.weighty = 1;
        mainGbc.weightx = 0.147;
        mainContent.add(left, mainGbc);

        mainGbc.gridx = 1;
        mainGbc.weightx = 1;
        mainContent.add(right, mainGbc);


        mainContent.revalidate();


    }

}
