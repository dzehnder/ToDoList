package ch.gibmit.m226.todo.ch.gibmit.m266.todo.guiToDoLeft;

import ch.gibmit.m226.todo.ch.gibmit.m226.todo.todo.Todo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by colin on 24.02.16.
 */
public class GuiToDoLeftImpl implements GuiToDoLeft {

    private JPanel pnlToDoLeft;
    private JPanel pnlToDoLeftTop;
    private JPanel pnlToDoLeftBottom;
    private JComboBox cmbxToDoSort;
    private JList<Todo> lstToDos;
    private JTextField txtFldSearchToDo;
    private JButton btnAddToDo;
    private JButton btnRemoveToDo;

    public GuiToDoLeftImpl() {

        pnlToDoLeft = new JPanel(new BorderLayout());
        pnlToDoLeftTop = new JPanel(new GridLayout(2, 1));
        pnlToDoLeftBottom = new JPanel(new GridLayout(1, 2));

        txtFldSearchToDo = new JTextField();
        cmbxToDoSort = new JComboBox();
        btnAddToDo = new JButton("+");
        btnRemoveToDo = new JButton("-");



        pnlToDoLeftTop.add(txtFldSearchToDo);
        pnlToDoLeftTop.add(cmbxToDoSort);

        pnlToDoLeftBottom.add(btnAddToDo);
        pnlToDoLeftBottom.add(btnRemoveToDo);

        pnlToDoLeft.add(new JScrollPane(lstToDos), BorderLayout.CENTER);
        pnlToDoLeft.add(pnlToDoLeftTop, BorderLayout.NORTH);
        pnlToDoLeft.add(pnlToDoLeftBottom, BorderLayout.SOUTH);



    }

    public JPanel getToDoLeft() {
        return pnlToDoLeft;
    }
}
