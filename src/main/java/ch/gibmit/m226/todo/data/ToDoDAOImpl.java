package ch.gibmit.m226.todo.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

import ch.gibmit.m226.todo.dto.ToDoDTO;
import ch.gibmit.m226.todo.util.ToDoSortType;

/**
 * Created by hecol on 22.04.2016.
 */
public class ToDoDAOImpl implements ToDoDAO, Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 642680629408108860L;
    private ArrayList<ToDoDTO> toDoList;

    public ToDoDAOImpl() {
        toDoList = new ArrayList<>();
    }

    @Override
    public void addToDo(ToDoDTO toDo) {
        toDoList.add(toDo);
    }

    @Override
    public ArrayList<ToDoDTO> getAllToDos() {
        return toDoList;
    }

    @Override
    public ArrayList<ToDoDTO> getSortedToDos(final ToDoSortType sortType) {
        Collections.sort(toDoList, (toDo1, toDo2) -> {
            switch (sortType) {
                case NAME:
                    return toDo1.getName().compareTo(toDo2.getName());

                case PRIORITY:
                    return Integer.valueOf(toDo2.getPriority()).compareTo(toDo1.getPriority());

                case CATEGORY:
                    return toDo1.getCategory().toString().compareTo(toDo2.getCategory().toString());

            }
            throw new IllegalStateException("Unsupported sort type: " + sortType);
        });
        return toDoList;
    }
}