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
 * This class implements the calendar view of the day
 */
public class DayPanelGuiCalendar extends AbstrGuiCalendar {

    private JToolBar tlBrCalDay;
    private GuiCalendarDayComp dayComp;
    private JPanel pnlTools;
    private SimpleDateFormat sdf = new SimpleDateFormat("EEEE, d. MMMM yyyy");
    private Calendar cal = getCal();
    private JLabel lblDay;

    public DayPanelGuiCalendar(ToDoModel toDoModel) {

        this.setLayout(new BorderLayout());
        pnlTools = new JPanel(new BorderLayout());

        tlBrCalDay = new JToolBar();
        dayComp = new GuiCalendarDayComp(cal, toDoModel);
        addButtonsToToolBar(tlBrCalDay);
        lblDay = new JLabel();
        lblDay.setBorder(new EmptyBorder(5, 10, 5, 10));
        updateDateLabel();



        pnlTools.add(tlBrCalDay, BorderLayout.LINE_START);
        pnlTools.add(lblDay, BorderLayout.LINE_END);

        this.add(pnlTools, BorderLayout.PAGE_START);
        this.add(dayComp, BorderLayout.CENTER);
    }

    /**
     * This method catches the action event of the tool bar buttons
     * @param e Action Event of the tool bar buttons
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "back":
                cal.add(Calendar.DATE, -1);
                updateDateLabel();
                break;

            case "forward":
                cal.add(Calendar.DATE, 1);
                updateDateLabel();
                break;

            case "today":
                cal = Calendar.getInstance(Locale.GERMANY);
                updateDateLabel();
                break;
        }

    }

    /**
     * updates the date label of the day
     */
    private void updateDateLabel() {
        lblDay.setText(sdf.format(cal.getTime()));
        setCal(cal);
        dayComp.repaint();
    }
}
