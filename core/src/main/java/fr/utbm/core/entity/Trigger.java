package fr.utbm.core.entity;

import java.io.Serializable;

/**
 *
 * @author Julien
 */
public class Trigger implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private float trigHigh;
	private float trigLow;
	private byte trigEdge;
	private Alert alert;
	private Sensor sensor;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getTrigHigh() {
		return trigHigh;
	}

	public void setTrigHigh(float trigHigh) {
		this.trigHigh = trigHigh;
	}

	public float getTrigLow() {
		return trigLow;
	}

	public void setTrigLow(float trigLow) {
		this.trigLow = trigLow;
	}

	public byte getTrigEdge() {
		return trigEdge;
	}

	public void setTrigEdge(byte trigEdge) {
		this.trigEdge = trigEdge;
	}

	public Sensor getSensor() {
		return sensor;
	}

	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}

	public Alert getAlert() {
		return alert;
	}

	public void setAlert(Alert alert) {
		this.alert = alert;
	}

}
