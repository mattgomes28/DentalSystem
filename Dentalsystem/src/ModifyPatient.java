import DataClasses.*;
import UI.ButtonListener;
import UI.TransPanel;

import javax.swing.*;
import javax.xml.transform.Result;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Matheus on 21/11/2016.
 */
public class ModifyPatient {

    /**
     * This method will simply get the panel
     * with all the fields for booking an appointment.
     *
     * All the DB connection should be here as well.
     */
    public static JPanel getPanel(final Patient p, final JButton trigger){

        //  By now I'm a pro at gridBagLayout
        // so I might as well use it...
        JPanel main = new JPanel(new GridBagLayout());

        // The labels we'll need
        JLabel  titleL, forenameL,
                surnameL, dobL, contactL,
                houseNoL, postcodeL, streetL,
                countyL, cityL;

        final JLabel title, forename, surname,
                dob;

        // To change
        final JTextField contact,
                houseNo, postcode, street,
                county, city;


        // Create the labels
        titleL = new JLabel("Title: ");
        forenameL = new JLabel("Forename: ");
        surnameL = new JLabel("Surname: ");
        dobL = new JLabel("Date of Birth: ");
        contactL = new JLabel("Contact Number: ");
        streetL = new JLabel("Street Name: ");
        houseNoL = new JLabel("House Number");
        postcodeL = new JLabel("Postcode: ");
        countyL = new JLabel("County: ");
        cityL = new JLabel("City: ");



        // Create each button for the form
        title = new JLabel(p.getTitle());
        forename = new JLabel(p.getForename());
        surname = new JLabel(p.getSurname());
        dob = new JLabel(p.getDob());


        contact = new JTextField();
        street = new JTextField();
        houseNo = new JTextField();
        postcode = new JTextField();
        county = new JTextField();
        city = new JTextField();

        // Set the size of each Text Field
        int colSize = 15;
        contact.setColumns(colSize);
        street.setColumns(colSize);
        houseNo.setColumns(colSize);
        postcode.setColumns(colSize);
        county.setColumns(colSize);
        city.setColumns(colSize);


        // Put everything together here
        GridBagConstraints gcb = new GridBagConstraints();

        gcb.anchor = GridBagConstraints.FIRST_LINE_START;
        gcb.insets = new Insets(20, 15, 0, 0);
        gcb.gridx = 0;
        gcb.gridy = 0;

        main.add(titleL, gcb);
        gcb.gridx = 1;
        gcb.weightx = 1;
        main.add(title, gcb);

        gcb.gridx = 0;
        gcb.gridy = 1;
        gcb.weightx = 0;
        main.add(forenameL, gcb);
        gcb.gridx = 1;
        gcb.weightx = 1;
        main.add(forename, gcb);

        gcb.gridx = 0;
        gcb.gridy = 2;
        gcb.weightx = 0;
        main.add(surnameL,gcb);
        gcb.gridx = 1;
        gcb.weightx = 1;
        main.add(surname, gcb);

        gcb.gridx = 0;
        gcb.gridy = 3;
        gcb.weightx = 0;
        main.add(dobL, gcb);
        gcb.gridx = 1;
        gcb.weightx = 1;
        main.add(dob, gcb);

        gcb.gridx = 0;
        gcb.gridy = 4;
        gcb.weightx = 0;
        main.add(contactL, gcb);
        gcb.gridx = 1;
        gcb.weightx = 1;
        main.add(contact, gcb);

        gcb.gridx = 0;
        gcb.gridy = 5;
        gcb.weightx = 0;
        main.add(streetL, gcb);
        gcb.gridx = 1;
        gcb.weightx = 1;
        main.add(street, gcb);

        gcb.gridx = 0;
        gcb.gridy = 6;
        gcb.weightx = 0;
        main.add(houseNoL, gcb);
        gcb.gridx = 1;
        gcb.weightx = 1;
        main.add(houseNo, gcb);

        gcb.gridx = 0;
        gcb.gridy = 7;
        gcb.weightx = 0;
        main.add(postcodeL, gcb);
        gcb.gridx = 1;
        gcb.weightx = 1;
        main.add(postcode, gcb);

        gcb.gridx = 0;
        gcb.gridy = 8;
        gcb.weightx = 0;
        main.add(countyL, gcb);
        gcb.gridx = 1;
        gcb.weightx = 1;
        main.add(county, gcb);

        gcb.gridx = 0;
        gcb.gridy = 9;
        gcb.weightx = 0;
        main.add(cityL, gcb);
        gcb.gridx = 1;
        gcb.weightx = 1;
        main.add(city, gcb);

        // Dummy to push everything to the top
        gcb.gridy = 10;
        gcb.weighty = 1;


        // Buttons here
        JButton submit = new JButton("Submit");
        gcb.anchor = GridBagConstraints.CENTER;
        gcb.gridx = 0;
        gcb.gridy = 11;
        gcb.weightx = 1;
        gcb.fill = GridBagConstraints.BOTH;
        main.add(submit, gcb);


        // Add Event listener to button
        ButtonListener submitL = new ButtonListener(submit) {
            @Override
            public void actionPerformed(ActionEvent e) {

                Address a = new Address(
                        Integer.valueOf(houseNo.getText()),
                        postcode.getText(),
                        street.getText(),
                        county.getText(),
                        city.getText()
                );


                if(!a.insertAddress()) JOptionPane.showMessageDialog(null, "Address already registered. Patient registered to address.");

                DBConnection c = new DBConnection();
                c.openConnection();
                String query = "UPDATE patient SET contactNumber=?, houseNo=?, postcode=? WHERE id=?;";
                String[] args = {contact.getText(), String.valueOf(a.getHouseNo()), a.getPostcode(), String.valueOf(p.getId())};
                c.runUpdate(query, args);
                c.closeConnection();

                JOptionPane.showMessageDialog(null, "Patient details updated successfully. Refresh list to view changes.");

                // Clear fields
                title.setText("");
                forename.setText("");
                surname.setText("");
                dob.setText("");
                contact.setText("");
                postcode.setText("");
                houseNo.setText("");
                county.setText("");
                title.setText("");
                street.setText("");

                // trigger the button
                trigger.doClick();
            }
        };
        submit.addActionListener(submitL);

        // End bit
        main.add(new TransPanel(), gcb);




        return main;
    }
}
