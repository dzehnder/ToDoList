package ch.gibmit.m226.todo.gui.guiMenu;

import ch.gibmit.m226.todo.gui.gui.GuiMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
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

        menuItem = new JMenuItem("Save ToDo");
        menuItem.setAccelerator(KeyStroke.getKeyStroke('S', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        mnuMenu.add(menuItem);

        menuItem = new JMenuItem("Save All");
        menuItem.setAccelerator(KeyStroke.getKeyStroke('S', (InputEvent.SHIFT_MASK | (Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()))));
        mnuMenu.add(menuItem);


//a group of radio button mnuMenu items
        mnuMenu.addSeparator();
        ButtonGroup group = new ButtonGroup();
        rbMenuItem = new JRadioButtonMenuItem("A radio button menu item");
        rbMenuItem.setSelected(true);
        rbMenuItem.setMnemonic(KeyEvent.VK_R);
        group.add(rbMenuItem);
        mnuMenu.add(rbMenuItem);

        rbMenuItem = new JRadioButtonMenuItem("Another one");
        rbMenuItem.setMnemonic(KeyEvent.VK_O);
        group.add(rbMenuItem);
        mnuMenu.add(rbMenuItem);

//a group of check box mnuMenu items
        mnuMenu.addSeparator();
        cbMenuItem = new JCheckBoxMenuItem("A check box menu item");
        cbMenuItem.setMnemonic(KeyEvent.VK_C);
        mnuMenu.add(cbMenuItem);

        cbMenuItem = new JCheckBoxMenuItem("Another one");
        cbMenuItem.setMnemonic(KeyEvent.VK_H);
        mnuMenu.add(cbMenuItem);

//a submenu
        mnuMenu.addSeparator();
        submenu = new JMenu("A submenu");
        submenu.setMnemonic(KeyEvent.VK_S);

        menuItem = new JMenuItem("An item in the submenu");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_2, ActionEvent.ALT_MASK));
        submenu.add(menuItem);

        menuItem = new JMenuItem("Another item");
        submenu.add(menuItem);
        mnuMenu.add(submenu);

//Build second mnuMenu in the mnuMenu bar.
        mnuMenu= new JMenu("Another Menu");
        mnuMenu.setMnemonic(KeyEvent.VK_N);
        mnuMenu.getAccessibleContext().setAccessibleDescription(
                "This menu does nothing");
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