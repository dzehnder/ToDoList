package ch.gibmit.m226.todo.dto;

import ch.gibmit.m226.todo.bl.Category;

import java.util.Date;

/**
 * Created by hecol on 22.04.2016.
 */
public class ToDoDTO {
    private int id;
    private String name;
    private Date dateTime;
    private int priority;
    private boolean done;
    private String note;
    //private Repeat repeat;
    private Category cat;


    public ToDoDTO(String name, Date dateTime, int priority, boolean done, String note, Category cat) {
        //this.id = id;
        this.name = name;
        this.dateTime = dateTime;
        this.priority = priority;
        this.done = done;
        this.note = note;
        this.cat = cat;
    }
    
    public ToDoDTO(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Category getCat() {
        return cat;
    }

    public void setCat(Category cat) {
        this.cat = cat;
    }

}
