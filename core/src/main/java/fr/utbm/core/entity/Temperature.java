package fr.utbm.core.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "temperature")
public class Temperature implements Serializable {

	private static final long serialVersionUID = -6599972396675661321L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Tmp_Id")
	private int id;
	@Column(name = "Tmp_Value")
	private float value;

	@Column(name = "Tmp_Date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	@JoinColumn(name = "Sen_Id")
	@ManyToOne
	private int sensorId;

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
	 * @return the sensorId
	 */
	public int getSensorId() {
		return sensorId;
	}

	/**
	 * @param sensorId
	 *            the sensorId to set
	 */
	public void setSensorId(int sensorId) {
		this.sensorId = sensorId;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
}
