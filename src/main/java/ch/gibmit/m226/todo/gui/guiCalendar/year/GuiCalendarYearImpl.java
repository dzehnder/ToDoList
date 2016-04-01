package ch.gibmit.m226.todo.gui.guiCalendar.year;

import ch.gibmit.m226.todo.gui.guiCalendar.GuiCalendar;
import ch.gibmit.m226.todo.gui.guiCalendar.GuiCalendarAbstr;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * @author Damian Zehnder
 * This class implements the calendar view of the year
 */
public class GuiCalendarYearImpl extends GuiCalendarAbstr implements GuiCalendar {

    private JPanel pnlYear;
    private JToolBar tlBrCalYear;
    private GuiCalendarYearComp yearComp;
    private JPanel pnlTools;
    private Calendar cal = Calendar.getInstance(Locale.GERMANY);
    private JLabel lblYear;

    public GuiCalendarYearImpl() {
        pnlYear = new JPanel(new BorderLayout());
        pnlTools = new JPanel(new BorderLayout());

        tlBrCalYear = new JToolBar();
        yearComp = new GuiCalendarYearComp(cal);
        addButtonsToToolBar(tlBrCalYear);
        lblYear = new JLabel();
        lblYear.setBorder(new EmptyBorder(5, 10, 5, 10));
        updateDateLabel();

        pnlTools.add(tlBrCalYear, BorderLayout.LINE_START);
        pnlTools.add(lblYear, BorderLayout.LINE_END);

        pnlYear.add(pnlTools, BorderLayout.PAGE_START);
        pnlYear.add(yearComp, BorderLayout.CENTER);

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
     * Interface method that returns the year view panel of the calendar
     * @return the calendar panel of the year
     */
    public JPanel getCalendar() {
        return pnlYear;
    }

    /**
     * updates the date label of the year
     */
    private void updateDateLabel() {
        lblYear.setText(String.valueOf(cal.get(Calendar.YEAR)));
        setCal(cal);
    }
}
