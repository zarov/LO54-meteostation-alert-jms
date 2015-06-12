package fr.utbm.core.entity;

import java.io.Serializable;

/**
 *
 * @author Adrien Berthet <adrien.berthet@utbm.fr>
 * @package fr.utbm.core.entity
 */
public class Area implements Serializable {

	private static final long serialVersionUID = -3571500543876062353L;

	private int id;
	private String label;
	private String road;

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

	public void setId(int id) {
		this.id = id;
	}
}
