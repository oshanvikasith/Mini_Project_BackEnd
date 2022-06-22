package com.mproject.oshanchandrapala.MiniProjectBackend.repository;

import com.mproject.oshanchandrapala.MiniProjectBackend.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepo extends JpaRepository<Category,String> {

}
