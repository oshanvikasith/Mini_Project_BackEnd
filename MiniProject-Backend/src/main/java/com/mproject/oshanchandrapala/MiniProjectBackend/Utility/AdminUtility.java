package com.mproject.oshanchandrapala.MiniProjectBackend.Utility;

import com.mproject.oshanchandrapala.MiniProjectBackend.model.Admin;
import com.mproject.oshanchandrapala.MiniProjectBackend.service.AdminService;

import java.util.List;

public class AdminUtility {

    private final AdminService adminService;


    public AdminUtility(AdminService adminService) {
        this.adminService = adminService;
    }

    public Admin validateUser(String email, String password) {
        List<Admin> admin = adminService.getAll();
        Admin valid = null;
        try{
            for (Admin single : admin) {
                if (single.getUserEmail().equals(email) && single.getUserPassword().equals(password)) {
                    valid = single;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return valid;
    }

}