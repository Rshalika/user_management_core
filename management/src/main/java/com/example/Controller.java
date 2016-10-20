package com.example;

import com.example.models.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @RequestMapping("/")
    public String home(){
        return "hello world";
    }


    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public User[] allUsers(){

        return null; //all
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public User[] create(){

        return null; //all
    }

    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    public User[] delete(){

        return null; //all
    }
    @RequestMapping(value = "/user/privs", method = RequestMethod.POST)
    public User[] changePrivs(){

        return null; //all
    }


}
