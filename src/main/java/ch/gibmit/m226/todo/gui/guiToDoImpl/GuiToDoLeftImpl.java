package ch.gibmit.m226.todo.gui.guiToDoImpl;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import ch.gibmit.m226.todo.dto.ToDoDTO;
import ch.gibmit.m226.todo.gui.interfaces.GuiPanel;

public class GuiToDoLeftImpl implements GuiPanel {

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

	public GuiToDoLeftImpl(ToDoModel toDoModel, ToDoController controller) {

		this.toDoModel = toDoModel;
		this.controller = controller;

		setUpPanels();

		setUpComponents();

		placeComponents();
		
        lstToDos.addListSelectionListener(e -> {
            if (lstToDos.getSelectedIndex() >= 0) {
                btnRemoveToDo.setEnabled(true);
            }
            else {
            	btnRemoveToDo.setEnabled(false);
            }
        });
        
        btnRemoveToDo.addActionListener(e -> {
            this.toDoModel.removeToDo(lstToDos.getSelectedIndex());
            updateList();
        });

		listModel = new DefaultListModel<>();
		lstToDos.setModel(listModel);
	}
	
	public JButton getBtnAddToDo() {
		return btnAddToDo;
	}

	public void addToDo() {
		ToDoDTO toDoDTO = new ToDoDTO("New ToDo");
		this.controller.addToDo(toDoDTO);
		updateList();
	}

	private void updateList() {
		listModel.removeAllElements();
		for (int i = 0; i < toDoModel.getToDoList().size(); i++) {
			listModel.add(i, toDoModel.getToDoName(i));
		}
	}

	private void setUpPanels() {
		pnlToDoLeft = new JPanel(new BorderLayout());
		pnlToDoLeftTop = new JPanel(new GridLayout(2, 1));
		pnlToDoLeftBottom = new JPanel(new GridLayout(1, 2));
	}

	private void setUpComponents() {
		lstToDos = new JList<String>();
		txtFldSearchToDo = new JTextField();
		cmbxToDoSort = new JComboBox<String>();
		cmbxToDoSort.addItem("Name");
		cmbxToDoSort.addItem("Priority");
		cmbxToDoSort.addItem("Date");
		btnAddToDo = new JButton("+");
		btnRemoveToDo = new JButton("-");
		btnRemoveToDo.setEnabled(false);

		lstToDos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}

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

	@Override
	public JPanel getPanel() {
		return pnlToDoLeft;
	}
}
