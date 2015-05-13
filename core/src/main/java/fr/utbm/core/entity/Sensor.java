package fr.utbm.core.entity;

import java.io.Serializable;
import java.util.Set;

public class Sensor implements Serializable {

	private static final long serialVersionUID = 4472531906645355642L;

	private int id;
	private String label;

	private Set<Temperature> temperatures;
	private Set<Trigger> triggers;

	public Sensor() {
	}

	public Sensor(String label) {
		this.label = label;
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
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the temperatures
	 */
	public Set<Temperature> getTemperatures() {
		return temperatures;
	}

	/**
	 * @param temperatures
	 *            the temperatures to set
	 */
	public void setTemperatures(Set<Temperature> temperatures) {
		this.temperatures = temperatures;
	}

	/**
	 * @return the triggers
	 */
	public Set<Trigger> getTriggers() {
		return triggers;
	}

	/**
	 * @param triggers
	 *            the triggers to set
	 */
	public void setTriggers(Set<Trigger> triggers) {
		this.triggers = triggers;
	}
}
