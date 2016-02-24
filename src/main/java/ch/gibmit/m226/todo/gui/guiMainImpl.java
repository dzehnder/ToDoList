package ch.gibmit.m226.todo.gui;

/**
 * Created by colin on 24.02.16.
 */

import ch.gibmit.m226.todo.guiToDo.GuiToDoMain;
import ch.gibmit.m226.todo.guiToDo.GuiToDoMainImpl;

import javax.swing.*;

/**
 * @autor Colin Herzog
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

    public GuiMainImpl() {

        this.setVisible(true);
        this.setSize(800, 500);

        mainPane = new JTabbedPane();
        gtm = new GuiToDoMainImpl();

        this.mainPane.addTab("ToDos", gtm.getToDoMain());
        this.mainPane.addTab("Kalender", new JPanel());

        this.add(mainPane);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}
