package fr.utbm.core.entity;

import java.io.Serializable;

/**
 *
 * @author Julien
 */

public class Alert implements Serializable {
	private static final long serialVersionUID = -2138583970512839325L;

	private String id;
	private String label;
	private String description;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
