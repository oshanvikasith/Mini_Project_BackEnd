package com.mproject.oshanchandrapala.MiniProjectBackend.service;

import com.mproject.oshanchandrapala.MiniProjectBackend.model.Admin;
import com.mproject.oshanchandrapala.MiniProjectBackend.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class UserService {

    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

//    userRepopublic Optional<Admin> findUserByEmail(String userEmail){
//        return userRepo.FindAdminByEmail(userEmail);
//    }

    public Admin addUser(Admin admin){
        admin.setUserId(UUID.randomUUID().toString());
        return userRepo.save(admin);
    }
}
