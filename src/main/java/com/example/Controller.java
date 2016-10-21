package com.example;

import com.example.bindings.PrivilegesBinding;
import com.example.bindings.ResponseBinding;
import com.example.bindings.PasswordChangeBinding;
import com.example.models.Privilege;
import com.example.models.User;
import com.example.models.UserValidateBinding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/user")
public class Controller {

    private final UserRepository userRepository ;

    @Autowired
    public Controller(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<User>>  allUsers(){

        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.POST)
    public User[] create(){

        return null; //all
    }

    @RequestMapping(value = "{username}",method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable("username") String username){
        Iterator<User> iterator = userRepository.findByUsername(username).iterator();
        if (iterator.hasNext()){
            User user = iterator.next();
            userRepository.delete(user);
            return ResponseEntity.ok().build();
        }

        return null;
    }
    @RequestMapping(value = "/privs", method = RequestMethod.POST)
    public ResponseEntity<Void> changePrivs(@RequestBody PrivilegesBinding binding){
        String username = binding.getUser().getUsername();
        Iterator<User> iterator = userRepository.findByUsername(username).iterator();
        if (iterator.hasNext()){
            User user = iterator.next();
            user.setPrivileges(binding.getPrivileges());
            userRepository.save(user);
            return ResponseEntity.ok().build();
        }
        return null; //all
    }

    @RequestMapping(value = "/validate", method = RequestMethod.POST)
    public ResponseBinding validate(@RequestBody UserValidateBinding binding){
        Iterable<User> byUsername = userRepository.findByUsername(binding.getUsername());
        Iterator<User> iterator = byUsername.iterator();
        if (iterator.hasNext()){
            User  user = iterator.next();
            if(user.getPassword().equals(binding.getPassword()) && user.isPasswordSet()){
                return new ResponseBinding(user,true, "success");
            }
        }
        return new ResponseBinding(null,false, "fail");
    }

    @RequestMapping(value = "/admin",method = RequestMethod.POST)
    public ResponseBinding changePassword(@RequestBody PasswordChangeBinding binding){
        Iterable<User> byUsername = userRepository.findByUsername(binding.getUsername());
        Iterator<User> iterator = byUsername.iterator();
        if (iterator.hasNext()){
            User  user = iterator.next();
            if(user.getPassword().equals(binding.getOld()) && binding.getNewPass().equals(binding.getConfirm())){
                user.setPassword(binding.getNewPass());
                user.setPasswordSet(true);
                userRepository.save(user);
                return new ResponseBinding(user,true,"success");
            }
        }
        return new ResponseBinding(null,false, "fail");
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.POST)
    public ResponseEntity<List<Privilege>> getUserPrivs(@PathVariable("username") String username){
        Iterable<User> byUsername = userRepository.findByUsername(username);
        Iterator<User> iterator = byUsername.iterator();
        if (iterator.hasNext()){
            User  user = iterator.next();
            new ResponseEntity<>(user.getPrivileges(), HttpStatus.OK);

        }
        return null;
    }

    @RequestMapping(value = "/init", method = RequestMethod.POST)
    public ResponseEntity<Void> init(){
        Iterator<User> iterator = userRepository.findByUsername("admin").iterator();
        if (iterator.hasNext()){
            return ResponseEntity.ok().build();
        }else {
            User user = new User(0L,"admin","admin",true,false);
            List<Privilege> privileges = new ArrayList<>();
            privileges.add(new Privilege("add"));
            privileges.add(new Privilege("remove"));
            privileges.add(new Privilege("edit"));
            user.setPrivileges(privileges);
            userRepository.save(user);
        }
        return null;
    }

}
