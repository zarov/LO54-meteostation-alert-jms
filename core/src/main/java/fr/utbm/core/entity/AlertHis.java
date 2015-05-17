/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.core.entity;

import java.util.Date;

/**
 *
 * @author Julien
 */

//@Entity
//@Table(name = "alerthis")
public class AlertHis {
    
    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(name = "Alh_Id")
    private int Id;
    //@Column(name = "Alh_Date")
    private Date date;
    //@Column(name = "Alh_State")
    private boolean state;
    //@JoinColumn(name = "Trg_Id")
    private Trigger trigger;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public Trigger getTrigger() {
        return trigger;
    }

    public void setTrigger(Trigger trigger) {
        this.trigger = trigger;
    }
    
}
