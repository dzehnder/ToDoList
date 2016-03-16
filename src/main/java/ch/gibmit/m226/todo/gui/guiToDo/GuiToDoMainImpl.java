package ch.gibmit.m226.todo.gui.guiToDo;


import ch.gibmit.m226.todo.gui.guiToDo.guiToDoLeft.GuiToDoLeft;
import ch.gibmit.m226.todo.gui.guiToDo.guiToDoLeft.GuiToDoLeftImpl;
import ch.gibmit.m226.todo.gui.guiToDo.guiToDoRight.GuiToDoRight;
import ch.gibmit.m226.todo.gui.guiToDo.guiToDoRight.GuiToDoRightImpl;

import javax.swing.*;
import java.awt.*;

/**
 * Created by colin on 24.02.16.
 */
public class GuiToDoMainImpl implements GuiToDoMain {

    JPanel pnlToDoMain;
    JSplitPane sptPnToDoMain;
    GuiToDoLeft gtl;
    GuiToDoRight gtr;

    public GuiToDoMainImpl() {

        pnlToDoMain = new JPanel(new BorderLayout());

        sptPnToDoMain = new JSplitPane();
        sptPnToDoMain.setDividerLocation(0.5);

        gtl = new GuiToDoLeftImpl();
        sptPnToDoMain.setLeftComponent(gtl.getToDoLeft());

        gtr = new GuiToDoRightImpl();
        sptPnToDoMain.setRightComponent(gtr.getToDoRight());

        pnlToDoMain.add(sptPnToDoMain);

    }

    public JPanel getToDoMain() {
        return pnlToDoMain;
    }
}
