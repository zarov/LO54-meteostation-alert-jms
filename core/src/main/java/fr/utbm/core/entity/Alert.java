/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.core.entity;

import java.io.Serializable;

/**
 *
 * @author Julien
 */

//@Entity
//@Table(name="alert")
public class Alert implements Serializable {
    
    //@Id
    //@Column(name = "Alr_code")
    private String id;
    //@Column(name = "Alr_Label")
    private String label;
    //@Column(name = "Alr_Description")
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
