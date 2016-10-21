package com.example.bindings;


import com.example.models.Privilege;

import java.util.List;

public class PrivilegesBinding {
    private String username;
    private List<Privilege> privileges;

    public PrivilegesBinding(){}

    public PrivilegesBinding(String username, List<Privilege> privileges) {
        this.username = username;

        this.privileges = privileges;
    }


    public List<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<Privilege> privileges) {
        this.privileges = privileges;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
