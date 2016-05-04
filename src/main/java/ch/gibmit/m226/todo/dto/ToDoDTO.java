package ch.gibmit.m226.todo.dto;

import ch.gibmit.m226.todo.bl.Category;

import java.util.Date;

/**
 * Created by hecol on 22.04.2016.
 */
public class ToDoDTO {
	private String name;
	private Date dateTime;
	private int priority;
	private boolean done;
	private String note;
	private String repeat;
	private Object category;

	/**
	 * New ToDoDTO
	 * @param name
	 * @param dateTime
	 * @param priority
	 * @param done
	 * @param note
	 * @param category
	 * @param repeat
	 */
	public ToDoDTO(String name, Date dateTime, int priority, boolean done, String note, Object category,
				   String repeat) {
		this.name = name;
		this.dateTime = dateTime;
		this.priority = priority;
		this.done = done;
		this.note = note;
		this.category = category;
		this.repeat = repeat;
	}

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

	public String getRepeat() {
		return repeat;
	}

	public void setRepeat(String repeat) {
		this.repeat = repeat;
	}

	public Object getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
