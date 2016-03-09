package ch.gibmit.m226.todo.gui.guiCalendar.month;

import ch.gibmit.m226.todo.gui.guiCalendar.GuiToDoCalendarAbstr;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author Damian Zehnder
 * This class implements the calendar view of the month
 */
public class GuiToDoCalendarMonthImpl extends GuiToDoCalendarAbstr implements GuiToDoCalendarMonth {

    private JPanel pnlMonth;
    private JToolBar tlBrCalMonth;

    public GuiToDoCalendarMonthImpl() {
        pnlMonth = new JPanel(new BorderLayout());
        tlBrCalMonth = new JToolBar();
        addButtonsToToolBar(tlBrCalMonth);
        pnlMonth.add(tlBrCalMonth, BorderLayout.PAGE_START);
    }

    /**
     * Interface method that returns the week view panel of the clanedar
     * @return the calendar panel of the week view
     */
    public JPanel getCalendarMonth() {
        return pnlMonth;
    }

    /**
     * This method catches the action event of the tool bar buttons
     * @param e Action Event of the tool bar buttons
     */
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
