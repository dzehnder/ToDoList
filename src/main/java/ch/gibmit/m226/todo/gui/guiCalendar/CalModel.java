package ch.gibmit.m226.todo.gui.guiCalendar;

import java.util.Calendar;
import java.util.Locale;

/**
 * @author Damian Zehnder
 * This class is the calendar model of the calendar view
 * It stores the date-informations and provides them to the calendar components.
 */
public class CalModel {



    private Calendar cal;

    private static CalModel instance = new CalModel();

    /**
     * constructor creates instance of the calendar
     */
    private CalModel() {
        cal = Calendar.getInstance(Locale.GERMANY);
    }

    /**
     * @return the instance of the CalModel
     */
    public static CalModel getInstance() {
        return instance;
    }

    /**
     * @return the calendar of the model
     */
    public Calendar getCal() {
        return cal;
    }
}
