package ch.gibmit.m226.todo.gui.interfaces;

import ch.gibmit.m226.todo.bl.ToDo;
import ch.gibmit.m226.todo.dto.ToDoDTO;

/**
 * Created by hecol on 22/04/16.
 */
public interface IToDoController {

    void addToDo(ToDoDTO toDoDTO);

    void refreshToDosInModel();
    
    ToDoDTO getLatestToDo();
    
    ToDoDTO getSingleToDo(int index);

	ToDo getToDo();

}
