package com.example.models;


import javax.persistence.*;

@Entity
public class Privilege {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private boolean active;

    public Privilege(){}

    public Privilege(String name, boolean active) {
        this.name = name;
        this.active = active;
    }





    public String getName() {
        return name;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setName(String name) {
        this.name = name;
    }
}
