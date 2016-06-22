package ch.gibmit.m226.todo.gui.guiToDoImpl;

import java.util.ArrayList;

import ch.gibmit.m226.todo.dto.ToDoDTO;

/**
 * @author Colin Herzog
 * This class provides the cache for the todos
 */
public class ToDoModel {

    /**
     * ArrayList for the jlist on the left side
     */
    private ArrayList<ToDoDTO> toDoList;

    /**
     * Creates a new instance of the arraylist -> only if it's a new todolist
     */
    public ToDoModel() {
        toDoList = new ArrayList<>();
    }


    /**
     * refreshs todolist from the todocontroller
     * @param toDoList the new todolist
     */
    public void refreshToDoList(ArrayList<ToDoDTO> toDoList) {
        this.toDoList = toDoList;
    }

    /**
     * Get the whole todolist
     * @return this todolist
     */
    public ArrayList<ToDoDTO> getToDoList() {
        return toDoList;
    }

    /**
     * get the name of the todo in the /index/-position.
     * @param index the position
     * @return name of todo
     */
    public String getToDoName(int index) {
        return toDoList.get(index).getName();
    }

    /**
     * Remove an element by index on the list
     * @param index element to remove
     */
    public void removeToDo(int index) {
        toDoList.remove(index);
    }

    /**
     * Update the todo to select
     * @param selected the int to select
     * @param changedToDo which todo should be affected
     */
	public void updateToDo(int selected, ToDoDTO changedToDo) {
		this.toDoList.set(selected, changedToDo);		
	}
}
