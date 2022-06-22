package com.mproject.oshanchandrapala.MiniProjectBackend.Utility;

import com.mproject.oshanchandrapala.MiniProjectBackend.model.Admin;
import com.mproject.oshanchandrapala.MiniProjectBackend.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AdminUtility {


    public Admin validateUser(String email, String password, AdminService adminService) {
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