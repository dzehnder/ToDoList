package ch.gibmit.m226.todo.gui.guiCalendar.day;

import ch.gibmit.m226.todo.gui.guiCalendar.GuiToDoCalendarAbstr;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

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

    /**
     * This method catches the action event of the tool bar buttons
     * @param e Action Event of the tool bar buttons
     */
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
