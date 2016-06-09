package ch.gibmit.m226.todo.gui.guiCalendar;

import ch.gibmit.m226.todo.dto.ToDoDTO;
import ch.gibmit.m226.todo.gui.guiToDoImpl.GuiToDoLeftImpl;
import ch.gibmit.m226.todo.gui.guiToDoImpl.ToDoModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

/**
 * @author Damian Zehnder
 * This class paints the day view of the calendar
 */
public class GuiCalendarDayComp extends JComponent {

    private ToDoModel toDoModel;
    private Calendar calModel;
    private List<String> dayNameModel;
    private JTabbedPane tbdPnMain;
    private GuiToDoLeftImpl gtl;

    /**
     * Constructor sets the calendar and model value.
     * @param toDoModel the todolist-model, containing all todos
     * @param mainPane
     * @param leftTodo
     */
    public GuiCalendarDayComp(ToDoModel toDoModel, JTabbedPane mainPane, GuiToDoLeftImpl leftTodo) {
        this.toDoModel = toDoModel;
        this.calModel = CalModel.getInstance().getCal();
        this.dayNameModel = new ArrayList<>();
        this.tbdPnMain = mainPane;
        this.gtl = leftTodo;
    }

    /**
     * paints the main component of the daily view
     * @param g graphics object
     */
    @Override
    protected void paintComponent(Graphics g) {
        int width = getWidth()-2;
        int height = getHeight()-2 ;
        int labelHeight = 30;

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_DEFAULT);

        Font font = new Font("Arial", Font.PLAIN, 16);
        g2d.setFont(font);

        // Background
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);

        g.setColor(Color.BLACK);
        g.drawRect(0, 0, width, height);


        // loop through all todos and check if the date matches to the selected day
        int todosThisDay = 0;
        for (ToDoDTO toDoDTO : toDoModel.getToDoList()) {
            Calendar todoDate = Calendar.getInstance();
            todoDate.setTime(toDoDTO.getDateTime());
            if (toDoDTO.isDateValid(calModel)) {
                todosThisDay++;
                int posY = todosThisDay*labelHeight;
                SimpleDateFormat sdf = new SimpleDateFormat("H:m");
                String repeat = "";
                if (toDoDTO.getRepeat() != null) {
                    repeat = ", Repeat: "+ toDoDTO.getRepeat().getRecurrence();
                }
                String status = "– ";
                if (toDoDTO.isDone()) {
                    status = "\u2713";
                }

                dayNameModel.add(toDoDTO.getName());
                g2d.drawString(status + sdf.format(toDoDTO.getDateTime())+" Uhr: "+ toDoDTO.getName() + repeat + ", Category: "+ toDoDTO.getCategory() + ", Priority "+ toDoDTO.getPriority(), 10, posY);
            }

        }

        MouseAdapter mouseAdapter = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {

                    int index = e.getY()/labelHeight;
                    if (index < dayNameModel.size()) {


                        tbdPnMain.setSelectedIndex(0);
                        gtl.setSelectedToDoName(dayNameModel.get(index));
                    }
                }
            }
        };

        addMouseListener(mouseAdapter);

    }
}
