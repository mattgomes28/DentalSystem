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
    public ArrayList<Patient> getPatients(){return patients;}

    @Override
    public int getRowCount() {
        // Return how many entries there are in the result set
        return patients.size();
    }

    @Override
    public int getColumnCount() {
        // This is the number of instance variables we
        // have in the patients class
        return 7; // Depends on the PATIENTS CLASS - CHANGE IF NEED TO
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0: return patients.get(rowIndex).getTitle();
            case 1: return patients.get(rowIndex).getForename();
            case 2: return patients.get(rowIndex).getSurname();
            case 3: return patients.get(rowIndex).getDob();
            case 4: return patients.get(rowIndex).getContact();
            case 5: return patients.get(rowIndex).getAddress().getHouseNo();
            case 6: return patients.get(rowIndex).getAddress().getPostcode();
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
            case 0: return "Title";
            case 1: return "Forename";
            case 2: return "Surname";
            case 3: return "DOB";
            case 4: return "Contact No.";
            case 5: return "House No.";
            case 6: return "Postcode";
        }
        return "None";
    }


}

