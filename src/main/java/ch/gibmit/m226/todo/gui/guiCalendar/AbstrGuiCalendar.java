package ch.gibmit.m226.todo.gui.guiCalendar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Calendar;


/**
 * @author Damian Zehnder
 * This abstract class is the panel of the calendar.
 * It also generates the navigation buttons and adds them to the calendar toolbar
 */
public abstract class AbstrGuiCalendar extends JPanel implements ActionListener {

    private static final String BCKIMGNAME = "backButtonIcon";
    private static final String FWDIMGNAME = "forwardButtonIcon";
    private final Calendar cal = CalModel.getInstance().getCal();

    /**
     * This method makes a navigation Button with an arrow
     * @param imgName name of the image
     * @param action action witch can be catched from the action Listener in the main calendar class
     * @return the button with the specified icon
     */
    public JButton navButton(String imgName, String action) {



        JButton btn = new JButton();

        try {
            URL pic = this.getClass().getClassLoader().getResource(imgName+".png");
            Icon img = new ImageIcon(pic);
            btn.setIcon(img);
        }
        catch (NullPointerException e) {
            e.printStackTrace();
        }

        btn.setActionCommand(action);
        btn.addActionListener(this);

        return btn;
    }

    /**
     * This method adds all the necessary buttons to the toolbar
     * @param tlBrCal the toolbar, where the button should be added
     */
    public void addButtonsToToolBar(JToolBar tlBrCal) {
        tlBrCal.setFloatable(false);
        JButton btn;

        btn = navButton(BCKIMGNAME, "back");
        tlBrCal.add(btn);

        btn = new JButton("Today");
        btn.setActionCommand("today");
        btn.addActionListener(this);
        tlBrCal.add(btn);

        btn = navButton(FWDIMGNAME, "forward");
        tlBrCal.add(btn);
    }

    /**
     * This method catches all performed actions in the calendar
     * @param e the Action Event
     */
    public abstract void actionPerformed(ActionEvent e);

    /**
     * @return the selected calendar date in the calendar view
     */
    public Calendar getCal() {
        return cal;
    }

    /**
     * set the selected calendar date in the calendar view
     * @param cal the selected calendar date in the calendar view
     */

}
