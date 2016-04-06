package ch.gibmit.m226.todo.gui.guiToDoImpl;

import ch.gibmit.m226.todo.gui.gui.GuiPanel;

import javax.swing.*;
import java.awt.*;

/**
 * @author Damian Zehnder
 *
 */



public class GuiToDoRepeatImpl implements GuiPanel {

    private JPanel pnlRepeater;
    private JPanel pnlRepeaterCenter;

    public GuiToDoRepeatImpl() {
        setUpPanels();
    }


    private void setUpPanels() {
        pnlRepeater = new JPanel(new BorderLayout());
        pnlRepeaterCenter = new JPanel();

        pnlRepeater.add(pnlRepeaterCenter);
    }



    @Override
    public JPanel getPanel() {
        return pnlRepeater;
    }
}
