package DataClasses;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

/**
 * Created by Annie on 21/11/2016.
 */
public class TreatmentModel extends AbstractTableModel {
    private ArrayList<Treatment> treatments;

    public TreatmentModel(ArrayList<Treatment> treatments){

        // Use super constructor
        super();

        this.treatments = treatments;


        // Just set the variables

    }

    // Get/set functions

    @Override
    public int getRowCount() {
        // Return how many entries there are in the result set
        return treatments.size();
    }

    @Override
    public int getColumnCount() {
        // This is the number of instance variables we
        // have in the patients class
        return 4; // Depends on the TREATMENT CLASS - CHANGE IF NEED TO
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0: return treatments.get(rowIndex).getName();
            case 1: return treatments.get(rowIndex).getPrice();
            case 2: return treatments.get(rowIndex).getPractitioner();
            case 3: return treatments.get(rowIndex).getDuration();
        }

        // Else all fails
        System.out.println(String.format("Row index: %s, Col index: %s, returned null", rowIndex, columnIndex));
        return null;
    }
}
