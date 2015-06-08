package fr.utbm.core.entity;

import java.io.Serializable;


//@Entity
//@Table(name = "area")
public class Area implements Serializable {

	private static final long serialVersionUID = -3571500543876062353L;

	//@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	//@Column(name = "Are_Id")
	private int id;


	//@Column(name = "Are_Label", length = 45)
	private String label;
	//@Column(name = "Are_Road", length = 45)
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
