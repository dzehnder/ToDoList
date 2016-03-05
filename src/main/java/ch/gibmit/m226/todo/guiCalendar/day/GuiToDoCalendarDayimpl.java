package ch.gibmit.m226.todo.guiCalendar.day;

import javax.swing.*;
import java.awt.*;

/**
 * Created by zehnder on 05/03/16.
 */
public class GuiToDoCalendarDayimpl implements GuiToDoCalendarDay {

    private JPanel pnlDay;

    public GuiToDoCalendarDayimpl() {
        pnlDay = new JPanel(new BorderLayout());
    }

    public JPanel getCalendarDay() {
        return pnlDay;
    }
}
