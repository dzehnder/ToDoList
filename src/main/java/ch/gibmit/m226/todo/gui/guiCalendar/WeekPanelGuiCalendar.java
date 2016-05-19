package ch.gibmit.m226.todo.gui.guiCalendar;

import ch.gibmit.m226.todo.gui.guiToDoImpl.ToDoModel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * @author Damian Zehnder
 * This class implements the calendar view of the year
 */
public class WeekPanelGuiCalendar extends AbstrGuiCalendar {

    private JToolBar tlBrCalWeek;
    private GuiCalendarWeekComp weekComp;
    private JPanel pnlTools;
    private SimpleDateFormat sdf = new SimpleDateFormat("d. MMM");
    private Calendar cal = Calendar.getInstance(Locale.GERMANY);
    private JLabel lblWeek;

    public WeekPanelGuiCalendar(ToDoModel toDoModel) {
        this.setLayout(new BorderLayout());
        pnlTools = new JPanel(new BorderLayout());

        tlBrCalWeek = new JToolBar();
        weekComp = new GuiCalendarWeekComp(cal, toDoModel);
        addButtonsToToolBar(tlBrCalWeek);
        lblWeek = new JLabel();
        lblWeek.setBorder(new EmptyBorder(5, 10, 5, 10));
        updateDateLabel();

        pnlTools.add(tlBrCalWeek, BorderLayout.LINE_START);
        pnlTools.add(lblWeek, BorderLayout.LINE_END);

        this.add(pnlTools, BorderLayout.PAGE_START);
        this.add(weekComp, BorderLayout.CENTER);

    }

    /**
     * This method catches the action event of the tool bar buttons
     * @param e Action Event of the tool bar buttons
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "back":
                cal.add(Calendar.WEEK_OF_YEAR, -1);
                updateDateLabel();
                break;

            case "forward":
                cal.add(Calendar.WEEK_OF_YEAR, 1);
                updateDateLabel();
                break;

            case "today":
                cal = Calendar.getInstance(Locale.GERMANY);
                updateDateLabel();
                break;
        }
    }

    /**
     * updates the date label of the week
     */
    private void updateDateLabel() {
        Calendar first = (Calendar) cal.clone();
        first.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);

        Calendar last = (Calendar) cal.clone();
        last.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);

        lblWeek.setText(sdf.format(first.getTime())+" - "+sdf.format(last.getTime())+" (Week "+cal.get(Calendar.WEEK_OF_YEAR)+")");
    }
}
