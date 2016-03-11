package ch.gibmit.m226.todo.gui.guiCalendar.year;

import ch.gibmit.m226.todo.gui.guiCalendar.GuiCalendarAbstr;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author Damian Zehnder
 * This class implements the calendar view of the year
 */
public class GuiCalendarYearImpl extends GuiCalendarAbstr implements GuiCalendarYear {

    private JPanel pnlYear;
    private JToolBar tlBrCalYear;

    public GuiCalendarYearImpl() {
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