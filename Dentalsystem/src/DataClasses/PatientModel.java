package DataClasses;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;


/**
 * Created by Annie on 21/11/2016.
 */
public class PatientModel extends AbstractTableModel {
    private ArrayList<Patient> patients;

    public PatientModel(ArrayList<Patient> patients){

        // Use super constructor
        super();

        this.patients = patients;




        // Just set the variables

    }

    // Get/set functions
    //public Patient getPatient(){return getPatient();}

    @Override
    public int getRowCount() {
        // Return how many entries there are in the result set
        return patients.size();
    }

    @Override
    public int getColumnCount() {
        // This is the number of instance variables we
        // have in the patients class
        return 6; // Depends on the PATIENTS CLASS - CHANGE IF NEED TO
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0: return patients.get(rowIndex).getId();
            case 1: return patients.get(rowIndex).getTitle();
            case 2: return patients.get(rowIndex).getForename();
            case 3: return patients.get(rowIndex).getSurname();
            case 4: return patients.get(rowIndex).getDob();
            case 5: return patients.get(rowIndex).getContact();
        }

        // Else all fails
        System.out.println(String.format("Row index: %s, Col index: %s, returned null", rowIndex, columnIndex));
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex){
        return true;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex){
            case 0: return "Patient ID";
            case 1: return "Title";
            case 2: return "Forename";
            case 3: return "Surname";
            case 4: return "DOB";
            case 5: return "Contact No.";
        }
        return "None";
    }


}

