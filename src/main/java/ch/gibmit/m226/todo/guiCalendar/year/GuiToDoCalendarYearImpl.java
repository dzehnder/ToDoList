package ch.gibmit.m226.todo.guiCalendar.year;

import javax.swing.*;
import java.awt.*;

/**
 * Created by zehnder on 05/03/16.
 */
public class GuiToDoCalendarYearImpl implements GuiToDoCalendarYear {

    private JPanel pnlYear;

    public GuiToDoCalendarYearImpl() {
        pnlYear = new JPanel(new BorderLayout());
    }

    public JPanel getCalendarYear() {
        return pnlYear;
    }
}
