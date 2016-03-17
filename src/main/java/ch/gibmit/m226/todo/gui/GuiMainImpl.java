package ch.gibmit.m226.todo.gui;

/**
 * Created by colin on 24.02.16.
 */

import ch.gibmit.m226.todo.gui.guiCalendar.GuiCalendarPanel;
import ch.gibmit.m226.todo.gui.guiCalendar.GuiCalendarImpl;
import ch.gibmit.m226.todo.gui.guiToDo.GuiToDoMain;
import ch.gibmit.m226.todo.gui.guiToDo.GuiToDoMainImpl;

import javax.swing.*;

/**
 * @author Colin Herzog
 * This class divides the GUI by its tabs.
 * The left tab is the detailed view for the ToDos, whilst the right tab the calendar view shows.
 */
public class GuiMainImpl extends JFrame{

    /**
     * This is the main pane. It's a tabbed pane where you can split a view into tabs.
     */
    private JTabbedPane mainPane;
    /**
     * This is the class for the left tab.
     */
    private GuiToDoMain gtm;
    private GuiCalendarPanel gtc;

    public GuiMainImpl() {

        mainPane = new JTabbedPane();
        gtm = new GuiToDoMainImpl();
        gtc = new GuiCalendarImpl();

        this.mainPane.addTab("ToDos", gtm.getToDoMain());
        this.mainPane.addTab("Calendar", gtc.getCalendarPanel());

        this.add(mainPane);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.pack();
        this.setSize(800, 500);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }
}
