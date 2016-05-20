package ch.gibmit.m226.todo.gui.guiCalendar;

import ch.gibmit.m226.todo.dto.ToDoDTO;
import ch.gibmit.m226.todo.gui.guiToDoImpl.ToDoModel;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

/**
 * @author Damian Zehnder
 * This class paints the day view of the calendar
 */
public class GuiCalendarDayComp extends JComponent {

    ToDoModel toDoModel;
    Calendar cal;

    public GuiCalendarDayComp(Calendar cal, ToDoModel toDoModel) {
        this.toDoModel = toDoModel;
        this.cal = cal;
    }

    @Override
    protected void paintComponent(Graphics g) {
        int width = getWidth()-2;
        int height = getHeight()-2 ;
        System.out.println(cal.getTime());

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
         * loop through all todos and check if the date matches to the selected day
         */
        int todosThisDay = 0;
        for (ToDoDTO toDoDTO : toDoModel.getToDoList()) {
            Calendar todoDate = Calendar.getInstance();
            todoDate.setTime(toDoDTO.getDateTime());
            if (todoDate.get(Calendar.DAY_OF_YEAR) == cal.get(Calendar.DAY_OF_YEAR)) {
                todosThisDay++;
                int posY = todosThisDay*20 + 5;
                g2d.drawString(toDoDTO.getName() + ", " + toDoDTO.getNote(), 10, posY);
            }

        }
    }
}
