package ch.gibmit.m226.todo.guiCalendar.year;

import ch.gibmit.m226.todo.guiCalendar.GuiToDoCalendarAbstr;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author Damian Zehnder
 * This class implements the calendar view of the year
 */
public class GuiToDoCalendarYearImpl extends GuiToDoCalendarAbstr implements GuiToDoCalendarYear {

    private JPanel pnlYear;
    private JToolBar tlBrCalYear;

    public GuiToDoCalendarYearImpl() {
        pnlYear = new JPanel(new BorderLayout());
        tlBrCalYear = new JToolBar();
        addButtonsToToolBar(tlBrCalYear);
        pnlYear.add(tlBrCalYear, BorderLayout.PAGE_START);

    }

    /**
     * Interface method that returns the year view panel of the calendar
     * @return the calendar panel of the year view
     */
    public JPanel getCalendarYear() {
        return pnlYear;
    }

    /**
     * This method catches the action event of the tool bar buttons
     * @param e Action Event of the tool bar buttons
     */
    @Override
    public void actionPerformed(ActionEvent e) {


    }
}
