package com.mproject.oshanchandrapala.MiniProjectBackend.controller;

import com.mproject.oshanchandrapala.MiniProjectBackend.exception.ResourceNotFoundException;
import com.mproject.oshanchandrapala.MiniProjectBackend.model.User;
import com.mproject.oshanchandrapala.MiniProjectBackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/new")
    public ResponseEntity<User> createUser(@RequestBody User user){

        User newUser = null;

        try{
            newUser = userService.addUser(user);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping("/validate/{userEmail}/{password}")
    public ResponseEntity<User> getUser(@PathVariable("email") String email, @PathVariable("password") String password){
        User u1 = null;
        User valid = null;
        try{
            u1= userService.findUserByEmail(email).orElseThrow(()-> new ResourceNotFoundException("User not Found"));
            if(u1.getUserPassword().equals(password)){
                valid=u1;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(valid,HttpStatus.FOUND);
    }

}
