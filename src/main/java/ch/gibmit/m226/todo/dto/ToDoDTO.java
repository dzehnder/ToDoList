package ch.gibmit.m226.todo.dto;

import ch.gibmit.m226.todo.bl.Category;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by hecol on 22.04.2016.
 */
public class ToDoDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9162166727252543372L;
	
	private String name;
	private Date dateTime;
	private int priority;
	private boolean done;
	private String note;
	private Repeater repeat;
	private Object category;


	/**
	 * Constructor sets default values
	 * @param name the default name of the new todo
	 * @param date the default date of new todo
     */
	public ToDoDTO(String name, Date date) {
		this.name = name;
		this.dateTime = date;
	}
	
	public ToDoDTO(String name) {
		this.name = name;
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

	public Repeater getRepeat() {
		return repeat;
	}

	public void setRepeat(Repeater repeat) {
		this.repeat = repeat;
	}

	public Object getCategory() {
		return category;
	}

	public void setCategory(Object category) {
		this.category = category;
	}

}
