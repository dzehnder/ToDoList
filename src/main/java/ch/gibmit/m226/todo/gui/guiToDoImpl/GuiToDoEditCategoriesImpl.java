package ch.gibmit.m226.todo.gui.guiToDoImpl;

import ch.gibmit.m226.todo.dto.CategoryDTO;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Created by hecol on 08.04.2016.
 */
public class GuiToDoEditCategoriesImpl extends JFrame {

    private JDialog dlgAddCategory;
    private JPanel pnlButtons;
    private JPanel pnlButtonsList;
    private JPanel pnlTextField;
    private JPanel pnlList;
    private JScrollPane scrollPane;
    private CategoryController controller;
    private CategoryModel categoryModel;

    private JButton btnAdd;
    private JButton btnRem;
    private JButton btnDone;
    private JButton btnCancel;

    private JTextField txtFldCatName;
    private JList<String> categoryList;
    private DefaultListModel<String> model;

    public GuiToDoEditCategoriesImpl() {

        dlgAddCategory = new JDialog();
        categoryModel = new CategoryModel();
        controller = new CategoryController(categoryModel);

        setUpComponents();
        setUpPanels();
        placeComponents();

        btnAdd.addActionListener(e -> {
            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setName("New Category");
            controller.addCategory(categoryDTO);
            updateList();

        });

        model = new DefaultListModel<>();
        categoryList.setModel(model);

        dlgAddCategory.getRootPane().setDefaultButton(btnDone);
        btnDone.isDefaultButton();

        btnCancel.addActionListener(e -> dlgAddCategory.dispose());




        dlgAddCategory.setTitle("Edit categories");
        dlgAddCategory.setSize(new Dimension(300, 500));
        dlgAddCategory.setLocationRelativeTo(SwingUtilities.getWindowAncestor(this));
        dlgAddCategory.setModal(true);
        dlgAddCategory.setVisible(true);



    }

    private void updateList() {
        model.clear();
        for (int i = 0; i < categoryModel.getCategoryList().size(); i++) {
            model.add(i, categoryModel.getCategoryList().get(i).getName());
        }

    }

    private void setUpPanels() {
        dlgAddCategory.setLayout(new BorderLayout());
        categoryList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        scrollPane = new JScrollPane(categoryList);
        pnlList = new JPanel(new BorderLayout());


        pnlButtonsList = new JPanel();
        pnlTextField = new JPanel(new BorderLayout());
        pnlTextField.add(pnlButtonsList, BorderLayout.LINE_END);

        pnlList.add(pnlTextField, BorderLayout.SOUTH);
        pnlList.setBorder(new EmptyBorder(15,15,15,15));
        dlgAddCategory.add(pnlList, BorderLayout.CENTER);
        pnlButtons = new JPanel(new GridLayout(1, 2));

        dlgAddCategory.add(pnlButtons, BorderLayout.SOUTH);
    }

    private void setUpComponents() {
        categoryList = new JList<>();

        btnDone = new JButton("Save");
        btnCancel = new JButton("Cancel");

        txtFldCatName = new JTextField();
        txtFldCatName.setEnabled(false);

        btnAdd = new JButton("+");
        btnAdd.setPreferredSize(new Dimension(30, 30));
        btnRem = new JButton("-");
        btnRem.setPreferredSize(new Dimension(30, 30));
        btnRem.setEnabled(false);
    }

    private void placeComponents() {
        pnlList.add(scrollPane, BorderLayout.CENTER);
        pnlTextField.add(txtFldCatName, BorderLayout.CENTER);
        pnlButtonsList.add(btnAdd);
        pnlButtonsList.add(btnRem);

        pnlButtons.add(btnCancel);
        pnlButtons.add(btnDone);
    }


}
