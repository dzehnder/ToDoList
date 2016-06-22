package ch.gibmit.m226.todo.bl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import org.apache.commons.io.FilenameUtils;

import ch.gibmit.m226.todo.data.CategoryDAO;
import ch.gibmit.m226.todo.data.ToDoDAO;

/**
 * @author colinherzog
 *         this class is the serializes the data to a file
 */
public class Serializor {

    /**
     * The CategoryDAO to save
     */
    CategoryDAO categoryDAO;
    /**
     * The ToDODAO to save
     */
    ToDoDAO toDoDAO;

    /**
     * The constructor sets the DAO's to save
     * @param categoryDAO the categoryDAO to save
     * @param toDoDAO the ToDoDAO to save
     */
    public Serializor(CategoryDAO categoryDAO, ToDoDAO toDoDAO) {
        this.categoryDAO = categoryDAO;
        this.toDoDAO = toDoDAO;
    }

    /**
     * Saves the DAOs in a file in a chosen path.
     * The path is given by the file-chooser-dialog.
     *
     * @param path is the path where the file should be saved.
     */
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

    public boolean saveAs(int userSelection, File fileToSave) {
        if (FilenameUtils.getExtension(fileToSave.getName()).equalsIgnoreCase("tdo")) {
            // filename is OK as it is
        } else {
            fileToSave = new File(fileToSave.toString() + ".tdo");
        }
        this.save(fileToSave.getAbsolutePath());
        return false;
    }
}
