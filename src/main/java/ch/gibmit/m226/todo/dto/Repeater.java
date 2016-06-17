package ch.gibmit.m226.todo.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Damian Zehnder
 * this class is the data access object of the repeater settings
 * it contains all repeater data
 */
public class Repeater implements Serializable {

	private static final long serialVersionUID = 1024913788309088968L;
	
	private Object recurrence;
    private int rate;
    private Boolean hasEndDate;
    private Date endDate;
    private Boolean[] weekDays = {false, false, false, false, false, false, false};

    /**
     * constructor initializes nothing to the repeater settings
     */
    public Repeater() {
        // nothing to do
    }

    /**
     * @return the recurrence setting
     */
    public Object getRecurrence() {
        return recurrence;
    }

    /**
     * set a new recurrence
     * @param recurrence the recurrence to be set
     */
    public void setRecurrence(Object recurrence) {
        this.recurrence = recurrence;
    }

    /**
     * @return the repeat rate
     */
    public int getRate() {
        return rate;
    }

    /**
     * set a new repeat rate
     * @param rate the repeat rate to be set
     */
    public void setRate(int rate) {
        this.rate = rate;
    }

    /**
     * @return true if this setting has an enda date
     */
    public Boolean hasEndDate() {
        return hasEndDate;
    }

    /**
     * @param hasEndDate define if ths setting has an end date
     */
    public void setHasEndDate(Boolean hasEndDate) {
        this.hasEndDate = hasEndDate;
    }

    /**
     * @return the end date of the setting, if it has one
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * set a new end date
     * @param endDate the end date to be set
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * @return the array of weekdays. Set the index of the weekday to true, if the todo should be repeated on that day.
     */
    public Boolean[] getWeekDays() {
        return weekDays;
    }

    /**
     * @param index the weekday. 0 is monday and 6 is sunday
     * @return true if a specific weekday is repeated
     */
    public Boolean getWeekdayAt(int index) {
            return weekDays[index];
    }

    /**
     * set a specific weekday, on which the todo should be repeated
     * @param weekday true if the todo should be repeated on the specified day
     * @param index the specified weekday. 0 is monday and 6 is sunday
     */
    public void setWeekdayAt(Boolean weekday, int index) {
        weekDays[index] = weekday;
    }

}
