package ch.gibmit.m226.todo.guiToDoLeft;

import ch.gibmit.m226.todo.todo.Todo;

import javax.swing.*;
import java.awt.*;

public class GuiToDoLeftImpl implements GuiToDoLeft {

    private JPanel pnlToDoLeft;
    private JPanel pnlToDoLeftTop;
    private JPanel pnlToDoLeftBottom;
    private JComboBox cmbxToDoSort;
    private JList<Todo> lstToDos;
    private JTextField txtFldSearchToDo;
    private JButton btnAddToDo;
    private JButton btnRemoveToDo;
    private JScrollPane scrPnListToDo;

    public GuiToDoLeftImpl() {

        pnlToDoLeft = new JPanel(new BorderLayout());
        pnlToDoLeftTop = new JPanel(new GridLayout(2, 1));
        pnlToDoLeftBottom = new JPanel(new GridLayout(1, 2));
        lstToDos = new JList<Todo>();
        txtFldSearchToDo = new JTextField();
        cmbxToDoSort = new JComboBox();
        btnAddToDo = new JButton("+");
        btnRemoveToDo = new JButton("-");
        scrPnListToDo = new JScrollPane(lstToDos);

        lstToDos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        

        pnlToDoLeftTop.add(txtFldSearchToDo);
        pnlToDoLeftTop.add(cmbxToDoSort);

        pnlToDoLeftBottom.add(btnAddToDo);
        pnlToDoLeftBottom.add(btnRemoveToDo);

        pnlToDoLeft.add(new JScrollPane(lstToDos), BorderLayout.CENTER);
        pnlToDoLeft.add(pnlToDoLeftTop, BorderLayout.NORTH);
        pnlToDoLeft.add(pnlToDoLeftBottom, BorderLayout.SOUTH);
        pnlToDoLeft.add(lstToDos, BorderLayout.CENTER);

    }

    public JPanel getToDoLeft() {
        return pnlToDoLeft;
    }
}
