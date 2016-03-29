package ch.gibmit.m226.todo.gui.guiMenu;

import ch.gibmit.m226.todo.gui.gui.GuiPanel;

import javax.swing.*;

/**
 * Created by colin on 29.03.16.
 */
public class GuiMenuImpl implements GuiPanel {

    private JMenuItem uiMenuDelTodo;
    private JMenuItem uiMenuSelectUp;
    private JMenuItem uiMenuSelectDown;
    private JMenu uiMenuWindow;
    private JCheckBoxMenuItem uiChckBxMenuSortItems;

    JMenuBar menuBar = new JMenuBar();

    JMenu menuFile = new JMenu("Datei");
    menuBar.add(menuFile);

    JMenuItem menuOpenTodo = new JMenuItem("TODO Liste √∂ffnen...");
    menuOpenTodo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
            Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
    menuFile.add(menuOpenTodo);
    menuOpenTodo.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            openList();
        }
    });

    JMenuItem menuSaveTodo = new JMenuItem("TODO speichern");
    menuSaveTodo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
            Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
    menuFile.add(menuSaveTodo);
    menuSaveTodo.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            saveList();
        }
    });

    JMenuItem menuSaveAsTodo = new JMenuItem("TODO speichern unter...");
    menuSaveAsTodo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
            (InputEvent.SHIFT_MASK | (Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()))));
    menuFile.add(menuSaveAsTodo);
    menuSaveAsTodo.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            savaAsList();
        }
    });

    menuFile.addSeparator();

    JMenuItem menuNewTodo = new JMenuItem("Neues Fenster");
    menuNewTodo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
            Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
    menuFile.add(menuNewTodo);
    menuNewTodo.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            new TodoWindow().setVisible(true);
            Frame[] frames = JFrame.getFrames();
            for (Frame frame : frames) {
                JCheckBoxMenuItem menuWindows = new JCheckBoxMenuItem(frame.getTitle());
                uiMenuWindow.add(menuWindows);
            }
        }
    });

    JMenuItem menuCloseWindow = new JMenuItem("Fenster Schliessen");
    menuCloseWindow.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,
            Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
    menuFile.add(menuCloseWindow);
    menuCloseWindow.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            dispose();
        }
    });

    JMenu menuEdit = new JMenu("Bearbeiten");
    menuBar.add(menuEdit);

    JMenuItem menuCopy = new JMenuItem("Kopieren");
    menuCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
            Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
    menuEdit.add(menuCopy);

    JMenuItem menuCut = new JMenuItem("Ausschneiden");
    menuCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
            Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
    menuEdit.add(menuCut);

    JMenuItem menuPaste = new JMenuItem("Einf√ºgen");
    menuPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,
            Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
    menuEdit.add(menuPaste);

    JMenuItem menuSelectAll = new JMenuItem("Alle Ausw√§hlen");
    menuSelectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
            Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
    menuEdit.add(menuSelectAll);

    menuEdit.addSeparator();

    final JMenuItem menuAddTodo = new JMenuItem("Neues TODO");
    menuAddTodo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
            (InputEvent.ALT_MASK | (Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()))));
    menuEdit.add(menuAddTodo);
    menuAddTodo.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            addTodo();
        }
    });

    uiMenuDelTodo = new JMenuItem("Ausgew√§hltes TODO l√∂schen");
    menuEdit.add(uiMenuDelTodo);
    uiMenuDelTodo.setEnabled(false);
    uiMenuDelTodo.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            deleteTodo();
        }
    });

    JMenu menuView = new JMenu("Ansicht");
    menuBar.add(menuView);

    JMenu menuArrangeBy = new JMenu("Sortieren nach");
    menuView.add(menuArrangeBy);
    for (int i = 1; i < sort.length; i++) {
        uiChckBxMenuSortItems = new JCheckBoxMenuItem(sort[i]);
        menuArrangeBy.add(uiChckBxMenuSortItems);
    }
    uiChckBxMenuSortItems.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Item Selected");
        }
    });

    menuView.addSeparator();

    uiMenuSelectUp = new JMenuItem("Liste Aufw√§rts");
    uiMenuSelectUp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_UP, InputEvent.ALT_MASK));
    menuView.add(uiMenuSelectUp);
    uiMenuSelectUp.setEnabled(false);
    uiMenuSelectUp.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            saveTodoList();
            uiListTodos.setSelectedIndex(uiListTodos.getSelectedIndex() - 1);
        }
    });

    uiMenuSelectDown = new JMenuItem("Lista Abw√§rts");
    uiMenuSelectDown.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, InputEvent.ALT_MASK));
    menuView.add(uiMenuSelectDown);
    uiMenuSelectDown.setEnabled(false);
    uiMenuSelectDown.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            saveTodoList();
            uiListTodos.setSelectedIndex(uiListTodos.getSelectedIndex() + 1);
        }
    });

    uiMenuWindow = new JMenu("Fenster");
    menuBar.add(uiMenuWindow);

    JMenuItem menuMin;
    if (OS.isMac()) {
        menuMin = new JMenuItem("Im Dock ablegen");
    }
    else {
        menuMin = new JMenuItem("Minimieren");
    }
    menuMin.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,
            Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
    uiMenuWindow.add(menuMin);
    menuMin.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            setState(ICONIFIED);
        }
    });

    JMenuItem menuMax = new JMenuItem("Zoomen");
    uiMenuWindow.add(menuMax);
    menuMax.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
        }
    });

    uiMenuWindow.addSeparator();

    JCheckBoxMenuItem menuFirstWindow = new JCheckBoxMenuItem(firstWindowName);
    uiMenuWindow.add(menuFirstWindow);
    menuFirstWindow.setSelected(true);

    JMenu menuHelp = new JMenu("Help");
    menuBar.add(menuHelp);

    JMenuItem menuHelpWindow = new JMenuItem("TODO Liste Hilfe");
    menuHelpWindow.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
    menuHelp.add(menuHelpWindow);
    menuHelpWindow.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            new Help(tab);
        }
    });

    setJMenuBar(menuBar);


    @Override
    public JPanel getPanel() {
        return menuBar;
    }
}
