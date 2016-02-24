package ch.gibmit.m226.todo.ch.gibmit.m266.todo.guiToDoLeft;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * Created by colin on 24.02.16.
 */
public class GuiToDoLeftImpl implements GuiToDoLeft {

    private JPanel pnlToDoLeft;
    private JPanel pnlToDoLeftTop;
    private JPanel pnlToDoLeftBottom;
    private JComboBox cmbxToDoSort;
    private JList<CheckboxListItem> lstToDos;
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

        lstToDos = new JList<CheckboxListItem>(
                new CheckboxListItem[]{
                        new CheckboxListItem("ToDoItem1"),
                        new CheckboxListItem("ToDoItem2"),
                        new CheckboxListItem("ToDoItem3"),
                        new CheckboxListItem("ToDoItem4"),
                        new CheckboxListItem("ToDoItem5")
                });

        lstToDos.setCellRenderer(new CheckboxListRenderer());
        lstToDos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        lstToDos.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent event) {
                JList<CheckboxListItem> list =
                        (JList<CheckboxListItem>) event.getSource();

                int index = list.locationToIndex(event.getPoint());
                CheckboxListItem item = list.getModel()
                        .getElementAt(index);

                item.setSelected(!item.isSelected());

                list.repaint(list.getCellBounds(index, index));
            }
        });


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
