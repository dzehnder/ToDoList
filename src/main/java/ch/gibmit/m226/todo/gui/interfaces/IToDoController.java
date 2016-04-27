package ch.gibmit.m226.todo.gui.interfaces;

import ch.gibmit.m226.todo.dto.CategoryDTO;
import ch.gibmit.m226.todo.dto.ToDoDTO;

/**
 * Created by zehnder on 22/04/16.
 */
public interface IToDoController {

    void addToDo(ToDoDTO toDoDTO);

    void getAllToDos();

}
