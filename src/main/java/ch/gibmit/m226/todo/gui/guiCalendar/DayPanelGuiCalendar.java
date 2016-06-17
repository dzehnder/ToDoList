package ch.gibmit.m226.todo.gui.guiCalendar;

import ch.gibmit.m226.todo.dto.ToDoDTO;
import ch.gibmit.m226.todo.gui.guiToDoImpl.GuiToDoLeftImpl;
import ch.gibmit.m226.todo.gui.guiToDoImpl.ToDoModel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

/**
 * @author Damian Zehnder
 * This class implements the calendar view of the day
 */
public class DayPanelGuiCalendar extends AbstrGuiCalendar {

    private JToolBar tlBrCalDay;
    private JPanel pnlTools;
    private SimpleDateFormat sdf = new SimpleDateFormat("EEEE, d. MMMM yyyy");
    private Calendar cal = getCal();
    private JLabel lblDay;
    private Calendar calModel;
    private ToDoModel toDoModel;
    private  DefaultListModel<String> listModel = new DefaultListModel<>();
    private JList<String> list;
    private List<String> dayNameModel;

    /**
     * constructor initializes the daily view of the calendar
     * @param toDoModel the todolist-model, containing all todos
     * @param mainPane the main tabbed pane
     * @param leftTodo the gui from the left side of the split pane in the main view
     */
    public DayPanelGuiCalendar(ToDoModel toDoModel, JTabbedPane mainPane, GuiToDoLeftImpl leftTodo) {
        this.toDoModel = toDoModel;
        this.setLayout(new BorderLayout());
        pnlTools = new JPanel(new BorderLayout());
        this.calModel = CalModel.getInstance().getCal();
        this.dayNameModel = new ArrayList<>();

        tlBrCalDay = new JToolBar();
        addButtonsToToolBar(tlBrCalDay);
        lblDay = new JLabel();
        lblDay.setBorder(new EmptyBorder(5, 10, 5, 10));
        updateDateLabel();



        list = new JList<>();
        Font font = new Font("Arial", Font.PLAIN, 16);

        list.setFont(font);
        list.setBorder(BorderFactory.createMatteBorder(10,10,10,10, Color.WHITE));
        list.setCellRenderer(getRenderer());

        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setModel(listModel);
        list.addMouseListener(new MouseAdapter() {
            /**
             * Catch the event of the mouse. If a list item gets double clicked, the view switches to the standard
             * todolist view and selects the chosen item in the list.
             * @param e the mouse action event
             */
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    mainPane.setSelectedIndex(0);
                    leftTodo.setSelectedToDoName(dayNameModel.get(list.getSelectedIndex()));

                }
            }
        });


        JScrollPane listScrollPane = new JScrollPane(list);

        pnlTools.add(tlBrCalDay, BorderLayout.LINE_START);
        pnlTools.add(lblDay, BorderLayout.LINE_END);

        this.add(pnlTools, BorderLayout.PAGE_START);
        this.add(listScrollPane, BorderLayout.CENTER);
    }

    /**
     * This method catches the action event of the tool bar buttons
     * it sets the time, according to the input of the navigation buttons in the calendar view.
     * @param e Action Event of the tool bar buttons
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "back":
                cal.add(Calendar.DATE, -1);
                updateDateLabel();
                break;

            case "forward":
                cal.add(Calendar.DATE, 1);
                updateDateLabel();
                break;

            case "today":
                cal.setTime(new Date());
                updateDateLabel();
                break;
        }
    }

    /**
     * updates the date label of the day and repaints the day-component
     */
    public void updateDateLabel() {
        lblDay.setText(sdf.format(cal.getTime()));

            listModel.clear();

        int todosThisDay = 0;
        for (ToDoDTO toDoDTO : toDoModel.getToDoList()) {
            Calendar todoDate = Calendar.getInstance();
            todoDate.setTime(toDoDTO.getDateTime());
            if (toDoDTO.isDateValid(calModel)) {
                SimpleDateFormat sdf = new SimpleDateFormat("H:m");
                String repeat = "";
                if (toDoDTO.getRepeat() != null) {
                    repeat = ", Repeat: "+ toDoDTO.getRepeat().getRecurrence();
                }
                dayNameModel.add(toDoDTO.getName());
                listModel.add(todosThisDay, sdf.format(toDoDTO.getDateTime())+" Uhr: "+ toDoDTO.getName() + repeat + ", Category: "+ toDoDTO.getCategory() + ", Priority "+ toDoDTO.getPriority());
                todosThisDay++;
            }

        }
    }

    /**
     * Create custom JList renderer. Renderer creates border between the list items.
     * @return the list cell renderer of the day list.
     */
    private ListCellRenderer getRenderer() {
        return new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean hasFocus) {
                JLabel lblRenderComponent = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, hasFocus);
                lblRenderComponent.setBorder(BorderFactory.createMatteBorder(0, 0, 10, 0,Color.WHITE));
                return lblRenderComponent;
            }
        };
    }

}
