package fr.utbm.core.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "station")
public class Station implements Serializable {

	private static final long serialVersionUID = 6132454940793990497L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Sta_Id")
	private int id;
	@Column(name = "Sta_Label", length = 45)
	private String label;
	@JoinColumn(name = "Are_Id")
	private int areaId;

	@Column(name = "Sta_LastCom")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastCom;
	@Column(name = "Sta_Valid")
	private int valid;

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
	 * @return the areaId
	 */
	public int getAreaId() {
		return areaId;
	}

	/**
	 * @param areaId
	 *            the areaId to set
	 */
	public void setAreaId(int areaId) {
		this.areaId = areaId;
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
}
