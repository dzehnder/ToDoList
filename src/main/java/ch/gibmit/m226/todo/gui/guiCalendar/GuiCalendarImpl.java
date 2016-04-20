package ch.gibmit.m226.todo.gui.guiCalendar;

import ch.gibmit.m226.todo.gui.gui.GuiCalendarPanel;

import javax.swing.*;
import java.awt.*;

/**
 * @author Damian Zehnder
 * This class is the main calendar class. It adds all calendar components to the main frame.
 */
public class GuiCalendarImpl implements GuiCalendarPanel {

    private JPanel pnlCalendarMain;
    private JTabbedPane tbdPnCalendars;

    public GuiCalendarImpl() {
        pnlCalendarMain = new JPanel(new BorderLayout());

        tbdPnCalendars = new JTabbedPane();
        tbdPnCalendars.addTab("Day", new DayPanelGuiCalendar());

        tbdPnCalendars.addTab("Week", new WeekPanelGuiCalendar());

        tbdPnCalendars.addTab("Month", new MonthPanelGuiCalendar());

        tbdPnCalendars.addTab("Year", new YearPanelGuiCalendar());

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
