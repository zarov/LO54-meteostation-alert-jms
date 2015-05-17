package fr.utbm.core.entity;

import java.io.Serializable;

//@Entity
//@Table(name="user")
public class User implements Serializable {
    
    //@Id
    //@Column(name = "user_id")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    //@Column(name = "username", length = 255)
    private String username;
    //@Column(name = "active")
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
