package ch.gibmit.m226.todo.gui.guiMenu;

import java.awt.Toolkit;
import java.awt.event.InputEvent;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

import ch.gibmit.m226.todo.gui.guiToDoImpl.GuiToDoEditCategoriesImpl;

/**
 * Created by colin on 29.03.16.
 */
public class GuiMenu {

    //Where the GUI is created:
    JMenuBar menuBar;
    JMenu mnuMenu, submenu;
    JMenuItem newToDo;
    JMenuItem open;
    JMenuItem close;
    JMenuItem save;
    JMenuItem saveAs;
    JMenuItem editCategories;
    JMenuItem closeWindow;
    JMenuItem minimize;
    JMenuItem zoom;
    JMenuItem switchWindow;
    
    
    JRadioButtonMenuItem rbMenuItem;
    JCheckBoxMenuItem cbMenuItem;

    public GuiMenu() {
        setUpPanels();

        setUpComponents();

        placeComponents();
    }

    private void setUpPanels() {

        //Create the mnuMenu bar.
        menuBar = new JMenuBar();

        mnuMenu= new JMenu("File");
        menuBar.add(mnuMenu);

        newToDo = new JMenuItem("New ToDo");
        newToDo.setAccelerator(KeyStroke.getKeyStroke('N', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        mnuMenu.add(newToDo);

        open = new JMenuItem("Open...");
        open.setAccelerator(KeyStroke.getKeyStroke('O', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        mnuMenu.add(open);

        close = new JMenuItem("Close");
        close.setAccelerator(KeyStroke.getKeyStroke('W', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        mnuMenu.add(close);

        mnuMenu.addSeparator();

        save = new JMenuItem("Save");
        save.setAccelerator(KeyStroke.getKeyStroke('S', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        mnuMenu.add(save);

        saveAs = new JMenuItem("Save As...");
        saveAs.setAccelerator(KeyStroke.getKeyStroke('S', (InputEvent.SHIFT_MASK | (Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()))));
        mnuMenu.add(saveAs);

        mnuMenu = new JMenu("Edit");
        menuBar.add(mnuMenu);
        
        editCategories = new JMenuItem("Edit Categories...");
        editCategories.setAccelerator(KeyStroke.getKeyStroke('E', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        editCategories.addActionListener(e -> GuiToDoEditCategoriesImpl.getInstance().setVisible(true));
        mnuMenu.add(editCategories);

        mnuMenu = new JMenu("View");

        closeWindow = new JMenuItem("Close Window");
        closeWindow.setAccelerator(KeyStroke.getKeyStroke('W', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        mnuMenu.add(closeWindow);

        minimize = new JMenuItem("Minimize");
        minimize.setAccelerator(KeyStroke.getKeyStroke('M', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        mnuMenu.add(minimize);

        zoom = new JMenuItem("Zoom");
        zoom.setAccelerator(KeyStroke.getKeyStroke('K', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        mnuMenu.add(zoom);

        mnuMenu.addSeparator();

        switchWindow = new JMenuItem("Switch");
        //TODO add keystroke (tab not working as keystroke)
        //menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_TAB, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        mnuMenu.add(switchWindow);

        menuBar.add(mnuMenu);


    }

    private void setUpComponents() {

    }

    private void placeComponents() {

    }
    
	public JMenuItem getNewToDo() {
		return newToDo;
	}

	public JMenuItem getOpen() {
		return open;
	}

	public JMenuItem getClose() {
		return close;
	}

	public JMenuItem getSave() {
		return save;
	}

	public JMenuItem getSaveAs() {
		return saveAs;
	}

	public JMenuItem getEditCategories() {
		return editCategories;
	}

	public JMenuItem getCloseWindow() {
		return closeWindow;
	}

	public JMenuItem getMinimize() {
		return minimize;
	}

	public JMenuItem getZoom() {
		return zoom;
	}

	public JMenuItem getSwitchWindow() {
		return switchWindow;
	}

	public JRadioButtonMenuItem getRbMenuItem() {
		return rbMenuItem;
	}

	public JCheckBoxMenuItem getCbMenuItem() {
		return cbMenuItem;
	}

    public JMenuBar getMenu() {
        return menuBar;
    }
}
