package ch.gibmit.m226.todo.gui.guiCalendar;

import ch.gibmit.m226.todo.gui.guiCalendar.day.GuiCalendarDayImpl;
import ch.gibmit.m226.todo.gui.guiCalendar.month.GuiCalendarMonthImpl;
import ch.gibmit.m226.todo.gui.guiCalendar.week.GuiCalendarWeekImpl;
import ch.gibmit.m226.todo.gui.guiCalendar.year.GuiCalendarYearImpl;

import javax.swing.*;
import java.awt.*;

/**
 * @author Damian Zehnder
 * This class is the main calendar class. It adds all calendar components to the main frame.
 */
public class GuiCalendarImpl implements GuiCalendarPanel {

    private JPanel pnlCalendarMain;
    private JTabbedPane tbdPnCalendars;
    private GuiCalendar gtc;




    public GuiCalendarImpl() {
        pnlCalendarMain = new JPanel(new BorderLayout());
        gtc = new GuiCalendarDayImpl();



        tbdPnCalendars = new JTabbedPane();
        tbdPnCalendars.addTab("Day", gtc.getCalendar());

        gtc = new GuiCalendarWeekImpl();
        tbdPnCalendars.addTab("Week", gtc.getCalendar());

        gtc = new GuiCalendarMonthImpl();
        tbdPnCalendars.addTab("Month", gtc.getCalendar());

        gtc = new GuiCalendarYearImpl();
        tbdPnCalendars.addTab("Year", gtc.getCalendar());

        pnlCalendarMain.add(tbdPnCalendars);

    }




    /**
     * Interface method that returns the main calendar panel
     * @return the main Calendar Panel
     */
    public JPanel getCalendarPanel() {
        return pnlCalendarMain;
    }

}
