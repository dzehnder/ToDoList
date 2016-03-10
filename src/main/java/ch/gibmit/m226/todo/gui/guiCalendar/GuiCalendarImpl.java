package ch.gibmit.m226.todo.gui.guiCalendar;

import ch.gibmit.m226.todo.gui.guiCalendar.day.GuiCalendarDay;
import ch.gibmit.m226.todo.gui.guiCalendar.day.GuiCalendarDayimpl;
import ch.gibmit.m226.todo.gui.guiCalendar.month.GuiCalendarMonth;
import ch.gibmit.m226.todo.gui.guiCalendar.month.GuiCalendarMonthImpl;
import ch.gibmit.m226.todo.gui.guiCalendar.week.GuiCalendarWeek;
import ch.gibmit.m226.todo.gui.guiCalendar.week.GuiCalendarWeekImpl;
import ch.gibmit.m226.todo.gui.guiCalendar.year.GuiCalendarYear;
import ch.gibmit.m226.todo.gui.guiCalendar.year.GuiCalendarYearImpl;

import javax.swing.*;
import java.awt.*;

/**
 * @author Damian Zehnder
 * This class is the main calendar class. It adds all calendar components to the main frame.
 */
public class GuiCalendarImpl implements GuiCalendar {

    private JPanel pnlCalendarMain;
    private JTabbedPane tbdPnCalendars;
    private GuiCalendarDay gtcd;
    private GuiCalendarWeek gtcw;
    private GuiCalendarMonth gtcm;
    private GuiCalendarYear gtcy;




    public GuiCalendarImpl() {
        pnlCalendarMain = new JPanel(new BorderLayout());

        gtcd = new GuiCalendarDayimpl();
        gtcw = new GuiCalendarWeekImpl();
        gtcm = new GuiCalendarMonthImpl();
        gtcy = new GuiCalendarYearImpl();

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
