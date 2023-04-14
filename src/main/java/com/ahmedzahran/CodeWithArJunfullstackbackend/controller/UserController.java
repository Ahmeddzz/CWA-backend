package com.ahmedzahran.CodeWithArJunfullstackbackend.controller;

import com.ahmedzahran.CodeWithArJunfullstackbackend.model.User;
import com.ahmedzahran.CodeWithArJunfullstackbackend.repository.UserRepository;
import com.ahmedzahran.CodeWithArJunfullstackbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public User newUser(@RequestBody User newUser){
        return userService.createNewUser(newUser);
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @PutMapping("/user/{id}")
    public User updateUser(@RequestBody User newUser, @PathVariable Long id){
        return userService.updateUser(id,newUser);

    }

    @DeleteMapping("/user/{id}")
    public String deleteUserById(@PathVariable Long id){
        return userService.deleteUserById(id);

    }
}
