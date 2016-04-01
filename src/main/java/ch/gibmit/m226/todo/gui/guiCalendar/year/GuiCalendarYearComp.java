package ch.gibmit.m226.todo.gui.guiCalendar.year;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.*;
import java.util.List;

/**
 * @author Damian Zehnder
 */
public class GuiCalendarYearComp extends JComponent {

    private static final String[] MONTHS = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    private static final String[] WEEKDAYS = {"Mo", "Tu", "We", "Th", "Fr", "Sa", "Su"};
    private List<Rectangle> months;
    private Calendar cal;

    public GuiCalendarYearComp(Calendar cal) {
        months = new ArrayList<>();
        this.cal = cal;
    }

    @Override
    protected void paintComponent(Graphics g) {
        int width = getWidth()-2;
        int height = getHeight()-2 ;
        int monthWidth = width/4;
        int monthHeight = height/3;
        int monthLabelHeight = 20;
        int monthsVertical = 3;
        int monthsHorizontal = 4;

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

        /**
         * create month cells
         */
        months.clear();

        for(int row = 0; row < monthsVertical; row++){
            for(int col = 0; col < monthsHorizontal; col++){
                Rectangle month = new Rectangle(col * monthWidth, (row * monthHeight)+monthLabelHeight, monthWidth, monthHeight);
                months.add(month);
            }
        }

        //months.forEach(g2d::draw);
        /**
         * draw month labels
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

        /**
         * draw weekday labels
         */
        g.setFont(new Font("Helvetica", Font.PLAIN, 10));
        for (Rectangle month : months) {
            int xPos = (int) Math.round(month.getX());
            int yPos = (int) Math.round(month.getY());
            for (int d = 0; d < WEEKDAYS.length; d++) {
                g.drawString(WEEKDAYS[d], xPos + (d * (monthWidth / 7)) + ((monthWidth / 7) / 3), yPos + monthLabelHeight-3);
            }
            g.drawLine(xPos+monthWidth/28, yPos+monthLabelHeight, xPos+monthWidth-monthWidth/28, yPos+monthLabelHeight);
        }

        Calendar today = Calendar.getInstance(Locale.GERMANY);

        Calendar yearCal = (Calendar) cal.clone();

        for (int m = 0; m <months.size(); m++) {
            yearCal.set(Calendar.MONTH, m);
            yearCal.set(Calendar.DAY_OF_MONTH, 1);
            yearCal.getTime();
            yearCal.set(Calendar.DAY_OF_WEEK, 2);
            for (int w = 1; w < 7; w++) {
                for (int d = 0; d < WEEKDAYS.length; d++) {
                    g.setColor(Color.BLACK);
                    if (yearCal.get(Calendar.MONTH) > m || yearCal.get(Calendar.MONTH) < m) {
                        g.setColor(Color.decode("#BDBDBD"));
                    }
                    else if (today.get(Calendar.YEAR) == yearCal.get(Calendar.YEAR) && today.get(Calendar.MONTH) == yearCal.get(Calendar.MONTH) && today.get(Calendar.DAY_OF_MONTH) == yearCal.get(Calendar.DAY_OF_MONTH)) {
                        g.setColor(Color.decode("#DD5238"));
                        g2d.fill(new Ellipse2D.Double(months.get(m).getX()+ (d * (monthWidth / 7))  + ((monthWidth / 7) / 3)-2, months.get(m).getY() + (w * ((monthHeight - monthLabelHeight) / 7))+9, 15, 15));
                        g.setColor(Color.WHITE);
                    }
                    g.drawString(String.valueOf(yearCal.get(Calendar.DAY_OF_MONTH)), (int) Math.round(months.get(m).getX()) + (d * (monthWidth / 7)) + ((monthWidth / 7) / 3), (int) Math.round(months.get(m).getY()) + (w * ((monthHeight - monthLabelHeight) / 7)) + monthLabelHeight);
                    yearCal.add(Calendar.DAY_OF_YEAR, 1);
                }
            }
        }

    }
}
