package fr.utbm.core.entity;

import java.io.Serializable;

/**
 *
 * @author Julien
 * @package fr.utbm.core.entity
 */
public class User implements Serializable {


	private static final long serialVersionUID = -143724295728779068L;
	private long id;
	private String username;
	private boolean enabled;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

}
