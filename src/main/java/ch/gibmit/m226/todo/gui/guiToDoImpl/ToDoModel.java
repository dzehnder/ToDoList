package ch.gibmit.m226.todo.gui.guiToDoImpl;

import java.util.ArrayList;

import ch.gibmit.m226.todo.dto.ToDoDTO;

/**
 * Created by hecol on 29/04/16.
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

    public void setToDoName(int index, String name) {
        toDoList.get(index).setName(name);
    }

    public void removeToDo(int index) {
        toDoList.remove(index);
    }
}
