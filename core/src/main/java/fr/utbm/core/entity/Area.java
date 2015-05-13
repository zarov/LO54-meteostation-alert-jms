package fr.utbm.core.entity;

import java.io.Serializable;
import java.util.Set;

public class Area implements Serializable {

	private static final long serialVersionUID = -3571500543876062353L;

	private int id;
	private String label;
	private String road;
	private Set<Station> stations;

	public Area() {
	}

	public Area(String label, String road) {
		this.label = label;
		this.road = road;
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
	 * @return the road
	 */
	public String getRoad() {
		return road;
	}

	/**
	 * @param road
	 *            the road to set
	 */
	public void setRoad(String road) {
		this.road = road;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the stations
	 */
	public Set<Station> getStations() {
		return stations;
	}

	/**
	 * @param stations
	 *            the stations to set
	 */
	public void setStations(Set<Station> stations) {
		this.stations = stations;
	}
}
