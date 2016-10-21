package com.example.bindings;


import com.example.models.Privilege;
import com.example.models.User;

import java.util.List;

public class PrivilegesBinding {
    private User user;
    private List<Privilege> privileges;

    public PrivilegesBinding(){}

    public PrivilegesBinding(User user, List<Privilege> privileges) {
        this.user = user;
        this.privileges = privileges;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<Privilege> privileges) {
        this.privileges = privileges;
    }
}
