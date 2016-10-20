package com.example;

import com.example.models.User;
import com.example.models.UserValidateBinding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class Controller {

    private final UserRepository userRepository ;

    @Autowired
    public Controller(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @RequestMapping(method = RequestMethod.GET)
    public User[] allUsers(){

        return null; //all
    }

    @RequestMapping(method = RequestMethod.POST)
    public User[] create(){

        return null; //all
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public User[] delete(){

        return null; //all
    }
    @RequestMapping(value = "/privs", method = RequestMethod.POST)
    public User[] changePrivs(){

        return null; //all
    }

    @RequestMapping(value = "/validate", method = RequestMethod.POST)
    public User[] validate(@RequestBody UserValidateBinding binding){
    userRepository.findByUsername(binding.getUsername());
        return null; //all
    }


}
