package ch.gibmit.m226.todo.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Damian Zehnder
 */
public class Repeater implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1024913788309088968L;
	
	private Object recurrence;
    private int rate;
    private Boolean hasEndDate;
    private Date endDate;
    private Boolean[] weekDays;


    public Repeater() {
        // nothing to do
    }

    public Object getRecurrence() {
        return recurrence;
    }

    public void setRecurrence(Object recurrence) {
        this.recurrence = recurrence;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public Boolean getHasEndDate() {
        return hasEndDate;
    }

    public void setHasEndDate(Boolean hasEndDate) {
        this.hasEndDate = hasEndDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Boolean[] getWeekDays() {
        return weekDays;
    }

    public void setWeekDays(Boolean[] weekDays) {
        this.weekDays = weekDays;
    }
}
