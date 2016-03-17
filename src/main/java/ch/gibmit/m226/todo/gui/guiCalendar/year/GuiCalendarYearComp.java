package ch.gibmit.m226.todo.gui.guiCalendar.year;

import javax.swing.*;
import java.awt.*;

/**
 * @author Damian Zehnder
 */
public class GuiCalendarYearComp extends JComponent {

    private static final String[] MONTHS = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

    @Override
    protected void paintComponent(Graphics g) {
        int width = getWidth()-2;
        int height = getHeight()-2 ;
        int monthWidth = width/4;
        int monthHeight = height/3;
        int monthLabelHeight = 20;

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

        /**
         * Month lines vertical
         */
        for (int i = monthWidth; i<=width-monthWidth; i+=monthWidth) {
            g.drawLine(i, 0, i, height);
        }

        /**
         * Month lines horizontal
         */
        for (int i = monthHeight; i<=height-monthHeight; i+=monthHeight) {
            g.drawLine(0,i, width, i);
        }

        /**
         * Month labels line
         */
        for (int i = monthLabelHeight; i <=height-monthLabelHeight; i+=monthHeight) {
            g.drawLine(0, i, width, i);
        }

        /**
         * Month labels
         */
        for (int i = 0; i<MONTHS.length; i++) {
            if (i<4) {
                g2d.drawString(MONTHS[i], (monthWidth*i)+10, 15);
            }
            else if (i >= 4 && i<8) {
                g2d.drawString(MONTHS[i], monthWidth*(i-4)+10, monthHeight+15);
            }
            else if (i >= 8) {
                g2d.drawString(MONTHS[i], monthWidth*(i-8)+10, (monthHeight*2)+15);
            }
        }



    }
}
