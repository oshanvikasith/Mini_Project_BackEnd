package com.mproject.oshanchandrapala.MiniProjectBackend.service;

import com.mproject.oshanchandrapala.MiniProjectBackend.model.User;
import com.mproject.oshanchandrapala.MiniProjectBackend.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public Optional<User> findUserByEmail(String userEmail){
        return userRepo.findUserByEmail(userEmail);
    }

    public User addUser(User user){
        user.setUserId(UUID.randomUUID().toString());
        return userRepo.save(user);
    }
}
