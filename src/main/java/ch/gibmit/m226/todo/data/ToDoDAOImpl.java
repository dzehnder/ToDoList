package ch.gibmit.m226.todo.data;

import java.io.Serializable;
import java.util.ArrayList;

import ch.gibmit.m226.todo.dto.ToDoDTO;

/**
 * Created by hecol on 22.04.2016.
 */
public class ToDoDAOImpl implements ToDoDAO, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 642680629408108860L;
	private ArrayList<ToDoDTO> toDoList;
	
	public ToDoDAOImpl() {
		toDoList = new ArrayList<>();
	}
	
    @Override
    public void addToDo(ToDoDTO toDo) {
    	toDoList.add(toDo);
    }

    @Override
    public ArrayList<ToDoDTO> getAllToDos() {
        return toDoList;
    }
}