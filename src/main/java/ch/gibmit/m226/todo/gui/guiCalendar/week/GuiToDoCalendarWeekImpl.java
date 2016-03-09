package ch.gibmit.m226.todo.gui.guiCalendar.week;

import ch.gibmit.m226.todo.gui.guiCalendar.GuiToDoCalendarAbstr;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

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

    /**
     * This method catches the action event of the tool bar buttons
     * @param e Action Event of the tool bar buttons
     */
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
