package ch.gibmit.m226.todo.bl;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import ch.gibmit.m226.todo.data.CategoryDAO;
import ch.gibmit.m226.todo.data.ToDoDAO;

public class Serializor {

	CategoryDAO categoryDAO;
	ToDoDAO toDoDAO;

	public Serializor(CategoryDAO categoryDAO, ToDoDAO toDoDAO) {
		this.categoryDAO = categoryDAO;
		this.toDoDAO = toDoDAO;
	}

	public void save() {
		try {
			this.categoryDAO.getCategories();
			this.toDoDAO.getAllToDos();
			ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream("output.bin"));

			oout.writeObject(this.categoryDAO);
			oout.writeObject(this.toDoDAO);
			oout.flush();
			oout.close();
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
}
