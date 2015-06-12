package fr.utbm.core.entity;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Julien
 */

public class AlertHis implements Serializable {

	private static final long serialVersionUID = -2713084408260793280L;

	private int Id;
	private Date date;
	private boolean state;
	private Trigger trigger;

	public AlertHis() {
	}

	public AlertHis(Date date, boolean state, Trigger trigger) {
		this.date = date;
		this.state = state;
		this.trigger = trigger;
	}

	public int getId() {
		return Id;
	}

	public void setId(int Id) {
		this.Id = Id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public Trigger getTrigger() {
		return trigger;
	}

	public void setTrigger(Trigger trigger) {
		this.trigger = trigger;
	}

}
