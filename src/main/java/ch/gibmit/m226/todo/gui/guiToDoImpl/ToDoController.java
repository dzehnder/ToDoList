package ch.gibmit.m226.todo.gui.guiToDoImpl;

import ch.gibmit.m226.todo.bl.ToDo;
import ch.gibmit.m226.todo.data.ToDoDAO;
import ch.gibmit.m226.todo.data.ToDoDAOImpl;
import ch.gibmit.m226.todo.dto.ToDoDTO;
import ch.gibmit.m226.todo.gui.interfaces.IToDoController;
import ch.gibmit.m226.todo.util.ToDoSortType;

import java.util.ArrayList;

/**
 * @author Colin Herzog
 * This class provides methods for the gui, in order to controll the todo
 */
public class ToDoController implements IToDoController {

    
    private ToDoModel toDoModel;
    private int activeTodo;
    private ToDo toDo = null;

    /**
     * Overload if list is new
     * @param toDoModel
     */
    public ToDoController(ToDoModel toDoModel) {
        this(toDoModel, new ToDoDAOImpl());
    }

    /**
     * Constuctor for a existing controller (or new controller if overloaded)
     * @param toDoModel
     * @param toDoDAO
     */
    public ToDoController(ToDoModel toDoModel, ToDoDAO toDoDAO) {
        this.toDoModel = toDoModel;
        toDo = new ToDo(toDoDAO);
    }
 

    @Override
    public void addToDo(ToDoDTO toDoDTO) {
        toDo.add(toDoDTO);
        refreshToDosInModel();
    }

    @Override
    public void refreshToDosInModel() {
    	toDoModel.refreshToDoList(toDo.getToDos());
    }

	@Override
	public ToDoDTO getLatestToDo() {
		return toDo.getToDos().get(toDo.getToDos().size() - 1);
	}

	@Override
	public ToDoDTO getSingleToDo(int index) {
		return this.toDo.getToDos().get(index);
	}
	
	@Override
	public ToDo getToDo() {
		return this.toDo;
	}

    /**
     * retruns the todo of the active (selected) tododto
     * @return selected toDoDTO
     */
    public ToDoDTO getActiveTodo() {
        return toDo.getToDos().get(activeTodo);
    }

    /**
     * Set a active todo
     * @param activeTodo the int for the active todo
     */
    public void setActiveTodo(int activeTodo) {
        this.activeTodo = activeTodo;
    }

    /**
     * refreshs the todolist and sort them by the sorttype
     * @param sortType as ToDoSortType Enum
     */
    public void createSortedToDoList(final ToDoSortType sortType) {
        toDoModel.refreshToDoList(toDo.getSortedToDos(sortType));
    }
}
