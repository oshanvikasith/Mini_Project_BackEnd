package com.mproject.oshanchandrapala.MiniProjectBackend.service;

import com.mproject.oshanchandrapala.MiniProjectBackend.model.Admin;
import com.mproject.oshanchandrapala.MiniProjectBackend.repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class AdminService {

    private final AdminRepo adminRepo;

    @Autowired
    public AdminService(AdminRepo adminRepo) {
        this.adminRepo = adminRepo;
    }

    public List<Admin> getAll(){
        return adminRepo.findAll();
    }

    public Admin addUser(Admin admin){
        admin.setUserId(UUID.randomUUID().toString());
        return adminRepo.save(admin);
    }
}
