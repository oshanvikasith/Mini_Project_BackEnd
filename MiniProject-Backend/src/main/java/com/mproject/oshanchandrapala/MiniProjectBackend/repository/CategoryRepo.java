package com.mproject.oshanchandrapala.MiniProjectBackend.repository;

import com.mproject.oshanchandrapala.MiniProjectBackend.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category,String> {
}
