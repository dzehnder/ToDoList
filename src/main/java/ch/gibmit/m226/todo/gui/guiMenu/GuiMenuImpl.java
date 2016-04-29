package ch.gibmit.m226.todo.gui.guiMenu;

import ch.gibmit.m226.todo.gui.guiToDoImpl.GuiToDoEditCategoriesImpl;
import ch.gibmit.m226.todo.gui.interfaces.GuiMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

/**
 * Created by colin on 29.03.16.
 */
public class GuiMenuImpl implements GuiMenu {

    //Where the GUI is created:
    JMenuBar menuBar;
    JMenu mnuMenu, submenu;
    JMenuItem menuItem;
    JRadioButtonMenuItem rbMenuItem;
    JCheckBoxMenuItem cbMenuItem;

    public GuiMenuImpl() {
        setUpPanels();

        setUpComponents();

        placeComponents();
    }

    private void setUpPanels() {
//Create the mnuMenu bar.
        menuBar = new JMenuBar();

        mnuMenu= new JMenu("File");
        menuBar.add(mnuMenu);

//a group of JMenuItems
        menuItem = new JMenuItem("New ToDo");
        menuItem.setAccelerator(KeyStroke.getKeyStroke('N', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        mnuMenu.add(menuItem);

        menuItem = new JMenuItem("Open...");
        menuItem.setAccelerator(KeyStroke.getKeyStroke('O', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        mnuMenu.add(menuItem);

        menuItem = new JMenuItem("Close");
        menuItem.setAccelerator(KeyStroke.getKeyStroke('W', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        mnuMenu.add(menuItem);

        mnuMenu.addSeparator();

        menuItem = new JMenuItem("Save");
        menuItem.setAccelerator(KeyStroke.getKeyStroke('S', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        mnuMenu.add(menuItem);

        menuItem = new JMenuItem("Save As...");
        menuItem.setAccelerator(KeyStroke.getKeyStroke('S', (InputEvent.SHIFT_MASK | (Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()))));
        mnuMenu.add(menuItem);

        mnuMenu = new JMenu("Edit");
        menuBar.add(mnuMenu);
        menuItem = new JMenuItem("Edit Categories...");
        menuItem.setAccelerator(KeyStroke.getKeyStroke('E', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        menuItem.addActionListener(e -> GuiToDoEditCategoriesImpl.getInstance().setVisible(true));
        mnuMenu.add(menuItem);

        mnuMenu = new JMenu("View");

        menuItem = new JMenuItem("Close Window");
        menuItem.setAccelerator(KeyStroke.getKeyStroke('W', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        mnuMenu.add(menuItem);

        menuItem = new JMenuItem("Minimize");
        menuItem.setAccelerator(KeyStroke.getKeyStroke('M', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        mnuMenu.add(menuItem);

        menuItem = new JMenuItem("Zoom");
        menuItem.setAccelerator(KeyStroke.getKeyStroke('K', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        mnuMenu.add(menuItem);

        mnuMenu.addSeparator();

        menuItem = new JMenuItem("Switch");
        //TODO add keystroke (tab not working as keystroke)
        mnuMenu.add(menuItem);

        menuBar.add(mnuMenu);


    }

    private void setUpComponents() {

    }

    private void placeComponents() {

    }

    @Override
    public JMenuBar getMenu() {
        return menuBar;
    }
}

/*
cmd+shift+n -> Neue ToDo Liste...
cmd+s -> Speichern (oder Speichern unter falls neu...)
cmd+shift+s -> Speichern unter...
ctrl+tab -> Ansicht wechseln (ToDos / Kalender)
cmd+o -> Liste öffnen…
cmd+w -> Liste schliessen
cmd+m -> Fenster minimieren
cmd+k -> Fenster maximieren
 */