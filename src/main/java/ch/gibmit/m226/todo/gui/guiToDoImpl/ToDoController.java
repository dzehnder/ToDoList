package ch.gibmit.m226.todo.gui.guiToDoImpl;

import ch.gibmit.m226.todo.bl.ToDo;
import ch.gibmit.m226.todo.data.ToDoDAO;
import ch.gibmit.m226.todo.data.ToDoDAOImpl;
import ch.gibmit.m226.todo.dto.ToDoDTO;
import ch.gibmit.m226.todo.gui.interfaces.IToDoController;

/**
 * Created by hecol on 25/04/16.
 */
public class ToDoController implements IToDoController {

    
    private ToDoModel toDoModel;
    private int activeTodo;
    private ToDo toDo = null;

    public ToDoController(ToDoModel toDoModel) {
        this(toDoModel, new ToDoDAOImpl());
    }
    
    public ToDoController(ToDoModel toDoModel, ToDoDAO toDoDAO) {
        this.toDoModel = toDoModel;
        toDo = new ToDo(toDoDAO);
    }
 

    @Override
    public void addToDo(ToDoDTO toDoDTO) {
        toDo.add(toDoDTO);
        getAllToDos();
    }

    @Override
    public void getAllToDos() {
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

    public ToDoDTO getActiveTodo() {
        return toDo.getToDos().get(activeTodo);
    }
    
    public void setActiveTodo(int activeTodo) {
        this.activeTodo = activeTodo;
    }
}
