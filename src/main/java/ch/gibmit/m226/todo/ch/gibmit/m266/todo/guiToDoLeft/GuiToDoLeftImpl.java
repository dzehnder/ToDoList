package ch.gibmit.m226.todo.ch.gibmit.m266.todo.guiToDoLeft;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by colin on 24.02.16.
 */
public class GuiToDoLeftImpl implements GuiToDoLeft {

    private JPanel pnlToDoLeft;
    private JPanel pnlToDoLeftTop;
    private JComboBox cmbxToDoSort;
    private JList<String> lstToDos;

    JTextField txtFldSearchToDo;

    public GuiToDoLeftImpl() {

        pnlToDoLeft = new JPanel(new BorderLayout());
        pnlToDoLeftTop = new JPanel(new GridLayout(2,1));

        txtFldSearchToDo = new JTextField();

        cmbxToDoSort = new JComboBox();

        String listData[] =
                {
                        "Item 1",
                        "Item 2",
                        "Item 3",
                        "Item 4"
                };

        lstToDos = new JList(listData);

        pnlToDoLeft.add(pnlToDoLeftTop, BorderLayout.NORTH);
        pnlToDoLeftTop.add(txtFldSearchToDo);
        pnlToDoLeftTop.add(cmbxToDoSort);

        pnlToDoLeft.add(lstToDos, BorderLayout.CENTER);



    }

    public JPanel getToDoLeft() {
        return pnlToDoLeft;
    }
}
