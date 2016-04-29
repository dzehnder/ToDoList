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
		toDoList.add(new ToDoDTO("Work"));
		toDoList.add(new ToDoDTO("School"));
		toDoList.add(new ToDoDTO("Theater"));
		toDoList.add(new ToDoDTO("Movies"));
	}
	
    @Override
    public void addToDo(ToDoDTO toDo) {
    	toDoList.add(toDo);
    }

    @Override
    public ArrayList<ToDoDTO> getAllToDo() {
        return toDoList;
    }
}