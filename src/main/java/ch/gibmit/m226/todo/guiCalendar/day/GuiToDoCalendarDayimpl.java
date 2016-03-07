package ch.gibmit.m226.todo.guiCalendar.day;

import ch.gibmit.m226.todo.guiCalendar.GuiToDoCalendarAbstr;

import javax.swing.*;
import java.awt.*;

/**
 * @author Damian Zehnder
 * This class implements the calendar view of the day
 */
public class GuiToDoCalendarDayimpl extends GuiToDoCalendarAbstr implements GuiToDoCalendarDay {

    private JPanel pnlDay;
    private JToolBar tlBrCalDay;

    public GuiToDoCalendarDayimpl() {
        pnlDay = new JPanel(new BorderLayout());
        tlBrCalDay = new JToolBar();
        addButtonsToToolBar(tlBrCalDay);
        pnlDay.add(tlBrCalDay, BorderLayout.PAGE_START);
    }

    /**
     * Interface method that returns the day view panel of the calendar
     * @return the calendar panel of the day view
     */
    public JPanel getCalendarDay() {
        return pnlDay;
    }
}
