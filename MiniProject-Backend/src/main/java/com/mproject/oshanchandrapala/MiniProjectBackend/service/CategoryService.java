package com.mproject.oshanchandrapala.MiniProjectBackend.service;

import com.mproject.oshanchandrapala.MiniProjectBackend.model.Category;
import com.mproject.oshanchandrapala.MiniProjectBackend.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryService {
    private final CategoryRepo categoryRepo;

    @Autowired
    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public Category addCategory(Category category){
        category.setCategoryId(UUID.randomUUID().toString());
        return categoryRepo.save(category);
    }

    public List<Category> getAllCategories(){
        return categoryRepo.findAll();
    }

    public Category updateCategory(Category category){
        return categoryRepo.save(category);
    }

    public void deleteCategory(String categoryId){
        categoryRepo.deleteById(categoryId);
    }

    public Optional<Category> findCategoryById(String categoryId){
        return categoryRepo.findById(categoryId);
    }

}
