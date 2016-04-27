package ch.gibmit.m226.todo.gui.guiToDoImpl;

import ch.gibmit.m226.todo.bl.Category;
import ch.gibmit.m226.todo.bl.ToDo;
import ch.gibmit.m226.todo.dto.CategoryDTO;
import ch.gibmit.m226.todo.dto.ToDoDTO;
import ch.gibmit.m226.todo.gui.interfaces.ICategoryController;
import ch.gibmit.m226.todo.gui.interfaces.IToDoController;

/**
 * Created by zehnder on 25/04/16.
 */
public class ToDoController implements IToDoController {

    /**
     * give Data to business layer:
     */
    private ToDo toDo = new ToDo();

    @Override
    public void addToDo(ToDoDTO toDoDTO) {
        toDo.add(toDoDTO);
    }

    @Override
    public void getAllToDos() {

    }
}
