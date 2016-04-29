package ch.gibmit.m226.todo.gui.guiToDoImpl;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JSplitPane;

import ch.gibmit.m226.todo.gui.interfaces.GuiPanel;

/**
 * Created by colin on 24.02.16.
 */
public class GuiToDoMainImpl implements GuiPanel {

    private ToDoController controller;
    private ToDoModel toDoModel;
	
	private JPanel pnlToDoMain;
	private JSplitPane sptPnToDoMain;
	private GuiPanel gtl;
	private GuiPanel gtr;

	public GuiToDoMainImpl() {

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
		
        toDoModel = new ToDoModel();
        controller = new ToDoController(toDoModel);
        controller.getAllToDos();

		gtl = new GuiToDoLeftImpl(toDoModel, controller);
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
