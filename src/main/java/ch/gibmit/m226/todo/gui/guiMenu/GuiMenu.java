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
 * @author Colin Herzog
 * This class creates the menubar for the application
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

    /**
     * constructor that calls methods to create menubar
     */
    public GuiMenu() {
        setUpPanels();
    }

    /**
     * This method creates all panels and adds the accelerator (keyboard shortcuts) and adds them to the menu
     */
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

        menuBar.add(mnuMenu);


    }


    /**
     * Get ToDo-Item to add the Action-listener
     * @return ToDo-Item
     */
    public JMenuItem getNewToDo() {
		return newToDo;
	}

    /**
     * Get Open-Item to add the Action-listener
     * @return Open-Item
     */
	public JMenuItem getOpen() {
		return open;
	}

    /**
     * Get Close-Item to add the Action-listener
     * @return Close-Item
     */
	public JMenuItem getClose() {
		return close;
	}

    /**
     * Get Save-Item to add the Action-listener
     * @return Save-Item
     */
	public JMenuItem getSave() {
		return save;
	}

    /**
     * Get SaveAs-Item to add the Action-listener
     * @return SaveAs-Item
     */
	public JMenuItem getSaveAs() {
		return saveAs;
	}

    /**
     * Get Minimize-Item to add the Action-listener
     * @return Minimize-Item
     */
	public JMenuItem getMinimize() {
		return minimize;
	}

    /**
     * Get Zoom-Item to add the Action-listener
     * @return Zoom-Item
     */
	public JMenuItem getZoom() {
		return zoom;
	}

    /**
     * Get Menu-Item to add the Action-listener
     * @return Menu-Item
     */
    public JMenuBar getMenu() {
        return menuBar;
    }
}
