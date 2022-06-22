package com.mproject.oshanchandrapala.MiniProjectBackend.repository;

import com.mproject.oshanchandrapala.MiniProjectBackend.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CategoryRepo extends JpaRepository<Category,String> {
    @Query("select c from Category c where c.categoryName = :categoryName")
    Optional<Category> findCategoryByName(@Param("categoryName")String categoryName);
}
