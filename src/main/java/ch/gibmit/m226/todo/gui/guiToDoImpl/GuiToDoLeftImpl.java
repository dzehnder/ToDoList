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

	private JPanel pnlToDoLeft;
	private JPanel pnlToDoLeftTop;
	private JPanel pnlToDoLeftBottom;

	private JButton btnAddToDo;
	private JButton btnRemoveToDo;

	private JComboBox<String> cmbxToDoSort;
	private JList<String> lstToDos;
	private DefaultListModel<String> model;
	private JTextField txtFldSearchToDo;

	private ToDoController controller;
	private ToDoModel toDoModel;

	public GuiToDoLeftImpl(ToDoModel toDoModel, ToDoController controller) {

		this.toDoModel = toDoModel;
		this.controller = controller;

		setUpPanels();

		setUpComponents();

		placeComponents();

		/**
		 * add a new todo to the todo list
		 */
		btnAddToDo.addActionListener(e -> {
			ToDoDTO toDoDTO = new ToDoDTO("New ToDo");
			this.controller.addToDo(toDoDTO);
			updateList();
			lstToDos.setSelectedIndex(lstToDos.getLastVisibleIndex());
		});

		model = new DefaultListModel<>();
		lstToDos.setModel(model);
		/**
		 * set the textfield value to the same value as the selected item value
		 * in the category list, enable or disable elements according to
		 * selection
		 */
		lstToDos.addListSelectionListener(e -> {
			if (lstToDos.getSelectedIndex() >= 0) {
				btnRemoveToDo.setEnabled(true);
			} else {
				btnRemoveToDo.setEnabled(false);
			}
		});

		btnRemoveToDo.addActionListener(e -> {
			this.toDoModel.removeToDo(lstToDos.getSelectedIndex());
			updateList();
		});

		updateList();

	}

	/**
	 * Updates the toDo list content
	 */
	private void updateList() {
		try {
			model.removeAllElements();
			for (int i = 0; i < toDoModel.getToDoList().size(); i++) {
				model.add(i, toDoModel.getToDoName(i));
			}
		} catch (NullPointerException e) {

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
