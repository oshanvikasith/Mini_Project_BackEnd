package com.mproject.oshanchandrapala.MiniProjectBackend.controller;

import com.mproject.oshanchandrapala.MiniProjectBackend.Utility.AdminUtility;
import com.mproject.oshanchandrapala.MiniProjectBackend.exception.ResourceNotFoundException;
import com.mproject.oshanchandrapala.MiniProjectBackend.model.Admin;
import com.mproject.oshanchandrapala.MiniProjectBackend.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user")
public class AdminController {


    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping()
    public ResponseEntity<Admin> addNewUser(@RequestBody Admin admin){
        Admin admin1 = adminService.addUser(admin);
        return new ResponseEntity<>(admin1, HttpStatus.CREATED);
    }

    @GetMapping("/{userEmail}/{password}")
    public ResponseEntity<Admin> getUser(@PathVariable("userEmail") String userEmail, @PathVariable("password")String password){
        Admin admin = null;
        AdminUtility adminUtility = new AdminUtility();
        admin=adminUtility.validateUser(userEmail,password, adminService);
        return new ResponseEntity<>(admin,HttpStatus.FOUND);
    }
}
