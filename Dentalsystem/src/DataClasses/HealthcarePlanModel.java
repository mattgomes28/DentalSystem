package DataClasses;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

/**
 * Created by Annie on 21/11/2016.
 */
public class HealthcarePlanModel extends AbstractTableModel {


    private ArrayList<HealthcarePlan> healthcareplans;

    public HealthcarePlanModel(ArrayList<HealthcarePlan> healthcareplans){

        // Use super constructor
        super();

        this.healthcareplans= healthcareplans;


        // Just set the variables

    }

    // Get/set functions

    @Override
    public int getRowCount() {
        // Return how many entries there are in the result set
        return healthcareplans.size();
    }

    @Override
    public int getColumnCount() {
        // This is the number of instance variables we
        // have in the patients class
        return 3; // Depends on the PATIENTS CLASS - CHANGE IF NEED TO
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0: return healthcareplans.get(rowIndex).getPlanName();
            case 1: return healthcareplans.get(rowIndex).getTreatList();
            case 2: return healthcareplans.get(rowIndex).getMonthlyPayment();
        }

        // Else all fails
        System.out.println(String.format("Row index: %s, Col index: %s, returned null", rowIndex, columnIndex));
        return null;
    }
}