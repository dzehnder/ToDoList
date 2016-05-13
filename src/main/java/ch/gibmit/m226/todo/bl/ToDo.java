package ch.gibmit.m226.todo.bl;

import ch.gibmit.m226.todo.data.ToDoDAO;
import ch.gibmit.m226.todo.data.ToDoDAOImpl;
import ch.gibmit.m226.todo.dto.ToDoDTO;

import java.util.ArrayList;

/**
 * Created by hecol on 22.04.2016.
 * this class is the business-logic of the todo class
 */
public class ToDo {

    private ToDoDAO toDoDAO;

    public ToDo() {
        this(new ToDoDAOImpl());
    }
    
    public ToDo(ToDoDAO toDoDAO) {
        this.toDoDAO = toDoDAO;
    }

    public void add(ToDoDTO toDo) {
        toDoDAO.addToDo(toDo);
    }

    public ArrayList<ToDoDTO> getToDos() {
        return toDoDAO.getAllToDos();
    }
    
    public ToDoDAO getToDoDAO() {
    	return this.toDoDAO;
    }
    
    public void setToDoDAO(ToDoDAO toDoDAO) {
    	this.toDoDAO = toDoDAO;
    }
    
}
