package ch.gibmit.m226.todo.gui.interfaces;

import ch.gibmit.m226.todo.bl.ToDo;
import ch.gibmit.m226.todo.dto.ToDoDTO;

/**
 * Created by hecol on 22/04/16.
 * @author colinherzog
 * This interface provides all necessary metohds for the tooocontroller
 */
public interface IToDoController {

    /**
     * adds a todo to the
     * @param toDoDTO
     */
    void addToDo(ToDoDTO toDoDTO);

    void refreshToDosInModel();
    
    ToDoDTO getLatestToDo();
    
    ToDoDTO getSingleToDo(int index);

	ToDo getToDo();

}
