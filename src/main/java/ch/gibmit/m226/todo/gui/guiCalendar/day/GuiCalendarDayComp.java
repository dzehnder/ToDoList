package ch.gibmit.m226.todo.gui.guiCalendar.day;

import javax.swing.*;
import java.awt.*;

/**
 * @author Damian Zehnder
 */
public class GuiCalendarDayComp extends JComponent {


    @Override
    protected void paintComponent(Graphics g) {
        int width = getWidth()-2;
        int height = getHeight()-2 ;


        g.drawRect(0, 0, width, height);
    }
}
