package fr.utbm.core.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class Station implements Serializable {

	private static final long serialVersionUID = 6132454940793990497L;

	private int id;
	private String label;
	private Date lastCom;
	private int valid;
	private Set<Sensor> sensors;

	public Station() {
	}

	public Station(String label, Date lastCom, int valid) {
		this.label = label;
		this.lastCom = lastCom;
		this.valid = valid;
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param label
	 *            the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * @return the lastCom
	 */
	public Date getLastCom() {
		return lastCom;
	}

	/**
	 * @param lastCom
	 *            the lastCom to set
	 */
	public void setLastCom(Date lastCom) {
		this.lastCom = lastCom;
	}

	/**
	 * @return the valid
	 */
	public int getValid() {
		return valid;
	}

	/**
	 * @param valid
	 *            the valid to set
	 */
	public void setValid(int valid) {
		this.valid = valid;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the sensors
	 */
	public Set<Sensor> getSensors() {
		return sensors;
	}

	/**
	 * @param sensors
	 *            the sensors to set
	 */
	public void setSensors(Set<Sensor> sensors) {
		this.sensors = sensors;
	}
}
