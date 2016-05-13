package ch.gibmit.m226.todo.gui.guiToDoImpl;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Date;

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
	}
	
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

	public ToDoDTO addToDo() {
		ToDoDTO toDoDTO = new ToDoDTO("New ToDo" + test, new Date());
		this.controller.addToDo(toDoDTO);
		this.updateList();
		this.lstToDos.setSelectedIndex(lstToDos.getLastVisibleIndex());
		test++;
		return this.controller.getLatestToDo();
	}

	public void updateList() {
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

	public JPanel getPanel() {
		return pnlToDoLeft;
	}

	public void updateListByIndex(int selected) {
		listModel.removeAllElements();
		for (int i = 0; i < toDoModel.getToDoList().size(); i++) {
			listModel.add(i, toDoModel.getToDoName(i));
		}
		this.lstToDos.setSelectedIndex(selected);
	}

}
