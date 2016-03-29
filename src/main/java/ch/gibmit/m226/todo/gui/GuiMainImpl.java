package ch.gibmit.m226.todo.gui;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;

/**
 * Created by colin on 24.02.16.
 */

import ch.gibmit.m226.todo.gui.guiCalendar.GuiCalendarImpl;
import ch.gibmit.m226.todo.gui.guiCalendar.GuiCalendarPanel;
import ch.gibmit.m226.todo.gui.gui.GuiToDo;
import ch.gibmit.m226.todo.gui.guiToDoImpl.GuiToDoMainImpl;

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
    private GuiToDo gtm;
    private GuiCalendarPanel gtc;
    
    private GuiMenu gm;

    public GuiMainImpl() {

        mainPane = new JTabbedPane();
        gtm = new GuiToDoMainImpl();
        gtc = new GuiCalendarImpl();
        gm = new GuiMenu();
        
        this.mainPane.addTab("ToDos", gtm.getPanel());
        this.mainPane.addTab("Calendar", gtc.getCalendarPanel());
        this.setJMenuBar(gm.getMenuBar());
        
        this.add(mainPane);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.pack();
        this.setSize(800, 500);
        this.setMinimumSize(new Dimension(500, 300));
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }
}
