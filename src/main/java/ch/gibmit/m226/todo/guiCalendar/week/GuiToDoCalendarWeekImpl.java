package ch.gibmit.m226.todo.guiCalendar.week;

import javax.swing.*;
import java.awt.*;

/**
 * Created by zehnder on 05/03/16.
 */
public class GuiToDoCalendarWeekImpl implements GuiToDoCalendarWeek {

    private JPanel pnlWeek;

    public GuiToDoCalendarWeekImpl() {
        pnlWeek = new JPanel(new BorderLayout());
    }

    public JPanel getCalendarWeek() {
        return pnlWeek;
    }
}
