package com.mproject.oshanchandrapala.MiniProjectBackend.Utility;

import com.mproject.oshanchandrapala.MiniProjectBackend.exception.ResourceNotFoundException;
import com.mproject.oshanchandrapala.MiniProjectBackend.model.Category;
import com.mproject.oshanchandrapala.MiniProjectBackend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class CategoryUtility {

    public List<Category> ListOfCategories(CategoryService categoryService){
        List<Category> categories = null;

        try{
            categories  = categoryService.getAllCategories();
        }catch (Exception e){
            e.printStackTrace();
        }
        return categories;
    }

    public Category UpdatingCategories(String categoryId, Category category,CategoryService categoryService){
        Category categoryUpdate = null;

        try{
            categoryUpdate = categoryService.findCategoryById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category {"+categoryId +"} does not exist"));
            categoryUpdate.setCategoryName(category.getCategoryName());
            categoryUpdate.setCategoryDesc(category.getCategoryDesc());

            categoryService.updateCategory(categoryUpdate);
        }catch (Exception e){
            e.printStackTrace();
        }

        return categoryUpdate;
    }

    public Category findingCategoryUsingId(String categoryId,CategoryService categoryService){
        Category findCategory = null;
        try{
            findCategory = categoryService.findCategoryById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category {"+categoryId+"} not exist"));

        }catch (Exception e){
            e.printStackTrace();
        }
        return findCategory;
    }

    public Category findCategoryUsingName(String categoryName, CategoryService categoryService){
        Category findByName = null;

        try {
            findByName = categoryService.findCategoryByName(categoryName).orElseThrow(()-> new ResourceNotFoundException("Category Name does not exist"));
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return findByName;
    }

}
