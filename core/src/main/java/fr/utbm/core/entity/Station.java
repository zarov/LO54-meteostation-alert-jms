package fr.utbm.core.entity;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Adrien Berthet <adrien.berthet@utbm.fr>
 * @package fr.utbm.core.entity
 */
public class Station implements Serializable {

	private static final long serialVersionUID = 6132454940793990497L;

	private int id;
	private String label;
	private Area area;
	private Date lastCom;
	private boolean valid;

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
	 * @return the area
	 */
	public Area getArea() {
		return area;
	}

	/**
	 * @param areaId
	 *            the areaId to set
	 */
	public void setArea(Area area) {
		this.area = area;
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
	 * @param valid
	 *            the valid to set
	 */
	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public boolean isValid() {
		return valid;
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
