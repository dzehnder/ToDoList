package ch.gibmit.m226.todo.gui.guiCalendar.day;

import ch.gibmit.m226.todo.gui.guiCalendar.GuiCalendar;
import ch.gibmit.m226.todo.gui.guiCalendar.GuiCalendarAbstr;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author Damian Zehnder
 * This class implements the calendar view of the day
 */
public class GuiCalendarDayimpl extends GuiCalendarAbstr implements GuiCalendar {

    private JPanel pnlDay;
    private JToolBar tlBrCalDay;
    private GuiCalendarDayComp dayComp;
    private JPanel pnlTools;

    public GuiCalendarDayimpl() {
        pnlDay = new JPanel(new BorderLayout());
        pnlTools = new JPanel(new BorderLayout());

        tlBrCalDay = new JToolBar();
        dayComp = new GuiCalendarDayComp();
        addButtonsToToolBar(tlBrCalDay);

        pnlTools.add(tlBrCalDay, BorderLayout.LINE_START);

        pnlDay.add(pnlTools, BorderLayout.PAGE_START);
        pnlDay.add(dayComp, BorderLayout.CENTER);
    }

    /**
     * This method catches the action event of the tool bar buttons
     * @param e Action Event of the tool bar buttons
     */
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    /**
     * Interface method that returns the day view panel of the calendar
     * @return the calendar panel of the day
     */
    public JPanel getCalendar() {
        return pnlDay;

    }
}
