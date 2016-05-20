package ch.gibmit.m226.todo.gui.guiCalendar;

import ch.gibmit.m226.todo.gui.guiToDoImpl.ToDoModel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * @author Damian Zehnder
 * This class implements the calendar view of the year
 */
public class YearPanelGuiCalendar extends AbstrGuiCalendar {

    private JToolBar tlBrCalYear;
    private GuiCalendarYearComp yearComp;
    private JPanel pnlTools;
    private Calendar cal = Calendar.getInstance(Locale.GERMANY);
    private JLabel lblYear;

    public YearPanelGuiCalendar(ToDoModel toDoModel) {
        this.setLayout(new BorderLayout());
        pnlTools = new JPanel(new BorderLayout());

        tlBrCalYear = new JToolBar();
        yearComp = new GuiCalendarYearComp(cal, toDoModel);
        addButtonsToToolBar(tlBrCalYear);
        lblYear = new JLabel();
        lblYear.setBorder(new EmptyBorder(5, 10, 5, 10));
        updateDateLabel();

        pnlTools.add(tlBrCalYear, BorderLayout.LINE_START);
        pnlTools.add(lblYear, BorderLayout.LINE_END);

        this.add(pnlTools, BorderLayout.PAGE_START);
        this.add(yearComp, BorderLayout.CENTER);

    }

    /**
     * This method catches the action event of the tool bar buttons
     * @param e Action Event of the tool bar buttons
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "back":
                cal.add(Calendar.YEAR, -1);
                updateDateLabel();
                break;

            case "forward":
                cal.add(Calendar.YEAR, 1);
                updateDateLabel();
                break;

            case "today":
                cal.setTime(new Date());
                updateDateLabel();
                break;
        }
        yearComp.repaint();
    }

    /**
     * updates the date label of the year
     */
    private void updateDateLabel() {
        lblYear.setText(String.valueOf(cal.get(Calendar.YEAR)));
    }
}
