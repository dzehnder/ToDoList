package ch.gibmit.m226.todo.gui.guiCalendar.month;

import ch.gibmit.m226.todo.gui.guiCalendar.GuiCalendarAbstr;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author Damian Zehnder
 * This class implements the calendar view of the month
 */
public class GuiCalendarMonthImpl extends GuiCalendarAbstr implements GuiCalendarMonth {

    private JPanel pnlMonth;
    private JToolBar tlBrCalMonth;
    private GuiCalendarMonthComp monthComp;
    private JPanel pnlTools;

    public GuiCalendarMonthImpl() {
        pnlMonth = new JPanel(new BorderLayout());
        pnlTools = new JPanel(new BorderLayout());

        tlBrCalMonth = new JToolBar();
        monthComp = new GuiCalendarMonthComp();
        addButtonsToToolBar(tlBrCalMonth);

        pnlTools.add(tlBrCalMonth, BorderLayout.LINE_START);

        pnlMonth.add(pnlTools, BorderLayout.PAGE_START);
        pnlMonth.add(monthComp, BorderLayout.CENTER);
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
