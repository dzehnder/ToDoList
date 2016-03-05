package ch.gibmit.m226.todo.guiCalendar.month;

import javax.swing.*;
import java.awt.*;

/**
 * Created by zehnder on 05/03/16.
 */
public class GuiToDoCalendarMonthImpl implements GuiToDoCalendarMonth {

    private JPanel pnlMonth;

    public GuiToDoCalendarMonthImpl() {
        pnlMonth = new JPanel(new BorderLayout());
    }

    public JPanel getCalendarMonth() {
        return pnlMonth;
    }
}
