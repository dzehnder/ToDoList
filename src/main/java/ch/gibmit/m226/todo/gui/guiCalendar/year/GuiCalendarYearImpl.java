package ch.gibmit.m226.todo.gui.guiCalendar.year;

import ch.gibmit.m226.todo.gui.guiCalendar.GuiCalendar;
import ch.gibmit.m226.todo.gui.guiCalendar.GuiCalendarAbstr;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author Damian Zehnder
 * This class implements the calendar view of the year
 */
public class GuiCalendarYearImpl extends GuiCalendarAbstr implements GuiCalendar {

    private JPanel pnlYear;
    private JToolBar tlBrCalYear;
    private GuiCalendarYearComp yearComp;
    private JPanel pnlTools;

    public GuiCalendarYearImpl() {
        pnlYear = new JPanel(new BorderLayout());
        pnlTools = new JPanel(new BorderLayout());

        tlBrCalYear = new JToolBar();
        yearComp = new GuiCalendarYearComp();
        addButtonsToToolBar(tlBrCalYear);

        pnlTools.add(tlBrCalYear, BorderLayout.PAGE_START);

        pnlYear.add(pnlTools, BorderLayout.PAGE_START);
        pnlYear.add(yearComp, BorderLayout.CENTER);

    }

    /**
     * This method catches the action event of the tool bar buttons
     * @param e Action Event of the tool bar buttons
     */
    @Override
    public void actionPerformed(ActionEvent e) {


    }

    /**
     * Interface method that returns the year view panel of the calendar
     * @return the calendar panel of the year
     */
    public JPanel getCalendar() {
        return pnlYear;
    }
}
