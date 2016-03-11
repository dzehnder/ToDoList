package ch.gibmit.m226.todo.gui.guiCalendar.week;

import javax.swing.*;
import java.awt.*;

/**
 * @author Damian Zehnder
 * This class paints the week view of the calendar
 */
public class GuiCalendarWeekComp extends JComponent {

    private static final String[] WEEKDAYS = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

    /**
     * @param g Graphics object
     */
    @Override
    protected void paintComponent(Graphics g) {

        int width = getWidth()-2;
        int height = getHeight()-2 ;
        int dayWidth = width/7;
        int dayLabelHeight = 30;

        /**
         * Graphics2D object for antialiasing
         */
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_DEFAULT);

        /**
         * Background
         */
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);

        g.setColor(Color.BLACK);
        g.drawRect(0, 0, width, height);
        g.drawLine(0, dayLabelHeight, width, dayLabelHeight);

        /**
         * Week day lines
         */
        for (int i = dayWidth; i<=width-dayWidth; i+=dayWidth) {
            g.drawLine(i, 0, i, height);
        }

        /**
         * Week day labels
         */
        for (int i = 0; i<WEEKDAYS.length; i++) {
            g2d.drawString(WEEKDAYS[i], (dayWidth*i)+20, 20);
        }


    }
}
