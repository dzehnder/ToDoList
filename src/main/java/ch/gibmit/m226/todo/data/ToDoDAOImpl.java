package ch.gibmit.m226.todo.data;

import java.util.ArrayList;

import ch.gibmit.m226.todo.dto.ToDoDTO;

/**
 * Created by hecol on 22.04.2016.
 */
public class ToDoDAOImpl implements ToDoDAO {
	
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