package ch.gibmit.m226.todo.gui.guiToDoImpl;

import java.util.ArrayList;

import ch.gibmit.m226.todo.dto.ToDoDTO;

/**
 * @author Colin Herzog
 * This class provides the cache for the todos
 */
public class ToDoModel {
    private ArrayList<ToDoDTO> toDoList;

    public ToDoModel() {
        toDoList = new ArrayList<>();
    }
    
    public void refreshToDoList(ArrayList<ToDoDTO> toDoList) {
        this.toDoList = toDoList;
    }

    public ArrayList<ToDoDTO> getToDoList() {
        return toDoList;
    }

    public String getToDoName(int index) {
        return toDoList.get(index).getName();
    }

    public void removeToDo(int index) {
        toDoList.remove(index);
    }

	public void updateToDo(int selected, ToDoDTO changedToDo) {
		this.toDoList.set(selected, changedToDo);		
	}
}
