package ch.gibmit.m226.todo.gui.guiToDoImpl;

import ch.gibmit.m226.todo.dto.ToDoDTO;
import ch.gibmit.m226.todo.util.ToDoSortType;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.util.Date;

public class GuiToDoLeftImpl {

    private ToDoModel toDoModel;
    private ToDoController controller;

    private JPanel pnlToDoLeft;
    private JPanel pnlToDoLeftTop;
    private JPanel pnlToDoLeftBottom;

    private JButton btnAddToDo;
    private JButton btnRemoveToDo;

    private JComboBox<String> cmbxToDoSort;
    private JList<String> lstToDos;
    private DefaultListModel<String> listModel;
    private JTextField txtFldSearchToDo;

    private int test = 0;

    public GuiToDoLeftImpl(ToDoModel toDoModel, ToDoController controller) {

        this.toDoModel = toDoModel;
        this.controller = controller;

        setUpPanels();

        setUpComponents();

        placeComponents();

        btnRemoveToDo.addActionListener(e -> {
            this.toDoModel.removeToDo(lstToDos.getSelectedIndex());
            updateList();
        });

        listModel = new DefaultListModel<>();
        lstToDos.setModel(listModel);

        cmbxToDoSort.addActionListener(e -> {
            switch (cmbxToDoSort.getSelectedIndex()) {
                case 0:
                    controller.createSortedToDoList(ToDoSortType.NAME);
                    updateList();
                    break;
                case 1:
                    controller.createSortedToDoList(ToDoSortType.PRIORITY);
                    updateList();
                    break;
                case 2:
                    controller.createSortedToDoList(ToDoSortType.CATEGORY);
                    updateList();
                    break;
            }
        });

        addSearchFieldListener();

    }

    /**
     * Add the listener to the searchfield
     */
    private void addSearchFieldListener() {
        txtFldSearchToDo.getDocument().addDocumentListener(new DocumentListener() {
            /**
             * If the user writes a new char this method will call
             * @param e not neccessary
             */
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateSearch(txtFldSearchToDo);
                System.out.println("insert");
            }
            /**
             * If the user deltes a char this method will call
             * @param e not neccessary
             */
            @Override
            public void removeUpdate(DocumentEvent e) {
                updateSearch(txtFldSearchToDo);
                System.out.printf("remove");
            }
            /**
             * If the user changes a char (for instance by marking a char and write another char) this method will call
             * @param e not neccessary
             */
            @Override
            public void changedUpdate(DocumentEvent e) {
                updateSearch(txtFldSearchToDo);
                System.out.println("Change");
            }
        });
    }

    /**
     * Selects the ToDo that matches the searchbox
     * @param search is the JTextField to listen to
     */
    private void updateSearch(JTextField search) {
        String stringToSearch = search.getText();
        for (int i = 0; i < toDoModel.getToDoList().size(); i++) {
            if (toDoModel.getToDoList().get(i).getName().toLowerCase().contains(stringToSearch.toLowerCase())) {
                this.updateListByIndex(i);
            }
        }
    }

    /**
     * Remove the last ToDo in the list and call updateList() to reassemble the list
     */
    public void removeLastToDo() {
        this.toDoModel.removeToDo(lstToDos.getVisibleRowCount());
        updateList();
    }

    public JButton getBtnAddToDo() {
        return this.btnAddToDo;
    }

    public JButton getBtnRemoveToDo() {
        return this.btnRemoveToDo;
    }

    public JList<String> getLstToDos() {
        return this.lstToDos;
    }

    /**
     * Create a new ToDo
     * @return the latest ToDo
     */
    public ToDoDTO addToDo() {
        ToDoDTO toDoDTO = new ToDoDTO("New ToDo" + test, new Date());
        this.controller.addToDo(toDoDTO);
        this.updateList();
        this.lstToDos.setSelectedIndex(lstToDos.getLastVisibleIndex());
        test++;
        return this.controller.getLatestToDo();
    }

    /**
     * Delete everything from the list add all todos
     */
    public void updateList() {
        listModel.removeAllElements();
        for (int i = 0; i < toDoModel.getToDoList().size(); i++) {
            listModel.add(i, toDoModel.getToDoName(i));
        }
    }

    /**
     * Create new panels
     */
    private void setUpPanels() {
        pnlToDoLeft = new JPanel(new BorderLayout());
        pnlToDoLeftTop = new JPanel(new GridLayout(2, 1));
        pnlToDoLeftBottom = new JPanel(new GridLayout(1, 2));
    }

    /**
     * Set up components and create instances
     */
    private void setUpComponents() {
        lstToDos = new JList<String>();
        txtFldSearchToDo = new JTextField();
        cmbxToDoSort = new JComboBox<String>();
        cmbxToDoSort.addItem("Name");
        cmbxToDoSort.addItem("Priority");
        cmbxToDoSort.addItem("Category");
        btnAddToDo = new JButton("+");
        btnRemoveToDo = new JButton("-");
        btnRemoveToDo.setEnabled(false);

        lstToDos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    /**
     * Place components on JPanel
     */
    private void placeComponents() {
        pnlToDoLeftTop.add(txtFldSearchToDo);
        pnlToDoLeftTop.add(cmbxToDoSort);

        pnlToDoLeftBottom.add(btnAddToDo);
        pnlToDoLeftBottom.add(btnRemoveToDo);

        pnlToDoLeft.add(new JScrollPane(lstToDos), BorderLayout.CENTER);
        pnlToDoLeft.add(pnlToDoLeftTop, BorderLayout.NORTH);
        pnlToDoLeft.add(pnlToDoLeftBottom, BorderLayout.SOUTH);
        pnlToDoLeft.add(lstToDos, BorderLayout.CENTER);
    }

    /**
     * Return the whole panel to let the GuiToDoMainImpl assemble everything
     * @return the whole panel
     */
    public JPanel getPanel() {
        return pnlToDoLeft;
    }

    /**
     * Select a ToDo in the ToDoList
     * @param selected is position to select
     */
    public void updateListByIndex(int selected) {
        listModel.removeAllElements();
        for (int i = 0; i < toDoModel.getToDoList().size(); i++) {
            listModel.add(i, toDoModel.getToDoName(i));
        }
        this.lstToDos.setSelectedIndex(selected);
    }

    /**
     * Set the selected value to the ToDoName
     * @param toDoName is the value to select
     */
    public void setSelectedToDoName(String toDoName) {
        lstToDos.setSelectedValue(toDoName, true);
    }
}
