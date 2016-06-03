package ch.gibmit.m226.todo.gui.guiCalendar;

import ch.gibmit.m226.todo.dto.ToDoDTO;
import ch.gibmit.m226.todo.gui.guiToDoImpl.ToDoModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;

/**
 * @author Damian Zehnder
 * This class paints the week view of the calendar
 */
public class GuiCalendarWeekComp extends JComponent {

    private static final String[] WEEKDAYS = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    private Calendar cal;
    private ToDoModel toDoModel;
    private JTabbedPane tabbedPane;

    /**
     *
     * @param toDoModel the todolist-model, containing all todos. It is used to determine the days the todos are happening.
     * @param tbdPnCalendars
     */
    public GuiCalendarWeekComp(ToDoModel toDoModel, JTabbedPane tbdPnCalendars) {
        this.cal = CalModel.getInstance().getCal();
        this.toDoModel = toDoModel;
        this.tabbedPane = tbdPnCalendars;
    }

    /**
     * in this method, the main component gets painted.
     * @param g Graphics object
     */
    @Override
    protected void paintComponent(Graphics g) {

        int width = getWidth()-2;
        int height = getHeight()-2 ;
        int dayWidth = width/7;
        int dayLabelHeight = 30;

        // Graphics2D object for antialiasing
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_DEFAULT);

        // Background
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);

        g.setColor(Color.BLACK);
        g.drawRect(0, 0, width, height);
        g.drawLine(0, dayLabelHeight, width, dayLabelHeight);

        // Week day lines
        for (int i = dayWidth; i<=width-dayWidth; i+=dayWidth) {
            g.drawLine(i, 0, i, height);
        }

        Calendar weekCal = (Calendar) cal.clone();
        // Week day labels
        for (int i = 0; i<WEEKDAYS.length; i++) {
            weekCal.set(Calendar.DAY_OF_WEEK, i+2);
            int todoDayCount = 0;
            g2d.drawString(WEEKDAYS[i], (dayWidth*i)+(dayWidth/8), (dayLabelHeight/2)+dayLabelHeight/4);

            // draw the todos
            for (ToDoDTO toDoDTO : toDoModel.getToDoList()) {
                Calendar todoDate = Calendar.getInstance();
                todoDate.setTime(toDoDTO.getDateTime());
                //if (weekCal.get(Calendar.DAY_OF_YEAR) == todoDate.get(Calendar.DAY_OF_YEAR) && weekCal.get(Calendar.YEAR) == todoDate.get(Calendar.YEAR)) {
                if (toDoDTO.isDateValid(weekCal)) {

                    // before dwawing the todoname, check if the length fits into the width of the day
                    FontMetrics metrics = g.getFontMetrics();
                    int todoNameWidth = metrics.stringWidth(toDoDTO.getName());
                    int extensionWidth = metrics.stringWidth("...");
                    // if the day is not big enough, shorten the todoname
                    if (todoNameWidth+15+extensionWidth > dayWidth) {
                        String changedToDoName = toDoDTO.getName();
                        while(todoNameWidth+15+extensionWidth > dayWidth) {
                            changedToDoName = changedToDoName.substring(0, changedToDoName.length()-1);
                            todoNameWidth = metrics.stringWidth(changedToDoName);
                        }
                        g2d.drawString(changedToDoName+"...", (dayWidth*i)+10, (dayLabelHeight+20)+(todoDayCount*15));
                    }
                    // draw original todoname
                    else {
                        g2d.drawString(toDoDTO.getName(), (dayWidth*i)+10, (dayLabelHeight+20)+(todoDayCount*15));
                    }

                    todoDayCount++;
                }
            }

        }

        MouseAdapter mouseAdapter = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int col = e.getX() / dayWidth;
                    weekCal.set(Calendar.DAY_OF_WEEK, col+2);
                    cal.setTime(weekCal.getTime());
                    tabbedPane.setSelectedIndex(0);
                }
            }
        };
        addMouseListener(mouseAdapter);

    }
}
