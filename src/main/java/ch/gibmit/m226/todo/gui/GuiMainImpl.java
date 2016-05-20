package ch.gibmit.m226.todo.gui;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import ch.gibmit.m226.todo.Start;
import ch.gibmit.m226.todo.bl.Serializor;
import ch.gibmit.m226.todo.data.CategoryDAO;
import ch.gibmit.m226.todo.data.ToDoDAO;
//import ch.gibmit.m226.todo.bl.Serializor;
import ch.gibmit.m226.todo.gui.guiCalendar.GuiCalendarImpl;
import ch.gibmit.m226.todo.gui.guiMenu.GuiMenu;
import ch.gibmit.m226.todo.gui.guiToDoImpl.GuiToDoEditCategoriesImpl;
import ch.gibmit.m226.todo.gui.guiToDoImpl.GuiToDoMainImpl;
import ch.gibmit.m226.todo.gui.interfaces.GuiCalendarPanel;

/**
 * @author Colin Herzog This class divides the GUI by its tabs. The left tab is
 *         the detailed view for the ToDos, whilst the right tab shows calendar
 *         view.
 */
public class GuiMainImpl extends JFrame {

	/**
	 * This is the main pane. It's a tabbed pane where you can split a view into
	 * tabs.
	 */
	private JTabbedPane mainPane;
	/**
	 * This is the class for the left tab.
	 */
	private GuiToDoMainImpl gtm;
	private GuiCalendarPanel gtc;
	private GuiMenu gm;
	private Serializor sr;

	private String path;
	private boolean newFile = true;

	/**
	 * Creates windows and sets menu bar. Creates new Serializor.
	 * 
	 * @param categoryDAO
	 *            Data Access Object for Categories
	 * @param toDoDAO
	 *            Data Access Object for ToDos
	 * @param path
	 *            Path where the file was opened. If this got overloaded, the
	 *            path is "" that means it will ask you for a location to save
	 *            the file
	 */
	public GuiMainImpl(Object categoryDAO, Object toDoDAO, String path) {
		this.path = path;
		gm = new GuiMenu();
		mainPane = new JTabbedPane();
		gtm = new GuiToDoMainImpl();
		gtc = new GuiCalendarImpl(gtm.getToDoModel());
		if ((categoryDAO != null) && (toDoDAO != null)) {
			openToDoList(categoryDAO, toDoDAO);
		}
		sr = new Serializor(
				GuiToDoEditCategoriesImpl.getInstance().getCategoryController().getCategory().getCategoryDAO(),
				gtm.getToDoController().getToDo().getToDoDAO());

		this.mainPane.addTab("ToDos", gtm.getPanel());
		this.mainPane.addTab("Calendar", gtc.getCalendarPanel());
		this.setJMenuBar(gm.getMenu());

		this.add(mainPane);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		this.pack();
		this.setSize(950, 600);
		this.setMinimumSize(new Dimension(950, 550));
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		this.setVisible(true);

		this.setActionListeners();

	}

	/**
	 * Overload for GuiMainPanel if no path is given
	 * 
	 * @param categoryDAO
	 *            Data Access Object for Categories
	 * @param toDoDAO
	 *            Data Access Object for ToDos
	 */
	public GuiMainImpl(Object categoryDAO, Object toDoDAO) {
		this(categoryDAO, toDoDAO, "");
	}

	/**
	 * Opens new ToDoList from File Sets DAO's from file as active DAO's, makes
	 * list updates.
	 * 
	 * @param categoryDAO
	 *            Data Access Object for Categories (gets parsed from Object to
	 *            CategoryDAO)
	 * @param toDoDAO
	 *            Data Access Object for ToDos (gets parsed from Object to
	 *            ToDoDAO)
	 */
	private void openToDoList(Object categoryDAO, Object toDoDAO) {
		GuiToDoEditCategoriesImpl.getInstance().getCategoryController().getCategory()
				.setCategoriyDAO((CategoryDAO) categoryDAO);
		gtm.updateToDosAndCategories();
		GuiToDoEditCategoriesImpl.getInstance().updateList();
		gtm = new GuiToDoMainImpl((ToDoDAO) toDoDAO);
		gtm.updateToDosAndCategories();
		gtm.updateList();
		newFile = false;
	}

	/**
	 * Sets all ActionListeners for the buttons in the menu
	 */
	private void setActionListeners() {
		gm.getSave().addActionListener(e -> {
			gtm.saveChanges();
			if (newFile) {
				this.newFile = sr.saveNew();
			} else if (!newFile && !path.equals("")) {
				sr.save(this.path);
			}
		});
		gm.getSaveAs().addActionListener(e -> {
			gtm.saveChanges();
			this.newFile = sr.saveAs();
		});
		gm.getOpen().addActionListener(e -> {
			if (!newFile && !path.equals("")) {
				sr.save(this.path);
			}
			ObjectInputStream oin;
			Object categoryDAO;
			Object toDoDAO;
			JFrame parentFrame = new JFrame();
			JFileChooser fileChooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("ToDoList Files", "tdo", "tdo");

			fileChooser.setDialogTitle("Save ToDoList");
			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			fileChooser.setFileFilter(filter);

			int userSelection = fileChooser.showOpenDialog(parentFrame);

			if (userSelection == JFileChooser.APPROVE_OPTION) {
				String fileToOpen = fileChooser.getSelectedFile().getAbsolutePath();
				try {
					oin = new ObjectInputStream(new FileInputStream(fileToOpen));
					categoryDAO = oin.readObject();
					toDoDAO = oin.readObject();
					this.dispose();
					Start.update(categoryDAO, toDoDAO, fileToOpen);
				} catch (IOException | ClassNotFoundException f) {
					System.out.println("File not found - " + f.getMessage());
				}
			}
		});
		gm.getNewToDo().addActionListener(e -> {
			gtm.addToDo();
		});
		gm.getClose().addActionListener(e -> {
			System.exit(0);
		});
		gm.getMinimize().addActionListener(e -> {
			this.setState(Frame.ICONIFIED);
		});
		gm.getZoom().addActionListener(e -> {
			this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		});
	}
}
