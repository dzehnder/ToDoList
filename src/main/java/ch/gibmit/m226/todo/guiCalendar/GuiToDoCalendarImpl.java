package ch.gibmit.m226.todo.guiCalendar;

import ch.gibmit.m226.todo.guiCalendar.day.GuiToDoCalendarDay;
import ch.gibmit.m226.todo.guiCalendar.day.GuiToDoCalendarDayimpl;
import ch.gibmit.m226.todo.guiCalendar.month.GuiToDoCalendarMonth;
import ch.gibmit.m226.todo.guiCalendar.month.GuiToDoCalendarMonthImpl;
import ch.gibmit.m226.todo.guiCalendar.week.GuiToDoCalendarWeek;
import ch.gibmit.m226.todo.guiCalendar.week.GuiToDoCalendarWeekImpl;
import ch.gibmit.m226.todo.guiCalendar.year.GuiToDoCalendarYear;
import ch.gibmit.m226.todo.guiCalendar.year.GuiToDoCalendarYearImpl;

import javax.swing.*;
import java.awt.*;

/**
 * @author Damian Zehnder
 * This class is the main calendar class. It adds all calendar components to the main frame.
 */
public class GuiToDoCalendarImpl implements GuiToDoCalendar {

    private JPanel pnlCalendarMain;
    private JTabbedPane tbdPnCalendars;
    private GuiToDoCalendarDay gtcd;
    private GuiToDoCalendarWeek gtcw;
    private GuiToDoCalendarMonth gtcm;
    private GuiToDoCalendarYear gtcy;




    public GuiToDoCalendarImpl() {
        pnlCalendarMain = new JPanel(new BorderLayout());

        gtcd = new GuiToDoCalendarDayimpl();
        gtcw = new GuiToDoCalendarWeekImpl();
        gtcm = new GuiToDoCalendarMonthImpl();
        gtcy = new GuiToDoCalendarYearImpl();

        tbdPnCalendars = new JTabbedPane();
        tbdPnCalendars.addTab("Tag", gtcd.getCalendarDay());
        tbdPnCalendars.addTab("Woche", gtcw.getCalendarWeek());
        tbdPnCalendars.addTab("Monat", gtcm.getCalendarMonth());
        tbdPnCalendars.addTab("Jahr", gtcy.getCalendarYear());

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
