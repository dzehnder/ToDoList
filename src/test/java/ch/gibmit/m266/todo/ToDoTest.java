package ch.gibmit.m266.todo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ch.gibmit.m226.todo.dto.ToDoDTO;
import ch.gibmit.m226.todo.gui.guiToDoImpl.ToDoController;
import ch.gibmit.m226.todo.gui.guiToDoImpl.ToDoModel;

/**
 * @author Colin Herzog
 */
public class ToDoTest {

    private ToDoModel toDoModel = new ToDoModel();
    private ToDoController toDoController = new ToDoController(toDoModel);

    private String todoname = "a toDo";

    @Test
    public void testAddToDo() {
        ToDoDTO toDoDTO = new ToDoDTO(todoname);
        toDoController.addToDo(toDoDTO);
        
        //index 4 because of default categories
        assertEquals(toDoModel.getToDoName(0), todoname);
    }

    @Test
    public void testRemoveToDo() {
    	testAddToDo();
        toDoController.getAllToDos();
        int size = toDoModel.getToDoList().size();
        System.out.println(size);
        toDoModel.removeToDo(size-1);

        assertEquals(toDoModel.getToDoList().size(), size-1);
    }
}
