package ch.gibmit.m226.todo.gui.guiCalendar.week;

import ch.gibmit.m226.todo.gui.guiCalendar.GuiCalendar;
import ch.gibmit.m226.todo.gui.guiCalendar.GuiCalendarAbstr;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author Damian Zehnder
 * This class implements the calendar view of the year
 */
public class GuiCalendarWeekImpl extends GuiCalendarAbstr implements GuiCalendar {

    private JPanel pnlWeek;
    private JToolBar tlBrCalWeek;
    private GuiCalendarWeekComp weekComp;
    private JPanel pnlTools;

    public GuiCalendarWeekImpl() {
        pnlWeek = new JPanel(new BorderLayout());
        pnlTools = new JPanel(new BorderLayout());

        tlBrCalWeek = new JToolBar();
        weekComp = new GuiCalendarWeekComp();
        addButtonsToToolBar(tlBrCalWeek);

        pnlTools.add(tlBrCalWeek, BorderLayout.PAGE_START);

        pnlWeek.add(pnlTools, BorderLayout.PAGE_START);
        pnlWeek.add(weekComp, BorderLayout.CENTER);

    }

    /**
     * This method catches the action event of the tool bar buttons
     * @param e Action Event of the tool bar buttons
     */
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    /**
     * Interface method that returns the week view panel of the calendar
     * @return the calendar panel of the week view
     */
    public JPanel getCalendar() {
        return pnlWeek;
    }
}
