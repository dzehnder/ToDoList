package ch.gibmit.m226.todo.gui.guiToDoImpl;

import ch.gibmit.m226.todo.dto.CategoryDTO;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by hecol on 08.04.2016.
 */
public class GuiToDoEditCategoriesImpl extends JDialog {

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

    private JTextField txtFldCatName;
    private JList<String> categoryList;
    private DefaultListModel<String> model;

    private static GuiToDoEditCategoriesImpl instance = new GuiToDoEditCategoriesImpl();

    private GuiToDoEditCategoriesImpl() {

        categoryModel = new CategoryModel();
        controller = new CategoryController(categoryModel);
        controller.getAllCategories();
        //this.categoryModel = categoryModel;
        //this.controller = controller;

        setUpComponents();
        setUpPanels();
        placeComponents();


        /**
         * add a new category to the category list
         */
        btnAdd.addActionListener(e -> {
            //TODO test for multiple 'new category'
            CategoryDTO categoryDTO = new CategoryDTO("New Category");
            this.controller.addCategory(categoryDTO);
            updateList();
            categoryList.setSelectedIndex(categoryList.getLastVisibleIndex());

        });

        model = new DefaultListModel<>();
        categoryList.setModel(model);
        /**
         * set the textfield value to the same value as the selected item value in the category list,
         * enable or disable elements according to selection
         */
        categoryList.addListSelectionListener(e -> {
            if (categoryList.getSelectedIndex() >= 0) {
                txtFldCatName.setEnabled(true);
                btnRem.setEnabled(true);
                txtFldCatName.setText(categoryList.getSelectedValue());
                txtFldCatName.requestFocus();
                txtFldCatName.selectAll();
            }
            else {
                txtFldCatName.setEnabled(false);
                btnRem.setEnabled(false);
                txtFldCatName.setText("");
            }
        });

        btnRem.addActionListener(e -> {

            this.categoryModel.removeCategory(categoryList.getSelectedIndex());

            updateList();
        });

        /**
         * listener to check, if the category name got changed
         */
        txtFldCatName.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateCategory();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateCategory();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateCategory();
            }
        });

        getRootPane().setDefaultButton(btnDone);
        btnDone.isDefaultButton();

        btnDone.addActionListener(e -> setVisible(false));

        updateList();

        setResizable(false);
        setTitle("Edit categories");
        setSize(new Dimension(300, 500));
        setLocationRelativeTo(SwingUtilities.getWindowAncestor(this));
        setModal(true);
        setVisible(false);


    }

    /**
     * Updates the category list content
     */
    private void updateList() {

        model.removeAllElements();
        for (int i = 0; i < categoryModel.getCategoryList().size(); i++) {
            model.add(i, categoryModel.getCategoryName(i));
        }

    }

    /**
     * updates the selected category name to the input of the text field
     */
    private void updateCategory() {
        int index = categoryList.getSelectedIndex();
        if (index >= 0) {
            categoryModel.setCategoryName(index, txtFldCatName.getText());
            model.set(index, categoryModel.getCategoryName(index));
        }
    }

    /**
     * sets up all panels in this dialog window
     */
    private void setUpPanels() {
        setLayout(new BorderLayout());


        scrollPane = new JScrollPane(categoryList);
        pnlList = new JPanel(new BorderLayout());


        pnlButtonsList = new JPanel();
        pnlTextField = new JPanel(new BorderLayout());
        pnlTextField.add(pnlButtonsList, BorderLayout.LINE_END);

        pnlList.add(pnlTextField, BorderLayout.SOUTH);
        pnlList.setBorder(new EmptyBorder(15,15,15,15));
        add(pnlList, BorderLayout.CENTER);
        pnlButtons = new JPanel(new BorderLayout());

        add(pnlButtons, BorderLayout.SOUTH);
    }

    /**
     * sets up all components in this dialog window
     */
    private void setUpComponents() {
        categoryList = new JList<>();
        categoryList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        btnDone = new JButton("Done");

        txtFldCatName = new JTextField();
        txtFldCatName.setEnabled(false);

        btnAdd = new JButton("+");
        btnAdd.setPreferredSize(new Dimension(30, 30));
        btnRem = new JButton("-");
        btnRem.setPreferredSize(new Dimension(30, 30));
        btnRem.setEnabled(false);
    }

    /**
     * places all the components in this dialog window
     */
    private void placeComponents() {
        pnlList.add(scrollPane, BorderLayout.CENTER);
        pnlTextField.add(txtFldCatName, BorderLayout.CENTER);
        pnlButtonsList.add(btnAdd);
        pnlButtonsList.add(btnRem);

        pnlButtons.add(btnDone, BorderLayout.LINE_END);
    }

    public CategoryModel getCategoryModel() {
        return categoryModel;
    }

    public static GuiToDoEditCategoriesImpl getInstance() {
        return instance;
    }


}
