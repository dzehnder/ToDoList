package ch.gibmit.m226.todo.gui.guiCalendar.month;

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
 * This class implements the calendar view of the month
 */
public class GuiCalendarMonthImpl extends GuiCalendarAbstr implements GuiCalendar {

    private JPanel pnlMonth;
    private JToolBar tlBrCalMonth;
    private GuiCalendarMonthComp monthComp;
    private JPanel pnlTools;
    private SimpleDateFormat sdf = new SimpleDateFormat("MMMM yyyy");
    private Calendar cal = getCal();
    private JLabel lblMonth;

    public GuiCalendarMonthImpl() {
        pnlMonth = new JPanel(new BorderLayout());
        pnlTools = new JPanel(new BorderLayout());

        tlBrCalMonth = new JToolBar();
        monthComp = new GuiCalendarMonthComp(cal);
        addButtonsToToolBar(tlBrCalMonth);
        lblMonth = new JLabel();
        lblMonth.setBorder(new EmptyBorder(5, 10, 5, 10));
        updateDateLabel();


        pnlTools.add(tlBrCalMonth, BorderLayout.LINE_START);
        pnlTools.add(lblMonth, BorderLayout.LINE_END);

        pnlMonth.add(pnlTools, BorderLayout.PAGE_START);
        pnlMonth.add(monthComp, BorderLayout.CENTER);
    }

    /**
     * This method catches the action event of the tool bar buttons
     * @param e Action Event of the tool bar buttons
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "back":
                cal.add(Calendar.MONTH, -1);
                updateDateLabel();
                break;

            case "forward":
                cal.add(Calendar.MONTH, 1);
                updateDateLabel();
                break;

            case "today":
                cal.setTime(new Date());
                updateDateLabel();
                break;
        }
        monthComp.repaint();
    }

    /**
     * Interface method that returns the week view panel of the clanedar
     * @return the calendar panel of the week
     */
    public JPanel getCalendar() {
        return pnlMonth;
    }

    /**
     * updates the date label of the month
     */
    private void updateDateLabel() {
        lblMonth.setText(sdf.format(cal.getTime()));
        setCal(cal);
    }
}
