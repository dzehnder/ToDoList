package ch.gibmit.m226.todo.gui.guiCalendar.month;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * @author Damian Zender
 */
public class GuiCalendarMonthComp extends JComponent {

    private static final String[] WEEKDAYS = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    private Calendar cal;
    private List<Rectangle> days;

    public GuiCalendarMonthComp(Calendar cal) {
        this.cal = cal;
        days = new ArrayList<>();
    }

    @Override
    protected void paintComponent(Graphics g) {
        int width = getWidth()-2;
        int height = getHeight()-2 ;
        int columns = 7;
        int rows = 6;
        int dayWidth = width/columns;
        int dayLabelHeight = 30;
        int weekHeight = (height-dayLabelHeight)/6;

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
        g.drawLine(0, dayLabelHeight, width, dayLabelHeight);

        /**
         * draw day cells
         */
        days.clear();

        for(int row = 0; row < rows; row++){
            for(int col = 0; col < columns; col++){
                Rectangle day = new Rectangle(col * dayWidth, (row * weekHeight)+dayLabelHeight, dayWidth, weekHeight);
                days.add(day);
            }
        }

        days.forEach(g2d::draw);

        /**
         * draw date numbers
         */

        Calendar thisMonth = (Calendar) cal.clone();
        thisMonth.set(Calendar.DAY_OF_MONTH, 1);
        int index = 0;

        /**
         * Test if  the first day of the month is monday, that it doesn't need to generate a previous month object
         */
        if (thisMonth.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
            Calendar prevMonth = (Calendar) cal.clone();
            prevMonth.add(Calendar.MONTH, -1);
            /**
             * Test if the first day of the month is sunday, special handling needed because of american week form
             */
            if (thisMonth.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                prevMonth.set(Calendar.DAY_OF_MONTH, prevMonth.getActualMaximum(Calendar.DAY_OF_MONTH)-5);
            }
            else {
                prevMonth.set(Calendar.DAY_OF_MONTH, prevMonth.getActualMaximum(Calendar.DAY_OF_MONTH) - thisMonth.get(Calendar.DAY_OF_WEEK) + 3);
            }

            /**
             * previous month date numbers
             */
            g.setColor(Color.decode("#BDBDBD"));
            for (int i = prevMonth.get(Calendar.DAY_OF_MONTH); i<=prevMonth.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
                g.drawString(String.valueOf(i), (int) Math.round(days.get(index).getX())+5, (int) Math.round(days.get(index).getY())+15);
                index++;
            }
        }

        /**
         * selected month date numbers
         */
        g.setColor(Color.BLACK);
        for (int i = thisMonth.get(Calendar.DAY_OF_MONTH); i<= thisMonth.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
            g.drawString(String.valueOf(i), (int) Math.round(days.get(index).getX())+5, (int) Math.round(days.get(index).getY())+15);
            index++;
        }


        /**
         * Week day labels
         */
        for (int i = 0; i<WEEKDAYS.length; i++) {
            g2d.drawString(WEEKDAYS[i], (dayWidth*i)+(dayWidth/8), (dayLabelHeight/2)+dayLabelHeight/4);
        }
    }
}
