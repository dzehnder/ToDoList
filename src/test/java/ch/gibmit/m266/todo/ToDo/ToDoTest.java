package ch.gibmit.m266.todo.ToDo;

import ch.gibmit.m226.todo.bl.ToDo;
import ch.gibmit.m226.todo.data.ToDoDAOImpl;
import ch.gibmit.m226.todo.dto.ToDoDTO;
import ch.gibmit.m226.todo.gui.guiToDoImpl.ToDoController;
import ch.gibmit.m226.todo.gui.guiToDoImpl.ToDoModel;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Colin Herzog
 */
public class ToDoTest {

    private ToDoModel toDoModel = new ToDoModel();
    private ToDoController toDoController = new ToDoController(toDoModel);

    private String toDoName = "a toDo";

    private ToDoDTO toDoDTO = new ToDoDTO(toDoName);

    @Test
    public void testAddToDo() {

        toDoController.addToDo(toDoDTO);

        assertEquals(toDoModel.getToDoName(toDoModel.getToDoList().size()-1), toDoName);
    }

    @Test
    public void testRemoveToDo() {
        testAddToDo();
        toDoController.refreshToDosInModel();
        int size = toDoModel.getToDoList().size();
        toDoModel.removeToDo(size-1);
        assertEquals(toDoModel.getToDoList().size(), size-1);
    }

    @Test
    public void testToDoBLAdd() {
        ToDo toDo = new ToDo(new ToDoDAOImpl());

        toDo.add(toDoDTO);
        toDo.add(toDoDTO);
        toDo.add(toDoDTO);

        // expected return value must be 3 because there are now 3 todos.
        assertEquals(toDo.getToDos().size(), 3);

        // index must be 2 because 3 toDos were added
        assertEquals(toDo.getToDos().get(2), toDoDTO);
    }
}
