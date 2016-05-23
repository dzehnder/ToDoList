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

    /**
     * Constructor creates all week components and adds them to the appropriate tab.
     * It also updates all date-values in the view, after the tab selection has changed.
     * @param toDoModel the todolist-model, containing all todos
     */
    public GuiCalendarImpl(ToDoModel toDoModel) {
        DayPanelGuiCalendar day = new DayPanelGuiCalendar(toDoModel);
        WeekPanelGuiCalendar week = new WeekPanelGuiCalendar(toDoModel);
        MonthPanelGuiCalendar month = new MonthPanelGuiCalendar(toDoModel, tbdPnCalendars);
        YearPanelGuiCalendar year = new YearPanelGuiCalendar(toDoModel);

        pnlCalendarMain = new JPanel(new BorderLayout());

        tbdPnCalendars = new JTabbedPane();
        tbdPnCalendars.addTab("Day", day);

        tbdPnCalendars.addTab("Week", week);

        tbdPnCalendars.addTab("Month", month);

        tbdPnCalendars.addTab("Year", year);

        pnlCalendarMain.add(tbdPnCalendars);

        tbdPnCalendars.addChangeListener(e -> {
            day.updateDateLabel();
            month.updateDateLabel();
            week.updateDateLabel();
            year.updateDateLabel();
        });

    }


    /**
     * Interface method that returns the main calendar panel
     * @return the main Calendar Panel
     */
    public JPanel getCalendarPanel() {
        return pnlCalendarMain;
    }

}
