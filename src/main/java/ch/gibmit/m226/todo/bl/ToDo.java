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
        toDoDAO = new ToDoDAOImpl();
    }

    public void add(ToDoDTO toDo) {
        toDoDAO.addToDo(toDo);
    }

    public ArrayList<ToDoDTO> getToDos() {
        return null;
    }
    
}
