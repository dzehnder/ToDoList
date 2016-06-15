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
     * add a todo
     * @param toDoDTO
     */
    void addToDo(ToDoDTO toDoDTO);

    /**
     * refresh the model, to get all todos in the model
     */
    void refreshToDosInModel();

    /**
     * get last todo from the todolist
     * @return last todo
     */
    ToDoDTO getLatestToDo();

    /**
     * get todo by index
     * @param index
     * @return
     */
    ToDoDTO getSingleToDo(int index);


    /**
     * Get the ToDo-Instance (Class from Business-Logic)
     * @return toDol instance
     */
	ToDo getToDo();

}
