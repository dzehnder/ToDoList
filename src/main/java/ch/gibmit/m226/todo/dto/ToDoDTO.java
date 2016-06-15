package ch.gibmit.m226.todo.dto;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Damian Zehnder
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
                        while (startDate.get(Calendar.DAY_OF_MONTH) < calModel.get(Calendar.DAY_OF_MONTH)) {
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
                            while (startDate.getTimeInMillis() < calModel.getTimeInMillis()) {
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
