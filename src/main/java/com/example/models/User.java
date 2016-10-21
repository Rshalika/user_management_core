package com.example.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String username;
    private String password;

    private boolean isAdmin;

    private boolean passwordSet;

//    public List<Privilege> getPrivileges() {
//        return privileges;
//    }
//
//    public void setPrivileges(List<Privilege> privileges) {
//        this.privileges = privileges;
//    }
////    @ManyToMany
////    @JoinTable(
////            name = "privileged" ,
////            joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"),
////            inverseJoinColumns = @JoinColumn(name="privilege_id", referencedColumnName="id")
////    )
    private String privileges;

    public User(){

    }

    public User(Long id, String username, String password, boolean isAdmin, boolean passwordSet) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
        this.passwordSet = passwordSet;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public boolean isPasswordSet() {
        return passwordSet;
    }

    public void setPasswordSet(boolean passwordSet) {
        this.passwordSet = passwordSet;
    }

    public void setPrivileges(List<Privilege> privileges) {
        JSONArray jsonArray = new JSONArray();
        for (Privilege privilege:privileges) {
            jsonArray.put(privilege.getName());
        }

        this.privileges = jsonArray.toString();
    }

    public List<Privilege> getPrivileges() {

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Privilege[] privileges = objectMapper.readValue(this.privileges, Privilege[].class);
            return Arrays.asList(privileges);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
