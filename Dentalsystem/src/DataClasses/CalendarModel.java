package DataClasses;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

/**
 * Created by Matheus on 18/11/2016.
 */
public class CalendarModel extends AbstractTableModel {

    private ArrayList<Appointment> appointments;
    private int week;


    public CalendarModel(int week, int role){

        // Use super constructor
        super();

        if (role == 1) this.appointments = Appointment.getWeekHAppointments(week);
        else if (role == 2) this.appointments = Appointment.getWeekDAppointments(week);
        else {
            System.out.println("invalid role. Showing dentist ");
            this.appointments = Appointment.getWeekDAppointments(week);
        }
        this.week = week;


    }

    // Get/set functions
    public int getWeek(){return week;}
    public Appointment getElement(int index){return appointments.get(index);}
    public int getListSize() {return appointments.size();}


    @Override
    public int getRowCount() {
        // Return how many entries there are in the result set
        return appointments.size();
    }

    @Override
    public int getColumnCount() {
        // This is the number of instance variables we
        // have in the appointments class
        return 5; // Depends on the APPOINTMENTS CLASS - CHANGE IF CHANGE
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0: return appointments.get(rowIndex).getDate();
            case 1: return appointments.get(rowIndex).getStartTime();
            case 2: return appointments.get(rowIndex).getEndTime();
            case 3: return appointments.get(rowIndex).getPatient();
            case 4: return appointments.get(rowIndex).getPractitioner().getName();
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
            case 0: return "Date";
            case 1: return "Start Time";
            case 2: return "End Time";
            case 3: return "Patient";
            case 4: return "Practitioner";
        }
        // Shouldn't happen at all
        // but just in case.
        return "None";
    }
}