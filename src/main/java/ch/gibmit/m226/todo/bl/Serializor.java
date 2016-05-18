package ch.gibmit.m226.todo.bl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import ch.gibmit.m226.todo.data.CategoryDAO;
import ch.gibmit.m226.todo.data.ToDoDAO;

import javax.swing.*;

public class Serializor {

    CategoryDAO categoryDAO;
    ToDoDAO toDoDAO;

    public Serializor(CategoryDAO categoryDAO, ToDoDAO toDoDAO) {
        this.categoryDAO = categoryDAO;
        this.toDoDAO = toDoDAO;
    }

    public void saveNew() {
        saveAs();
    }

    public void save(String path) {
        try {
            this.categoryDAO.getCategories();
            this.toDoDAO.getAllToDos();
            ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(path));

            oout.writeObject(this.categoryDAO);
            oout.writeObject(this.toDoDAO);
            oout.flush();
            oout.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public void saveAs() {
        JFrame parentFrame = new JFrame();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save ToDoList");
        int userSelection = fileChooser.showSaveDialog(parentFrame);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            this.save(fileToSave.getAbsolutePath());
        }
    }
}
