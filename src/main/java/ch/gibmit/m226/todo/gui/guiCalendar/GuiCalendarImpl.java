package ch.gibmit.m226.todo.gui.guiCalendar;

import ch.gibmit.m226.todo.gui.guiToDoImpl.ToDoModel;
import ch.gibmit.m226.todo.gui.interfaces.GuiCalendarPanel;

import javax.swing.*;
import java.awt.*;

/**
 * @author Damian Zehnder
 * This class is the main calendar class. It adds all calendar components to the main frame.
 */
public class GuiCalendarImpl implements GuiCalendarPanel {

    private JPanel pnlCalendarMain;
    private JTabbedPane tbdPnCalendars;

    public GuiCalendarImpl(ToDoModel toDoModel) {
        pnlCalendarMain = new JPanel(new BorderLayout());

        tbdPnCalendars = new JTabbedPane();
        tbdPnCalendars.addTab("Day", new DayPanelGuiCalendar(toDoModel));

        tbdPnCalendars.addTab("Week", new WeekPanelGuiCalendar(toDoModel));

        tbdPnCalendars.addTab("Month", new MonthPanelGuiCalendar(toDoModel, tbdPnCalendars));

        tbdPnCalendars.addTab("Year", new YearPanelGuiCalendar(toDoModel));

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
