package ch.gibmit.m226.todo.dto;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Damian Zehnder
 * this class is the data access object of the todo.
 * it contains alldata of a todo
 */
public class ToDoDTO implements Serializable {

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
	public ToDoDTO(String name, Date date, int priority, Object category) {
		this.name = name;
		this.dateTime = date;
        this.priority = priority;
        this.category = category;
	}

    /**
     * this constructor sets only the name as default value
     * @param name the default name of the new todo
     */
	public ToDoDTO(String name) {
		this.name = name;
	}

    /**
     * @return the name of the todo
     */
	public String getName() {
		return name;
	}

    /**
     * set a new name
     * @param name the name to be set
     */
	public void setName(String name) {
		this.name = name;
	}

    /**
     * @return the date and the time on which the todo is happening
     */
	public Date getDateTime() {
		return dateTime;
	}

    /**
     * set a new date and a new time, on which the todo should happen
     * @param dateTime the new date
     */
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

    /**
     * @return the priority of the todo
     */
	public int getPriority() {
		return priority;
	}

    /**
     * set a new priority
     * @param priority the priority to be set
     */
	public void setPriority(int priority) {
		this.priority = priority;
	}

    /**
     * @return if the todo is already done
     */
	public boolean isDone() {
		return done;
	}

    /**
     * define if the todo is already done
     * @param done set this to true if the todo is already done
     */
	public void setDone(boolean done) {
		this.done = done;
	}

    /**
     * @return the note of the todo
     */
	public String getNote() {
		return note;
	}

    /**
     * set a new note to the todo
     * @param note the note to be set
     */
	public void setNote(String note) {
		this.note = note;
	}

    /**
     * @return the repeater settings of the todo
     */
	public Repeater getRepeat() {
		return repeat;
	}

    /**
     * set a new repeater setting
     * @param repeat the repeater object of the new repeater setting
     */
	public void setRepeat(Repeater repeat) {
		this.repeat = repeat;
	}

    /**
     * @return the category of the todo
     */
	public Object getCategory() {
		return category;
	}

    /**
     * set a new category
     * @param category the category to be set
     */
	public void setCategory(Object category) {
		this.category = category;
	}

    /**
     * Checks if a todo has the same date, as the date given. It also calculates the dates of the repeated todos.
     * @param calModel the date to check
     * @return true if the date given, matches to some todos.
     */
	public boolean isDateValid(Calendar calModel) {
        Calendar startDate = Calendar.getInstance();
        startDate.setTime(dateTime);

        Calendar endDate = Calendar.getInstance();

        if (repeat == null) {
            return startDate.get(Calendar.DAY_OF_YEAR) == calModel.get(Calendar.DAY_OF_YEAR) && startDate.get(Calendar.YEAR) == calModel.get(Calendar.YEAR);
        }
        else {
            if (startDate.getTimeInMillis() <= calModel.getTimeInMillis()) {
                int repeatRate = repeat.getRate();
                if (repeat.hasEndDate()) {
                    endDate.setTime(repeat.getEndDate());
                }
                if (repeat.getRecurrence().equals("Daily")) {

                    if (repeatRate > 1) {
                        while (startDate.get(Calendar.DAY_OF_YEAR) < calModel.get(Calendar.DAY_OF_YEAR) || startDate.get(Calendar.YEAR) < calModel.get(Calendar.YEAR)) {
                            startDate.add(Calendar.DAY_OF_MONTH, repeatRate);
                        }
                        if (!repeat.hasEndDate()) {
                            return startDate.get(Calendar.DAY_OF_MONTH) == calModel.get(Calendar.DAY_OF_MONTH);
                        } else {
                            return startDate.get(Calendar.DAY_OF_MONTH) == calModel.get(Calendar.DAY_OF_MONTH) && calModel.getTimeInMillis() <= endDate.getTimeInMillis();
                        }
                    } else {
                        return !repeat.hasEndDate() || calModel.getTimeInMillis() <= endDate.getTimeInMillis();
                    }

                } else if (repeat.getRecurrence().equals("Weekly")) {
                    int dayOfWeek;

                    if (calModel.get(Calendar.DAY_OF_WEEK) == 1) {
                        dayOfWeek = 6;
                    } else {
                        dayOfWeek = calModel.get(Calendar.DAY_OF_WEEK) - 2;
                    }
                    return repeat.getWeekDays()[dayOfWeek] && (!repeat.hasEndDate() || calModel.getTimeInMillis() <= endDate.getTimeInMillis());


                } else if (repeat.getRecurrence().equals("Monthly")) {
                        if (repeatRate > 1) {
                            while (startDate.get(Calendar.MONTH) < calModel.get(Calendar.MONTH) || startDate.get(Calendar.YEAR) < calModel.get(Calendar.YEAR)) {
                                startDate.add(Calendar.MONTH, repeatRate);
                            }
                            if (!repeat.hasEndDate()) {
                                return startDate.get(Calendar.MONTH) == calModel.get(Calendar.MONTH) && calModel.get(Calendar.DAY_OF_MONTH) == startDate.get(Calendar.DAY_OF_MONTH);

                            }
                            else {
                                return startDate.get(Calendar.MONTH) == calModel.get(Calendar.MONTH) && calModel.getTime().getTime() <= endDate.getTime().getTime() &&
                                        calModel.get(Calendar.DAY_OF_MONTH) == startDate.get(Calendar.DAY_OF_MONTH);
                            }
                        } else {
                            int dayToCheck = startDate.get(Calendar.DAY_OF_MONTH);
                            if (repeat.hasEndDate()) {
                                return calModel.get(Calendar.DAY_OF_MONTH) == dayToCheck && calModel.getTime().getTime() <= endDate.getTime().getTime();
                            } else {
                                return calModel.get(Calendar.DAY_OF_MONTH) == dayToCheck;
                            }
                        }

                } else if (repeat.getRecurrence().equals("Yearly")) {
                    if (repeatRate > 1) {
                        while (startDate.get(Calendar.YEAR) <  calModel.get(Calendar.YEAR)) {
                            startDate.add(Calendar.YEAR, repeatRate);
                        }
                        if (repeat.hasEndDate()) {
                            return startDate.get(Calendar.YEAR) == calModel.get(Calendar.YEAR) && calModel.getTimeInMillis() <= endDate.getTimeInMillis() &&
                                    calModel.get(Calendar.DAY_OF_YEAR) == startDate.get(Calendar.DAY_OF_YEAR);
                        }
                        else {
                            return startDate.get(Calendar.DAY_OF_YEAR) == calModel.get(Calendar.DAY_OF_YEAR) && startDate.get(Calendar.YEAR) == calModel.get(Calendar.YEAR);
                        }
                    }
                    else {
                        if (repeat.hasEndDate()) {
                            return startDate.get(Calendar.DAY_OF_YEAR) == calModel.get(Calendar.DAY_OF_YEAR) && calModel.getTimeInMillis() <= endDate.getTimeInMillis();
                        }
                        else {
                            return startDate.get(Calendar.DAY_OF_YEAR) == calModel.get(Calendar.DAY_OF_YEAR);
                        }
                    }


                } else {
                    return false;
                }
            }
            else {
                return false;
            }
        }

	}
}
