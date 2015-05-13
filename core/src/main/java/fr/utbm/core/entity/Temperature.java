package fr.utbm.core.entity;

import java.io.Serializable;
import java.util.Date;

public class Temperature implements Serializable {

	private static final long serialVersionUID = -6599972396675661321L;

	private int id;
	private float value;

	private Date date;

	public Temperature() {
	}

	public Temperature(float value, Date date) {
		this.value = value;
		this.date = date;
	}

	/**
	 * @return the value
	 */
	public float getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(float value) {
		this.value = value;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
}
