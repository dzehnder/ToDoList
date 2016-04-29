package ch.gibmit.m226.todo.gui.guiToDoImpl;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JSplitPane;

import ch.gibmit.m226.todo.gui.interfaces.GuiPanel;

/**
 * Created by colin on 24.02.16.
 */
public class GuiToDoMainImpl implements GuiPanel {
	
	private JPanel pnlToDoMain;
	private JSplitPane sptPnToDoMain;
	private GuiToDoLeftImpl gtl;
	private GuiToDoRightImpl gtr;
	
	private ToDoController toDoController;
	private ToDoModel toDoModel;

	public GuiToDoMainImpl() {
		
		this.toDoModel = new ToDoModel();
		this.toDoController = new ToDoController(toDoModel);

		setUpPanels();

		setUpComponents();

		placeComponents();

	}

	private void setUpPanels() {
		pnlToDoMain = new JPanel(new BorderLayout());
	}

	private void setUpComponents() {
		sptPnToDoMain = new JSplitPane();
		sptPnToDoMain.setDividerLocation(0.3);

		gtl = new GuiToDoLeftImpl(toDoModel, toDoController);
		
		gtl.getBtnAddToDo().addActionListener(e -> gtl.addToDo());
			
		sptPnToDoMain.setLeftComponent(gtl.getPanel());

		gtr = new GuiToDoRightImpl();
		sptPnToDoMain.setRightComponent(gtr.getPanel());
	}

	private void placeComponents() {
		pnlToDoMain.add(sptPnToDoMain);
	}

	@Override
	public JPanel getPanel() {
		return pnlToDoMain;
	}
}
