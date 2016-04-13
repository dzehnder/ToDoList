package ch.gibmit.m226.todo.gui.guiToDoImpl;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.DimensionUIResource;
import java.awt.*;

/**
 * Created by hecol on 08.04.2016.
 */
public class GuiToDoAddCategoryImpl extends JFrame {

    JPanel pnlButtons;
    JPanel pnlButtonsList;
    JPanel pnlList;

    JButton btnAdd;
    JButton btnRem;
    JButton btnDone;
    JButton btnCancel;
    JDialog dlgAddCategory;

    public GuiToDoAddCategoryImpl() {

        dlgAddCategory = new JDialog();
        btnDone = new JButton("Ok");
        dlgAddCategory.getRootPane().setDefaultButton(btnDone);
        btnDone.isDefaultButton();
        btnCancel = new JButton("Cancel");

        setUpPanels();
        setUpComponents();

        dlgAddCategory.setTitle("Add cateogry");
        dlgAddCategory.setSize(new Dimension(300, 500));
        dlgAddCategory.setLocationRelativeTo(SwingUtilities.getWindowAncestor(this));
        dlgAddCategory.setModal(true);
        dlgAddCategory.setVisible(true);
        setUpPanels();

        setUpComponents();

        placeComponents();
    }

    private void setUpPanels() {
        dlgAddCategory.setLayout(new BorderLayout());
        DefaultListModel model = new DefaultListModel();
        model.ensureCapacity(100);
        for (int i = 0; i<100; i++) {
            model.addElement(Integer.toString(i));
        }
        JList jlist = new JList(model);
        jlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(jlist);
        pnlList = new JPanel(new BorderLayout());
        pnlList.add(scrollPane, BorderLayout.CENTER);
        btnAdd = new JButton("+");
        btnRem = new JButton("-");
        pnlButtonsList = new JPanel(new GridLayout(1,2));
        pnlButtonsList.add(btnAdd);
        pnlButtonsList.add(btnRem);
        pnlList.add(pnlButtonsList, BorderLayout.SOUTH);
        pnlList.setBorder(new EmptyBorder(15,15,15,15));
        dlgAddCategory.add(pnlList, BorderLayout.CENTER);
        btnDone = new JButton("Done");
        btnCancel = new JButton("Cancel");
        pnlButtons = new JPanel(new GridLayout(1, 2));
        pnlButtons.add(btnDone);
        pnlButtons.add(btnCancel);
        dlgAddCategory.add(pnlButtons, BorderLayout.SOUTH);
    }

    private void setUpComponents() {

    }

    private void placeComponents() {
    }


}
