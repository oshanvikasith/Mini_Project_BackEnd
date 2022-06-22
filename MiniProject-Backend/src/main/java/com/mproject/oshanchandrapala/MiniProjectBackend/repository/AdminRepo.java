package com.mproject.oshanchandrapala.MiniProjectBackend.repository;


import com.mproject.oshanchandrapala.MiniProjectBackend.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface AdminRepo extends JpaRepository<Admin,String> {

}
