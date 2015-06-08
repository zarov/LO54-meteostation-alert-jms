/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.core.entity;

import java.io.Serializable;

//import org.hibernate.annotations.Entity;

/**
 *
 * @author Julien
 */
//@Entity
//@Table(name="trigger")
public class Trigger implements Serializable  {
    
    private static final long serialVersionUID = 1L;
    
    //@Id
    //@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    //@Column( name = "Trg_High")
    private float trigHigh;
    //@Column( name = "Trg_Low")
    private float trigLow;
    //@Column( name = "Trg_Edge")
    private byte trigEdge;
    //@JoinColumn( name = "Alr_code")
    private Alert alert;
    //@JoinColumn( name = "Sen_Id")
    private Sensor sensor;
     
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getTrigHigh() {
        return trigHigh;
    }

    public void setTrigHigh(float trigHigh) {
        this.trigHigh = trigHigh;
    }
    
    public float getTrigLow() {
        return trigLow;
    }

    public void setTrigLow(float trigLow) {
        this.trigLow = trigLow;
    }

    public byte getTrigEdge() {
        return trigEdge;
    }

    public void setTrigEdge(byte trigEdge) {
        this.trigEdge = trigEdge;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }


    public Alert getAlert() {
        return alert;
    }

    public void setAlert(Alert alert) {
        this.alert = alert;
    }
    
    
}
