package ch.gibmit.m226.todo.gui.guiToDoImpl;


import ch.gibmit.m226.todo.gui.guiToDo.GuiToDo;

import javax.swing.*;
import java.awt.*;

/**
 * Created by colin on 24.02.16.
 */
public class GuiToDoMainImpl implements GuiToDo {

    JPanel pnlToDoMain;
    JSplitPane sptPnToDoMain;
    GuiToDo gtl;
    GuiToDo gtr;

    public GuiToDoMainImpl() {

        pnlToDoMain = new JPanel(new BorderLayout());

        sptPnToDoMain = new JSplitPane();
        sptPnToDoMain.setDividerLocation(0.5);

        gtl = new GuiToDoLeftImpl();
        sptPnToDoMain.setLeftComponent(gtl.getPanel());

        gtr = new GuiToDoRightImpl();
        sptPnToDoMain.setRightComponent(gtr.getPanel());

        pnlToDoMain.add(sptPnToDoMain);

    }

    @Override
    public JPanel getPanel() {
        return pnlToDoMain;
    }
}
