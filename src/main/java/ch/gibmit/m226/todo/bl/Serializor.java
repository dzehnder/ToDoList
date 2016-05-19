package ch.gibmit.m226.todo.bl;

import ch.gibmit.m226.todo.data.CategoryDAO;
import ch.gibmit.m226.todo.data.ToDoDAO;
import org.apache.commons.io.FilenameUtils;

import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

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
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int userSelection = fileChooser.showSaveDialog(parentFrame);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            if (FilenameUtils.getExtension(fileToSave.getName()).equalsIgnoreCase("tdo")) {
                // filename is OK as it is
            } else {
            	fileToSave = new File(fileToSave.toString() + ".tdo");
            }
            this.save(fileToSave.getAbsolutePath());
        }
    }
}
