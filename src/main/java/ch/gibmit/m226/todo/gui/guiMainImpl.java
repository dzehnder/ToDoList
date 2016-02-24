package ch.gibmit.m226.todo.gui;

/**
 * Created by colin on 24.02.16.
 */

import javax.swing.*;

public class guiMainImpl extends JFrame{

    private JTabbedPane mainPane;

    public guiMainImpl() {

        this.setVisible(true);
        this.setSize(300, 300);

        mainPane = new JTabbedPane();

        this.mainPane.addTab("ToDo's", new JPanel());
        this.mainPane.addTab("Kalender", new JPanel());

        this.add(mainPane);

    }
}
