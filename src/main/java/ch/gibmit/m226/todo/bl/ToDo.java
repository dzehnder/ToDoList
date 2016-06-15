package ch.gibmit.m226.todo.bl;

import ch.gibmit.m226.todo.data.ToDoDAO;
import ch.gibmit.m226.todo.data.ToDoDAOImpl;
import ch.gibmit.m226.todo.dto.ToDoDTO;
import ch.gibmit.m226.todo.util.ToDoSortType;

import java.util.ArrayList;

/**
 * @author Colin Herzog
 *         this class is the business-logic of the todo class
 */
public class ToDo {

    private ToDoDAO toDoDAO;

    /**
     * constructor sets paramter as the todo data access object
     */
    public ToDo(ToDoDAO toDoDAO) {
        this.toDoDAO = toDoDAO;
    }

    /**
     * add a todo to the tododao
     * @param toDo tododto to add to the tododao
     */
    public void add(ToDoDTO toDo) {
        toDoDAO.addToDo(toDo);
    }

    /**
     * get all todos in an arraylist
     * @return all todos
     */
    public ArrayList<ToDoDTO> getToDos() {
        return toDoDAO.getAllToDos();
    }

    /**
     * get the toDoDAO instance
     * @return toDoDAO instance
     */
    public ToDoDAO getToDoDAO() {
        return this.toDoDAO;
    }

    /**
     * returns a ordered arraylist containing all the todos
     * @param sortType enum ToDoSortType
     * @return ordered arraylist of all todos
     */
    public ArrayList<ToDoDTO> getSortedToDos(final ToDoSortType sortType) {
        return toDoDAO.getSortedToDos(sortType);
    }
}
