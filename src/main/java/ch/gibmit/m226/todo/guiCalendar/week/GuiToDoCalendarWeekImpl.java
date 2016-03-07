package ch.gibmit.m226.todo.guiCalendar.week;

import ch.gibmit.m226.todo.guiCalendar.GuiToDoCalendarAbstr;

import javax.swing.*;
import java.awt.*;

/**
 * @author Damian Zehnder
 * This class implements the calendar view of the year
 */
public class GuiToDoCalendarWeekImpl extends GuiToDoCalendarAbstr implements GuiToDoCalendarWeek {

    private JPanel pnlWeek;
    private JToolBar tlBrCalWeek;

    public GuiToDoCalendarWeekImpl() {
        pnlWeek = new JPanel(new BorderLayout());
        tlBrCalWeek = new JToolBar();
        addButtonsToToolBar(tlBrCalWeek);
        pnlWeek.add(tlBrCalWeek, BorderLayout.PAGE_START);
    }

    /**
     * Interface method that returns the week view panel of the calendar
     * @return the calendar panel of the week view
     */
    public JPanel getCalendarWeek() {
        return pnlWeek;
    }
}
