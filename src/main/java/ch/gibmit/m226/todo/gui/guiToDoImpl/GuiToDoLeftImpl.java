package ch.gibmit.m226.todo.gui.guiToDoImpl;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import ch.gibmit.m226.todo.gui.guiToDo.GuiToDo;
import ch.gibmit.m226.todo.todo.Todo;

public class GuiToDoLeftImpl implements GuiToDo {

	private JPanel pnlToDoLeft;
	private JPanel pnlToDoLeftTop;
	private JPanel pnlToDoLeftBottom;
	private JComboBox<String> cmbxToDoSort;
	private JList<Todo> lstToDos;
	private JTextField txtFldSearchToDo;
	private JButton btnAddToDo;
	private JButton btnRemoveToDo;

	public GuiToDoLeftImpl() {

		setUpPanels();

		setUpComponents();

		placeComponents();

	}

	private void setUpPanels() {
		pnlToDoLeft = new JPanel(new BorderLayout());
		pnlToDoLeftTop = new JPanel(new GridLayout(2, 1));
		pnlToDoLeftBottom = new JPanel(new GridLayout(1, 2));
	}

	private void setUpComponents() {
		lstToDos = new JList<Todo>();
		txtFldSearchToDo = new JTextField();
		cmbxToDoSort = new JComboBox<String>();
		cmbxToDoSort.addItem("Sortieren");
		cmbxToDoSort.addItem("Prio");
		cmbxToDoSort.addItem("Erstellungsdatum");
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
