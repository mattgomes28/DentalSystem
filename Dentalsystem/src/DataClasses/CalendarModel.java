package DataClasses;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

/**
 * Created by Matheus on 18/11/2016.
 */
public class CalendarModel extends AbstractTableModel {

    private ArrayList<Appointment> appointments;
    private int week;


    public CalendarModel(int week){

        // Use super constructor
        super();

        this.appointments = Appointment.getWeekAppointments(week);
        this.week = week;


        // Just set the variables

    }

    // Get/set functions
    public int getWeek(){return week;}


    @Override
    public int getRowCount() {
        // Return how many entries there are in the result set
        return appointments.size();
    }

    @Override
    public int getColumnCount() {
        // This is the number of instance variables we
        // have in the appointments class
        return 4; // Depends on the APPOINTMENTS CLASS - CHANGE IF CHANGE
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0: return appointments.get(rowIndex).getStartTime();
            case 1: return appointments.get(rowIndex).getEndTime();
            case 2: return appointments.get(rowIndex).getPatient();
            case 3: return appointments.get(rowIndex).getPractitioner().getName();
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
            case 0: return "Start Time";
            case 1: return "End Time";
            case 2: return "Patient";
            case 3: return "Practitioner";
        }
        return "None";
    }
}
